package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.app.thread.RandomTextGeneratorThread;

class Application {
    public static void run(String[] args)
    {
        var self = Thread.currentThread();

        System.out.printf("main thread name : %s%n", self.getName());

        var nThreads    = Console.readInt("Input number of threads : ");
        var counts      = Console.readInt("Input count : ");

        for (var i = 0; i < nThreads; ++i){
            var generator = new RandomTextGeneratorThread(counts, 5, 10);
            var thread = new Thread(generator, "Generator - " + (i+1));

            thread.start();
        }

        System.out.println("main end...!");
    }
}
