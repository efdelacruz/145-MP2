import java.net.*;

public class MyServer {
	public static void main(String args[]) {
		try {
			System.out.println("Server: Starting Server...");
			ServerSocket ssocket = new ServerSocket(8888);
            ServerReceiver sr = new ServerReceiver(ssocket);
            sr.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
