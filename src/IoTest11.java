import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

// 객체 직렬화 클래스 Customer.java를 활용해서 result10.txt에 객체단위로 기록된 것을 객체단위로 읽어온다.


public class IoTest11 {
	public static void main(String[] args) {
		
		try {
			FileInputStream fi= new FileInputStream("./src/result10.txt"); // 파일로 부터 바이트 단위로 읽어들이기 위한 fi 생성                                                                                                                                
			ObjectInputStream oi = new ObjectInputStream(fi);
			Customer cus = (Customer)oi.readObject(); // 객체단위로 읽어옴
			
			System.out.println("ID \t name \t age \t height"); 
			System.out.println("----------------------------->");
			System.out.println(cus); // toString 생략됨
			
		}catch(ClassNotFoundException fe) {
			fe.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
}
