import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

// 객체 직렬화 클래스 Customer.java 를 활용해서 객체 단위로 기록하기 위한 소스


public class IoTest10 {
	public static void main(String[] args) {
		
		Customer cu = new Customer(10, "홍길동", 23, 173.6);
		
		try {
			System.out.println(cu.toString());
			FileOutputStream fo = new FileOutputStream("./src/result10.txt");
			ObjectOutputStream os = new ObjectOutputStream(fo);
			os.writeObject(cu); // 객체 단위로 기록
			
			os.close(); fo.close();
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
}
