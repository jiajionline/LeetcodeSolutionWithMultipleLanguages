using System.Threading;

public class Foo
{
    private EventWaitHandle waitFirst;
    private EventWaitHandle waitSecond;

    public Foo()
    {
        waitFirst = new AutoResetEvent(initialState: false);
        waitSecond = new AutoResetEvent(initialState: false);
    }

    public void First(Action printFirst)
    {
        // printFirst() outputs "first". Do not change or remove this line.
        printFirst();

        waitFirst.Set();
    }

    public void Second(Action printSecond)
    {
        waitFirst.WaitOne();

        // printSecond() outputs "second". Do not change or remove this line.
        printSecond();

        waitSecond.Set();
    }

    public void Third(Action printThird)
    {
        waitSecond.WaitOne();

        // printThird() outputs "third". Do not change or remove this line.
        printThird();
    }
}