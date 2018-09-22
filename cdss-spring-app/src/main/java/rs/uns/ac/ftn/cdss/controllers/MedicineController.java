package rs.uns.ac.ftn.cdss.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ac.ftn.cdss.service.MedicineService;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

	
	@Autowired
	MedicineService medicineService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(medicineService.getAll(),HttpStatus.OK);
	}
	
}
