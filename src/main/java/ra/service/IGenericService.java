package ra.service;

import java.util.List;
import java.util.Optional;

public interface IGenericService <E,T>{
    List<E> findAll();
    E findById(T id);
    E save(E e);
    void deleteById(T id);
}
