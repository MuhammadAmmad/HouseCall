package com.example.stephen.housecall;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Created by Stephen on 2016-07-27.
 */
public class Password {

    public static String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(12));
    }

    //TODO: test what happens when checked with null or symbols in candidate
    public static Boolean checkPassword(String candidate, String storedHashed) {
        return BCrypt.checkpw(candidate, storedHashed);
    }
}
