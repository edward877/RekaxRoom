package RelaxRoom.repository;

import RelaxRoom.model.StatementsQueueEntity;
import org.springframework.data.repository.CrudRepository;

public interface StatementsQueueRepository
        extends CrudRepository<StatementsQueueEntity, Long> {
}
