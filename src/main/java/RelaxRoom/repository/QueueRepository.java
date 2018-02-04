package RelaxRoom.repository;

import RelaxRoom.model.QueueEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Repository
public interface QueueRepository extends CrudRepository<QueueEntity, Long>, PagingAndSortingRepository<QueueEntity,Long> {

    List<QueueEntity> findByRelaxRoomIdAndStatementsQueueStatusNameStatusIn(Integer idRelaxRoom, Collection<String> names);

    QueueEntity findByUserUsernameAndStatementsQueueStatusNameStatusIn(String username, Collection<String> names);

    QueueEntity findFirstByRelaxRoomIdAndStatementsQueueStatusNameStatus(int relaxRoomId, String status_name);

    List<QueueEntity> findAllByStatementsQueueStatusNameStatusAndStatementsQueueDateOutBefore (String status_name, Timestamp now);
}
