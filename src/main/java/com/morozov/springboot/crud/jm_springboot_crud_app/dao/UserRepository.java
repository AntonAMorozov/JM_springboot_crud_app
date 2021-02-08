package com.morozov.springboot.crud.jm_springboot_crud_app.dao;


import com.morozov.springboot.crud.jm_springboot_crud_app.model.Role;
import com.morozov.springboot.crud.jm_springboot_crud_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
   // List<User> findAllByName(String name);
    User getUserByUsername(String name);

}
