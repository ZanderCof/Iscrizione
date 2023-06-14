package com.provaIscrizione.provaIscrizione.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.provaIscrizione.provaIscrizione.models.User;
import com.provaIscrizione.provaIscrizione.repositories.UserRepository;

@Service
public class UserServices {
	@Autowired
	UserRepository repo;
	public User save(User obj) {
		return repo.save(obj);
	}
	public User user (Integer userID) {
		return repo.findById(userID).orElse(null);
	}
    public User findByNicknameAndPassword(String nickname, String password) {
        return repo.findByNicknameAndPassword(nickname, password).orElse(null);
    }
}
