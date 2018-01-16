/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.phb.perpuswebapp.controller;

/**
 *
 * @author ekatesar
 */
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import lab.phb.perpuswebapp.repo.PerpusRepo;
import lab.phb.perpuswebapp.entity.Perpus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context
	.SecurityContextHolder;
import org.springframework.security.web.authentication
	.logout.SecurityContextLogoutHandler;

@RestController
public class ApiController {
    
    @Autowired
    private PerpusRepo prpsRepo;

    // aplikasi perpus
    @RequestMapping("/daftar-perpus")
	public List<Perpus> getDaftarPerpus() {
		return prpsRepo.findAll();
	}

	@RequestMapping(value = "/hapus/{id}", method = RequestMethod.DELETE)
	public void hapus(@PathVariable("id") String id){
		prpsRepo.delete(id);
	}

	@RequestMapping(value = "/simpan", method = RequestMethod.POST)
	public void simpan(@RequestBody Perpus prps) {
		//System.out.println("nim : " + mhs.getNim());
		//System.out.println("nama : " + mhs.getNama());
		//System.out.println("jurusan : " + mhs.getJurusan());
		prpsRepo.save(prps);
	}

	@RequestMapping("/ambil-data-prps/{id}")
	public Perpus getDataPrps(@PathVariable("id") String id) {
		return prpsRepo.findOneById(id);
	}

	@RequestMapping("/logout")
	public void logout(HttpServletRequest req,
			HttpServletResponse resp) {
		Authentication auth = 
			SecurityContextHolder.getContext()
				.getAuthentication();
		new SecurityContextLogoutHandler()
		    .logout(req, resp, auth);
	}
}
