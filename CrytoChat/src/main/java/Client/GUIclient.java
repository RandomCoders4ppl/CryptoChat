/**
 * 
 */
package Client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
///
//import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.UIManager;

/**
 *  @author M.NAVEEN
 *  RANDOM CODER'S
 *  Tech/Project Lead Android Club
 */
public class GUIclient {
	private JFrame frame;
	private JTextField textField;
	static JTextArea textArea;
  //  static ServerSocket user_server;
    static Socket s;
	static DataInputStream in;
	static DataOutputStream out;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIclient window = new GUIclient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		connect();
	}
   public static  void connect()
   {  
    String inputdata;
	      try {
	    	  s=new Socket("127.0.0.1",6001);
	    	  in=new DataInputStream(s.getInputStream());
	    	  out=new DataOutputStream(s.getOutputStream());
	    	  while(true)
	    	  {  inputdata=in.readUTF();
	    	  textArea.setText(textArea.getText()+"\n"+inputdata);
	    	  }
	      }
	      catch(Exception e)
	      {
	    	System.out.println( e.getClass().getName());
	      }
   
   }
	/**
	 * Create the application.
	 */
	public GUIclient() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel Top_panel = new JPanel();
		Top_panel.setBackground(new Color(255, 0, 0));
		Top_panel.setBounds(0, 0, 486, 50);
		frame.getContentPane().add(Top_panel);
		Top_panel.setLayout(null);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("male.png")).getImage().getScaledInstance(70, 50, Image.SCALE_DEFAULT));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 66, 50);
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("back-arrow.png")).getImage().getScaledInstance(66, 50, Image.SCALE_DEFAULT));
		lblNewLabel_1.setIcon(imageIcon2);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		Top_panel.add(lblNewLabel_1);
		
		JLabel User = new JLabel("User");
		User.setForeground(new Color(255, 250, 250));
		User.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		User.setBounds(198, 4, 82, 40);
		Top_panel.add(User);
		
		JLabel lblNewLabel_3 = new JLabel("Active");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(403, 10, 77, 40);
		Top_panel.add(lblNewLabel_3);
	
		JPanel Bottom_panel = new JPanel();
		Bottom_panel.setBackground(new Color(255, 0, 0));
		Bottom_panel.setBounds(0, 459, 486, 50);
		frame.getContentPane().add(Bottom_panel);
		Bottom_panel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 16));
		textField.setBounds(10, 10, 343, 30);
		Bottom_panel.add(textField);
		textField.setColumns(10);
		
		
		
		
		JPanel Center_panel = new JPanel();
		Center_panel.setBackground(new Color(255, 255, 255));
		Center_panel.setBounds(0, 51,486, 408);
		frame.getContentPane().add(Center_panel);
		Center_panel.setLayout(null);
		
		textArea = new JTextArea();
		
		textArea.setForeground(new Color(255, 0, 255));
		textArea.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
		textArea.setBounds(10, 10, 466, 388);
		//to prevent it from editing
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		//textArea.setText(" ");
		Center_panel.add(textArea);
		//frame.setUndecorated(true);
		
		JButton btnNewButton = new JButton("SEND");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{textArea.setText(textArea.getText()+"\n\t\t\t"+textField.getText());
			  try {
				out.writeUTF(textField.getText());
			} catch (IOException e) {System.out.println(e.getClass().getName());}
			textField.setText(null);
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 139, 139));
		btnNewButton.setFont(new Font("Segoe UI Black", Font.ITALIC, 16));
		btnNewButton.setBounds(374, 10, 85, 28);
		Bottom_panel.add(btnNewButton);
		
			
	}

	public void actionPerformed(ActionEvent arg0)
	{
		//textArea.setText(textArea.getName()+"\n"+textField.getText());
		
	}

	public JTextArea getTextArea() {
		return textArea;
	}
}

