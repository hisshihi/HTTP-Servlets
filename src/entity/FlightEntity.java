package entity;

import java.time.LocalDateTime;
import java.util.Objects;

/**
        * Сущность Flight, представляющая рейс.
 */
public class FlightEntity {

    // Идентификатор рейса
    private Long id;
    // Номер рейса
    private String flightNo;
    // Дата и время вылета
    private LocalDateTime departureDate;
    // Код аэропорта вылета
    private String departureDateCode;
    // Дата и время прилета
    private LocalDateTime arrivalDate;
    // Код аэропорта прилета
    private String arrivalDateCode;
    // Идентификатор воздушного судна
    private int aircraftId;
    // Статус рейса
    private FlightStatus status;

    // Конструктор
    public FlightEntity(Long id, String flightNo, LocalDateTime departureDate, String departureDateCode, LocalDateTime arrivalDate, String arrivalDateCode, int aircraftId, FlightStatus status) {
        this.id = id;
        this.flightNo = flightNo;
        this.departureDate = departureDate;
        this.departureDateCode = departureDateCode;
        this.arrivalDate = arrivalDate;
        this.arrivalDateCode = arrivalDateCode;
        this.aircraftId = aircraftId;
        this.status = status;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureDateCode() {
        return departureDateCode;
    }

    public void setDepartureDateCode(String departureDateCode) {
        this.departureDateCode = departureDateCode;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalDateCode() {
        return arrivalDateCode;
    }

    public void setArrivalDateCode(String arrivalDateCode) {
        this.arrivalDateCode = arrivalDateCode;
    }

    public int getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    // Переопределенные методы equals(), hashCode() и toString()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightEntity that = (FlightEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "FlightEntity{" +
               "id=" + id +
               ", flightNo='" + flightNo + '\'' +
               ", departureDate=" + departureDate +
               ", departureDateCode='" + departureDateCode + '\'' +
               ", arrivalDate=" + arrivalDate +
               ", arrivalDateCode='" + arrivalDateCode + '\'' +
               ", aircraftId=" + aircraftId +
               ", status=" + status +
               '}';
    }
}
