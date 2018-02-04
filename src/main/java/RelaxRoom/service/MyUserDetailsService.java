package RelaxRoom.service;

import RelaxRoom.model.UsersEntity;
import RelaxRoom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
                        client.getUsername(), client.getPassword(), getAuthorities());
                return loadedUser;
            }
        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }
        return null;
    }

    private List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authList = new ArrayList<>(1);
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authList;
    }
}