package com.example.userAuth.userAuthentication.Repository;

import com.example.userAuth.userAuthentication.model.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserInfo,String> {
  UserInfo findByUsername(String userName);
  UserInfo findByEmail(String email);
}
