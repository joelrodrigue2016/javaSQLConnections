package src.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String file = "text2.txt";
		String line = "";
		try {
			BufferedReader bfReader = new BufferedReader(new FileReader(file));

			try {
				while ((line = bfReader.readLine()) != null) {
					String[] lineStrings = line.split(";");
					System.out.println(lineStrings[0] + lineStrings[1] + lineStrings[2] + lineStrings[3]
							+ lineStrings[4] + lineStrings[5] + lineStrings[6]);

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
