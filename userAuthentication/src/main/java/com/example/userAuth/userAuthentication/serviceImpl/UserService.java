package com.example.userAuth.userAuthentication.serviceImpl;


import com.example.userAuth.userAuthentication.Repository.UserRepository;
import com.example.userAuth.userAuthentication.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService implements com.example.userAuth.userAuthentication.service.UserService {
 @Autowired
  private final UserRepository userRepository;
 @Autowired
  private final BCryptPasswordEncoder passwordEncoder;

  @Autowired
  public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public UserInfo registerUser(UserInfo userInfo){
    //check if username or email already exists
    if(userRepository.findByUsername(userInfo.getUsername())!=null
        || userRepository.findByEmail(userInfo.getEmail())!=null){

      throw new RuntimeException("UserName or email already exists");
    }

    //Hash the password before saving
    userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
    return userRepository.save(userInfo);
  }

  @Override
  public UserInfo loginUser(String userName, String password){
    UserInfo userInfo = userRepository.findByUsername(userName);

    //Validate password
    if(userInfo != null && passwordEncoder.matches(password,userInfo.getPassword()))
    {
      return userInfo;
    }
    return null; //Invalid credentials
  }

}
