import java.io.*;

class Main {
    public static void main(String[] args) {
        File path = new File("."); // current directory
        String[] list = path.list();

        for(int i = 0; i < list.length; i++)
            System.out.println(list[i]);
    }
}
