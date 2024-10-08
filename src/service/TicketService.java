package service;

import dao.TicketDao;
import dto.TicketDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class TicketService {

    private static final TicketService INSTANCE = new TicketService();

    private final TicketDao ticketDao = TicketDao.getInstance();

    private TicketService() {
    }

    public List<TicketDto> findAllByFlightId(Long flightId) {
        return ticketDao.findAllByFlightId(flightId).stream()
                .map(ticketEntity -> new TicketDto(
                            ticketEntity.getId(),
                            ticketEntity.getFlight_id(),
                            ticketEntity.getSeat_no())
                ).collect(toList());
    }

    public static TicketService getInstance() {
        return INSTANCE;
    }

}
