import java.io.*;
import java.util.*;
  class inventory
{
    public void send(String msg)
    {
        System.out.println("msg:"  + msg );
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println("Thread  interrupted.");
        }
        System.out.println("\n" + msg + "Sent");
    }
}
  
class ThreadSend extends Thread
{
    private String msg;
    inventory  sender;
        ThreadSend(String m,  inventory obj)
    {
        msg = m;
        sender = obj;
    }
      public void run()
    {
        synchronized(sender)
        {
          sender.send(msg);
        }    }}
  class thread
{
    public static void main(String args[])
    {
    	inventory send = new inventory();
        ThreadSend t1 = new ThreadSend( " My name is Tooba " , send );
        ThreadSend t2 = new ThreadSend( " Daughter of Ashraf " , send );
  
        t1.start();
        t2.start();
          try
        {
            t1.join();
            t2.join();
        }
        catch(Exception e)
        {
            System.out.println("Interrupted");
        }
    }
}

