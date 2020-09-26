package com.multi.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.multi.login.jwt.JwtTokenUtil;
import com.multi.login.model.User;
import com.multi.login.repository.UserRepository;
import com.multi.login.service.JwtUserDetailsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserRepository repository;
	
	private final PasswordEncoder bcryptEncoder;
	
	private final AuthenticationManager authenticationManager;

	private final JwtTokenUtil jwtTokenUtil;
	
	public String token;

	private final JwtUserDetailsService userDetailsService;
	
	 private FacebookConnectionFactory factory = new FacebookConnectionFactory("644341372856516",
				"d8d45f4668a89497ebb0e27682bb84f1");
	
	@GetMapping("/")
	public String loginPage(User user, Model model) {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@Valid User user, BindingResult result, Model model, HttpServletResponse response) throws Exception {
		if (result.hasErrors()) {
			return "login";
		}
		User user1 = repository.findByName(user.getName());
		if (user1 == null || !bcryptEncoder.matches(user.getPassword(), user1.getPassword())) 
		{
			model.addAttribute("errorMessage", "Invalid Credentials!");
			return "login";
		}
		
		token = createAuthenticationToken(user.getName(), user.getPassword());
		System.out.println(token);
		Cookie cookie = new Cookie("Authorization",  token);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String indexPage (Model model, @RequestHeader(name = "Authorization", required = false) String Authorization) 
	{
		System.out.println(token);
		Iterable<User> users = repository.findAll();
		users.forEach(unit -> System.out.println(unit.isNotSocial()));
		model.addAttribute("users", repository.findAll());
		
		
		return "index";
	}
	
	@GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }
    
    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        user.setNotSocial(true);
        repository.save(user);
        return "redirect:/";
    }
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        User user = repository.findByIdUser(id);
        model.addAttribute("user", user);
        return "update-user";
    }
    
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid User user, BindingResult result, Model model, HttpServletResponse response) {
        if (result.hasErrors()) {
            user.setIdUser(id);
            return "update-user";
        }
        User user1 = repository.findByIdUser(id);
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        
        repository.save(user1);
        try {
			token = createAuthenticationToken(user.getName(), user.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(token);
		Cookie cookie = new Cookie("Authorization",  token);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
        return "redirect:/index";
    }
    
    @GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {
		User user = repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		repository.delete(user);
			return "redirect:/index";
	}
    
    @GetMapping("/backtologin")
    public String backToLogin(HttpServletResponse response) {
    	Cookie cookie = new Cookie("Authorization", null);
    	cookie.setMaxAge(0);
    	response.addCookie(cookie);
    	return "redirect:/";
    }
    
	@GetMapping(value = "/useApplication")
	public String producer() {

		OAuth2Operations operations = factory.getOAuthOperations();
		OAuth2Parameters params = new OAuth2Parameters();

		params.setRedirectUri("http://localhost:8080/forwardLogin");
		params.setScope("email,public_profile");

		String url = operations.buildAuthenticateUrl(params);
		System.out.println("The URL is" + url);
		return "redirect:" + url;

	}

	@RequestMapping(value = "/forwardLogin")
	public String prodducer(@RequestParam("code") String authorizationCode, HttpServletResponse response) throws Exception {
		OAuth2Operations operations = factory.getOAuthOperations();
		AccessGrant accessToken = operations.exchangeForAccess(authorizationCode, "http://localhost:8080/forwardLogin",
				null);

		Connection<Facebook> connection = factory.createConnection(accessToken);
		Facebook facebook = connection.getApi();
		String[] fields = { "id", "email", "first_name", "last_name" };
		org.springframework.social.facebook.api.User userProfile = facebook.fetchObject("me", org.springframework.social.facebook.api.User.class, fields);
		User addUser = new User();
		addUser.setName(userProfile.getFirstName());
		addUser.setPassword(userProfile.getEmail());
		addUser.setNotSocial(false);
		userDetailsService.save(addUser);
		token = createAuthenticationToken(addUser.getName(), addUser.getPassword());
		System.out.println(token);
		Cookie cookie = new Cookie("Authorization",  token);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		return "redirect:/index";

	}
    
    private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
    
    public String createAuthenticationToken(String username, String password) throws Exception {

		authenticate(username, password);

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(username);

		final String token = jwtTokenUtil.generateToken(userDetails);
		return token;
	}
}
