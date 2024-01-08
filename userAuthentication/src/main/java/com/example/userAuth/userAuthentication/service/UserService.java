package com.example.userAuth.userAuthentication.service;

import com.example.userAuth.userAuthentication.model.UserInfo;

public interface UserService {
  UserInfo registerUser(UserInfo userInfo);
  UserInfo loginUser(String userName, String password);
}
