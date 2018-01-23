package simplecodes;

public class SquareRootFunction {

	public static void main(String[] args) {
	    
		// Finding sqrt without using built in fucntion
		
	  System.out.println(sqrt(5));
				
				
				/*
				 *     float Q_rsqrt( float number )
    {
    	long i;
    	float x2, y;
    	const float threehalfs = 1.5F;
    	x2 = number * 0.5F;
    	y  = number;
    	i  = * ( long * ) &y;                       // evil floating point bit level hacking
    	i  = 0x5f3759df - ( i >> 1 );               // what the fuck? 
    	y  = * ( float * ) &i;
    	y  = y * ( threehalfs - ( x2 * y * y ) );   // 1st iteration
    //	y  = y * ( threehalfs - ( x2 * y * y ) );   // 2nd iteration, this can be removed
    	return y;
    }
				 */
				
	}

	private static double sqrt(int i) {
		
	    /*int num = 5
	    	    while(0.0001 < Math.abs(guess * guess - num)){
	    	        guess = (guess + num / guess) / 2;
	    	    }
		return ;*/
		return 0;
	}
	
	

}
