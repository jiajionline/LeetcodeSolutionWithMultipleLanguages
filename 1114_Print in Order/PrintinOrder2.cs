using System.Threading;

public class Foo {
    private readonly Semaphore first = new Semaphore(1, 1);
    private readonly Semaphore second = new Semaphore(0, 1);
    private readonly Semaphore third = new Semaphore(0, 1);

    public void First(Action printFirst) {
        first.WaitOne();
        printFirst();
        second.Release();
    }

    public void Second(Action printSecond) {
        second.WaitOne();
        printSecond();
        third.Release();
    }

    public void Third(Action printThird) {
        third.WaitOne();
        printThird();
        first.Release();
    }
}