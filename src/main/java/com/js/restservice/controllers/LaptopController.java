package com.js.restservice.controllers;

import com.js.restservice.model.Laptop;
import com.js.restservice.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @GetMapping("/filterLaptopsByManufacturer")
    public ResponseEntity<?> filterLaptopsByManufacturer(@RequestParam("manufacturer") String manufacturer){
        return ResponseEntity.ok().body(laptopService.getNumberOfLaptopsFilteredByManufacturer(manufacturer));
    }

    @GetMapping("/filterLaptopsByScreenResolution")
    public ResponseEntity<?> filterLaptopsByScreenResolution(@RequestParam("screenResolution") String screenResolution){
        return ResponseEntity.ok().body(laptopService.getNumberOfLaptopsByScreenResolution(screenResolution));
    }

    @GetMapping("/filterLaptopsByMatrixType")
    public ResponseEntity<List<Laptop>> filterLaptopsByMatrixType(@RequestParam String matrixType){
        return ResponseEntity.ok().body(laptopService.getLaptopsFilteredByMatrixType(matrixType));
    }

    @PostMapping("/addNewRecord")
    public ResponseEntity<?> addNewRecord(@RequestBody Laptop laptop){
        laptopService.addNewLaptopInfo(laptop);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/allRecord")
    public ResponseEntity<List<Laptop>> getAll(){
        return ResponseEntity.ok().body(laptopService.showAllLaptops());
    }

    @DeleteMapping("/deleteRecord/{id}")
    public ResponseEntity<?> deleteLaptop(@PathVariable("id") Long id){
        laptopService.deleteLaptop(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/updateRecord/{id}")
    public ResponseEntity<?> updateLaptop(@PathVariable("id") Long id, @RequestBody Laptop laptop){
        laptopService.updateLaptop(id, laptop);
        return ResponseEntity.ok().build();
    }

}
