package com.example;

public interface State {
    void handle(LampContext context, int keyIndex);
}
