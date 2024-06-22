
package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Integer> keyPresses = new ArrayList<>();
        for (int k = 1; k < 5; k++) {
            keyPresses = new ArrayList<>();
            System.out.println("start program for " + k + "th run");
            for (int i = 1; i <= 7; i++) {
                keyPresses.add(i);
            }
            Collections.shuffle(keyPresses);

            System.out.println(keyPresses);
            LampContext.resetInstance();
            int activationCount = LampActivator.countLampActivations(keyPresses);
            System.out.println("Number of lamp activations: " + activationCount);
            System.out.println("*****************************************");
        }
    }
}
