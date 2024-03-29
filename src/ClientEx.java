import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

// 스레드가 적용 안된 사용자 네트워크 프로그램
// 192.168.41.71 
public class ClientEx {
	Socket client = null; //서버와 통신하기 위해서 필요한 소켓
	
	String ipAddress; //서버ip 주소 저장하는 변수
	static final int PORT = 5000; //네트워크 포트번호
	
	BufferedReader read; // 읽어들인 문자를 버퍼링
	
	InputStream is;
	ObjectInputStream ois; //입력 스트림
	
	OutputStream os;
	ObjectOutputStream oos; //출력 스트림
	
	String sendData; // 서버로 보낼 자료를 저장할 변수
	String receiveData; // 서버로 부터 받은 데이터를 저장할 변수 
	
	public ClientEx(String ipAddress) {
		this.ipAddress = ipAddress;
		
		try {
			System.out.println("*** 사용자 채팅 프로그램 ***");
			
			client = new Socket(ipAddress, PORT); // 사용자단에서 소켓객체가 생성되면 동시에 서버상에서도 소켓 객체가 생성됨.
			read = new BufferedReader(new InputStreamReader(System.in));
			
			os = client.getOutputStream();
			oos = new ObjectOutputStream(os); // 출력스트림 객체 생성
			
			is = client.getInputStream();
			ois = new ObjectInputStream(is); // 입력스트림 객체 생성
			
			System.out.println("입력: ");
			while((sendData = read.readLine()) != null) {
				// readLine 메소드는 한줄 끝까지 문자열로 읽어들인다. 더 이상 읽을 값이 없다면 null
				oos.writeObject(sendData); // 서버로 자료 전송
				oos.flush(); // 출력 스트림을 비움
				
				if(sendData.equals("quit")) {
					break; //반복문 중단
				}
				
				receiveData = (String)ois.readObject(); //서버가 보낸 자료를 다시 입력받음
				System.out.println(client.getInetAddress() + "로 부터 받은 메시지: " + receiveData);
				System.out.println("입력: ");
			}// while
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}finally {
			try {
				if(is != null) is.close();
				if(ois != null) ois.close();
				if(os != null) os.close();
				if(oos != null) oos.close();
				if(client != null) client.close();
			}catch(Exception e) { e.printStackTrace();}
		}
	}// 생성자
	
	public static void main(String[] args) {
		new ClientEx("192.168.41.71"); // 생성자 인자값으로 서메신저 서버 프로그램 ip 주소
	}
}























