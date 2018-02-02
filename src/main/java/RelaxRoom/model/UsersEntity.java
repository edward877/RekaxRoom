package RelaxRoom.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class UsersEntity implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "username", nullable = false, length = 40)
    private String username;

    @Column(name = "fio", nullable = false, length = 40)
    private String fio;

    @Column(name = "password", nullable = false, length = 40)
    private String password;

    @Column(name = "is_free", nullable = false)
    private boolean isFree;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="username")
    private Set<QueueEntity> queue;

    public UsersEntity() {
    }

    public UsersEntity(String username, String fio, String password) {
        this.username = username;
        this.fio = fio;
        this.password = password;
        this.isFree = true;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "username='" + username + '\'' +
                ", fio='" + fio + '\'' +
                ", password='" + password + '\'' +
                ", isFree=" + isFree +
//                ", queuesByUsername=" + queuesByUsername +
                '}';
    }
}
