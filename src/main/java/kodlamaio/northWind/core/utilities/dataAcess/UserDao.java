/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodlamaio.northWind.core.utilities.dataAcess;

import kodlamaio.northWind.core.utilities.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kaan.unsal
 */
public interface UserDao extends JpaRepository<User,Integer>{
    User findByEmail(String email);
}
