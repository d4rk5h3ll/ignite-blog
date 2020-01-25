/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.webtech.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ignite177
 */
@Getter
@Setter

public class UserDto {
//    @NotNull
    String name;
//    @NotNull
    String email;
//    @NotNull
    String password;
    
    MultipartFile file;
    String image_path;
    
}
