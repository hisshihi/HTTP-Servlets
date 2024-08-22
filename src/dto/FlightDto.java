package dto;

import lombok.*;

import java.util.Objects;

/**
 * Data Transfer Object (DTO) для сущности Flight.
 * Используется для передачи данных о рейсах между слоями приложения.
 */
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
@Builder
public class FlightDto {

    // Идентификатор рейса
    private final Long id;
    // Описание рейса
    private final String description;

}
