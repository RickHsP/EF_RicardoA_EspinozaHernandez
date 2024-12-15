package pe.edu.cibertec.backoffice_s.dto;

public record CarDto(Integer carId,
                     String make,
                     String model,
                     Integer year,
                     String ownerName,
                     String engineType,
                     String color) {
}
