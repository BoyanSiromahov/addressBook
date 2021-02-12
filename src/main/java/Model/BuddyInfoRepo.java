package Model;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "buds", path = "buds")
public interface BuddyInfoRepo extends CrudRepository<BuddyInfo, Long> {

    List<BuddyInfo> findByName(@Param("name") String lastName);

    BuddyInfo findById(long id);
}
