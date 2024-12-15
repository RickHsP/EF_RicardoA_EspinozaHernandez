package pe.edu.cibertec.backoffice_s.response;

import pe.edu.cibertec.backoffice_s.dto.CarDetailDto;

public record FindCarResponse(String code,
                              String error,
                              CarDetailDto carDetailDto) {
}
