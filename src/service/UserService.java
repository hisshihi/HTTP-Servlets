package service;

import dao.UserDao;
import dto.CreateUserDto;
import entity.UserEntity;
import exception.ValidationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import mapper.CreateUserMapper;
import validator.CreateUserValidator;
import validator.ValidationResult;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();

    public static UserService getInstance() {
        return INSTANCE;
    }

    public Long create(CreateUserDto userDto) {
// Валидация
        ValidationResult validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        // Преобразовать dto в сущность (map)
        UserEntity userEntity = createUserMapper.mapFrom(userDto);

//        userDto.save
        userDao.save(userEntity);
//        return
        return null;
    }

}
