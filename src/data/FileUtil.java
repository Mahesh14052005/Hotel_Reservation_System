package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileUtil {
	public static void write(String fileName, String data) {
		try {
			FileWriter fw=new FileWriter(fileName);
			fw.write(data);
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static String read(String fileName) {
		StringBuilder sb=new StringBuilder();
		try {
			BufferedReader br=new BufferedReader(new FileReader(fileName));
			String line;
			while((line=br.readLine())!=null) {
				sb.append(line).append("\n");
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
