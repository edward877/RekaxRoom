package RelaxRoom.dao;

import RelaxRoom.model.User;

import java.util.List;

public interface UserDao {
    List getAll();

    User findByLogin(String username);

    void save(User user);

}
