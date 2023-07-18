import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

// 도메인 주소를 입력하면 주소에 대한 ip 주소를 알아내기 

public class NetworkTest01 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader reader;
		String url;
		InetAddress addr = null; // InetAddress 클래스는 ip 번호를 처리할 때 사용하는 클래스
		
		reader = new BufferedReader(new InputStreamReader(System.in)); // 1. System.in은 키보드 입력 장치와 연결됨     2. InputStreamReader은 읽어들인 바이트를 문자로 변경   3. BufferedReader은 읽어들인 문잘를 버퍼링 즉 임시 메모리에 저장
		System.out.print("웹사이트 주소 입력: ");
		url = reader.readLine(); // 한줄 끝까지 문자열로 읽어들임.
		
		try {
			addr = InetAddress.getByName(url);
		}catch(UnknownHostException ue) {ue.printStackTrace();}
		
		System.out.println("===========================");
		System.out.println(url + "의 ip번호:" + addr.getHostAddress());
	}
}
