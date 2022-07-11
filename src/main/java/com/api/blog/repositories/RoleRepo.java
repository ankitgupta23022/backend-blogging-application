package com.api.blog.repositories;

import com.api.blog.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo  extends JpaRepository<Role, Integer>{

}
