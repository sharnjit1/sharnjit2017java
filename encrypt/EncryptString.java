import java.awt.*;
import java.util.*;
import java.awt.event.*;


class EncryptString extends Frame implements ActionListener
 {


  Button button,button1;

  String str;

  TextArea text,text1;

  int count;

  static char rev[];

  EncryptString()
  {

        Frame frame = new Frame("Encrypted String");

        button = new Button("Encrypt");

        button1 = new Button("Decrypt ");

     	frame.setLayout(null);

     	text = new TextArea();

     	text1 = new TextArea();

     	frame.add(text);

     	frame.add(text1);

     	frame.add(button);

     	frame.add(button1);

     	text.setBounds(50,80,400,150);

     	text1.setBounds(50,280,400,150);

     	button.setBounds(250,450,50,30);

     	button1.setBounds(350,450,50,30);

     	button.addActionListener(this);

     	button1.addActionListener(this);

     	frame.setVisible(true);

     	frame.setSize(500,500);
	}

	public void actionPerformed(ActionEvent e)
	 {

		String str1 = e.getActionCommand();

		char c;


		if(str1=="Encrypt")
		 {

			 str=text.getText();

			 //str.reverse();

			 count=str.length();

			 rev = new char[count];

			 rev = str.toCharArray();



			 System.out.print(rev);




		 }

		 if(str1=="Decrypt ")
		 {

			 str=text.getText();
			 text1.setText(str);

		 }

	 }


  public static void main(String s[])
   {


   	EncryptString object = new EncryptString();

   }
 }