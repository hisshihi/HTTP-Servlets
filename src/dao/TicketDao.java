package dao;

import entity.TicketEntity;

import java.util.List;
import java.util.Optional;

public class TicketDao implements Dao<Long, TicketEntity> {

    private static final TicketDao INSTANCE = new TicketDao();

    private TicketDao() {}

    public static TicketDao getInstance() {
        return INSTANCE;
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
