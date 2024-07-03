/**
 * <h1> USAGE.... </h1>
 *
 * @author oozturk
 * Date:   3.07.2024
 */

package org.csystem.app.thread;

import org.csystem.util.string.StringUtil;

import java.util.Random;
import java.util.random.RandomGenerator;
public class RandomTextGeneratorThread implements Runnable{

    private final Random m_random = new Random();
    private final int m_count;
    private final int m_min;
    private final int m_bound;

    public RandomTextGeneratorThread(int count, int min, int bound){
        m_count = count;
        m_min   = min;
        m_bound = bound;
    }

    @Override
    public void run() {
        for(var i = 0; i < m_count; ++i){

            var name = Thread.currentThread().getName();

            var text = StringUtil.getRandomTextEN(m_random, m_random.nextInt(m_min, m_bound));

            System.out.printf("%s -> %s%n", name, text);
        }
    }
}
