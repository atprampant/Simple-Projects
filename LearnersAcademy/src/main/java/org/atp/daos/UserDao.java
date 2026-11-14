package org.atp.daos;

import org.atp.entities.User;

public interface UserDao {
    void saveUser(User user);
    boolean getUser(String username, String password);
}

