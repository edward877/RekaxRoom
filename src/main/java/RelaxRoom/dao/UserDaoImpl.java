package RelaxRoom.dao;

import RelaxRoom.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl  implements UserDao{

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void save(User user) {
        getSession().save(user);
    }

    @SuppressWarnings("unchecked")
    public List getAll() {
        return getSession().createQuery("from User").list();
    }

    @SuppressWarnings("unchecked")
    public User findByLogin(String username) {

        List<User> users;

        users = getSession()
                .createQuery("from User where login=?")
                .setParameter(0, username)
                .list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

    }

//    public User getById(long id) {
//        return (User) getSession().load(User.class, id);
//    }
//
//    public void update(User user) {
//        getSession().update(user);
//    }
//
//    public void delete(User user) {
//        getSession().delete(user);
//    }

}