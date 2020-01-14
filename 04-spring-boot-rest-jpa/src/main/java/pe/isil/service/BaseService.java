package pe.isil.service;

import java.util.List;

public interface BaseService<X, Y> {

    void save(X x);
    void update(X x);
    void delete(X x);

    List<X> findAll();
    X findById(Y y);

}
