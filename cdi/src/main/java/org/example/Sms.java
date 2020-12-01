package org.example;


import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;

@Alternative
@Dependent
public class Sms implements SendingInterface {

    public String sending(){

        return "Ik ben verstuurd via sms";
    }
}
