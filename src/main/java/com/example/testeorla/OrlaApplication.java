package com.example.testeorla;

import com.example.testeorla.view.AppTela;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrlaApplication {

    @Autowired
    private AppTela appTela;

    public static void main(String[] args) throws Exception {

        SpringApplication.run(Main.class, args);
    }

    public void run(String... args) throws Exception {
        appTela.iniciar();
    }
}
