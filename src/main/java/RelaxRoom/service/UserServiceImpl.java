package RelaxRoom.service;

import RelaxRoom.configs.WebSecurityConfig;
import RelaxRoom.model.UsersEntity;
import RelaxRoom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebSecurityConfig securityConfig;

    @Override
    public UsersEntity getCurrentDBUser() {
        return  userRepository.findByUsername(securityConfig.getCurrentUsername());
    }
}
