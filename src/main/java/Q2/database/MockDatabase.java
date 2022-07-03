package Q2.database;

import Q2.entity.IEntity;

import java.io.Serializable;
import java.util.concurrent.ConcurrentMap;

public interface MockDatabase<E extends Serializable, T extends IEntity<E>> {

    default T create(T t) {
        return getResource().putIfAbsent(t.getId(), t);
    }

    default T read(E e) {
        return getResource().getOrDefault(e, null);
    }

    default T update(T t) {
        return getResource().put(t.getId(), t);
    }

    default void delete(E e) {
        getResource().remove(e);
    }

    ConcurrentMap<E, T> getResource();
}
