
package misiontic.app.ciclo4.controller;

import java.util.List;
import java.util.Optional;
import static java.util.Optional.empty;
import misiontic.app.ciclo4.model.User;
import misiontic.app.ciclo4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jhost
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {
    @Autowired
    private UserService userService;
   
    /**
     * creacion de metodo para obtener todos los elementos de la tabla user
     * @return 
     */
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
   
    }
    /**
     * creacion de metodo para obtener un boolean para confirmar si existe o no el usuario
     * @param email
     * @return 
     */
     @GetMapping("/{email}")
    public boolean getUserByEmail(@PathVariable("email") String email){
      return userService.getUserby(email)!=null;
    }
    /**
     * creacion de metodo para obtener un usuario para confimar si existe o no el usuario
     * @param email
     * @param password
     * @return 
     */
    @GetMapping("/{email}/{password}")
    public User getByUserEmailAndUserPassword(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.getByEmailAndPassword(email,password);
    }
    
   /**
    * metodo para crear un nuevo usuario
    * @param user
    * @return 
    */

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return userService.saveUser(user);
    }
    
    

}
