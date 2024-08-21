package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Класс для работы с properties файлом.
 * Использует паттерн Singleton, чтобы гарантировать,
 * что существует только один экземпляр этого класса.
 */
public final class PropertiesUtil {

    // Экземпляр класса Properties для хранения свойств
    private static final Properties PROPERTIES = new Properties();

    // Статический блок инициализации, который загружает свойства из файла
    static {
        loadProperties();
    }

    // Приватный конструктор, чтобы предотвратить создание экземпляров класса извне
    private PropertiesUtil() {
    }

    /**
     * Загружает свойства из файла application.properties.
     */
    private static void loadProperties() {
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            // Обработка исключений IOException
            throw new RuntimeException(e);
        }
    }

    /**
     * Возвращает значение свойства по его ключу.
     *
     * @param key Ключ свойства.
     * @return Значение свойства.
     */
    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
