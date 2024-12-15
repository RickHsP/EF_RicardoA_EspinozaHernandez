package pe.edu.cibertec.backoffice_s.response;

import pe.edu.cibertec.backoffice_s.dto.CarDto;

import java.util.List;

public record FindCarsResponse(String code,
                               String error,
                               List<CarDto> cars) {
}
