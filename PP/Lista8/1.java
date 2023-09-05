public class FullException extends Exception {
    public FullException() {
    }

    public FullException(String message) {
        super(message);
    }
}



public class EmptyException extends Exception {
    public EmptyException() {
    }

    public EmptyException(String message) {
        super(message);
    }
}



public class EmptyException extends Exception {
    public EmptyException() {
    }

    public EmptyException(String message) {
        super(message);
    }
}


public static void main(String[] args) throws FullException, EmptyException {
    MyQueue<String> queue = new CyclicArrayQueue<>(3);
    queue.enqueue("kot");
    queue.enqueue("pies");
    queue.enqueue("krowa");
    System.out.println(queue.first());
    queue.dequeue();
    queue.enqueue("owca");
    System.out.println(queue.first());
    queue.dequeue();
    queue.enqueue("kangur");
    System.out.println(queue.first());
}

public interface MyQueue<E> {
public void enqueue( E x ) throws FullException; public void dequeue( );
public E first( ) throws EmptyException;
public boolean isEmpty( );
public boolean isFull( );
}

public class CyclicArrayQueue<E> implements MyQueue<E> {
    private List<E> queue;
    private int f = 0, r = 0;

    public CyclicArrayQueue(int n) {
        queue = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            queue.add(null);
        }
    }

    @Override
    public void enqueue(E x) throws FullException {
        if (isFull())
            throw new FullException("CyclicArrayQueue: enqueue");
        else {
            queue.set(r, x);
            r = (r + 1) % queue.size();
        }
    }

    @Override
    public void dequeue() {
        if (!isEmpty())
            f = (f + 1) % queue.size();
    }

    @Override
    public E first() throws EmptyException {
        if (isEmpty())
            throw new EmptyException("CyclicArrayQueue: first");
        else
            return queue.get(f);
    }
    @Override
    public boolean isEmpty() {
        return f == r;
    }

    @Override
    public boolean isFull() {
        return (r + 1) % queue.size() == f;
    }
}
