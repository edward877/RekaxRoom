package RelaxRoom.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "queue")
public class QueueEntity  implements Serializable {

    private static final long serialVersionUID = -3147973496160054219L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="username")
    private UsersEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_relax_room")
    private RelaxRoomsEntity relaxRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_microwave")
    private MicrowavesEntity microwave;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_statement")
    private StatementsQueueEntity statementsQueue;

    public QueueEntity() {
    }

    public QueueEntity(UsersEntity user, RelaxRoomsEntity relaxRoom, StatementsQueueEntity statementsQueue) {
        this.user = user;
        this.relaxRoom = relaxRoom;
        this.statementsQueue = statementsQueue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    public RelaxRoomsEntity getRelaxRoom() {
        return relaxRoom;
    }

    public void setRelaxRoom(RelaxRoomsEntity relaxRoom) {
        this.relaxRoom = relaxRoom;
    }

    public MicrowavesEntity getMicrowave() {
        return microwave;
    }

    public void setMicrowave(MicrowavesEntity microwave) {
        this.microwave = microwave;
    }

    public StatementsQueueEntity getStatementsQueue() {
        return statementsQueue;
    }

    public void setStatementsQueue(StatementsQueueEntity statements_queue) {
        this.statementsQueue = statements_queue;
    }


    @Override
    public String toString() {
        return "Queue{" +
                "id=" + id +
                ", user=" + user +
                ", relaxRoom=" + relaxRoom +
                ", microwave=" + microwave +
                ", statements_queue=" + statementsQueue +
                '}';
    }
}
