package com.provaIscrizione.provaIscrizione.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name= "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userID;
    @Column
	private String name;
    @Column
	private String surname;
    @Column
	private String email;
    @Column
	private String password;
    @Column
	private String nickname;
    @Column
    private String role;
    
    @Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + ", surname=" + surname + ", email=" + email + ", password="
				+ password + ", nickname=" + nickname + ", role=" + role + "]";
	}
	public User () {
    	
    }
	public User(Integer userID, String name, String surname, String email, String password, String nickname,
			String role) {
		super();
		this.userID = userID;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.role = role;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}