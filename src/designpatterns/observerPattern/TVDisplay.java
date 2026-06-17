package designpatterns.observerPattern;

public class TVDisplay<K> implements IObserver<K> {

    @Override
    public void update(K temperature) {
        System.out.println("TVDisplay New temperature " + temperature);

    }
}
