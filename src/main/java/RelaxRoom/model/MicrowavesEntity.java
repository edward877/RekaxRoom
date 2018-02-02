package RelaxRoom.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "microwaves")
public class MicrowavesEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "is_free", nullable = false)
    private boolean isFree;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="id_microwave")
    private Set<QueueEntity> queue;
}
