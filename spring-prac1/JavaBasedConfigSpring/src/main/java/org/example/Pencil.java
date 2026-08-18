package org.example;

import org.springframework.stereotype.Component;

@Component
public class Pencil implements Writer{

    public Pencil() {
        System.out.println("Pencil Constructor Called");
    }

    @Override
    public void write() {
        System.out.println("Writing using pencil");
    }
}
