/**
 * <h1> USAGE.... </h1>
 *
 * @author oozturk
 * Date:   3.07.2024
 */

package org.csystem.app;

import java.util.concurrent.atomic.AtomicInteger;

public class IntIncrementor {
    private final AtomicInteger m_value;
    private final int m_count;

    private void incrementerCallBack()
    {
        for (var i = 0; i < m_count; ++i) {
            m_value.getAndIncrement();
            System.out.printf("%s : m_vlue : %d%n", Thread.currentThread().getName(), m_value.get());
        }
    }

    IntIncrementor(int count)
    {
        m_count = count;
        m_value = new AtomicInteger();
    }

    public int getValue() {
        return m_value.get();
    }

    public int getCount() {
        return m_count;
    }

    public void run(int nThread)
    {
        Thread []threads = new Thread[nThread];

        for (int i = 0; i < nThread; ++i)
        {
            threads[i] = new Thread(()->incrementerCallBack(), "Thread-" + i);
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
