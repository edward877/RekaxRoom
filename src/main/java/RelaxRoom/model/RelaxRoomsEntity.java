package RelaxRoom.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "relax_rooms")
public class RelaxRoomsEntity   implements Serializable {

    private static final long serialVersionUID = -7223924813396360744L;

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @OneToMany(mappedBy = "relaxRoom", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<QueueEntity> queue = new ArrayList();

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RelaxRoomsEntity{" +
                "id=" + id +
                '}';
    }
}
