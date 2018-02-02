package RelaxRoom.service;

import RelaxRoom.model.UsersEntity;
import RelaxRoom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired

    private UserRepository userDao;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails loadedUser;

        try {
            UsersEntity client = userDao.findByUsername(username);
            if(client!=null){
                loadedUser = new User(
                        client.getUsername(), client.getPassword(), DummyAuthority.getAuth());
                return loadedUser;
            }
        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }
        return null;
    }

    ///исправить
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