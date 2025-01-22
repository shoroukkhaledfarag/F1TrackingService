package contracts;

import models.CarDto;
import models.CreateCarDto;
import models.UpdateCarDto;

import java.util.List;

public interface ICarService {

    CarDto createCar(CreateCarDto carDto);
    CarDto updateCar(UpdateCarDto carDto);
    void deleteCarById(Long carId);
    CarDto getCarById(Long carId);
    List<CarDto> getAllCars();
}
