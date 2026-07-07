package twoDArray;

import java.util.Stack;

public class MaxSumExpression {
    public static void main(String[] args) {
        char[][] cArr = {   { '+', '2', '+', '3', '1' },
                            { '+', '2', '*', '3', '1' },
                            { '4', '*', '3', '*', '9' },
                            { '+', '2', '9', '*', '8' } };
        // Max sum vertical/ horizontal
        // 3 * 9 = 27
        // 4 * 3 + 1 = 13
        // 9 * 8 = 72

        System.out.println(maxValueOfExpressionV2(cArr));

    }

    private static int maxValueOfExpressionV2(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxVal = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (Character.isDigit(grid[i][j])) {

                    // horizontal
                    maxVal = Math.max(maxVal,
                            evaluate(grid, i, j, 0, 1));

                    // vertical
                    maxVal = Math.max(maxVal,
                            evaluate(grid, i, j, 1, 0));
                }
            }
        }
        return maxVal;
    }

    static int evaluate(char[][] grid, int i, int j, int dx, int dy) {

        StringBuilder expr = new StringBuilder();
        expr.append(grid[i][j]);

        int x = i;
        int y = j;

        boolean expectOperator = true;

        while (true) {
            x += dx;
            y += dy;

            if (x >= grid.length || y >= grid[0].length)
                break;

            char c = grid[x][y];

            if (expectOperator && isOperator(c)) {
                expr.append(c);
                expectOperator = false;
            } else if (!expectOperator && Character.isDigit(c)) {
                expr.append(c);
                expectOperator = true;
            } else {
                break;
            }
        }

        return evaluateExpression(expr.toString());
    }

    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }

    // Simple evaluator with precedence
    static int evaluateExpression(String expr) {

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (!Character.isDigit(c) || i == expr.length() - 1) {

                if (sign == '+')
                    stack.push(num);
                else if (sign == '-')
                    stack.push(-num);
                else if (sign == '*')
                    stack.push(stack.pop() * num);

                sign = c;
                num = 0;
            }
        }

        int result = 0;
        for (int val : stack)
            result += val;

        System.out.println(expr + " : " + result);
        return result;
    }

    private static int maxValueOfExpression(char[][] cArr) {
        int m = cArr.length;
        int n = cArr[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (Character.isDigit(cArr[i][j])) {
                    int hMax = findMaxFromHorizontal(cArr, i, j, n);
                    int vMax = findMaxFromVirtical(cArr, i, j, m);
                    System.out.println(
                            " i " + i + " j " + j + " hMax : " + hMax + " vMax : " + vMax);
                    max = Math.max(max, Math.max(vMax, hMax));
                }
            }
        }
        return max;
    }

    private static int findMaxFromVirtical(char[][] cArr, int i, int j,
            int m) {
        int x = i, y = j;
        boolean flag = true;
        char sign = '+';
        int num = 0;
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        while (x < m) {

            char c = cArr[x][y];

            if (Character.isDigit(c)) {

                if (!flag)
                    break;
                num = c - '0';
                flag = false;
                stack.add(num);

            } else {

                if (flag)
                    break;
                int prv = stack.pop();
                if (c == '+') {
                    result = prv + num;
                } else if (c == '-') {
                    // result -= num;
                    result = prv - num;
                } else if (c == '*') {
                    //result *= num;
                    result = prv * num;
                }
                num = 0;
                sign = c;
                flag = true;
                stack.add(result);
                result = 0;
            }
            x++;

        }
        result = 0;
        if (num != 0) {
            int prv = stack.pop();
            if (sign == '+') {
                result = prv + num;
            } else if (sign == '-') {
                result = prv - num;
            } else if (sign == '*') {
                result = prv * num;
            }
        }
        return result;
    }

    private static int findMaxFromHorizontal(char[][] cArr, int i,
            int j, int n) {
        // Find max from horizontal

        int x = i, y = j;
        boolean flag = true;
        char sign = '+';
        int num = 0;
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        while (y < n) {

            char c = cArr[x][y];

            if (Character.isDigit(c)) {

                if (!flag)
                    break;
                num = c - '0';
                flag = false;
                stack.add(num);
                num = 0;

            } else {

                if (flag)
                    break;
                int prv = stack.pop();

                if (c == '+') {
                    //result += num;
                    result = prv + num;
                } else if (c == '-') {
                    //result -= num;
                    result = prv - num;
                } else if (c == '*') {
                    //result *= num;
                    result = prv * num;
                }
                num = 0;
                sign = c;
                flag = true;
                stack.add(result);
                result = 0;
            }
            y++;

        }
        result = 0;
        if (num != 0) {
            int prv = stack.pop();
            if (sign == '+') {
                result = prv + num;
            } else if (sign == '-') {
                result = prv - num;
            } else if (sign == '*') {
                result = prv * num;
            }
        }

        return result;
    }
}
