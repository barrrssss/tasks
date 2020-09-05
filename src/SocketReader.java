import java.io.*;

public class SocketReader implements Runnable {
    private BufferedReader bufferedReader;

    public SocketReader(InputStream inputStream) {
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
