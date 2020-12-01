package org.example;


import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

@Default
@Dependent
public class Email implements SendingInterface {

    public String sending(){

        return "Ik ben verstuurd via Email";
    }
}
