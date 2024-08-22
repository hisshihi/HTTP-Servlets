package dao;

import entity.TicketEntity;
import util.ConnectionManager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDao implements Dao<Long, TicketEntity> {

    private static final TicketDao INSTANCE = new TicketDao();
    private static final String FIND_ALL_BY_FLIGHT_ID = """
        SELECT *
        FROM ticket
        WHERE flight_id = ?
    """;

    private TicketDao() {
    }

    public static TicketDao getInstance() {
        return INSTANCE;
    }

    // Поиск билетов по id перелёта
    public List<TicketEntity> findAllByFlightId(Long flightId) {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BY_FLIGHT_ID)) {
            preparedStatement.setObject(1, flightId);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<TicketEntity> tickets = new ArrayList<>();

            while (resultSet.next()) {
                tickets.add(buildticket(resultSet));
            }

            return tickets;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private TicketEntity buildticket(ResultSet resultSet) throws SQLException {
        return new TicketEntity(
          resultSet.getObject("id", Long.class),
          resultSet.getObject("passenger_no", String.class),
          resultSet.getObject("passenger_name", String.class),
          resultSet.getObject("flight_id", Long.class),
          resultSet.getObject("seat_no", String.class),
          resultSet.getObject("cost", BigDecimal.class)
        );
    }

    @Override
    public List<TicketEntity> findAll() {
        return List.of();
    }

    @Override
    public Optional<TicketEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public void update(TicketEntity entity) {

    }

    @Override
    public TicketEntity save(TicketEntity entity) {
        return null;
    }
}
