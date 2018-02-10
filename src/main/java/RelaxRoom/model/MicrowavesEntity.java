package RelaxRoom.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "microwaves")
public class MicrowavesEntity   implements Serializable {

    private static final long serialVersionUID = -8750899970394647595L;

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "is_free", nullable = false)
    private boolean isFree;

    @OneToMany(mappedBy = "microwave", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<QueueEntity> queue = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    @Override
    public String toString() {
        return "MicrowavesEntity{" +
                "id=" + id +
                ", isFree=" + isFree +
                '}';
    }
}
