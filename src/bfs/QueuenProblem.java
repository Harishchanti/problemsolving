package bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    static class CellDetails {

        public int x;
        public int y;
        public String d;

        public CellDetails(int x, int y, String d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static int queensAttack(int n, int k, int r_q, int c_q,
            List<List<Integer>> obstacles) {
        // Write your code here
        int[] result = { 0 };
        int[][] board = new int[n  ][n  ];

        for (List<Integer> obs : obstacles) {
            int bloker_r = obs.get(0);
            int bloker_c = obs.get(1);
            board[bloker_r -1 ][bloker_c -1 ] = 1;
        }


        findMaxinumAttacks(board, n, r_q-1, c_q-1, result);
        return result[0];

    }

    static void findMaxinumAttacks(int[][] board, int n, int r_q, int c_q,
            int[] result) {

        Queue<CellDetails> queue = new LinkedList<CellDetails>();

        queue.add(new CellDetails(r_q-1, c_q-1, "center"));

        queue.add(new CellDetails(r_q + 1, c_q, "N"));
        queue.add(new CellDetails(r_q + 1, c_q + 1, "NE"));
        queue.add(new CellDetails(r_q + 1, c_q - 1, "NW"));

        queue.add(new CellDetails(r_q, c_q + 1, "E"));
        queue.add(new CellDetails(r_q, c_q - 1, "W"));

        queue.add(new CellDetails(r_q - 1, c_q, "S"));
        queue.add(new CellDetails(r_q - 1, c_q + 1, "SE"));
        queue.add(new CellDetails(r_q - 1, c_q - 1, "SW"));

        while (!queue.isEmpty()) {

            CellDetails cellDetails = queue.poll();
            int x = cellDetails.x, y = cellDetails.y;
            String d = cellDetails.d;

            if (x < 0 || y < 0 || x >= n || y >= n || board[x][y] == 1)
                continue;


            switch (d) {
            case "N":
                queue.add(new CellDetails(x + 1, y, "N"));
                break;
            case "NE":
                queue.add(new CellDetails(x + 1, y + 1, "NE"));
                break;
            case "NW":
                queue.add(new CellDetails(x + 1, y - 1, "NW"));
                break;
            case "E":
                queue.add(new CellDetails(x, y + 1, "E"));
                break;
            case "W":
                queue.add(new CellDetails(x, y - 1, "W"));
                break;
            case "S":
                queue.add(new CellDetails(x - 1, y, "S"));
                break;
            case "SE":
                queue.add(new CellDetails(x - 1, y + 1, "SE"));
                break;
            case "SW":
                queue.add(new CellDetails(x - 1, y - 1, "SW"));
                break;
            default:
                break;
            }
            if(!d.equalsIgnoreCase("center")) {
                result[0] += 1;
            }

        }

    }

}

public class QueuenProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
       /* BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH")));*/

        String[] firstMultipleInput =
                bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput =
                bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                        Stream.of(bufferedReader.readLine()
                                        .replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);
       /* bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }

}
