import java.io.*;
import java.net.SocketAddress;

public class SocketWriter implements Runnable {
    private PrintWriter printWriter;
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public SocketWriter(OutputStream outputStream){
        printWriter = new PrintWriter(outputStream, true);
    }

    @Override
    public void run() {
        while (true){
            try {
                printWriter.println(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
