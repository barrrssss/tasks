import com.sun.jndi.toolkit.url.UrlUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class HTTPRequest {
    private static final String REQUEST_PATTERN = "GET / HTTP/1.1\r\nHost: %s\r\n\r\n";
    private static final String URL = "ru.euronews.com";

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(URL, 80), 2_000);

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printWriter.printf(REQUEST_PATTERN, URL);
        while (true){
            System.out.println(bufferedReader.readLine());
        }
    }
}
