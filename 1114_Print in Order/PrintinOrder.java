class Foo {
    private Semaphore semaphore1, semaphore2;

    public Foo() {
        semaphore1 = new Semaphore(0);
        semaphore2 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        semaphore1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore1.acquire();
        printSecond.run();
        semaphore2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore2.acquire(); 
        printThird.run();
        semaphore2.release();
    }
}