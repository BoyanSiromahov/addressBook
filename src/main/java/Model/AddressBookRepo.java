package Model;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addressBook", path = "addressBook")
public interface AddressBookRepo extends CrudRepository<AddressBook, Long> {

    List<AddressBook> findByName(@Param("name") String lastName);

    AddressBook findById(long id);
}
