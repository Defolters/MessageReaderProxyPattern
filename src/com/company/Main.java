package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String name = "name20";
        String password = "pass20";

        String token = LoginService.getInstance().login(name, password);
        MessageReaderAPI messageReaderAPI = MessageReader.getMessageReader(token);

        ArrayList<String> messages = messageReaderAPI.getMessagesByUserID(20);
        printMessages(messages);

        messages = messageReaderAPI.getMessagesByUserID(41);
        printMessages(messages);
    }

    public static void printMessages(ArrayList<String> messages) {
        if (messages != null) {
            for (String message : messages) {
                System.out.println(message);
            }
            System.out.println();
        } else {
            System.out.println("Permission error\n");
        }
    }
}
