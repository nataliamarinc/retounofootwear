/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misiontic.app.ciclo4.service;

import java.util.List;
import java.util.Optional;
import misiontic.app.ciclo4.model.User;
import misiontic.app.ciclo4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jhost
 */
 @Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
   

    public List<User> getAll() {
        return userRepository.getAll();
    }
    
   
    public Optional<User> getUser(Integer idUser) {
        return userRepository.getUser(idUser);
    }
   
  public User saveUser(User user){
        if (user.getId() == null){
            if (getUserByEmail(user.getEmail()) == false){
                return userRepository.saveUser(user);
            }else{
                return user;
            }
        }else {
            return user;
        }
    }
 

    public boolean getUserByEmail(String email){
        return userRepository.getUserByEmail(email) != null;
    }
     public User getUserby(String email) {
        return userRepository.getUserByEmail(email);
    }
      public User getByEmailAndPassword(String email,String password){
        User user=userRepository.getByEmailAndPassword(email,password);
        User tempuser = new User();
        
        if(user==null){            
            tempuser.setName("NO DEFINIDO");
            tempuser.setPassword(password);
            tempuser.setEmail(email);  
            return tempuser;         
        }
        return user;
        
           
    }
   
}
