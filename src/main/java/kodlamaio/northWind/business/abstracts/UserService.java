/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodlamaio.northWind.business.abstracts;

import kodlamaio.northWind.core.utilities.entities.User;
import kodlamaio.northWind.core.utilities.results.DataResult;
import kodlamaio.northWind.core.utilities.results.Result;

/**
 *
 * @author kaan.unsal
 */
public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
}
