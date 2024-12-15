package pe.edu.cibertec.backoffice_s.service;

import pe.edu.cibertec.backoffice_s.dto.CarDetailDto;
import pe.edu.cibertec.backoffice_s.dto.CarDto;
import pe.edu.cibertec.backoffice_s.dto.CarUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ManageCarService {
    List<CarDto> getCarsAll() throws Exception;
    Optional<CarDetailDto> getCarById(int id) throws Exception;
    boolean updateCar(CarDto carDto) throws Exception;
    boolean deleteCarId(int id) throws Exception;
    boolean addCar(CarUpdateDto carUpdateDto) throws Exception;
}
