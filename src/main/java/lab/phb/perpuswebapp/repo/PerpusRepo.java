/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.phb.perpuswebapp.repo;

/**
 *
 * @author ekatesar
 */

import lab.phb.perpuswebapp.entity.Perpus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerpusRepo extends JpaRepository<Perpus,String> {
	Perpus findOneById(String id);
}
