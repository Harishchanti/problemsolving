package designpatterns.observerPattern;

// Subject
public interface IObservable {
    void addSubScriber(IObserver observer);
    void removeSubScriber(IObserver observer);
    void notifySubScriber();
}
