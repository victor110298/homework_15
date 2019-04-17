package jpa.dao;
public interface Contract<T>
{
    boolean insert(T t);
    boolean update(T t);
    T read(Long id);
    boolean delete(Long id);
}
