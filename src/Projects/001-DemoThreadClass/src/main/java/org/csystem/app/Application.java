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
            var thread = new RandomTextGeneratorThread("Thread-" + (i+1), counts, 5, 10);

            thread.start();
        }

        System.out.println("main end...!");
    }
}
