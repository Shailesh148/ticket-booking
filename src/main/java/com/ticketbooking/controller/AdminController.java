package com.ticketbooking.controller;


import com.ticketbooking.model.Movie;
import com.ticketbooking.model.Show;
import com.ticketbooking.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booking/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService adminService;


    @PostMapping("add_movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        adminService.addMovie(movie);
        return new ResponseEntity<String>("Saved", HttpStatus.OK);
    }

    @PostMapping("add_show")
    public ResponseEntity<String> addShow(@RequestBody Show show){
        adminService.addShow(show);
        return new ResponseEntity<String>("Saved", HttpStatus.OK);
    }
}
