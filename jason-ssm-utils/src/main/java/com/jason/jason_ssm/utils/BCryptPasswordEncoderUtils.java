package com.jason.jason_ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

    public static String encodePassword(String raw_password){
        return bCryptPasswordEncoder.encode(raw_password);
    }

    public static void main(String[] args) {
        System.out.println(BCryptPasswordEncoderUtils.encodePassword("123456"));
    }
}

//$2a$10$N0lXwmC.ipmkwac8w6aRoudI5OaoHcA6g2HhNDwWZwgK6BOdiTciO
//$2a$10$i/SnzIgDZTSjdd6mqnT8V.PZZMOblCeybfO5yP/3C8zzu.eUibn2y
