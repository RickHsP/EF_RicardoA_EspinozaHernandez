package pe.edu.cibertec.backoffice_s.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.backoffice_s.dto.CarDetailDto;
import pe.edu.cibertec.backoffice_s.dto.CarDto;
import pe.edu.cibertec.backoffice_s.dto.CarUpdateDto;
import pe.edu.cibertec.backoffice_s.response.*;
import pe.edu.cibertec.backoffice_s.service.ManageCarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manage-car")
public class ManageCarApi {

    @Autowired
    ManageCarService manageCarService;

    @GetMapping("/all")
    public FindCarsResponse findCarsAll()
    {
        try {
            List<CarDto> cars = manageCarService.getCarsAll();
            if (!cars.isEmpty())
                return new FindCarsResponse("01", null, cars);
            else
                return new FindCarsResponse("02", "Not found you Car", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarsResponse("99", "Cars Ocurred problem", null);
        }
    }
    @GetMapping("/detail")
    public FindCarResponse findCar(@RequestParam(value = "id", defaultValue = "0") String id) {
        try {
            Optional<CarDetailDto> optional = manageCarService.getCarById(Integer.parseInt(id));
            return optional.map(car ->
                    new FindCarResponse("01", null, car)
            ).orElse(
                    new FindCarResponse("02", null, null)
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarResponse("99", "Not Found you Car", null);
        }
    }
    @PutMapping("/update")
    public UpdateCarResponse updateCar(@RequestBody CarDto carDto) {
        try {
            if (manageCarService.updateCar(carDto))
                return new UpdateCarResponse("01", null);
            else
                return new UpdateCarResponse("02", "ocurred error");
        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99", "try again,error!!!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public DeleteCarResponse updateCar(@PathVariable String id) {
        try {
            if (manageCarService.deleteCarId(Integer.parseInt(id)))
                return new DeleteCarResponse("01", null);
            else
                return new DeleteCarResponse("02", "a try again,error!!!");
        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("99", "try again,error!!!");
        }
    }
    @PostMapping("/create")
    public CreateCarResponse createCar(@RequestBody CarUpdateDto carUpdateDto) {
        try {
            if (manageCarService.addCar(carUpdateDto))
                return new CreateCarResponse("01", null);
            else
                return new CreateCarResponse("02", "a try again,error!!!");
        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("99", "try again,error!!!");
        }

    }
}
