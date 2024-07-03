/**
 * <h1> USAGE.... </h1>
 *
 * @author oozturk
 * Date:   3.07.2024
 */

package org.csystem.app;

import java.util.concurrent.atomic.AtomicInteger;

public class IntIncrementor {
    private static int m_value1;
    private static long m_value2;

    private static void doWorkForValues() {
            var name = Thread.currentThread().getName();
            ++m_value1;
            m_value2 += m_value1;
            System.out.printf("name : %s - value1 : %d - value2 : %d%n", name, m_value1, m_value2);
    }
    private  static void incrementerCallBack(int count)
    {
        for (var i = 0; i < count; ++i)
            doWorkForValues();
    }

    public int getValue1() {
        return m_value1;
    }

    public long getValue2() {
        return m_value2;
    }


    public void run(int nThread, int count)
    {
        Thread []threads = new Thread[nThread];

        for (int i = 0; i < nThread; ++i)
        {
            threads[i] = new Thread(()->incrementerCallBack(count), "Thread-" + i);
            threads[i].start();
        }

        for(var t : threads){
            try{
                t.join();
            } catch (InterruptedException ignore){

            }
        }
    }
}
