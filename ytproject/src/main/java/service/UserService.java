package service;

import dao.UserDAO;
import model.User;

import java.sql.SQLException;

public class UserService {
    public static Integer saveUser(User user){
        try{
            // to avoid the duplicate emails...
            if(UserDAO.isExists(user.getEmail())){
                return 0;
            }else{
                UserDAO.saveUser(user);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
