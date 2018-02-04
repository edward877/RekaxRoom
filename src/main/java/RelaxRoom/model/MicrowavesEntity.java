package RelaxRoom.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "microwaves")
public class MicrowavesEntity   implements Serializable {

    private static final long serialVersionUID = -8750899970394647595L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "is_free", nullable = false)
    private boolean isFree;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="id_microwave")
    private Set<QueueEntity> queue;

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
