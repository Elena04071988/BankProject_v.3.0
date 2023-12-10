package BankProject.interfaces;

public interface BankOperationable<T> {
    T save(T entity);
    void delete(T entity);
}
