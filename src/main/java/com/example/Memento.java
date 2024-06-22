package com.example;

import java.util.Arrays;

public class Memento {
    private boolean[] state;

    public Memento(boolean[] state) {
        this.state = state;
    }

    public boolean[] getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Memento memento = (Memento) o;
        return Arrays.equals(state, memento.state);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(state);
    }
}
