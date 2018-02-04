package RelaxRoom.repository;

import RelaxRoom.model.StatementsQueueEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StatementsQueueRepository extends CrudRepository<StatementsQueueEntity, Long> {
}
