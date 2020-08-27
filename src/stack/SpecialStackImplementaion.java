package stack;


import java.util.Stack;


class SpecialStackImplementaion extends Stack<Integer> {

    Stack<Integer> min = new Stack<>();

    void push(int x) {

        if (isEmpty() == true) {
            super.push(x);
            min.push(x);
        } else {

            super.push(x);
            int y = min.pop();
            min.push(y);

            if (x <= y)
                min.push(x);
        }
    }

    public Integer pop() {
        int x = super.pop();
        int y = min.pop();

        if (y != x)
            min.push(y);
        return x;
    }

    int getMin() {
        int x = min.pop();
        min.push(x);
        return x;
    }

    public static void main(String[] args) {
        SpecialStackImplementaion s = new SpecialStackImplementaion();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.getMin());
        s.push(5);
        System.out.println(s.getMin());
    }
}
