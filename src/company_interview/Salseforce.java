package company_interview;

import java.util.*;

public class Salseforce {


    /*Set<SongDetails> set = new TreeSet<SongDetails>( ((SongDetails)o, (SongDetails)o1) -> {
            return o.count - o1.count;
        });*/
    public static void main(String[] args) {
        String[] logs = {
                "Bad - Michael Jackson",
                "ABC - XYZ",
                "EFG - UVT",
                "cfd - ggg",
                "Bad - Michael Jackson",
                "EFG - UVT",
                "EFG - UVT",
        };
        int n = 3;
        List<String> topSongs = findTopMostDownloadedSongs(logs, n);

        topSongs.forEach(o -> {
            System.out.print(o + " ");
        });
    }

    static List<String> findTopMostDownloadedSongs(String[] logs, int n) {
        List<String> result = new ArrayList<>();

        PriorityQueue<Song> pq = new PriorityQueue<>();
        Map<String, Integer> map = new HashMap<>();
        for (String log : logs) {
            String name = log.split(" - ")[0];
            Song s = new Song(name, 1);
            if (!map.containsKey(name)) {
                map.put(name, 1);
            } else {
                map.put(name, map.get(name) + 1);
            }
        }

        for (Map.Entry<String, Integer> s : map.entrySet()) {
            Song d = new Song(s.getKey(), s.getValue());
            pq.add(d);
        }

        while (!pq.isEmpty()){
            if (result.size() <n) {
                result.add(pq.poll().name);
            } else break;
        }
        return result;

    }

}

class Song implements Comparable<Song> {
    String name;
    Integer count;

    Song(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(name, song.name) &&
                Objects.equals(count, song.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count);
    }

    @Override
    public int compareTo(Song o) {
        return o.count - this.count;
    }
}
