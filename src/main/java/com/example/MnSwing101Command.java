package com.example;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.awt.*;

@Command(name = "mn-swing-101", description = "...", mixinStandardHelpOptions = true)
@Slf4j
public class MnSwing101Command implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(MnSwing101Command.class, args);
    }
    MyFrame frame  = null;
    public void run() {
        // business logic here
        if (verbose) {
            System.out.println("Hi!");
        }
        log.info("before initial MyFrame()....");
        frame = new MyFrame();
        log.info("After initial MyFrame()....");
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        log.info("Finish ....");
    }
}
