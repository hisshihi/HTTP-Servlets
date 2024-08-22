package util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс для управления подключением к базе данных.
 * Использует паттерн Singleton, чтобы гарантировать,
 * что существует только один экземпляр этого класса.
 */
@UtilityClass
public final class ConnectionManager {

    // Ключи для доступа к свойствам подключения к базе данных
    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";

    static {
        loadDriver();
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Возвращает соединение с базой данных.
     *
     * @return Соединение с базой данных.
     */
    @SneakyThrows
    public static Connection getConnection() {
            // Получение значений свойств подключения из класса PropertiesUtil
            return DriverManager.getConnection(
                    PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(USER_KEY),
                    PropertiesUtil.get(PASSWORD_KEY)
            );
    }
}
