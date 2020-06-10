using System.Threading;

public class FooBar {

// initialized to true to indicate the first time there is no need to wait.
    private EventWaitHandle waitFirst = new AutoResetEvent(initialState: true);
    private EventWaitHandle waitSecond = new AutoResetEvent(initialState: true);

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void Foo(Action printFoo) {
        
        for (int i = 0; i < n; i++) {
            waitFirst.WaitOne();
        	// printFoo() outputs "foo". Do not change or remove this line.
        	printFoo();
            waitSecond.Set();
        }
    }

    public void Bar(Action printBar) {
        
        for (int i = 0; i < n; i++) {
            waitSecond.WaitOne();
            // printBar() outputs "bar". Do not change or remove this line.
        	printBar();
            waitFirst.Set();
        }
    }
}