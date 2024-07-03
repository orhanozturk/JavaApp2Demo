package org.csystem.app;

import com.karandev.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        var count = Console.readInt("Input count:");
        var nThread = Console.readInt("Input number of threads:");

        var incrementer = new IntIncrementor(count);
        incrementer.run(nThread);
        System.out.printf("Value:%d%n", incrementer.getValue());
    }
}
