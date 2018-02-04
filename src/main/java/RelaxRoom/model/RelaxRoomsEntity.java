package RelaxRoom.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "relax_rooms")
public class RelaxRoomsEntity   implements Serializable {

    private static final long serialVersionUID = -7223924813396360744L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="id_relax_room")
    private Set<QueueEntity> queue;

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
