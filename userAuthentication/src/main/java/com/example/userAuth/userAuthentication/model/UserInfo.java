package com.example.userAuth.userAuthentication.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userInfo")
public class UserInfo {

  @Id
  private String id;

  private String username;
  private String password; //You should store the hashed password
  private String phoneNumber;
  private String email;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public UserInfo(){}

  public UserInfo(String id, String username, String password, String phoneNumber, String email) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
