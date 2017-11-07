package com.yandreamteam.server.service.impl;

import com.yandreamteam.server.dao.RoleDao;
import com.yandreamteam.server.dao.UserDao;
import com.yandreamteam.server.models.Role;
import com.yandreamteam.server.models.User;
import com.yandreamteam.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link com.yandreamteam.server.service.UserService} interface.
 *
 * @author Alexandr Butusov
 * @version 0.1
 */

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private RoleDao roleDao;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleDao.getOne(1L));
        user.setRoles(userRoles);
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
