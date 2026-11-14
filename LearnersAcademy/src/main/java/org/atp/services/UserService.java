package org.atp.services;

import org.atp.daos.UserDao;
import org.atp.daos.UserDaoImpl;
import org.atp.entities.User;

public class UserService {
        User user=new User();
        UserDao dao=new UserDaoImpl();
        public void createUser(String username,String password){
            user.setUsername(username);
            user.setPassword(password);
            dao.saveUser(user);
        }
        public boolean loginUser(String username,String password){
            boolean status=false;
            status=dao.getUser(username, password);
            return status;
        }
}
