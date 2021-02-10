package heap;

import java.util.*;

public class TopKSongs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PriorityQueue<Song> pq = new PriorityQueue<Song>((o, o1) -> {
            return o1.count - o.count;
        });
        Map<String, Song> map = new HashMap<>();

        boolean flag = true;
        while (flag) {
            System.out.println("Enter 1: To Play Song" +
                    "\n      2: Show top 3 Songs" +
                    "\n      3: Show all the songs" +
                    "\n      4: Exit the program");
            String op = in.next();
            switch (op) {
                case "1":
                    System.out.println("Enter song name played");

                    String songName = in.next();
                    int count = 1;
                    if (map.containsKey(songName)) {
                        Song song = map.get(songName);
                        count = song.count + 1;
                        pq.remove(song);
                    }
                    Song song = new Song(songName, count);
                    pq.add(song);
                    map.put(songName, song);
                    break;
                case "2":
                    System.out.println("Top 3 songs");
                    int i = 0;
                    Iterator iterator = pq.iterator();
                    while (i++ < 3 && iterator.hasNext()) {
                        Song s = (Song) iterator.next();
                        System.out.println(s.name + " " + s.count);
                    }
                    break;
                case "3":
                    System.out.println("All Songs list");
                    iterator = pq.iterator();
                    while (iterator.hasNext()) {
                        Song s = (Song) iterator.next();
                        System.out.println(s.name + " " + s.count);
                    }
                    break;
                case "4":
                    System.out.println("Done..!!");
                    flag = false;
                    break;
            }
        }

    }
}

class Song {
    int count;
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (count != song.count) return false;
        return name != null ? name.equals(song.name) : song.name == null;
    }

    @Override
    public int hashCode() {
        int result = count;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    Song(String name, int count) {
        this.count = count;
        this.name = name;
    }
}