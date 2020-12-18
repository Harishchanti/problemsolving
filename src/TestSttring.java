import java.util.*;

public class TestSttring {
    public static void main(String[] args) {
    /* System.out.print(arrange("Also notice that preprocessor" +
             " statements which is highlighted appear at the start of " +
             "the program these statements cause the contents of " +
             "the header file stdio and ctype to inserted " +
             "into the program the compilation process begins the " +
             "information contains in these files is essential for" +
             " the proper functioning of the library functions" +
             " getchar putchar and toupper."));
     //     I to love code.*/

        System.out.print(droppes(Arrays.asList(1,1,1,1,2)));

    }

    private static int droppes(List<Integer> requestTime) {
            // Write your code here
            //  3 trans/ secon
            // 20 trans / 10 secon
            // 60 trans / 60 secon
            int droppedCount= 0;
            Deque<Integer> q = new LinkedList<Integer>();
            int prev = 0;
            int count = 1;
            Map<Integer,Integer> map = new HashMap<>();

            for(Integer req : requestTime) {

                if(map.containsKey(req)) {
                    map.put(req,map.get(req)+1);
                } else {
                    map.put(req,1);
                }



                /*if(prev == req) count++;
                else count = 1;*/

                if(map.get(req) > 3) droppedCount++;

                if(prev == req && count > 3) {
                    droppedCount++;
                }

                if( (req % 10) == 0){

                    if(q.size() > 20) droppedCount++;

                }

                if(req % 60 == 0) {

                    if(q.size() > 60) droppedCount++;

                }

                if(q.size() > 20 && req < 10) {
                    droppedCount++;
                }

                if(q.size() > 60 && req < 60) {
                    droppedCount++;
                }

                if(req % 11 == 0) {
                    q.removeFirst();
                }

                q.add(req);
                prev = req;
            }

            return droppedCount;

    }

    public static String arrange(String sentence) {
        // Write your code here
        String output = "";
        Map<Integer, List<String>> map = new TreeMap<>();
        String[] words = sentence.split(" ");
        for(String word:words) {
            int len = word.length();
            if(!map.containsKey(len)) {
                List<String> list= new ArrayList<>();
                list.add(word);
                map.put(len, list);
            } else {
                List<String> list = map.get(len);
                list.add(word);
                map.put(len, list);
            }
        }
        boolean isFirst = true;
        for(Map.Entry<Integer,List<String>> m : map.entrySet()) {

            for(String s : m.getValue()) {

                if(isFirst) {
                    if(!Character.isUpperCase(s.charAt(0)))  {
                        String result = Character.toUpperCase(s.charAt(0)) +s.substring(1);
                        output += result+" ";
                    }else {
                        output += s+" ";
                    }

                    isFirst = false;
                } else {
                    output += s.toLowerCase()+" ";
                }
            }
        }

        return output.trim();
    }
}
