package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.app.thread.RandomTextGeneratorThread;
import org.csystem.util.string.StringUtil;

import java.util.Random;
import java.util.random.RandomGenerator;

class Application {

    private static void randomGeneratorCallback(RandomGenerator randomGenerator, int count, int min, int bound)
    {
        var name = Thread.currentThread().getName();

        for(var i = 0; i < count; ++i){

            var text = StringUtil.getRandomTextEN(randomGenerator, randomGenerator.nextInt(min, bound));

            System.out.printf("%s -> %s%n", name, text);
        }
    }
    public static void run(String[] args)
    {
        var self = Thread.currentThread();

        System.out.printf("main thread name : %s%n", self.getName());

        var nThreads    = Console.readInt("Input number of threads : ");
        var counts      = Console.readInt("Input count : ");

        Runnable []runnables = new Runnable[nThreads];

        for (var i = 0; i < nThreads; ++i){

            runnables[i] = () -> randomGeneratorCallback(new Random(), counts, 5, 15);

            var thread = new Thread(runnables[i], "Generator - " + (i+1));

            thread.start();
        }

        for (var r : runnables)
            System.err.println(r.getClass().getName());

        System.out.println("main end...!");
    }
}
