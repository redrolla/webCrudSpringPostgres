package testApplication.testApp.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        List<User> cities = (List<User>) repository.findAll();

        return cities;
    }

    public Optional<User> findById(Long id){
        return repository.findById(id);
    }


    public User save(User user){
        return repository.save(user);
    }

    public void delete(User user){
        repository.delete(user);
    }
}
