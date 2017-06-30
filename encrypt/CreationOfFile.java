import java.util.*;
import java.io.*;
import java.awt.*;

class CreationOfFile extends Frame
 {
   public static void main(String s[]) throws IOException
    {


		Frame frame = new Frame("File Handling");

		FileDialog filedialog = new FileDialog(frame,"Save",FileDialog.SAVE);

		TextArea text = new TextArea();

		frame.add(text);

		filedialog.setVisible(true);

		String filepath = filedialog.getDirectory();

		String filename = filedialog.getFile();

	    File file = new File(filepath+filename);

	    FileWriter writer = new FileWriter(filepath+filename);

	    //Scanner scan = new Scanner(new FileWriter(filepath+filename));

		//while (scan.hasNext()) // while there's still something to read

        //text.append(scan.nextLine() + "\n");



	    frame.setVisible(true);

	    frame.setSize(200,200);





    }
 }

