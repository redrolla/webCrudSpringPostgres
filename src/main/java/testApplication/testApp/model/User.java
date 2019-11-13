package testApplication.testApp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User implements Comparable<User>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Login cant be empty")
    private String login;
    @Size(min=5, message="Password must be at least 5 characters long")
    private String password;
    @Pattern(regexp = "\\w+[@]\\w+[.]\\D{2,3}",message = "E-mail must be formatted like email@google.com, email@mail.ru and etc")
    private String email;
    @Pattern(regexp="[0-9]{10}",message = "Phone number must contain only 10 digits")
    private String phone_number;

    public User() {
    }

    public User(String login, String password, String email, String phone_number) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }

    @Override
    public int compareTo(User u) {
        return getId().compareTo(u.getId());
    }
}
