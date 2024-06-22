package com.example;

public class InitialState implements State {
    @Override
    public void handle(LampContext context, int keyIndex) {
        context.getKeys()[keyIndex] = true;
        boolean allPreviousPressed = true;
        for (int i = 0; i < keyIndex; i++) {
            if (!context.getKeys()[i]) {
                allPreviousPressed = false;
                break;
            }
        }
        if (allPreviousPressed) {
            context.incrementLampActivations();
        }
    }
}
