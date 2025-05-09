import java.util.Random;

public class randNum {
    public static int randNum() {
        Random r = new Random();
        return r.nextInt(100); // số ngẫu nhiên từ 0 đến 99
    }
}
