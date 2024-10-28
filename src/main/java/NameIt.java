public class NameIt {
    public static void main(String[] args) {
        int[] input = new int[]{5, 7, 9, 11, 18, 34, 37, -7, 0, 2, 4};
        int result = nameMethod(input);

        if (result == -1) {
            System.out.println("Empty result");
        } else {
            System.out.println("Result => " + result);
        }
    }

    static int nameMethod(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] > input[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    //ToDo: Implement it. Improve nameMethod(...)
    static int nameMethod2(int[] input) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
