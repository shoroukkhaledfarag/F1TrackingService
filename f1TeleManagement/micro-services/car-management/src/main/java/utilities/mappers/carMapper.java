package utilities.mappers;


import entities.Car;
import models.CarDto;
import models.CreateCarDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface carMapper {

    Car mapToEntity(CarDto carDto);
    Car mapToEntity(CreateCarDto carDto);
    CarDto mapToCarDto(Car car);

}
