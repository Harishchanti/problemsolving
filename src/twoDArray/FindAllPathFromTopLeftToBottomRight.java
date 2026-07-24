package twoDArray;

import java.util.ArrayList;
import java.util.List;

public class FindAllPathFromTopLeftToBottomRight {
    static List<String> resultPath = new ArrayList<>();

    public static void main(String[] args) {
        int N = 4;
        int[][] a = {
                    {1, 1, 0, 1},
                    {1, 1, 1, 1},
                    {0, 1, 0, 1},
                    {1, 1, 1, 1} };
        /*
        DRDDRR
DRDRRDD
DRRDDDRR
DRRDDRRDD
         */

        List<Character> pathList = new ArrayList<>();
        char s = 's';
        generateAllPaths(a, 0, 0, pathList, 's', N);
        for (String path : resultPath) {
            System.out.println(path);
        }
    }

    //static int[][] dir = {{1,0},{-1,0},}
    private static void generateAllPaths(int[][] a, int i, int j,
            List<Character> pathList, char s, int N) {

        if (i < 0 || i >= N || j < 0 || j >= N || a[i][j] == 0)
            return;

        pathList.add(s);
        if (i == N - 1 && j == N - 1) {
            resultPath.add(getPathFromList(pathList));
            return;
        }

       // int temp = a[i][j];
        a[i][j] = 0;

        generateAllPaths(a, i + 1, j, pathList, 'D', N);
        generateAllPaths(a, i - 1, j, pathList, 'U', N);

        generateAllPaths(a, i, j + 1, pathList, 'R', N);
        generateAllPaths(a, i, j - 1, pathList, 'L', N);

        a[i][j] = 1;
        pathList.remove(pathList.size() - 1);

    }

    private static String getPathFromList(List<Character> pathList) {
        String result = "";
        int i = 0;
        for (Character c : pathList) {

            if (i++ == 0)
                continue;
            result += c;
        }
        return result;
    }
}
