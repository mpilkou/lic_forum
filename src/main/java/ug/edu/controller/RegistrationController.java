package ug.edu.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ug.edu.entity.MyUser;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	private UserDetailsManager userDetailsManager;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/signupForm")
	public String showMyLoginPage(Model theModel) {
		
		theModel.addAttribute("myUser", new MyUser());
		
		return "signup-form";
		
	}
	
	@PostMapping("/signupProcess")
	public String registrationProcess(
				@Valid @ModelAttribute("myUser") MyUser myUser, 
				BindingResult bindingResult, 
				Model model) {
		
		logger.info("____________________________________________________");
		logger.info(myUser.getUserName());
		logger.info(myUser.getPassword());
		logger.info("____________________________________________________");
		
		// form validation
		if (bindingResult.hasErrors()) {
			
			model.addAttribute("myUser", new MyUser());
			model.addAttribute("signupError", "User name/password can not be empty.");
			
			return "signup-form";
		}
		
		if (isExists(myUser.getUserName())) {
			model.addAttribute("myUser", new MyUser());
			model.addAttribute("registrationError", "User name already exists.");
			
			return "signup-form";
		}
		
		// password encryption 
        String encodedPassword = passwordEncoder.encode(myUser.getPassword());

        // prepend the encoding algorithm id
        encodedPassword = "{bcrypt}" + encodedPassword;
        
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_PLAYER");

        // create user object (from Spring Security framework)
        User tempUser = new User(myUser.getUserName(), encodedPassword, authorities);

        // save user in the database
        userDetailsManager.createUser(tempUser);
		
        return "signup-confirm";
	}
	
	private boolean isExists(String userName) {
		
		// check the database if the user already exists
		boolean exists = userDetailsManager.userExists(userName);
		
		return exists;
	}
}
