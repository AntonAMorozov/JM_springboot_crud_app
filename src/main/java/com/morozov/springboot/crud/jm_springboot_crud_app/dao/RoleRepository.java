package com.morozov.springboot.crud.jm_springboot_crud_app.dao;

import com.morozov.springboot.crud.jm_springboot_crud_app.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role getRoleById(long id);
}
