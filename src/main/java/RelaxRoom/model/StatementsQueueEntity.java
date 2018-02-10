package RelaxRoom.model;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "statements_queue")
public class StatementsQueueEntity implements Serializable{

    private static final long serialVersionUID = 2245986059132065916L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "date_in")
    private Timestamp dateIn;

    @Column(name = "date_out")
    private Timestamp dateOut;

    @Column(name = "minutes_to_end", nullable = false)
    private int minutesToEnd;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private StatusEntity status;

    public StatementsQueueEntity() {
    }

    public StatementsQueueEntity(int minutesToEnd, StatusEntity status) {
        this.minutesToEnd = minutesToEnd;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDateIn() {
        return dateIn;
    }

    public void setDateIn(Timestamp dateIn) {
        this.dateIn = dateIn;
    }

    public Timestamp getDateOut() {
        return dateOut;
    }

    public void setDateOut(Timestamp dateStart) {
        this.dateOut = dateStart;
    }

    public int getMinutesToEnd() {
        return minutesToEnd;
    }

    public void setMinutesToEnd(int minutesToEnd) {
        this.minutesToEnd = minutesToEnd;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StatementsQueueEntity{" +
                "id=" + id +
                ", dateIn=" + dateIn +
                ", dateStart=" + dateOut +
                ", minutesToEnd=" + minutesToEnd +
                '}';
    }
}
