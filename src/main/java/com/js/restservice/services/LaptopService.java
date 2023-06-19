package com.js.restservice.services;


import com.js.restservice.model.Laptop;
import com.js.restservice.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {

    @Autowired
    LaptopRepository laptopRepository;


//    private List<Laptop> laptops = getAllLaptops();
    public int getNumberOfLaptopsFilteredByManufacturer(String manufacturer){
        int count=0;
        List<Laptop> laptops = laptopRepository.findAll();
        for(Laptop laptop:laptops){
            if(laptop.getNazwaProducenta().equals(manufacturer)){
                count++;
            }
        }
        return count;
    }

    public List<Laptop> getLaptopsFilteredByMatrixType(String matrixType){
        List<Laptop> laptops = laptopRepository.findAll();
        List<Laptop> filteredLaptops = new ArrayList<>();
        for (Laptop laptop:laptops){
            if (laptop.getRodzajEkranu().equals(matrixType)){
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }

    public int getNumberOfLaptopsByScreenResolution(String screenResolution){
        List<Laptop> laptops = laptopRepository.findAll();
        int count=0;
        for (Laptop laptop:laptops){
            if (laptop.getRozdzielczosc().equals(screenResolution)){
                count++;
            }
        }
        return count;
    }

    public Laptop addNewLaptopInfo(Laptop laptop){
        return laptopRepository.save(laptop);
    }

    public void deleteLaptop(Long id){
        Optional<Laptop> laptopFromDb = laptopRepository.findById(id);
        laptopRepository.delete(laptopFromDb.get());
    }
}
