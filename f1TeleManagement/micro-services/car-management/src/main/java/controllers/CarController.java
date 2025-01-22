package controllers;

import contracts.ICarService;
import lombok.RequiredArgsConstructor;
import models.CarDto;
import models.CreateCarDto;
import models.UpdateCarDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final ICarService carService;

    @PostMapping
    public ResponseEntity<?> createCar(@Valid @RequestBody CreateCarDto carDto) {
        try{
            carService.createCar(carDto);
            return new ResponseEntity<>(OK);
        }catch (Exception e){
            return new ResponseEntity<>(NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateCar(@Valid @RequestBody UpdateCarDto carDto) {
        try{
            carService.updateCar(carDto);
            return new ResponseEntity<>(OK);
        }catch (Exception e){
            return new ResponseEntity<>(NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCarById(@PathVariable Long id){
        try{
            carService.deleteCarById(id);
            return new ResponseEntity<>(OK);
        }catch (Exception e){
            return new ResponseEntity<>(NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Long id){
        CarDto car = carService.getCarById(id);
        return car != null
                ? new ResponseEntity<>(car, OK)
                : new ResponseEntity<>(NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> getAllCars() {
        List<CarDto> cars = carService.getAllCars();
        return cars != null
                ? new ResponseEntity<>(cars, OK)
                : new ResponseEntity<>(NOT_FOUND);
    }
}
