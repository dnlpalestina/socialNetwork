package com.palestina.socialNetwork.service;

import com.palestina.socialNetwork.entities.User;
import com.palestina.socialNetwork.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService{

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public <S extends User> S save(S entity) {
        return this.userRepository.save(entity);
    }

    public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    public Optional<User> findById(Integer integer) {
        return userRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return false;
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public Iterable<User> findAllById(Iterable<Integer> integers) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void deleteById(Integer integer) {

    }

    public void delete(User entity) {
        userRepository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    public void deleteAll(Iterable<? extends User> entities) {

    }

    public void deleteAll() {

    }
}
