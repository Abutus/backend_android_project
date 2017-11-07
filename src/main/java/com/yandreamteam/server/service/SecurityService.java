package com.yandreamteam.server.service;

/**
 * Service for security.
 *
 * @author Alexandr Butusov
 * @version 0.1
 */

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
