package com.sabora.server.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sabora.server.Services.ConnectionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class VRGlassesConnectionController {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    ConnectionServices connectionServices;

    @PostMapping("/glassses/add-connection")
    public ResponseEntity addConnection(@RequestBody HashMap<String, ?> body){
        try {
            return connectionServices.addVRGlassesConnection(mapper.writeValueAsString(body));
        }catch (Exception e){
            return new ResponseEntity("Error creating connection.",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/mobile/remove-connection")
    public ResponseEntity removeConnection(@RequestBody HashMap<String, ?> body){
        try{
            return connectionServices.removeVRGlassesConnection(mapper.writeValueAsString(body));
        }catch (Exception e){
            return new ResponseEntity("Error removing connection.",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/glasses/search-mobile")
    public ResponseEntity searchMobile(@RequestBody HashMap<String, ?> body){
        try {
            return connectionServices.getConnectedMobileDirection(mapper.writeValueAsString(body));
        }catch (Exception e){
            return new ResponseEntity("Error searching mobiles." + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}