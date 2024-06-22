package com.example;

public class ConcreteKeyHandler extends KeyHandler {
    private int keyIndex;
    private LampContext context;

    public ConcreteKeyHandler(int keyIndex, LampContext context) {
        this.keyIndex = keyIndex;
        this.context = context;
    }

    @Override
    public void handleRequest(int keyIndex) {
        if (this.keyIndex == keyIndex) {
            context.pressKey(keyIndex);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(keyIndex);
        }
    }
}
