/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bll;

import dal.UserRepository;
import dto.User;
import java.util.List;

/**
 *
 * @author PC
 */
public class UserManager {

    private static List<User> users;

    public static List<User> getUsers() {
        if (users == null) {
            users = UserRepository.loadUsers();
        }
        return users;
    }

    public static void setUsers(List<User> newUsers) {
        UserRepository.saveUsers(newUsers);
        users = newUsers;
    }
}
