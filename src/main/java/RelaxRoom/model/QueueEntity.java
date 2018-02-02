package RelaxRoom.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "queue")
public class QueueEntity  implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name="username")
    private UsersEntity user;

    @ManyToOne
    @JoinColumn(name="id_relax_room")
    private RelaxRoomsEntity relaxRoom;

    @ManyToOne
    @JoinColumn(name="id_microwave")
    private MicrowavesEntity microwave;

    @OneToOne
    @JoinColumn(name="id_statement")
    private StatementsQueueEntity statements_queue;

    @Override
    public String toString() {
        return "QueueEntity{" +
                "id=" + id +
                ", user=" + user +
                ", relaxRoom=" + relaxRoom +
                ", microwave=" + microwave +
                ", statements_queue=" + statements_queue +
                '}';
    }
}
