package testApplication.testApp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import testApplication.testApp.model.InputEntry;
import testApplication.testApp.model.InputEntryService;
import testApplication.testApp.model.User;
import testApplication.testApp.model.UserService;

@Controller
public class HomeController {

    @Autowired
    private InputEntryService inputEntryService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("inputEntry",new InputEntry());
        return "home";
    }

    @PostMapping("/")
    public String homeSubmit(@ModelAttribute InputEntry inputEntry, Model model){
        model.addAttribute("inputEntry", inputEntry);

        System.out.println("model.asMap.keySey: ");
        System.out.println(inputEntry.getId());
        System.out.println(inputEntry.getContent());

        for (InputEntry ie : inputEntryService.findAll()) {
            System.out.println(ie.toString());
        }

        inputEntryService.save(inputEntry);

        return "result";
    }

    @GetMapping("/entries")
    public String entriesPage(Model model){
        InputEntry inputEntryById = inputEntryService.findById(27l).get();

        model.addAttribute("inputEntryById",inputEntryById);

        model.addAttribute("entries",inputEntryService.findAll());

        return "entries";
    }

    @GetMapping("/users")
    public String usersGetPage(Model model){
        model.addAttribute("newUser",new User());
        model.addAttribute("users",userService.findAll());
        return "users";
    }

    @PostMapping("/users")
    public String usersPostPage(@ModelAttribute User newUser, Model model){
        model.addAttribute("newUser", newUser);
        userService.save(newUser);
        return usersGetPage(model);
    }

    @GetMapping("/users/edit/id={id}/login={login}/password={password}/email={email}/phone_number={phone_number}")
    public String usersEditGetPage(@PathVariable Long id, @PathVariable String login, @PathVariable String password,
                                @PathVariable String email, @PathVariable String phone_number, Model model){
        User editUser = new User(login,password,email,phone_number);
        editUser.setId(id);
        model.addAttribute("editUser",editUser);
        return "usersEdit";
    }

    @PostMapping("users/edit/id={id}")
    public String usersEditAfterPostPage(@ModelAttribute User afterEditUser, @PathVariable Long id, Model model){
        userService.save(afterEditUser);
        model.addAttribute("editUser",afterEditUser);
        return "redirect:/users";
    }

    @GetMapping("/users/delete/id={id}")
    public String usersDeletePage(@PathVariable Long id, @ModelAttribute User userToDelete, Model model){
        userService.delete(userToDelete);
        return "redirect:/users";
    }
}
