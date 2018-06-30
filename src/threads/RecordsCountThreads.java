package threads;

public class RecordsCountThreads {

	public static void main(String[] args) {
		InheritableThreadLocal<Integer> th = new InheritableThreadLocal<Integer>();
		th.set(0);
		DataShare ds = new DataShare();
		DataShare ds1 = new DataShare();
		DataShare ds2 = new DataShare();
		Recodrs s = new Recodrs(1, 100, ds);
		Recodrs s1 = new Recodrs(101, 200, ds1);
		Recodrs s2 = new Recodrs(201, 300, ds2);

		Thread t1 = new Thread(s);
		Thread t2 = new Thread(s1);
		Thread t3 = new Thread(s2);
		t1.start();
		t2.start();
		t3.start();

		// s.start();
		// s1.start();
		// s2.start();

		while (true) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("T1 : "+ds.c + " T2 : " + ds1.c + " T3 :" + ds2.c + " " + " sum : " + (ds.c + ds1.c + ds2.c));
			if(ds.c>=100 && ds1.c>=100 && ds2.c>=100) {
				break;
			}
		}

	}

}

 class DataShare {
     int c;

    public DataShare () {
        c=0;
    }
}
class Recodrs implements Runnable {
	int min;
	int max;
	DataShare ds;

	public Recodrs(int min, int max, DataShare c) {
		this.min = min;
		this.max = max;
		this.ds = c;

	}

	@Override
	public void run() {
		for (int i = min; i <= max; i++) {
			ds.c++;
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}