/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.am.stoms.utils;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author manjul For password we are using SHA3-512 salted hash
 */
public class SHAHash {

    private static final String SALT_1 = "zm7?Ir0C:<w$gzrTG|vOq<MoA8S!dnHSS3(+Ii,F'rk4zVNv!K"; // Random String 1
    private static final String SALT_2 = "@,4.Ry,yIw6*@'rddFuk'(Mn:|&Xn76l,+8f@?*vJI(lH(mV1Z"; // Random String 2

    public static String hash(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(text.getBytes("UTF-8"));
            byte[] digest = md.digest();
            return Hex.encodeHexString(digest);
        } catch (Exception ex) {
            // This shouldn't happen
            Logger.getLogger(SHAHash.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String saltedHash(String text) {
        return hash(SALT_1 + text + SALT_2);
    }

    public static String hashPassword(String plainPassword) {
        return saltedHash(plainPassword);
    }

}
