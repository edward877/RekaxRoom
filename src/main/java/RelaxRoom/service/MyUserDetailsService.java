package RelaxRoom.service;

import RelaxRoom.dao.UserDao;
import RelaxRoom.dao.UserDaoImpl;
import RelaxRoom.model.User;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.authentication.InternalAuthenticationServiceException;
        import org.springframework.security.core.GrantedAuthority;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.core.userdetails.UsernameNotFoundException;
        import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
        import java.util.Collection;
        import java.util.List;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserDao users;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails loadedUser;

        try {
            User client = users.findByLogin(username);
            if(client!=null){
                loadedUser = new org.springframework.security.core.userdetails.User(
                        client.getLogin(), client.getPassword(), DummyAuthority.getAuth());
                return loadedUser;
            }
        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }
        return null;
    }

    static class DummyAuthority implements GrantedAuthority
    {
        static Collection<GrantedAuthority> getAuth()
        {
            List<GrantedAuthority> res = new ArrayList<>(1);
            res.add(new DummyAuthority());
            return res;
        }
        @Override
        public String getAuthority() {
            return "USER";
        }
    }
}