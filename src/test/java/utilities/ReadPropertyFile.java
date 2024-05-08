package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader(
				"C:\\Users\\pc\\eclipse-workspace\\selenium\\src\\test\\resources\\configfiles\\Config.Properties");
		Properties p = new Properties();
		p.load(fr);
		System.out.println(p.getProperty("browser"));

	}

}
