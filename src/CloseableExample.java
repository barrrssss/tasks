import java.io.Closeable;
import java.io.IOException;

public class CloseableExample {
    public static void main(String[] args) {
        try(CloseableClass closeableClass = new CloseableClass()) {
            closeableClass.doSmth();
            System.out.println("Code after the method");
            throw new IOException("Fake IOException");
        } catch (IOException e) {
            System.out.println("An exception has been thrown");
        } finally {
            System.out.println("The finally block has been executed");
        }
    }

    public static class CloseableClass implements Closeable{

        @Override
        public void close() throws IOException {
            System.out.println("Resource has been closed");
        }

        public void doSmth(){
            System.out.println("The method is doing something");
        }
    }
}

