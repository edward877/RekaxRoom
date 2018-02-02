//package RelaxRoom.model;
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Entity
//@Table(name = "test_user")
//public class UserEntity1 {
//    private int idUser;
//    private String login;
//    private String password;
//
//    public UserEntity1() {
//    }
//
//    public UserEntity1(String login, String password) {
//        this.login = login;
//        this.password = password;
//    }
//
//    @Id
////    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
//    @SequenceGenerator(name = "seq_user", sequenceName = "seq_user", allocationSize=1)
//    @Column(name = "id_user", nullable = false)
//    public int getIdUser() {
//        return idUser;
//    }
//
//    public void setIdUser(int idUser) {
//        this.idUser = idUser;
//    }
//
//    @Column(name = "login", nullable = false, length = 40)
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    @Column(name = "password", nullable = false, length = 40)
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserEntity1 testUser1 = (UserEntity1) o;
//        return idUser == testUser1.idUser &&
//                Objects.equals(login, testUser1.login) &&
//                Objects.equals(password, testUser1.password);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(idUser, login, password);
//    }
//
//    @Override
//    public String toString() {
//        return "UserEntity1{" +
//                "idUser=" + idUser +
//                ", login='" + login + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
//}