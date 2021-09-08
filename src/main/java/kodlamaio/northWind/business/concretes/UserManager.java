
package kodlamaio.northWind.business.concretes;

import kodlamaio.northWind.business.abstracts.UserService;
import kodlamaio.northWind.core.utilities.dataAcess.UserDao;
import kodlamaio.northWind.core.utilities.entities.User;
import kodlamaio.northWind.core.utilities.results.DataResult;
import kodlamaio.northWind.core.utilities.results.Result;
import kodlamaio.northWind.core.utilities.results.SuccesResult;
import kodlamaio.northWind.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserManager implements UserService{
   
    private UserDao userdao;

    @Autowired
    public UserManager(UserDao userdao) {
        this.userdao = userdao;
    }
    
    

    @Override
    public Result add(User user) {
        this.userdao.save(user);
       return new SuccesResult("Kullanıcı Ekşlendi.");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userdao.findByEmail(email),"Kullanıcı Bulundu.");
    }
    
}
