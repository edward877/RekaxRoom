package RelaxRoom.repository;

import RelaxRoom.model.StatusEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StatusRepository   extends CrudRepository<StatusEntity, Long> {
    StatusEntity findByNameStatus(String status);
}
