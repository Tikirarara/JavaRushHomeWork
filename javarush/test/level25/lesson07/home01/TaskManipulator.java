package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator
{
    private Thread myThread;

    @Override
    public void run()
    {
        try
        {
            while (!myThread.isInterrupted())
            {
                System.out.println(myThread.getName());
                Thread.sleep(110);
            }
        }
        catch (InterruptedException ignored)
        {
        }
    }

    @Override
    public void start(String threadName)
    {
        myThread = new Thread(this);
        myThread.setName(threadName);
        myThread.start();
    }

    @Override
    public void stop()
    {
        myThread.interrupt();
    }
}
