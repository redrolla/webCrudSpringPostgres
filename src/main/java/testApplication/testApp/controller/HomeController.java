package testApplication.testApp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import testApplication.testApp.model.User;
import testApplication.testApp.model.UserService;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String homePage(){
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String usersGetPage(Model model){
        model.addAttribute("newUser",new User());
        model.addAttribute("users",userService.findAll());
        return "users";
    }

    @PostMapping("/users")
    public String usersPostPage(@ModelAttribute("newUser") @Valid User newUser, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("users",userService.findAll());
            return "users";
        }
        model.addAttribute("newUser", newUser);
        userService.save(newUser);
        return usersGetPage(model);
    }

    @GetMapping("/users/edit/id={id}")
    public String usersEditGetPage(@PathVariable Long id, Model model){
        User editUser = userService.findById(id).get();
        model.addAttribute("editUser",editUser);
        return "usersEdit";
    }

    /**
     *
     * @param afterEditUser, name specified in annotation to match object name in view template
     * @param bindingResult must follow @ModelAttribute
     */
    @PostMapping("users/edit/id={id}")
    public String usersEditAfterPostPage(@ModelAttribute("editUser") @Valid User afterEditUser, BindingResult bindingResult, @PathVariable Long id, Model model){
        if(bindingResult.hasErrors()){
            //System.out.println(model.asMap());
            //return "redirect:/users/edit/id="+id;
            return "usersEdit";
        }
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
