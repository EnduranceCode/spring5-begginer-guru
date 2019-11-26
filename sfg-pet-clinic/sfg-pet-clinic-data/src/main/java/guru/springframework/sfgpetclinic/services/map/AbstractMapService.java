package guru.springframework.sfgpetclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import guru.springframework.sfgpetclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, N extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    T save(T object) {

        if (object != null) {
            if (object.getId() == null) {

                object.setId(getNextID());
            }
        } else {
            
            throw new RuntimeException("Object cannot be null");
        }

        map.put(object.getId(), object);

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

    private Long getNextID() {

        Long nextId = null;

        try {

            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {

            nextId = 1L;
        }

        return nextId;
    }
}
