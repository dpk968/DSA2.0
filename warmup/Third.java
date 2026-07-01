package warmup;

public class Third {
    public static void main(String[] args) {

        // nYn();
        // pattern2();
        // pattern3();
        // pattern4();
        // pattern5();
        // pattern6();

        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void pattern6() {
        // 12345
        // 1234
        // 123
        // 12
        // 1

        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }

    public static void pattern5() {
        // *****
        // ****
        // ***
        // **
        // *

        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern4() {
        // 1
        // 22
        // 333
        // 4444
        // 55555

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(i + 1);
            }
            System.out.println();
        }

    }

    public static void pattern3() {
        // 1
        // 12
        // 123
        // 1234
        // 12345

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }

    public static void pattern2() {
        // *
        // **
        // ***
        // ****
        // *****

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void nYn() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void binaryPrint() {

        // 1
        // 0 1
        // 1 0 1
        // 0 1 0 1
        // 1 0 1 0 1
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print((i + j) % 2 + " ");
            }
            System.out.println();
        }
    }

    public static void arrowTriangle() {

        // *
        // * *
        // * * *
        // * * * *
        // * * * * *
        // * * * *
        // * * *
        // * *
        // *

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 4; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void diamond() {

        // *
        // * * *
        // * * * * *
        // * * * * * * *
        // * * * * * * * * *
        // * * * * * * * * *
        // * * * * * * *
        // * * * * *
        // * * *
        // *

        pramid();
        pramidDownward();
    }

    public static void pramidDownward() {
        for (int i = 1; i <= 10; i = i + 2) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 10; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // * * * * * * * * *
        // * * * * * * *
        // * * * * *
        // * * *
        // *
    }

    public static void pramid() {
        // *
        // * * *
        // * * * * *
        // * * * * * * *
        // * * * * * * * * *

        for (int i = 1; i < 10; i = i + 2) {
            for (int j = 10; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

    }
}
