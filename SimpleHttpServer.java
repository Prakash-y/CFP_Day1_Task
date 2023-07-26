package SimpleWebServer;

import java.io.IOException;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
public class SimpleHttpServer 
{
		public static int DEFAULT_PORT = 9002;
		public static int port;
		private HttpServer httpServer;
		
		public static void main(String[] args) 
		{
			SimpleHttpServer httpsServer = new SimpleHttpServer();
			httpsServer.start(DEFAULT_PORT);

		}

		private void start(int port)
		{
		this.port = port;

		try {

		httpServer = HttpServer.create(new InetSocketAddress(port), 0);

		System.out.println("server started at port" + port);

		httpServer.createContext( "/Prakash", new Handlers.RootHandler());
		
     	httpServer.createContext( "/ecoHeader", new Handlers.EchoHeaderHandler());

		httpServer.createContext( "/echoGet", new Handlers.EchoGetHandler());

    	httpServer.createContext( "/echoPost", new Handlers. EchoPostHandler());

		httpServer.setExecutor (null);

		httpServer.start();

		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		}
}


