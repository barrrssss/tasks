import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        Socket socket = serverSocket.accept();

        ExecutorService service = Executors.newCachedThreadPool();

        service.submit(new SocketWriter(socket.getOutputStream()));
        service.submit(new SocketReader(socket.getInputStream()));

        service.shutdown();


    }

}


