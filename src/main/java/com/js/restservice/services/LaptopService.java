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

    public List<Laptop> showAllLaptops(){
        return (List<Laptop>) laptopRepository.findAll();
    }
    public void addNewLaptopInfo(Laptop laptop){
        Laptop newLaptop = new Laptop (0L, laptop.getNazwaProducenta(), laptop.getPrzekatnaEkranu(),
                laptop.getRozdzielczosc(), laptop.getRodzajEkranu(), laptop.getCzyDotykowy(),
                laptop.getNazwaProcesora(), laptop.getLiczbaRdzeni(), laptop.getTaktowanie(),
                laptop.getPamiecRam(), laptop.getPojemnoscDysku(), laptop.getRodzajDysku(),
                laptop.getNazwaUg(), laptop.getPamiecUg(), laptop.getNazwaSo(), laptop.getRodzajNapedu());
        laptopRepository.save(newLaptop);
    }

    public void deleteLaptop(Long id){
        Optional<Laptop> laptopFromDb = laptopRepository.findById(id);
        laptopRepository.delete(laptopFromDb.get());
    }

    public void updateLaptop(Long id, Laptop laptop){
        Optional<Laptop> laptopFromDb = laptopRepository.findById(id);
        if(laptopFromDb.isPresent()){
            laptopFromDb.get().setNazwaProducenta(laptop.getNazwaProducenta());
            laptopFromDb.get().setPrzekatnaEkranu(laptop.getPrzekatnaEkranu());
            laptopFromDb.get().setRozdzielczosc(laptop.getRozdzielczosc());
            laptopFromDb.get().setRodzajEkranu(laptop.getRodzajEkranu());
            laptopFromDb.get().setCzyDotykowy(laptop.getCzyDotykowy());
            laptopFromDb.get().setNazwaProcesora(laptop.getNazwaProcesora());
            laptopFromDb.get().setLiczbaRdzeni(laptop.getLiczbaRdzeni());
            laptopFromDb.get().setTaktowanie(laptop.getTaktowanie());
            laptopFromDb.get().setPamiecRam(laptop.getPamiecRam());
            laptopFromDb.get().setPojemnoscDysku(laptop.getPojemnoscDysku());
            laptopFromDb.get().setRodzajDysku(laptop.getRodzajDysku());
            laptopFromDb.get().setNazwaUg(laptop.getNazwaUg());
            laptopFromDb.get().setPamiecUg(laptop.getPamiecUg());
            laptopFromDb.get().setNazwaSo(laptop.getNazwaSo());
            laptopFromDb.get().setRodzajNapedu(laptop.getRodzajNapedu());
            laptopRepository.save(laptopFromDb.get());
        }
    }
}
