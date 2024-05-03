package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.example.demo.entities.User;

public class UserRepository implements IUserRepository {
    Map<Long, User> userMap;
    private Long autoIncrement=1L;
    
    public UserRepository() {
        this.userMap = new HashMap<Long, User>();
    }

    @Override
    public User save(User user) {
        // TODO Auto-generated method stub
        User u = new User(user.getName(), autoIncrement);
        userMap.put(autoIncrement, u);
        ++autoIncrement;
        return u;
    }

    @Override
    public Optional<User> findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User update(User user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Long count() {
        // TODO Auto-generated method stub
        return null;
    }

}
