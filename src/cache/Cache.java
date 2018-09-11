package cache;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Cache<K, V> {

    private final DelayQueue<ExpiringKey> delayQueue = new DelayQueue<ExpiringKey>();
    private final Map<K, V> map;

    private final Integer DEFAULT_EXPIRY = 3600000;
    private final Integer DEFAULT_SIZE = 1000;

    public Cache() {
        map = new Hashtable<K, V>(DEFAULT_SIZE);
    }

    public Cache(int capacity) {
        map = new Hashtable<K, V>(capacity);
    }

    public V get(Object key) {
        cleanup();
        return map.get((K) key);
    }

    public V put(K key, V value) {
        return this.put(key, value, DEFAULT_EXPIRY);
    }

    public V put(K key, V value, long lifeTimeMillis) {
        cleanup();
        ExpiringKey delayedKey = new ExpiringKey(key, lifeTimeMillis);
        delayQueue.offer(delayedKey);
        return map.put(key, value);
    }

    public int getSize() {
        cleanup();
        return map.size();
    }

    public boolean isEmpty() {
        cleanup();
        return map.isEmpty();
    }

    public boolean containsKey(Object key) {
        cleanup();
        return map.containsKey((K) key);
    }

    private void cleanup() {
        ExpiringKey<K> delayedKey = delayQueue.poll();
        while (delayedKey != null) {
            map.remove(delayedKey.getKey());
            delayedKey = delayQueue.poll();
        }
    }

    private class ExpiringKey<K> implements Delayed {

        private long startTime = System.currentTimeMillis();
        private final long maxLifeTimeMillis;
        private final K key;

        public ExpiringKey(K key, long maxLifeTimeMillis) {
            this.maxLifeTimeMillis = maxLifeTimeMillis;
            this.key = key;
        }

        public K getKey() {
            return key;
        }


        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ExpiringKey<K> other = (ExpiringKey<K>) obj;
            if (this.key != other.key && (this.key == null || !this.key.equals(other.key))) {
                return false;
            }
            return true;
        }


        @Override
        public int hashCode() {
            int hash = 7;
            hash = 31 * hash + (this.key != null ? this.key.hashCode() : 0);
            return hash;
        }


        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(getDelayMillis(), TimeUnit.MILLISECONDS);
        }

        private long getDelayMillis() {
            return (startTime + maxLifeTimeMillis) - System.currentTimeMillis();
        }

        public void renew() {
            startTime = System.currentTimeMillis();
        }

        public void expire() {
            startTime = Long.MIN_VALUE;
        }

        @Override
        public int compareTo(Delayed that) {
            return Long.compare(this.getDelayMillis(), ((ExpiringKey) that).getDelayMillis());
        }
    }

}


