package RelaxRoom.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "relax_rooms")
public class RelaxRoomsEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="id_relax_room")
    private Set<QueueEntity> queue;
}
