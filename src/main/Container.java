package main;

public interface Container<T> extends Iterable<T> {
    int getSize();
    default boolean isEmpty() { return getSize() == 0; }
}