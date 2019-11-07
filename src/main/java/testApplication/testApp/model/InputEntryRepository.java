package testApplication.testApp.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import testApplication.testApp.model.InputEntry;

@Repository
public interface InputEntryRepository extends CrudRepository<InputEntry,Long> {
}
