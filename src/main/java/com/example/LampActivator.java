package com.example;

import java.util.List;

public class LampActivator {
    public static int countLampActivations(List<Integer> keyPresses) {
        LampContext context = LampContext.getInstance();

        ChainBuilder builder = new ChainBuilder(context);
        KeyHandler chain = builder.buildChain(context.getKeys().length);

        for (int key : keyPresses) {
            int keyIndex = key - 1;
            chain.handleRequest(keyIndex);
        }

        return context.getLampActivations();
    }
}
