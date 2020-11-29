package company_interview;

import java.io.Console;
import java.util.*;

public class Grab {
    static List<String> musicExtList = Arrays.asList("mp3", "acc", "flac");
    static List<String> imagExtList = Arrays.asList("jpg", "bmp", "gif");
    static List<String> moviesExtList = Arrays.asList("mp4", "avi", "mkv");

    public static void main(String[] args) {
        String s = "my.song.mp3 11b\n" +
                "greatSong.flac 1000b\n" +
                "not3.txt 5b\n" +
                "video.mp4 200b\n" +
                "game.exe 100b\n" +
                "mov!e.mkv 10000b";
//
// System.out.print(getDetails(s));

        int[] a = {3, 5, 6, 3, 3, 5};

    //System.out.print(getCounnt(a));
        System.out.print(findDiversString(0,1,8,""));
    }

    private static String findDiversString(int a, int b, int c,String s) {

        //if(a)
        return null;
    }

    static int getCounnt(final int[] a) {

        //Push the indices into an array:
        Integer[] indices = new Integer[a.length];
        for (int p = 0; p < a.length; ++p) indices[p] = p;

        //Sort the indices according to the value of the corresponding element in a:
        //Arrays.sort(indices, /*(k, l) -> {
        //    return a[(int) k] - a[(int) l];
        //}*/);
        Arrays.sort(indices, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return a[o1] - a[o2];
            }

        });


        //Then just pull out blocks of indices with equal corresponding elements from indices:
        int count = 0;
        int i = 0;
        while (i < indices.length) {
            int start = i;
            while (i < indices.length && a[indices[i]] == a[indices[start]]) {
                ++i;
            }
            int thisCount = i - start;

            int numPairs = thisCount * (thisCount - 1) / 2;

            count += numPairs;
        }
        return count;
        //Console.WriteLine(count);
        //  Console.ReadKey();
    }

    /*
    music 1011b
    images 0b
    movies 10200b
    other 105b"
     */
    private static String getDetails(String s) {
        String[] files = s.split("\n");
        Map<String, Long> map = new LinkedHashMap<>();
        map.put("music", 0l);
        map.put("images", 0l);
        map.put("movies", 0l);
        map.put("other", 0l);

        for (String file : files) {
            String[] f = file.split(" ");
            String[] ext = f[0].split("\\.");
            String exteantionType = ext[ext.length - 1];
            Long numberOfBytes = Long.parseLong(f[1].substring(0, f[1].length() - 1));
            //System.out.println(exteantionType + " " + numberOfBytes);
            if (moviesExtList.contains(exteantionType)) {
                map.put("movies", map.get("movies") + numberOfBytes);
            } else if (musicExtList.contains(exteantionType)) {
                map.put("music", map.get("music") + numberOfBytes);
            } else if (imagExtList.contains(exteantionType)) {
                map.put("images", map.get("music") + numberOfBytes);
            } else {
                map.put("other", map.get("other") + numberOfBytes);
            }
        }

        return getOutPut(map);
    }

    private static String getOutPut(Map<String, Long> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Long> m : map.entrySet()) {
            sb.append(m.getKey() + " " + m.getValue() + "b\n");
        }
        return sb.toString().trim();
    }
}
