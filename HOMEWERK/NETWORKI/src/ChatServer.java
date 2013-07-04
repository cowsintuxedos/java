import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A simple chat server.
 */
public class ChatServer {
	static ChatRoom room;

	/**
	 * Runs the server.
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket listener = new ServerSocket(9090);
		ChatRoom room = new ChatRoom();

		try {
			while (true) {
				Socket socket = listener.accept();
				System.out.println(socket.getInetAddress() + "connected!");

				ChatLink link = new ChatLink(socket, room);
				Thread t = new Thread(link);
				t.start();
			}
		}
		finally {
			listener.close();
		}
	}
}

class ChatLink implements Runnable {

	BufferedReader input;
	PrintWriter output;
	ChatRoom room;
	int myLine = 0;

	public ChatLink(Socket socket, ChatRoom r) {
		try {
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream(), true);
			room = r;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** My custom protocol, based around action:value pairs
	 *  login:keshav@password
	 *  --> login:true/false
	 *  message:blah
	 *  --> message:sent/rate limit/not sent
	 */

	@Override
	public void run() {
		while (true) {
			try {
				String i = input.readLine();
				if (i != null) {
					String action = i.substring(0, i.indexOf(':'));
					String rest = i.substring(i.indexOf(':') + 1);
					if (action.equals("authenticate")) {
						String[] parts = rest.split("@");
						output.println("login:" + room.authenticate(parts[0], parts[1]));
					}
					if (action.equals("message")) {
						room.add(rest);
					}
					if (action.equals("line")) {
						try {
							myLine = Integer.parseInt(rest.trim());
						} catch (NumberFormatException e) { }
					}
				}
				for (int j = myLine ; j < room.messageSize() ; j++) {
					output.println("update:" + room.get(j));
				}
				myLine = room.messageSize();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}