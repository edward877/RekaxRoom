package RelaxRoom.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "queue")
public class QueueEntity  implements Serializable {

    private static final long serialVersionUID = -3147973496160054219L;

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "username", updatable = false)
    private UsersEntity user;

    @ManyToOne
    @JoinColumn(name = "id_relax_room", updatable = false)
    private RelaxRoomsEntity relaxRoom;

    @ManyToOne
    @JoinColumn(name = "id_microwave")
    private MicrowavesEntity microwave;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
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
