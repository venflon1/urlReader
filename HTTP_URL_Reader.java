import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HTTP_URL_Reader {
	
	public static void main(String[] args) throws IOException {
		if(args.length == 0) {
			System.out.println("no URL inserted!");
			System.exit(0);
		}
		else if(args.length == 1) {
			String[] input = args[0].split("/");
			String protocol = input[0];
			String host = input[2];
			String file = input[input.length-1];
			
//			URL url = new URL(protocol, host, 80, file);
			URL url = new URL(args[0]);
			InputStream istream = url.openStream();
			DataInputStream diStream = new DataInputStream(istream);
			
			String line = null;
			while((line = diStream.readLine()) != null) {
				System.out.println(line);
			}
			
			diStream.close();
			istream.close();
		}
	}
}