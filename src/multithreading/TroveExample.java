package multithreading;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import gnu.trove.map.TMap;
import gnu.trove.map.hash.THashMap;
import gnu.trove.set.TIntSet;
import gnu.trove.set.hash.THashSet;
import gnu.trove.set.hash.TIntHashSet;
import gnu.trove.set.hash.TLinkedHashSet;


public class TroveExample {

	private static final int SIZE = 100000*6;
    private static final float FILL_FACTOR = 0.75f;
 
    public static void main(String[] args) {
        //testJdkHashSet();
        //testJdkLinkedHashSet();
        testJdkHashMap();
        //testTHashSet();
        //testTLinkedHashSet();
        //testTIntHashSet();
        testTHashMap();
    }
 
    private static void testTHashMap() {
    	final long start = getUsedMemory();
        final TMap<String,Integer> map = new THashMap<String,Integer>( SIZE, FILL_FACTOR );
        for ( int i = 0; i < SIZE; ++i )
            map.put( String.valueOf(i),i );
        final long size = ( getUsedMemory() - start ) / 1024 / 1024;
        System.out.println( "THashMap<String,Integer> = " + size + 'M' );
        if ( map.size() == 1 ) System.out.println( 1 );
		
	}

	private static void testJdkHashMap() {
		final long start = getUsedMemory();
        final Map<String,Integer> map = new HashMap<String,Integer>( SIZE, FILL_FACTOR );
        for ( int i = 0; i < SIZE; ++i )
          map.put( String.valueOf(i),i );
        final long size = ( getUsedMemory() - start ) / 1024 / 1024;
        System.out.println( "HashMap<String,Integer> = " + size + 'M' );
        if ( map.size() == 1 ) System.out.println( 1 );
		
	}

	private static long getUsedMemory()
    {
        System.gc();
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }
 
    private static void testJdkHashSet()
    {
        final long start = getUsedMemory();
        final Set<Integer> set = new HashSet<>( SIZE, FILL_FACTOR );
        for ( int i = 0; i < SIZE; ++i )
            set.add( i );
        final long size = ( getUsedMemory() - start ) / 1024 / 1024;
        System.out.println( "HashSet<Integer> = " + size + 'M' );
        if ( set.size() == 1 ) System.out.println( 1 );
    }
 
    private static void testJdkLinkedHashSet()
    {
        final long start = getUsedMemory();
        final Set<Integer> set = new LinkedHashSet<>( SIZE, FILL_FACTOR );
        for ( int i = 0; i < SIZE; ++i )
            set.add( i );
        final long size = ( getUsedMemory() - start ) / 1024 / 1024;
        System.out.println( "LinkedHashSet<Integer> = " + size + 'M' );
        if ( set.size() == 1 ) System.out.println( 1 );
    }
 
    private static void testTHashSet()
    {
        final long start = getUsedMemory();
        final Set<Integer> set = new THashSet<>( SIZE, FILL_FACTOR );
        for ( int i = 0; i < SIZE; ++i )
            set.add( i );
        final long size = ( getUsedMemory() - start ) / 1024 / 1024;
        System.out.println( "THashSet<Integer> = " + size + 'M' );
        if ( set.size() == 1 ) System.out.println( 1 );
    }
 
    private static void testTLinkedHashSet()
    {
        final long start = getUsedMemory();
        final Set<Integer> set = new TLinkedHashSet<>( SIZE, FILL_FACTOR );
        for ( int i = 0; i < SIZE; ++i )
            set.add( i );
        final long size = ( getUsedMemory() - start ) / 1024 / 1024;
        System.out.println( "TLinkedHashSet<Integer> = " + size + 'M' );
        if ( set.size() == 1 ) System.out.println( 1 );
    }
 
    private static void testTIntHashSet()
    {
        final long start = getUsedMemory();
        final TIntSet set = new TIntHashSet( SIZE, FILL_FACTOR, -1 );
        for ( int i = 0; i < SIZE; ++i )
            set.add( i );
        final long size = ( getUsedMemory() - start ) / 1024 / 1024;
        System.out.println( "TIntHashSet<Integer> = " + size + 'M' );
        if ( set.size() == 1 ) System.out.println( 1 );
    }
}
