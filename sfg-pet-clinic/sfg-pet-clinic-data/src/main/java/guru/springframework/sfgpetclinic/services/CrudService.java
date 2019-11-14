package guru.springframework.sfgpetclinic.services;

import java.util.Set;

/*
 * Generic types named following the convention established in
 * https://docs.oracle.com/javase/tutorial/java/generics/types.html
 */
public interface CrudService<T, N> {

    T save(T object);

    Set<T> findAll();

    T findByID(N id);

    void delete(T object);

    void deleteByID(N id);
}
