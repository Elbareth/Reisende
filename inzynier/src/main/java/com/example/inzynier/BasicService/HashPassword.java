package com.example.inzynier.BasicService;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {
    public String hashMyPassword(String password, String shaszowaneHaslo){
        try{ // haslo hszujemy by bylo bezpieczne. W bazie sa juz shaszowane hasla
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1,messageDigest);
            shaszowaneHaslo = no.toString();
        }
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return shaszowaneHaslo;
    }
}
