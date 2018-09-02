import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.File;
import java.awt.Desktop;


public class helperTool {

	public static void main(String[] args) {
		
		String[] arr = new String[2];
		int testCaseNumber = 0;
		File fileOut = new File("out.txt");
		Desktop desktop = Desktop.getDesktop();
		
		
		
		try {
			FileOutputStream fos = new FileOutputStream(fileOut);
			RandomAccessFile file = new RandomAccessFile("file.txt", "r");
				
				PrintStream ps = new PrintStream(fos);
				System.setOut(ps);

			try {
				while (true) {
					try {
						
						String caseHeader = file.readLine();
						if(caseHeader.toLowerCase().contains("case ") && 
						  (caseHeader.toLowerCase().indexOf("t") == -1)){
						
							arr = caseHeader.toLowerCase().split("e ");
							 
						}
						if (caseHeader.contains("COMMENT")) {
							String tCaseHeader = file.readLine();
							
							if (!(tCaseHeader.toLowerCase().contains("design") &&
							   (!tCaseHeader.isEmpty()))) {
								testCaseNumber++;
								System.out.println("*   " + arr[1]
										+ "	" + tCaseHeader);
							} else if (tCaseHeader.toLowerCase().contains(
									"design")) {
								testCaseNumber++;
								System.out.println("*   " + arr[1]
										+ "	" + caseHeader);
							}

						}
						if (caseHeader.toLowerCase().contains(
								"end of test script")) {
							break;

						}
					} catch (EOFException ex) {
						ex.printStackTrace();
						System.out.println("error");
						file.close();
						break;

					}
				}

			} catch (IOException a) {
				System.out.println("error");
				a.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Can't read or find file");
			e.printStackTrace();

		}
		try{
		
		desktop.open(fileOut);
		}catch(IOException as){
			as.printStackTrace();
		}



}
}
