package com.provaIscrizione.provaIscrizione.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.provaIscrizione.provaIscrizione.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByNicknameAndPassword(String nickname, String password);
}
