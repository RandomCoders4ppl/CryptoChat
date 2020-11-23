/**
 * 
 */
package Server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.image.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
/**
 *  @author M.NAVEEN
 *  RANDOM CODER'S
 *  Tech/Project Lead Android Club
 */
public class Guiserver implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	static JTextArea textArea;
	static ServerSocket user_server;
    static Socket s;
	static DataInputStream in;
	static DataOutputStream out;
	static int flag=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guiserver window = new Guiserver();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//sockets
		connect();
	}
    public static void connect()
    { 
    	String outputdata;
	      try {
	    	  user_server=new ServerSocket(6001);
	    	  s=user_server.accept();
	    	  in=new DataInputStream(s.getInputStream());
	    	  out=new DataOutputStream(s.getOutputStream());
	    	  while(flag!=-1)
	    	  {  outputdata=in.readUTF();
	    	  textArea.setText(textArea.getText()+"\n"+outputdata);
	    	  
	    	  }
	    	  s.close();
	    	  user_server.close();
	      }
	      catch(Exception e)
	      {
	    	System.out.println( e.getClass().getName());
	      }
    	
    }
	/**
	 * Create the application.
	 */
	public Guiserver() {
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
		Top_panel.setBackground(new Color(255, 99, 71));
		Top_panel.setBounds(0, 0, 486, 50);
		frame.getContentPane().add(Top_panel);
		Top_panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(76, 0, 70, 50);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("male.png")).getImage().getScaledInstance(70, 50, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(imageIcon);
		//lblNewLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("male.png")).getImage().getScaledInstance());
		Top_panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 66, 50);
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("back-arrow.png")).getImage().getScaledInstance(66, 50, Image.SCALE_DEFAULT));
		lblNewLabel_1.setIcon(imageIcon2);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{    flag=-1;
				System.exit(0);
			}
		});
		Top_panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NAVEEN");
		lblNewLabel_2.setForeground(new Color(255, 250, 250));
		lblNewLabel_2.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblNewLabel_2.setBounds(169, 8, 82, 40);
		Top_panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Active");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(261, 3, 77, 40);
		Top_panel.add(lblNewLabel_3);
	
		JPanel Bottom_panel = new JPanel();
		Bottom_panel.setBackground(new Color(255, 99, 71));
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
			} catch (IOException e) {
				e.printStackTrace();
			}
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
}

