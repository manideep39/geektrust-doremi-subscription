package com.example.geektrust.service.invoker;

import com.example.geektrust.service.command.Command;

import java.util.LinkedList;
import java.util.Queue;

public class SubscriptionInvoker {
    private static SubscriptionInvoker instance;
    private final Queue<Command> commandQueue;

    private SubscriptionInvoker() {
        commandQueue = new LinkedList<>();
    }

    public static SubscriptionInvoker getInstance() {
        if (instance == null)
            instance = new SubscriptionInvoker();
        return instance;
    }

    public void queueCommand(Command command) {
        commandQueue.offer(command);
    }

    public void executeCommands() {
        while (!commandQueue.isEmpty()) {
            Command command = commandQueue.poll();
            command.execute();
        }
    }
}
