package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.User;

public interface IUserRepository {

    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    User update(User user);
    void deleteById(Long id);
    boolean existsById(Long id);
    Long count();

}
