public class ClassName extends Thread {
    public ClassName() {
        ClassName cn = new ClassName(); 
        cn.start(); 
    }

    public void run() {
        System.out.println("Luồng đang chạy...");
    }
}
