import java.awt.*;
import java.awt.event.*;
import java.awt.Frame.*;
import java.awt.MenuBar.*;
import java.io.*;
import java.util.*;
import java.lang.String.*;


class EncryptedNotepad extends Frame implements ActionListener
 {


      static TextArea textfield;

      static Frame f1;

      static char RevArr[];

      static String Temp;

      static int count,flag=0;

      Frame frame;

      EncryptedNotepad()

      {


	  }

	  static void Encrypted(int c,int d)

	   {

		f1.setVisible(true);

	   }



      EncryptedNotepad(int a)

      {


      f1 = new Frame("Encryped Notepad");
      MenuBar menubar = new MenuBar();   // Menu Bar
      textfield = new TextArea();

      f1.setMenuBar(menubar);
      f1.add(textfield);


      Menu file = new Menu("File"); // File Menu

      MenuItem New = new MenuItem("   New                         Ctrl+N "); // File Items
      MenuItem Open = new MenuItem("   Open                       Ctrl+O");
      MenuItem Save = new MenuItem("   Save                        Ctrl+S");
      MenuItem Exit = new MenuItem("   Exit");

      file.add(New);

      file.add(Open);

      New.addActionListener(this);
      Open.addActionListener(this);
      Save.addActionListener(this);
      Exit.addActionListener(this);


      file.add(Save);

      file.add(Exit);

      Menu edit = new Menu("Edit"); // Edit Menu

      MenuItem undo = new MenuItem("  Undo                      Ctrl+Z  "); // Edit Items
      MenuItem cut =  new MenuItem("  Cut                         Ctrl+X");
      MenuItem copy = new MenuItem("  Copy                      Ctrl+C");
      MenuItem paste = new MenuItem("  Paste                     Ctrl+V");
      MenuItem delete = new MenuItem("  Delete                        Del");
      MenuItem find = new MenuItem("  Find                        Ctrl+F");
      MenuItem replace = new MenuItem("  Replace                Ctrl+H");
      MenuItem goto1 = new MenuItem("  Goto                       Ctrl+G");
      MenuItem selectall = new MenuItem("  Select All               Ctrl+A");

      edit.add(undo);  // Adding items to Edit Menu
      edit.add(cut);
      edit.add(copy);
      edit.add(paste);
      edit.add(delete);
      edit.add(find);
      edit.add(replace);
      edit.add(goto1);
      edit.add(selectall);


	  Menu format = new Menu("Format"); // Format Menu Bar

	  MenuItem font = new MenuItem("  Font      ");

	  format.add(font);

	  Menu encrypt = new Menu("Encrypt");

	  MenuItem Encrypt = new MenuItem("Encrypt");

	  encrypt.add(Encrypt);

	  Encrypt.addActionListener(this);

	  Menu decrypt = new Menu("Decrypt");

	  MenuItem Decrypt = new MenuItem("Decrypt");

	  decrypt.add(Decrypt);

	  Decrypt.addActionListener(this);

      Menu help = new Menu("Help");

      MenuItem about = new MenuItem("  About Notepad        ");

      help.add(about);

      menubar.add(file);      // adding file,edit,format,encrypt,decrypt and help menu to menubar
      menubar.add(edit);
      menubar.add(format);
      menubar.add(encrypt);
      menubar.add(decrypt);
      menubar.add(help);



      f1.setSize(600,600);
      f1.setVisible(true);


      f1.addWindowListener(new WindowAdapter()
        {

          public void windowClosing(WindowEvent event)

          {

            if(textfield.getText().equals(""))

            {

				System.exit(21);

			}

			else

			{

				f1.setVisible(false);

				new framedialog();



		    } // else body close

	     }

        });



  } // constructor closed


  		public void actionPerformed(ActionEvent e)// throws FileNotFoundException
  		 {

			   String msg="";

			   String str = e.getActionCommand();

  			   if(str.equals("   New                         Ctrl+N ")) // create a new document

  			   {

				 if(textfield.getText().equals(""))
				 {

					 textfield.setText("");

				 }

				 else
				 {
					 f1.setVisible(false);

					 frame = new Frame("Encrypted Notepad");

					 Button Save = new Button("Save");

					 Button Dontsave = new Button("Don't Save");

					 Button Cancel = new Button("Cancel");

					 frame.setLayout(null);

					 frame.setResizable(false);

					 Label label = new Label("Do you want to save Change.....");

					 frame.add(label);

					 frame.add(Save);

					 frame.add(Dontsave);

					 frame.add(Cancel);

					 Save.addActionListener(this);

					 Dontsave.addActionListener(this);

					 Cancel.addActionListener(this);

					 label.setFont(new Font("Monospaced",2,20));

					 label.setBounds(50,40,350,30);

					 frame.setBounds(300,300,450,150);

					 Save.setBounds(80,95,80,30);

					 Dontsave.setBounds(180,95,80,30);

					 Cancel.setBounds(280,95,80,30);

					 frame.setVisible(true);

					 frame.setSize(450,150);

					 frame.addWindowListener(new WindowAdapter()
					  {
					    public void windowClosing(WindowEvent event)
					      {
					        frame.setVisible(false);

					        f1.setVisible(true);
					 	  }
					  }
					  );

				 } // else body close



			   } // if body close

			   if(str.equals("Save"))  // saving the file from Menu New Option

			   {

				    FileDialog filedialog = new FileDialog(new Frame(),"Save",FileDialog.SAVE);

					filedialog.setVisible(true);

				    String str1 = filedialog.getDirectory();

		            String str2 = filedialog.getFile();

		            File file = new File(str1+str2);

		            try
		            {

				    	   FileWriter filewriter = new FileWriter(file);

                           filewriter.write(textfield.getText());

                           filewriter.close();

                           f1.setVisible(true);

					       frame.setVisible(false);

					       textfield.setText("");

				    }

				    catch(Exception event1)

				    {

						System.out.println(event1);

					}

			   }


			   if(str.equals("Don't Save"))

			   {

			   		f1.setVisible(true);

			   		frame.setVisible(false);

			   		textfield.setText("");

			   }


			   if(str.equals("Cancel"))

			   {

			   		frame.setVisible(false);

			   		f1.setVisible(true);

			   }


  			   if(str.equals("   Open                       Ctrl+O"))      //Open the file in reading mode
  			    {

  			   FileDialog filedialog = new FileDialog(new Frame(),"Open",FileDialog.LOAD);

  			   filedialog.setVisible(true);

			   String filepath = filedialog.getDirectory();

		       String filename = filedialog.getFile();

		       File file = new File(filepath+filename);

		       textfield.setText("");

		       try														// genrate a exception FileNotFound if file not found in Dir
		       {

		         FileReader reader = new FileReader(filepath+filename);

		         Scanner scan = new Scanner(new FileReader(filepath+filename));

		         while (scan.hasNext()) // while there's still something to read

                  textfield.append(scan.nextLine()+"\n");


		       }

		       catch(Exception event)
		       {

				   System.out.println(event);

			   }


		       }

		       if(str.equals("   Save                        Ctrl+S"))					// Open the file in Saving Mode for creating a new file
		        {


					FileDialog filedialog = new FileDialog(new Frame(),"Save",FileDialog.SAVE);

					filedialog.setVisible(true);

				    String str1 = filedialog.getDirectory();

		            String str2 = filedialog.getFile();

		            File file = new File(str1+str2);


		            try
		            {

				    	   FileWriter filewriter = new FileWriter(file);

                           filewriter.write(textfield.getText());

                           filewriter.close();

				    }

				    catch(Exception event1)

				    {

						System.out.println(event1);

					}


				}

				if(str.equals("   Exit"))        // Close The Note Pad

				{

					System.exit(15);

				}

				if(str.equals("Encrypt") && flag==0)        // Encryption Code
				{

					Temp=textfield.getText();

					count=Temp.length();

					int half=0;

					RevArr = new char[count];

					RevArr=Temp.toCharArray();

					for(int i=count-1;i>=0;i--)
					{

						msg=msg+RevArr[i];
						half++;

					}


					RevArr=msg.toCharArray();

					msg="";

					for(int j=(count-1)/2;j<count;j++)
					{

						msg=msg+RevArr[j];

					}

					for(int k=0;k<=(half-3)/2;k++)
					{

						msg=msg+RevArr[k];
					}

					RevArr=msg.toCharArray();

					msg="";

					for(int i=0;i<count;i++)
					{

						msg=msg+(char)(RevArr[i]+10);

					}


					msg=msg.toString();

					textfield.setText(msg);

					flag=1;

					msg="";


				}



				if(str.equals("Decrypt") && flag==1)     // Decryption code
				 {

					 Temp=textfield.getText();

					 count=Temp.length();

					 int half=0;

					 RevArr = new char[count];

					 RevArr=Temp.toCharArray();

					 for(int i=count-1;i>=0;i--)
					 	{

	 						msg=msg+RevArr[i];
	 						half++;

     					}


					RevArr=msg.toCharArray();

					msg="";

					for(int j=(count-1)/2;j<count;j++)
	 					{

	 						msg=msg+RevArr[j];

	 					}

					for(int k=0;k<=(half-3)/2;k++)
	 					{

	 						msg=msg+RevArr[k];
	 					}

	 			    RevArr=msg.toCharArray();

					msg="";

					for(int i=0;i<count;i++)
					{

						msg=msg+(char)(RevArr[i]-10);

					}


					msg=msg.toString();

	                textfield.setText(msg);

	                msg="";

	                flag=0;




				 }



		 } // actionPerformed Closeing


  public static void main(String s[])

    {

		EncryptedNotepad encryptednotedpadCons = new EncryptedNotepad(1);



    }// main class close

 } // Encrypted class close


 class framedialog extends Frame implements ActionListener

 		 {

			 EncryptedNotepad object = new EncryptedNotepad();

			 Frame frame1;


 		  framedialog()
 			 {

 				 frame1 = new Frame("Encrypted Notepad");

 				 Button Save = new Button("Save");

 				 Button Dontsave = new Button("Don't Save");

 				 Button Cancel = new Button("Cancel");

 				 frame1.setLayout(null);

 				 Label label = new Label("Do you want to save Change.....");

 				 frame1.add(label);

 				 frame1.add(Save);

 				 frame1.add(Dontsave);

 				 frame1.add(Cancel);

 				 Save.addActionListener(this);

 				 Dontsave.addActionListener(this);

 				 Cancel.addActionListener(this);

 				 label.setFont(new Font("Monospaced",2,20));

 				 label.setBounds(50,40,350,30);

 				 frame1.setBounds(300,300,450,150);

 				 Save.setBounds(80,95,80,30);

 				 Dontsave.setBounds(180,95,80,30);

 				 Cancel.setBounds(280,95,80,30);

 				 frame1.setVisible(true);

 				 frame1.setSize(450,150);
 			 }

 		public void actionPerformed(ActionEvent e)// throws FileNotFoundException
			{

			   String str = e.getActionCommand();


 			if(str.equals("Save"))  // saving the file from Menu New Option

			   {

				    FileDialog filedialog = new FileDialog(new Frame(),"Save",FileDialog.SAVE);

					filedialog.setVisible(true);

				    String str1 = filedialog.getDirectory();

		            String str2 = filedialog.getFile();

		            File file = new File(str1+str2);

		            try
		            {

				    	   FileWriter filewriter = new FileWriter(file);

                           filewriter.write(EncryptedNotepad.textfield.getText());

                           filewriter.close();

                           EncryptedNotepad.f1.setVisible(true);

					       frame1.setVisible(false);

					       EncryptedNotepad.textfield.setText("");

				    }

				    catch(Exception event1)

				    {

						System.out.println(event1);

					}

			   }


			   if(str.equals("Don't Save"))

			   {

			   		System.exit(2);
			   }


			   if(str.equals("Cancel"))

			   {

			   		frame1.setVisible(false);

			   		EncryptedNotepad.Encrypted(20,21);

			   }

		   }


 		 }
