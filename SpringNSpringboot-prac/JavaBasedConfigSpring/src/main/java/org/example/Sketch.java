package org.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Sketch implements Writer{

    public Sketch() {
        System.out.println("Sketch Constructor Called");
    }

    @Override
    public void write() {
        System.out.println("Writing using Sketch");
    }
}
