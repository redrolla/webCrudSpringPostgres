package testApplication.testApp.model;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserNoDbService {
    private List<User> userList = new ArrayList<>();

    @PostConstruct
    public void initListWithTestEntities(){
        userList.add(new User("login1","password1","email1@email.ru","1000000000"));
        userList.add(new User("login2","password2","email2@email.ru","2000000000"));
        userList.add(new User("login3","password3","email3@email.ru","3000000000"));
        userList.add(new User("login4","password4","email4@email.ru","4000000000"));
        userList.add(new User("login5","password5","email5@email.ru","5000000000"));
        userList.add(new User("login6","password6","email6@email.ru","6000000000"));
    }

    public List<User> findAll(){
        return userList;
    }

    public Optional<User> findById(Long id){
        for(User u : userList){
            if(u.getId() == id){
                return Optional.of(u);
            }
        }
        return null;
    }

    public User save(User user){
        userList.add(user);
        return user;
    }

    public void delete(User user){
        userList.remove(user);
    }
}