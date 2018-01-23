import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.management.InstanceAlreadyExistsException;

import org.apache.commons.lang.exception.ExceptionUtils;

import multithreading.ExceptionTest;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Long d =5L;
		Long f = 8L;
		Object[] c =new Object[2];
		c[0] = d;c[1] = f;
		
		Long ss = Long.parseLong(c[0].toString());
		System.out.println(ss);
		String ex = "";
		try {
		int sum = 1/0;
		} catch (Exception e) {
			// TODO: handle exception
			 ex = ExceptionUtils.getMessage(e);
		}*/
		/*Long fd =null; 
		String orElse = Optional.ofNullable(fd.toString()).orElse("");
		*/
		/*System.out.println(new Date(System.currentTimeMillis() - 3600 * 1000));
		
		String[] s = new String[]{"1","2","3"};
		//List<String> sList = new ArrayList<String>(){"",""};
		List<String> sList = Arrays.asList(s);
		
		List<Integer> intList = sList.stream().map(i ->Integer.parseInt(i)).collect(Collectors.toList());
		
		intList.forEach(ss -> System.out.println(ss));
		
		int reduced2 = intList.stream()
		        .reduce((acc, item) -> acc +  item)
		        .get();
		System.out.println(reduced2);*/
		C c = new C();
	}
	
	
}


class A {
	
	A() {
		System.out.println("A");
	}
	
}

class B extends A{
	
	B() {
		System.out.println("B");
	}
	
}

class C extends B{
	
	C() {
		System.out.println("C");
	}
	
}