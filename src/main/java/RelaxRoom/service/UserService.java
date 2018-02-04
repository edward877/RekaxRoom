package RelaxRoom.service;

import RelaxRoom.model.UsersEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UsersEntity getCurrentDBUser();
}
