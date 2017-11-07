package com.yandreamteam.server.service;

import com.yandreamteam.server.models.User;

/**
 * Service class for {@link com.yandreamteam.server.models.User}.
 *
 * @author Alexandr Butusov
 * @version 0.1
 */

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
