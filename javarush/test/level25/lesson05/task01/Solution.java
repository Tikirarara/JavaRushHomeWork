package com.javarush.test.level25.lesson05.task01;

import com.sun.org.apache.xpath.internal.SourceTree;

/* Switch для нитей
Обработайте список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запустите ее.
2. Если нить в ожидании, то прервите ее.
3. Если нить работает, то проверить маркер isInterrupted.
4. Если нить прекратила работу, то выведите в консоль ее приоритет.
Используйте switch.
*/
public class Solution
{
    public static void processThreads(Thread... threads)
    {
        //implement this method - реализуйте этот метод
        for (Thread thread : threads)
        {
            switch (thread.getState())
            {
                case NEW:
                    thread.start();
                    return;
                case WAITING:
                    thread.interrupt();
                    return;
                case TIMED_WAITING:
                    thread.interrupt();
                    return;
                case BLOCKED:
                    thread.interrupt();
                    return;
                case RUNNABLE:
                    thread.isInterrupted();
                    return;
                case TERMINATED:
                    System.out.println(thread.getPriority());
                    return;
            }
        }
    }
}
