package org.example;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class SenderServices {

    private final SendingInterface defaultSending;

    @Inject
    public SenderServices(SendingInterface sending){
        this.defaultSending = sending;
    }

    public String verzenden(){
        System.out.println();
        return defaultSending.sending();
    }
}
