package RelaxRoom.repository;

import RelaxRoom.model.MicrowavesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
public interface MicrowavesRepository extends CrudRepository<MicrowavesEntity, Long>,PagingAndSortingRepository<MicrowavesEntity,Long> {

    MicrowavesEntity findFirstByisFreeTrueAndIdIn(Collection<Integer> ids);
}
