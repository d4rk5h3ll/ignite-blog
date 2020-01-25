/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.webtech.controller;

import com.tcs.webtech.dto.UserDto;
import com.tcs.webtech.model.WebtechUserdetails;
import com.tcs.webtech.repository.UserRepo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Optional;
import javax.validation.Valid;
import javax.xml.ws.soap.AddressingFeature;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ignite177
 */
@RestController
@RequestMapping("/")
public class UserController {
    Optional<WebtechUserdetails> webt;
    @Autowired
    UserRepo urepo;
    @Autowired
    Environment env;

    @GetMapping("/login")
    public ModelAndView LoginView() {
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("Login.html");
        return modelView;
    }

    @PostMapping("login/auth")
    public ModelAndView Auth(@Valid UserDto udto, BindingResult result) {
        Optional<WebtechUserdetails> wtud = urepo.findByemail(udto.getEmail());
//        String  st = wtud.get().getName();
        if (wtud.isPresent()) {
            if (udto.getPassword().equals(wtud.get().getPwd())) {
                webt = wtud;
                return new ModelAndView("CreateAccount.html");

            } else {
                return new ModelAndView("Login.html");
            }
        } else {
            return new ModelAndView("Login.html");
        }

    }
    @GetMapping("/URI")
    public ResponseEntity RegViewu() {
       return ResponseEntity.ok(webt);
    }
    
    

    @GetMapping("/register")
    public ModelAndView RegView() {
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("Registration.html");
        return modelView;
    }

    @PostMapping("/register/reg")
    public ResponseEntity RegData(@Valid UserDto udto, BindingResult result) {

        String CrntDir = System.getProperty("user.dir"); //Get Current Dir
        String imgDir = File.separator+env.getProperty("file-path"); //Get Image Dir
        String filepath = CrntDir+imgDir; //Full path
        File file = new File(filepath, udto.getFile().getOriginalFilename());
        udto.setImage_path(udto.getFile().getOriginalFilename());
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(udto.getFile().getBytes());
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return ResponseEntity.ok(CrntDir+" = "+imgDir);

        return ResponseEntity.ok(urepo.save(new WebtechUserdetails(udto.getName(), udto.getEmail(), udto.getPassword(), udto.getImage_path(),new Date(),false)));
    }
    @GetMapping("/down")
    public ResponseEntity imageFetch() throws FileNotFoundException, IOException{
        
        String img = webt.get().getImagePath();
        String filepath = System.getProperty("user.dir")+ File.separator + env.getProperty("file-path") + File.separator + img;
        File file=new File(filepath);
        InputStream is = new FileInputStream(file);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_PNG).body(IOUtils.toByteArray(is));
    }
    @GetMapping("/Logout")
    public ModelAndView logout(){
        webt = null;
        return new ModelAndView("Login.html");
    }
    
}
