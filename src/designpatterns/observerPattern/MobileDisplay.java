package designpatterns.observerPattern;

public class MobileDisplay<K> implements IObserver<K> {

    @Override
    public void update(K temperature) {
        System.out.println("MobileDisplay New temperature " + temperature);
    }
}
