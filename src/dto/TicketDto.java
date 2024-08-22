package dto;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class TicketDto {

    private final Long id;
    private final Long flightId;
    private final String seatNo;

}
