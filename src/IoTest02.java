import java.io.IOException;
import java.io.OutputStream;

// OutputSteram 은 바이트 출력 스트림의 촤상위 추상클래스
public class IoTest02 {
	public static void main(String[] args) throws Exception {
		
		int data = 0;
		System.out.print("문자 입력: ");
		OutputStream myOut = System.out;
		// System.out 은 모니터 출력장치와 연결됨
		
		while ((data = System.in.read()) != -1) {
			myOut.write((char)data);
		}
	}
}
