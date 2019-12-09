package com.example.springboot_4_04;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);


}
