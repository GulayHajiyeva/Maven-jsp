package common;

import java.util.List;

public interface CommonRepo<T> {
     List<T> getList();
     void update(T obj);
     void delete(T obj);
     void insert(T obj);
     T findById(int obj);
     List<T> getList(String name,String surname);
}
