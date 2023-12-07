package com.findzach.restaurant.controller.pages.login;

import com.findzach.restaurant.controller.BaseController;
import com.findzach.restaurant.controller.rest.CustomerController;
import com.findzach.restaurant.model.entities.user.Role;
import com.findzach.restaurant.model.entities.user.User;
import com.findzach.restaurant.model.entities.user.customer.Customer;
import com.findzach.restaurant.model.entities.user.employee.Employee;
import com.findzach.restaurant.model.session.SessionUser;
import com.findzach.restaurant.service.CrudService;
import com.findzach.restaurant.service.session.SessionService;
import com.findzach.restaurant.service.user.CustomerService;
import com.findzach.restaurant.service.user.EmployeeService;
import com.findzach.restaurant.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController extends BaseController {

    private final SessionService sessionService;
    private final UserService userService;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public LoginController(UserService userService, SessionService sessionService) {
        super(sessionService, "pages/login");
        this.sessionService = sessionService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public String join(Model model, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("name") String name, @RequestParam("email") String email) {
        System.out.println("User is trying to join...");

        System.out.println("Registering with email: " + email);
        System.out.println("Registering with name: " + name);
        if (username.isBlank() || password.isBlank() || email.isBlank() || name.isBlank()) {
            model.addAttribute("errorMsg", "Please populate all of the fields!");
            return "pages/login";
        }

        User foundUser = userService.findByUsername(username);

        if (foundUser != null) {
            model.addAttribute("errorMsg", "Username has been already taken!");
            return "pages/login";
        }

        String hashedPassword = passwordEncoder.encode(password);
        model.addAttribute("successMsg", "Account \'" + username + "\' has been properly created!");
        Employee customer = new Employee();
        customer.setUsername(username);
        customer.setPassword(hashedPassword);
        customer.setEmail(email);
        customer.setFirstName(name);

        userService.create(customer);
        return "pages/login";
    }
    @GetMapping("/login")
    public String login(Model model, HttpSession session) {
        return super.showPage(model, session);
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session) {

        SessionUser sessionUser = sessionService.findById(session.getId());
        if (sessionUser != null) {
            sessionUser.setRole(Role.GUEST);
            sessionUser.setRequestedLogout(true);
        }

        return "redirect:/" + "";
    }

    @PostMapping("/login")
    public String loginAttempt(Model model, HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        // Add your authentication logic here


        User foundUser = userService.findByUsername(username);

        if (username.isBlank() || password.isBlank() || foundUser == null || !passwordEncoder.matches(password, foundUser.getPassword())) {
            model.addAttribute("errorMsg", "Invalid username or password!");
            return "pages/login";
        }

        sessionService.getSessionUser(session.getId()).setUser(foundUser);
        System.out.println("Role: " + foundUser.getRole());

        if (foundUser.getUsername().equalsIgnoreCase("Zach") && foundUser.getRole() != Role.DEVELOPER) {
            foundUser.setRole("DEVELOPER");
            userService.save(foundUser);
        }

        if (sessionService.getSessionUser(session.getId()) != null)
            sessionService.getSessionUser(session.getId()).setRole(foundUser.getRole() != null ? foundUser.getRole() : Role.CUSTOMER);

        return "redirect:/user-portal"; // Redirect to the list page
    }

}