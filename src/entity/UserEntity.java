package entity;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserEntity {

    private Long id;
    private String name;
    // Путь до файла
    private String image;
    private LocalDate birthday;
    private String email;
    private String password;
    private Role role;
    private Gender gender;

}
