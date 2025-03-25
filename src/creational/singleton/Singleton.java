package creational.singleton;

public class Singleton {

    private static volatile Singleton instance; // using volatile so that every time we access this variable
    // we need to read it directly from main memory not from shared memory.

    private String data;

    private Singleton(String data) { // note- constructor is private
        this.data = data;
    }

    // in multi threaded env 2 thread will access this at same time.
    /*public Singleton getInstance(String data) {
        if (instance == null) {
            instance = new Singleton(data);
        }
        return instance;
    }*/

/*    public Singleton getInstance(String data) {
        synchronized (Singleton.class) { // but now even if instance was created, every thread has to wait
            // before returning it -> can be solved using double checked locking idiom
            if (instance == null) {
                instance = new Singleton(data);
            }
        }
        return instance;
    }*/

    // now as this reads from memory its inefficient to read twice so we can use local variable.
    /*public Singleton getInstance(String data) {
        if (instance == null) { // -> this limit synchronisation to rare case of constructing new instance of this field.
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(data);
                }
            }
        }
        return instance;
    }*/

    public Singleton getInstance(String data) {
        Singleton result = instance;
        if (result == null) { // -> this limit synchronisation to rare case of constructing new instance of this field.
            synchronized (Singleton.class) { // but now even if instance was created, every thread has to wait
                // before returning it -> can be solved using double checked locking idiom
                result = instance;
                if (result == null) {
                   instance = result = new Singleton(data);
                }
            }
        }
        return result;
    }

    /*
    Singleton pattern:
    1. should be used when a class must have single instance available
    2. disables all means of creating objects of class except static creation method.
    3. Returns existing instance if it has been created already
    4. its code need to be adapted to handle multiple thread.
     */
}
