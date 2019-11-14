package guru.springframework.sfgpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, N> {

    protected Map<N, T> map = new HashMap<>();

    T save(N id, T object) {

        map.put(id, object);

        return object;
    }

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findByID(N id) {
        return map.get(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    void deleteByID(N id) {
        map.remove(id);
    }
}
