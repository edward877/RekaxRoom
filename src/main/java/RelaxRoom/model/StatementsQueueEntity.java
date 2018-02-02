package RelaxRoom.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "statements_queue")
public class StatementsQueueEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "date_in", nullable = false)
    private Timestamp dateIn;

    @Column(name = "date_start")
    private Timestamp dateStart;

    @Column(name = "minutes_to_end", nullable = false)
    private int minutesToEnd;

    @ManyToOne
    private StatusEntity status;

    @OneToOne(mappedBy= "statements_queue")
    private QueueEntity queue;

    @Override
    public String toString() {
        return "StatementsQueueEntity{" +
                "id=" + id +
                ", dateIn=" + dateIn +
                ", dateStart=" + dateStart +
                ", minutesToEnd=" + minutesToEnd +
                ", status=" + status +
                ", queue=" + queue +
                '}';
    }
}
