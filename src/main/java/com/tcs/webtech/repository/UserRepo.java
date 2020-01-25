/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.webtech.repository;

import com.tcs.webtech.model.WebtechUserdetails;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ignite177
 */

@Repository
public interface UserRepo extends JpaRepository<WebtechUserdetails, Integer>{
    public Optional<WebtechUserdetails> findByemail(String email);
}
