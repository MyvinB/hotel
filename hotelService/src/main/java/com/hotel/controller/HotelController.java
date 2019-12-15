package com.hotel.controller;

import com.hotel.model.Hotel;
import com.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
@CrossOrigin
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<?> getList() {


        List<Hotel> hotelList = hotelService.getList();

        return new ResponseEntity<>(hotelList, HttpStatus.CREATED);

    }
}
