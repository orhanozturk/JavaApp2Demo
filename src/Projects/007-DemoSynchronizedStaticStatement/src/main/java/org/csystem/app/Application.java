package org.csystem.app;

import com.karandev.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        var count = Console.readInt("Input count:");
        var nThread = Console.readInt("Input number of threads:");

        var incrementer = new IntIncrementor();
        incrementer.run(nThread, count);
        System.out.printf("Value1 : %d%n", incrementer.getValue1());
        System.out.printf("Value2 : %d%n", incrementer.getValue2());
    }
}
