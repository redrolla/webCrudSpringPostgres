package testApplication.testApp.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testApplication.testApp.model.InputEntry;
import testApplication.testApp.model.InputEntryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InputEntryService{

    @Autowired
    private InputEntryRepository repository;

    public List<InputEntry> findAll() {
        List<InputEntry> cities = (List<InputEntry>) repository.findAll();

        return cities;
    }

    public Optional<InputEntry> findById(long id){
        return repository.findById(id);
    }


    public InputEntry save(InputEntry inputEntry){
        return repository.save(inputEntry);
    }
}
