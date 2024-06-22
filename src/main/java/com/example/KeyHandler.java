package com.example;

public abstract class KeyHandler {
    protected KeyHandler nextHandler;

    public void setNextHandler(KeyHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(int keyIndex);
}
