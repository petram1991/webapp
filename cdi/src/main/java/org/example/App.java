package org.example;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;


public class App {
    public static void main(String[] args) {

        Weld weld = new Weld();
        WeldContainer container = weld.initialize();


        SenderServices senderServices = container.select(SenderServices.class).get(); // object managed by CDI (i.e. DI container)
        String s = senderServices.verzenden();
        System.out.println(s);

        SenderServices senderServices2 = new SenderServices(new Sms()); // object managed by CDI (i.e. DI container)
        String s1 = senderServices2.verzenden();
        System.out.println(s1);



        container.close();

    }
}
