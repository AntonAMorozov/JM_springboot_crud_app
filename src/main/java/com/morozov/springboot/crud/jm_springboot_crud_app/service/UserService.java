package com.morozov.springboot.crud.jm_springboot_crud_app.service;


import com.morozov.springboot.crud.jm_springboot_crud_app.model.Role;
import com.morozov.springboot.crud.jm_springboot_crud_app.model.User;

import java.util.List;

public interface UserService {

    User getUserByName(String username);

    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(long id);

    void deleteUser(long id);

    List<Role> getAllRoles();

    Role getRoleById(long id);
}
