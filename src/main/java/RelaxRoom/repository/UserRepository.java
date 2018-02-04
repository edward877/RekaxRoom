package RelaxRoom.repository;

import RelaxRoom.model.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<UsersEntity, Long> {

    UsersEntity findByUsername(String username);
}
