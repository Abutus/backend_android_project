package com.yandreamteam.server.dao;

import com.yandreamteam.server.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
