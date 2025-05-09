public class BreakAndContinue {
    public static void WhileTest(int limit) {
        int i = 0;
        while (i < limit) {
            if (i == 5) break;
            System.out.println("While i = " + i);
            i++;
        }
    }

    public static void DoWhileTest(int limit) {
        int i = 0;
        do {
            if (i == 3) {
                i++;
                continue;
            }
            System.out.println("DoWhile i = " + i);
            i++;
        } while (i < limit);
    }
}
