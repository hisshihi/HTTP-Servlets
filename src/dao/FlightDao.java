package dao;

import entity.FlightEntity;
import entity.FlightStatus;
import util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * DAO (Data Access Object) для сущности Flight.
 * Реализует интерфейс Dao и предоставляет методы для
 * работы с данными о рейсах в базе данных.
 * Использует паттерн Singleton, чтобы гарантировать,
 * что существует только один экземпляр этого класса.
 */
public class FlightDao implements Dao<Long, FlightEntity> {

    // Единственный экземпляр класса FlightDao
    private static final FlightDao INSTANCE = new FlightDao();

    // SQL-запрос для получения всех рейсов
    private static final String FIND_ALL = """
            SELECT *
            FROM flight
            """;

    // Приватный конструктор, чтобы предотвратить создание экземпляров класса извне
    private FlightDao() {

    }

    /**
     * Возвращает список всех рейсов.
     *
     * @return Список всех рейсов.
     */
    @Override
    public List<FlightEntity> findAll() {
        // Получение соединения с базой данных
        try (Connection connection = ConnectionManager.getConnection()) {
            // Подготовка SQL-запроса
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            // Выполнение SQL-запроса и получение результата
            ResultSet resultSet = preparedStatement.executeQuery();
            // Создание списка для хранения рейсов
            List<FlightEntity> flights = new ArrayList<>();

            // Обработка результата запроса
            while (resultSet.next()) {
                // Создание объекта FlightEntity из текущей строки результата
                flights.add(buildFlight(resultSet));
            }

            // Возврат списка рейсов
            return flights;

        } catch (SQLException e) {
            // Обработка исключений SQLException
            throw new RuntimeException(e);
        }
    }

    // Другие методы интерфейса Dao (не реализованы)
    @Override
    public Optional<FlightEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public void update(FlightEntity entity) {

    }

    @Override
    public FlightEntity save(FlightEntity entity) {
        return null;
    }

    /**
     * Возвращает единственный экземпляр класса FlightDao.
     *
     * @return Единственный экземпляр класса FlightDao.
     */
    public static FlightDao getInstance() {
        return INSTANCE;
    }

    /**
     * Создает объект FlightEntity из строки результата запроса.
     *
     * @param resultSet Строка результата запроса.
     * @return Объект FlightEntity.
     * @throws SQLException Исключение, возникающее при ошибке работы с базой данных.
     */
    private FlightEntity buildFlight(ResultSet resultSet) throws SQLException {

        return new FlightEntity(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("flight_no", String.class),
                resultSet.getObject("departure_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("departure_date_code", String.class),
                resultSet.getObject("arrival_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("arrival_date_code", String.class),
                resultSet.getObject("aircraft_id", Integer.class),
                FlightStatus.valueOf(resultSet.getObject("status", String.class))
        );
    }
}
