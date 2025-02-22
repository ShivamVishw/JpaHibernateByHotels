package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Hotel;
import com.example.demo.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	//Getting data by GetMaping
	@GetMapping
	public List<Hotel> getAllHotel(){
		return hotelService.getAllHotel();
	}
	
	
	//Create Hotel for adding new hotel by PostMapping
	@PostMapping
	public Hotel addHotel(@RequestBody Hotel hotel) {
		return hotelService.saveHotel(hotel);
	}
	
	
	//updating hotel data by using PutMapping
	@PutMapping("/{id}")
	public ResponseEntity<Hotel> updateHotels(@PathVariable Long id, @RequestBody Hotel updateHotel){
		
		Hotel existingHotel = hotelService.getHotelbyId(id);
		
		if(existingHotel!=null) {
			existingHotel.setName(updateHotel.getName());
			existingHotel.setHoteltype(updateHotel.getHoteltype());
			existingHotel.setQuality(updateHotel.getQuality());
			
			Hotel savedHotel = hotelService.updateHotel(existingHotel);
			
			return ResponseEntity.ok(savedHotel);
			
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteHotelById(@PathVariable Long id){
		
		boolean isDeleted = hotelService.deleteHotelById(id);
		
		if(isDeleted) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
