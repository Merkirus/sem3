class IntCell {
    private int n = 0;
    private boolean taken = false;
    public synchronized int getN() {
        while (taken) {
            try { wait(); } catch (InterruptedException e) {}
        }
        taken = true;
        notifyAll();
        return n;
    }
    public synchronized void setN(int n) {
        while (!taken) {
            try { wait(); } catch (InterruptedException e) {}
        }
        this.n = n;
        taken = false;
        notifyAll();
    }
}

class Monitor extends Thread {
    private static IntCell n = new IntCell();

    @Override public void run() {
      int temp;
      for (int i = 0; i < 200000; i++) {
        temp = n.getN(); 
        n.setN(temp + 1);
      }
    }

    public static void main(String[] args) {
      Monitor p = new Monitor();
      Monitor q = new Monitor();
      p.start();
      q.start();
      try { p.join(); q.join(); }
      catch (InterruptedException e) { }
      System.out.println("The value of n is " + n.getN());
    }
}
