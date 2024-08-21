package dto;

import java.util.Objects;

/**
 * Data Transfer Object (DTO) для сущности Flight.
 * Используется для передачи данных о рейсах между слоями приложения.
 */
public class FlightDto {

    // Идентификатор рейса
    private final Long id;
    // Описание рейса
    private final String description;

    // Конструктор
    public FlightDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    // Геттеры
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    // Переопределенные методы equals(), hashCode() и toString()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightDto flightDto = (FlightDto) o;
        return Objects.equals(id, flightDto.id) && Objects.equals(description, flightDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "FlightDto{" +
               "id=" + id +
               ", description='" + description + '\'' +
               '}';
    }
}
