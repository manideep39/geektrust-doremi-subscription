package com.example.geektrust.service.invoker;

import com.example.geektrust.service.command.Command;

import java.util.LinkedList;
import java.util.Queue;

public class CommandInvoker {
    private static CommandInvoker instance;
    private final Queue<Command> commandQueue;

    private CommandInvoker () {
        commandQueue = new LinkedList<>();
    }

    public static CommandInvoker getInstance() {
        if (instance == null)
            instance = new CommandInvoker();
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
