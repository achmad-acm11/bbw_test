package com.example.bbw_test.controllers;

import java.net.URI;
import java.util.List;

import com.example.bbw_test.models.entities.Role;
import com.example.bbw_test.models.entities.User;
import com.example.bbw_test.response.AuthenticationResponse;
import com.example.bbw_test.services.MyUserDetailsService;
import com.example.bbw_test.services.UserService;
import com.example.bbw_test.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
public class UserController {
    // @Autowired
    // private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/hello")
    public ResponseEntity<String> getUsers() {
        return ResponseEntity.ok().body("hello");
    }

    // @PostMapping("/users")
    // public ResponseEntity<User> postUsers(@RequestBody User user) {
    // URI uri =
    // URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users").toUriString());
    // return ResponseEntity.created(uri ).body(userService.saveUser(user));
    // }

    // @PostMapping("/role")
    // public ResponseEntity<Role> postRoles(@RequestBody Role role) {
    // URI uri =
    // URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role").toUriString());
    // return ResponseEntity.created(uri).body(userService.saveRole(role));
    // }

    // @PostMapping("/role/addToUser")
    // public ResponseEntity<?> addUserRoles(@RequestBody RoleToUserForm role) {
    // userService.addRoleToUser(role.getUsername(),role.getRoleName());
    // return ResponseEntity.ok().build();
    // }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuth(@RequestBody UserRequest req) throws Exception {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}

/**
 * InnerUserController
 */
class RoleToUserForm {
    private String username;
    private String roleName;

    public RoleToUserForm() {
    }

    public RoleToUserForm(String username, String roleName) {
        this.username = username;
        this.roleName = roleName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}

class UserRequest {
    private String username;
    private String password;

    public UserRequest() {
    }

    public UserRequest(String username, String password) {
        this.username = username;
        this.password = password;
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

}
