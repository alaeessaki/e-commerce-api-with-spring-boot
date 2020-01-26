package com.youcode.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.entities.Client;
import com.youcode.entities.Coupon;
import com.youcode.entities.LigneDePiece;
import com.youcode.entities.Review;
import com.youcode.exceptions.NotFoundException;
import com.youcode.services.interfaces.ClientServiceInterface;

@RestController
@CrossOrigin
@RequestMapping("api/clients")
public class ClientController {

	@Autowired
	ClientServiceInterface client_service;
	
	@GetMapping("")
	public ResponseEntity<List<Client>> getAll(){
		return ResponseEntity.ok(client_service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> getClient(@PathVariable("id")int id){
		Client client = client_service.get(id).orElseThrow(()->new NotFoundException("there is no client with this id"));
		return ResponseEntity.ok(client);
	}
	
	@PostMapping("")
	public ResponseEntity<Client> addClient(@RequestBody Client client){
		client_service.add(client);
		List<Coupon> coupons = new ArrayList<Coupon>();
		List<LigneDePiece> lignes_de_piece = new ArrayList<LigneDePiece>();
		List<Review> reviews = new ArrayList<Review>();
		
		client.setCoupons(coupons);
		client.setLignes_de_piece(lignes_de_piece);
		client.setReviews(reviews);

		return ResponseEntity.ok(client);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> modifyClient(@PathVariable("id")int id, @RequestBody Client client){
		client_service.get(id).orElseThrow(()->new NotFoundException("there is no Client with this id"));
		client.setId(id);
		client_service.add(client);
		return ResponseEntity.ok(client); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable("id")int id){
		client_service.get(id).orElseThrow(()->new NotFoundException("there is no Client with this id"));
		client_service.delete(id);
		return ResponseEntity.ok("client deleted successfully");
	}
}
