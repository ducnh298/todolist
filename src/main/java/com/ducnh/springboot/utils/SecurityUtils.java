package com.ducnh.springboot.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import com.ducnh.springboot.dto.UserDTO;

public class SecurityUtils {

    public static UserDTO getPrincipal() {
        return  (UserDTO) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
    }
}