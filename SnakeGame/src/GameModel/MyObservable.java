package GameModel;

import java.util.ArrayList;

public class MyObservable {
    private ArrayList<MyObserver> observersList;

    public MyObservable(){
        observersList = new ArrayList<MyObserver>();
    }

    public synchronized void addObserver(MyObserver newObserver) throws NullPointerException{
        if (newObserver == null) {
            throw new NullPointerException();
        }
        if (!observersList.contains(newObserver)) {
            observersList.add(newObserver);
        }
    }

    public synchronized void deleteObserver(MyObserver observerToDelete){
        observersList.remove(observerToDelete);
    }

    public void notifyObservers(){
        Object[] arrLocalObservers;
        synchronized (this){
            arrLocalObservers = observersList.toArray();
        }
        for (Object observer : arrLocalObservers){
            ((MyObserver)observer).update();
        }
    }

    public void deleteAllObservers(){
        observersList.removeAll(observersList);
    }
}
