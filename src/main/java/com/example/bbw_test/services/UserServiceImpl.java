package com.example.bbw_test.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.bbw_test.models.entities.Role;
import com.example.bbw_test.models.entities.User;
import com.example.bbw_test.models.repositories.RoleRepo;
import com.example.bbw_test.models.repositories.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // TODO Auto-generated method stub
        User user = userRepo.findByUsername(username);

        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User not found");
        }else{
            System.out.println("User found : "+username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        // TODO Auto-generated method stub
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(rolename);
        user.getRoles().add(role);
        
    }

    @Override
    public User getUser(String username) {
        // TODO Auto-generated method stub
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        // TODO Auto-generated method stub
        return userRepo.findAll();
    }

    @Override
    public Role saveRole(Role role) {
        // TODO Auto-generated method stub
        return roleRepo.save(role);
    }

    
}
