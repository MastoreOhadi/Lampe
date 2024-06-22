package com.example;


public class LampContext extends Subject {
    private static LampContext instance;
    private State state;
    private Memento previousState; // Memento برای نگهداری حالت قبلی
    private boolean[] keys;
    private int lampActivations;

    private LampContext(int n) {
        keys = new boolean[n];
        state = new InitialState();
        previousState = null; // حالت قبلی در ابتدا null است
        lampActivations = 0;
        initializeLamps(n);
    }

    private void initializeLamps(int n) {
        for (int i = 0; i < n; i++) {
            addObserver(new Lamp(i + 1));
        }
    }

    public static LampContext getInstance() {
        if (instance == null) {
            instance = new LampContext(7); // Assuming 7 keys and lamps
        }
        return instance;
    }

    public static void resetInstance() {
        instance = null; // Reset the instance for testing purposes
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean[] getKeys() {
        return keys;
    }

    public void pressKey(int keyIndex) {
        if (keyIndex >= 0 && keyIndex < keys.length) {
            state.handle(this, keyIndex);
            notifyObservers();
        }
    }

    public int getLampActivations() {
        return lampActivations;
    }

    public void incrementLampActivations() {
        Memento currentState = createMemento(); // ایجاد Memento برای حالت فعلی
        if (previousState == null || !previousState.equals(currentState)) { // بررسی تغییر حالت
            lampActivations++;
            previousState = currentState; // بروزرسانی حالت قبلی
        }
    }

    public Memento createMemento() {
        return new Memento(keys.clone());
    }

    public void restoreMemento(Memento memento) {
        keys = memento.getState();
    }
}
