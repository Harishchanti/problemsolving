package designpatterns.observerPattern;

public interface IObserver<K> {
    void update(K temperature);
}
