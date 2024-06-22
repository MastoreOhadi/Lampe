package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> keyPresses = new ArrayList<>();

        System.out.println("Enter the key presses (enter -1 to end):");
        while (true) {
            int key = scanner.nextInt();
            if (key == -1) {
                break;
            }
            keyPresses.add(key);
        }

        int activationCount = LampActivator.countLampActivations(keyPresses);
        System.out.println("Number of lamp activations: " + activationCount);
    }
}
