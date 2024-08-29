package service;

import dao.UserDao;
import dto.CreateUserDto;
import entity.UserEntity;
import exception.ValidationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import mapper.CreateUserMapper;
import validator.CreateUserValidator;
import validator.ValidationResult;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final String IMAGE_FOLDER = "users/";
    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final ImageService imageService = ImageService.getInstance();

    public static UserService getInstance() {
        return INSTANCE;
    }

    @SneakyThrows
    public Long create(CreateUserDto userDto) {
// Валидация
        ValidationResult validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        // Преобразовать dto в сущность (map)
        UserEntity userEntity = createUserMapper.mapFrom(userDto);

//        Сохранение изображения
        imageService.upload(userEntity.getImage(), userDto.getImage().getInputStream());

//        userDto.save
        userDao.save(userEntity);
//        return
        return null;
    }

}
