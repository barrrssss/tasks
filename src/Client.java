import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("192.168.0.103", 8189), 2000);

        ExecutorService service = Executors.newCachedThreadPool();

        service.submit(new SocketWriter(socket.getOutputStream()));
        service.submit(new SocketReader(socket.getInputStream()));

        service.shutdown();
    }
}
