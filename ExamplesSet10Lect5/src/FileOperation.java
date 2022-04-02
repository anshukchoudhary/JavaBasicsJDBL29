import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperation {

	public static void main(String[] args) throws IOException {
		File file = new File("C:/SoftwareArch/myFirstFile.txt");
		
		//boolean val = file.createNewFile();
		
		//System.out.println("file created: "+ val);
		
		//char[] charArray = new char[500];
		
		//FileReader fr = new FileReader("C:/SoftwareArch/myFirstFile.txt");
		//fr.read(charArray);
		//System.out.println(charArray);
		//fr.close();
		
		String address = "i live on streets of NY";
		FileWriter fw = new FileWriter("C:/SoftwareArch/myFirstFile.txt");
		fw.write(address);
		fw.close();
		
		

	}

}
