package org.example;

import java.util.List;

class User {
    String username;
    String password;
    String email;
    int same;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getSame() {
        return same;
    }
}

public class SILab2 {

    public static boolean function(User user, List<User> allUsers) {
        if (user == null || user.getPassword() == null || user.getEmail() == null) { //1
            throw new RuntimeException("Mandatory information missing!"); //2
        }

        if (user.getUsername() == null) { //3
            user.setUsername(user.getEmail()); //4
        }

        user.same = 1; //5
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) { //5
            user.same = 0; //6
            for (int i = 0; i < allUsers.size(); i++) { //7.1, 7.2, 7.3
                User existingUser = allUsers.get(i); //8
                if (existingUser.getEmail() == user.getEmail()) { //8
                    user.same += 1; //9
                }
                if (existingUser.getUsername() == user.getUsername()) { //10
                    user.same += 1; //11
                }
            }
        }


        String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`{|}"; //12
        String password = user.getPassword(); //12
        String passwordLower = password.toLowerCase(); //12

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length() < 8) { //13
            return false; //14
        } else { //15
            if (!passwordLower.contains(" ")) { //16
                for (int i = 0; i < specialCharacters.length(); i++) { //17.1, 17.2, 17.3
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) { //18
                        return user.same == 0; //19
                    }
                }
            }
        }
        return false; //20
    }
}
