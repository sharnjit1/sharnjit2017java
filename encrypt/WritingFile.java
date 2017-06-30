import java.awt.*;
import java.io.*;
import java.util.*;

class WritingFile extends Frame
 {
  public static void main(String s[])
   {

    Frame frame = new Frame("Writing in File");

    TextField text = new TextField("It Is Working, Thank GOD");

    File file = new File("F:/hello.txt");

    try
    {

      FileWriter writer = new FileWriter("F:/hello.txt",true);

      writer.write(text.getText());

      writer.close();
    }

    catch(Exception e)
    {
		System.out.println(e);
	}

    frame.add(text);

    frame.setVisible(true);

    frame.setSize(200,200);



   }
 }