/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misiontic.app.ciclo4.repository.crud;

import java.util.List;
import java.util.Optional;
import misiontic.app.ciclo4.model.User;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jhost
 */
public interface UserCrudRepo extends CrudRepository<User,Integer>{
    
   public User findByEmail(String email);
   @Query("select u from User u where u.email = :email and u.password = :password")
    User findNameByEmailAndPassword(@Param("email") String email,
                                   @Param("password") String password);
   
}
