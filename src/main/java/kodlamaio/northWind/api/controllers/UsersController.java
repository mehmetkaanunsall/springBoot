
package kodlamaio.northWind.api.controllers;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import kodlamaio.northWind.business.abstracts.UserService;
import kodlamaio.northWind.core.utilities.entities.User;
import kodlamaio.northWind.core.utilities.results.ErrorDataResult;
import kodlamaio.northWind.core.utilities.results.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {
    
    private UserService userservice;

    public UsersController(UserService userservice) {
        this.userservice = userservice;
    }
    
    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user)
    {
       return ResponseEntity.ok(this.userservice.add(user)) ;
    }
    
    
    
    //Bütün validation hataları olduğu zaman bu fonksiyon çalışsın annotationı bu
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions)
    {
        Map<String,String> validationErros = new HashMap<String, String>();
        for (FieldError fielderror: exceptions.getBindingResult().getFieldErrors()) {
         validationErros.put(fielderror.getField(), fielderror.getDefaultMessage());
        }
        ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(validationErros,"Doğrulama Hataları Bulundu.");
        return errorDataResult;
    }
    
    
}
