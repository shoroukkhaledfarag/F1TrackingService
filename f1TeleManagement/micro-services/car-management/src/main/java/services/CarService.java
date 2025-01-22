package services;

import contracts.ICarService;
import entities.Car;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import models.CarDto;
import models.CreateCarDto;
import models.UpdateCarDto;
import org.springframework.stereotype.Service;
import repositories.CarRepository;
import utilities.mappers.carMapper;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarService implements ICarService {

    private final CarRepository carsRepository;
    private final carMapper carMapper;

    @Override
    public CarDto createCar(CreateCarDto carDto) {
        Car car = carMapper.mapToEntity(carDto);
        try {
            Car carSaved = carsRepository.save(car);
            return carMapper.mapToCarDto(carSaved);
        } catch (Exception e) {
            log.error("Error while saving car", e);
            throw new RuntimeException("Error while saving car");
        }
    }

    @Override
    public CarDto updateCar(UpdateCarDto carDto) {
        CheckIfCarExists(carDto.getId());
        Car car = carsRepository.findById(carDto.getId()).get();
        car.setName(carDto.getName());
        car.setCarNumber(carDto.getCarNumber());
        car.setSeason(carDto.getSeason());
        try {
            Car carSaved = carsRepository.save(car);
            return carMapper.mapToCarDto(carSaved);
        } catch (Exception e) {
            log.error("Error while saving car", e);
            throw new RuntimeException("Error while saving car");
        }
    }

    @Override
    public void deleteCarById(Long carId) {
        CheckIfCarExists(carId);
        try{
            carsRepository.deleteById(carId);
        }catch (Exception e) {
            log.error("Error while deleting car with id " + carId, e);
            throw new RuntimeException("Error while deleting car with id " + carId);
        }
    }

    @Override
    public CarDto getCarById(Long carId) {
        CheckIfCarExists(carId);
        Optional<Car> carOptional = carsRepository.findById(carId);
        return carMapper.mapToCarDto(carOptional.get());
    }

    @Override
    public List<CarDto> getAllCars() {
        return null;
    }

    private void CheckIfCarExists(Long carId) {
        Boolean CarExists = carsRepository.existsById(carId);
        if (!CarExists) throw new RuntimeException("Car Was Not Found");
    }
}
