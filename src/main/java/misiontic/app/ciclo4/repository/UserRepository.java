/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misiontic.app.ciclo4.repository;

import java.util.List;
import java.util.Optional;
import misiontic.app.ciclo4.model.User;
import misiontic.app.ciclo4.repository.crud.UserCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jhost
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepo userCrudRepo;
  
    public List<User> getAll() {
        return (List<User>) userCrudRepo.findAll();
    }
    
   
    public Optional<User> getUser(Integer id) {
        return userCrudRepo.findById(id);
    }
    public User getUserByEmail(String mail){
       return userCrudRepo.findByEmail(mail) ;
    }
    
    public User getByEmailAndPassword(String email,String password){
        return userCrudRepo.findNameByEmailAndPassword(email,password);
    }
    
    
    public User saveUser(User user) {
        return userCrudRepo.save(user);
    }
    

    
}