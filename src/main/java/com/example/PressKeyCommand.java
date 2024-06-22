package com.example;

public class PressKeyCommand implements Command {
    private LampContext context;
    private int keyIndex;

    public PressKeyCommand(LampContext context, int keyIndex) {
        this.context = context;
        this.keyIndex = keyIndex;
    }

    @Override
    public void execute() {
        context.pressKey(keyIndex);
    }
}
