package mapper;

import dto.CreateUserDto;
import entity.Gender;
import entity.Role;
import entity.UserEntity;
import util.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDto, UserEntity> {

    private static final String IMAGE_FOLDER = "users/";
    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public UserEntity mapFrom(CreateUserDto object) {
        return UserEntity.builder()
                .name(object.getName())
                .image(IMAGE_FOLDER + object.getImage().getSubmittedFileName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }
}
