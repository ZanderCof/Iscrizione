package com.provaIscrizione.provaIscrizione.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.provaIscrizione.provaIscrizione.models.User;
import com.provaIscrizione.provaIscrizione.services.UserServices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserServices userService;
	
    @PostMapping("/createuser")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
		public ResponseEntity<?> createUser(@RequestBody User user) {
        	userService.save(user);
        	return ResponseEntity.ok("Utente registrato con successo");
    }
    @PostMapping("/login")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<?> login(@RequestBody User user, HttpSession sessione) {
        User utente = userService.findByNicknameAndPassword(user.getNickname(), user.getPassword());

        if (utente == null) {
            return ResponseEntity.badRequest().body("Nickname o password errati");
        }

        if (!user.getPassword().equals(utente.getPassword())) {
            return ResponseEntity.badRequest().body("Nickname o password errati");
        }

        sessione.setAttribute("user", utente.getNickname());

        return ResponseEntity.ok("Login andato a buon fine");
    }

}

