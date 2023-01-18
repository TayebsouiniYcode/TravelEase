package com.youcode.travelease.repository;

import com.youcode.travelease.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository< Role, Long> {
//    Role findByName(String name);
//    Role findByRole_name(String role_name);
//    Role findRoleByRole_name(String role_name);
//    Role getRoleByRole_name(String role_name);

    @Query("SELECT r FROM Role r WHERE r.role_name=?1")
    public Role getRoleByName(String role_name);

}
