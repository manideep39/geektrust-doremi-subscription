package com.example.geektrust;

import com.example.geektrust.controller.SubscriptionController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SubscriptionController subCont = new SubscriptionController();

        try {
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] commandArgs = line.split(" ");
                subCont.handleCommands(commandArgs);
            }
            sc.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
