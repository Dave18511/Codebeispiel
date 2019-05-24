package org.isse.sopro.bo;

import java.util.Random;

public class RandomPasswords {

    /**
     *
     * Generates a Random Password String with given characters and length
     *
     * @return
     */
    public static String randomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String pwd = randomString( 12, characters );
        return pwd;
    }

    private static String randomString(int length, String chars) {
        StringBuilder s = new StringBuilder() ;
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            s.append(chars.charAt(r.nextInt(chars.length())));
        }
        return new String(s);
    }
}
