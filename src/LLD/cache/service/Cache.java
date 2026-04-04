package LLD.cache.service;

import LLD.cache.exception.ItemNotFoundException;

public interface Cache<K, V> {
    void put(K key, V value);

    V get(K key);

    void remove(K key) throws ItemNotFoundException;

    boolean containsKey(K key);

    int getSize();
}
