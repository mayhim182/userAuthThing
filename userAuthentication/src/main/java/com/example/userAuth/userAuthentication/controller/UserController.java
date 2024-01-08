package com.example.userAuth.userAuthentication.controller;

import com.example.userAuth.userAuthentication.model.UserInfo;
import com.example.userAuth.userAuthentication.serviceImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userInfo")
public class UserController {
  private final UserService userService;
  @Autowired
  public UserController(UserService userService){
    this.userService = userService;
  }

  @PostMapping("/register")
  public UserInfo registerUser(@RequestBody UserInfo userInfo){
      return userService.registerUser(userInfo);
  }

  @PostMapping("/login")
  public UserInfo loginUser(@RequestParam String userName, @RequestParam String password){
    return userService.loginUser(userName,password);
  }

}
