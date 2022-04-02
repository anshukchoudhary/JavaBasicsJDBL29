package pack71;


class MyThreadDaemon implements Runnable
{
    double num;
    public void run ()
    {
        for (int i = 1; i <= 10000; i++)
        {
         num = Math.random ();
         //System.out.println("User Thread value:" + num);
         try
         {
             Thread.sleep (1000);
         } catch (InterruptedException ie)
         {
         }
        }
    }
}
public class DaemonThread
{
    public static void main (String[]args)
    {
        MyThreadDaemon mt = new MyThreadDaemon ();
        Thread t = new Thread (mt);
        t.setDaemon (true);
        t.start ();
        for (int i = 1; i <= 5; i++)
        {
         System.out.println ("Main Thread value:" + mt.num);
         try
         {
             Thread.sleep (1000);
         } catch (InterruptedException ie)
         {
         }
        }
    }
}