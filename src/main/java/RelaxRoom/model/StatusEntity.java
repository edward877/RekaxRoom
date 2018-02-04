package RelaxRoom.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "status", schema = "public", catalog = "relax_room_db")
public class StatusEntity   implements Serializable {

    private static final long serialVersionUID = 941123547855698959L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name_status", nullable = false, length = 40)
    private String nameStatus;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="id_status")
    private Set<StatementsQueueEntity> statementsQueue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

    @Override
    public String toString() {
        return "StatusEntity{" +
                "id=" + id +
                ", nameStatus='" + nameStatus + '\'' +
                '}';
    }
}
