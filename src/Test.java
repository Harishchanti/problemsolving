import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.joda.time.DateTime;

public class Test {
	final int sss;
	{
		sss = 100;
	}

	static class A {
		int ww;

		A(int a) {
			ww = a;

		}

		void ma() {
			Test test = new Test();
			System.out.println(test.sss);
		}

	}

	public static void main(String[] args) throws IOException {

		Test.A s = new Test.A(11);

		// System.out.println(s.ma());
		s.ma();

		Demo object = new Demo(1, "geeksforgeeks");
		String filename = "file.ser";

		// Serialization
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(object);

			out.close();
			file.close();

			System.out.println("Object has been serialized");

		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		Demo object1 = null;

		// Deserialization
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			object1 = (Demo) in.readObject();

			in.close();
			file.close();

			System.out.println("Object has been deserialized ");
			System.out.println("a = " + object1.a);
			System.out.println("b = " + object1.b);
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}
		
		List<Integer> l = Arrays.asList(2,4,55,5,5,6,7);
		/*int start = 0;
		int size = l.size();
		int end = size;
		if(size >9) {
			end = size/10;
		}
		
		while(size>=start) {
			List<Integer> subList = l.subList(start, end);
			System.out.print(subList);
			start = end;
			end += 1000;
		}*/
		
		List<List<Integer>> pages = getPages(l,2);
		
		for(List<Integer> d:pages) {
			System.out.println(d);
		}
		
		System.out.print(new DateTime(2018,7,1,0,0,0));

		System.out.println(Math.round(1 * 1000.0) / 1000.0);
		
		Stack<S> st = new Stack<S>();
		st.push(new S(4,5));
		System.out.println(st.contains(new S(4,5)));
	}
	public static <T> List<List<T>> getPages(Collection<T> c, Integer pageSize) {
	    if (c == null)
	        return Collections.emptyList();
	    List<T> list = new ArrayList<T>(c);
	    if (pageSize == null || pageSize <= 0 || pageSize > list.size())
	        pageSize = list.size();
	    int numPages = (int) Math.ceil((double)list.size() / (double)pageSize);
	    List<List<T>> pages = new ArrayList<List<T>>(numPages);
	    for (int pageNum = 0; pageNum < numPages;)
	        pages.add(list.subList(pageNum * pageSize, Math.min(++pageNum * pageSize, list.size())));
	    return pages;
	}
	static class S {
		int i, j;

		S(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i;
			result = prime * result + j;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			S other = (S) obj;
			if (i != other.i)
				return false;
			if (j != other.j)
				return false;
			return true;
		}
	}
}

class Demo implements java.io.Serializable {
	public int a;
	public String b;

	// Default constructor
	public Demo(int a, String b) {
		this.a = a;
		this.b = b;
		System.out.println("constractor");
	}

}
