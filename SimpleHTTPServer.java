import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/*
 * Java program to create a simple HTTP Server to demonstrate how to use
 * ServerSocket and Socket class.
 */

public class SimpleHTTPServer {

  public static void main(String args[]) throws IOException {
    ServerSocket server = new ServerSocket(8000);
    System.out.println("Listening for connection on port 8000 ....");
    InetAddress id = InetAddress.getLocalHost();
    TimeZone timeZone = TimeZone.getTimeZone("Asia/Hong_Kong");
    while (true) {
      try (Socket socket = server.accept()) {
        Date today = new Date();
        SimpleDateFormat sdfHK = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        sdfHK.setTimeZone(timeZone);
        String todaydate = sdfHK.format(today);

        String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + "Hello everyone!\n\n" + "Current date and time is: " + todaydate + "\n\n" + "Your application is running on the server with this hostname: " + id.getHostName();
/*
        String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + "Hello everyone!\n\n" + "Current date and time is: " + todaydate + "\n\n" + "Current time zone is: " + timeZone.getID() + "\n\n" + "Your application is running on the server with this hostname: " + id.getHostName();
*/
        socket.getOutputStream()
              .write(httpResponse.getBytes("UTF-8"));
      }
    }
  }

}
