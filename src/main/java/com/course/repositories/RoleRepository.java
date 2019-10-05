package com.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
