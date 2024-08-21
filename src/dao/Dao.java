package dao;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс Dao (Data Access Object), определяющий общие методы
 * для работы с данными в базе данных.
 *
 * @param <K> Тип ключа сущности.
 * @param <T> Тип сущности.
 */
public interface Dao<K, T> {

    // Найти все сущности
    List<T> findAll();

    // Найти сущность по идентификатору
    Optional<T> findById(K id);

    // Удалить сущность (не реализовано)
    boolean delete();

    // Обновить сущность (не реализовано)
    void update(T entity);

    // Сохранить сущность (не реализовано)
    T save(T entity);
}
