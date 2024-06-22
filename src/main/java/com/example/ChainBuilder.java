package com.example;

public class ChainBuilder {
    private LampContext context;

    public ChainBuilder(LampContext context) {
        this.context = context;
    }

    public KeyHandler buildChain(int numberOfKeys) {
        KeyHandler firstHandler = new ConcreteKeyHandler(0, context);
        KeyHandler currentHandler = firstHandler;

        for (int i = 1; i < numberOfKeys; i++) {
            KeyHandler newHandler = new ConcreteKeyHandler(i, context);
            currentHandler.setNextHandler(newHandler);
            currentHandler = newHandler;
        }

        return firstHandler;
    }
}
