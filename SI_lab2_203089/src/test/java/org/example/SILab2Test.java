package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void everyBranch(){
        //1
        List<User> users = new ArrayList<>();
        RuntimeException ex;
        User user = null;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //2
        User user1 = new User(null, "Abc1234@!", "abc@gmail.com");
        SILab2.function(user1, users);
        assertEquals(user1.email, user1.getUsername());

        //3
        User user2 = new User("abc", "abcabcabc", "abcgmail.com");
        SILab2.function(user2, users);
        assertEquals(1, user2.getSame());

        //4
        User user4 = new User("abc", "abc$$abc%", "abc@gmail.com");
        SILab2.function(user4, users);
        assertEquals(0, user4.getSame());

        //5
        users.add(user1);
        users.add(user2);
        User user3 = new User("abc", "abc$$abc%", "abc@gmail.com");
        SILab2.function(user3, users);
        assertEquals(2, user3.getSame());


    }

    @Test
    void multipleCondition() {
        //1
        List<User> users = new ArrayList<>();
        RuntimeException ex;
        User user = null;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //2
        User user1 = new User("abc", null, "abc@gmail.com");
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user1, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //3
        User user2 = new User("abc", "abc123", null);
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //4
        User user3 = new User("abcd", "Abc1234@!", "abcd@gmail.com");
        assertTrue(SILab2.function(user3, users));
    }


}