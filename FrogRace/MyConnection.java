import java.io.*;
import java.net.*;

public class MyConnection{
    Socket connectionSocket;
    public MyConnection(Socket s){
        connectionSocket = s;
    }

    public String getMessage() throws Exception{
        InputStream a = connectionSocket.getInputStream();
		InputStreamReader b = new InputStreamReader(a);
		BufferedReader c = new BufferedReader(b);
		String msg = c.readLine();
		return msg;
    }

    public boolean sendMessage(String message) throws Exception{
        OutputStream a = connectionSocket.getOutputStream();
		OutputStreamWriter b = new OutputStreamWriter(a);
		PrintWriter c = new PrintWriter(b);
		c.println(message);
		c.flush();
        return true;
    }
}
