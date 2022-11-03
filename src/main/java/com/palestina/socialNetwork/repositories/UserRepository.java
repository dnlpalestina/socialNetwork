package com.palestina.socialNetwork.repositories;

import com.palestina.socialNetwork.entities.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{
  
}
