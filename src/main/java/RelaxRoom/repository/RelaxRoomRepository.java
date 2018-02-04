package RelaxRoom.repository;

import RelaxRoom.model.RelaxRoomsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RelaxRoomRepository extends CrudRepository<RelaxRoomsEntity, Long> {

    RelaxRoomsEntity findById(int id);
}
