package service;


import dao.FlightDao;
import dto.FlightDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Сервис для работы с рейсами.
 */
public class FlightService {

    // **Объявление и инициализация единственного экземпляра FlightService**
    private static final FlightService INSTANCE = new FlightService();

    // Экземпляр DAO для работы с данными о рейсах
    private final FlightDao flightDao = FlightDao.getInstance();

    private FlightService() {}

    /**
     * Возвращает список всех рейсов в формате DTO.
     *
     * @return Список всех рейсов в формате DTO.
     */
    public List<FlightDto> findAll() {
        // Получение списка всех рейсов из DAO
        return flightDao.findAll().stream()
                // Преобразование каждого объекта FlightEntity в FlightDto
                .map(flightEntity -> new FlightDto(
                        flightEntity.getId(),
                        """
                        %s - %s - %s
                        """.formatted(flightEntity.getDepartureDateCode(), flightEntity.getArrivalDateCode(), flightEntity.getStatus())
                ))
                // Сбор результатов в список
                .collect(toList());
    }

    /**
     * **Публичный статический метод для получения единственного экземпляра FlightService.**
     *
     * @return Единственный экземпляр FlightService.
     */
    public static FlightService getInstance() {
        return INSTANCE;
    }

}
