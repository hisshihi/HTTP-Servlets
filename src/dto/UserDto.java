package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserDto {

    private Long id;
    private String mail;

}
