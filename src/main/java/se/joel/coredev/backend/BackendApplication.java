package se.joel.coredev.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("IP-address: " + ip.getHostAddress());
            System.out.println("Copy-paste: http://" + ip.getHostAddress() + ":8080/geofences/");
        } catch (UnknownHostException e) {
            System.out.println("Could not obtain IP");
        }
        SpringApplication.run(BackendApplication.class, args);
    }
}
