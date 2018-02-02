package RelaxRoom.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "status", schema = "public", catalog = "relax_room_db")
public class StatusEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name_status", nullable = false, length = 255)
    private String nameStatus;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="id_status")
    private Set<StatementsQueueEntity> statementsQueue;

    @Override
    public String toString() {
        return "StatusEntity{" +
                "id=" + id +
                ", nameStatus='" + nameStatus + '\'' +
//                ", statementsQueue=" + statementsQueue +
                '}';
    }
}
