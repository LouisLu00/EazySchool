package com.louis.EazySchool.Repository;

import com.louis.EazySchool.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Roles getByRoleName(String roleName);
}
