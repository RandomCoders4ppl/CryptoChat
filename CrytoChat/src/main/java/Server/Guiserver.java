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
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.image.*;
/**
 *  @author M.NAVEEN
 *  RANDOM CODER'S
 *  Tech/Project Lead Android Club
 */
public class Guiserver {

	private JFrame frame;

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
		
		JPanel Bottom_panel = new JPanel();
		Bottom_panel.setBackground(new Color(255, 99, 71));
		Bottom_panel.setBounds(0, 459, 486, 50);
		frame.getContentPane().add(Bottom_panel);
		Bottom_panel.setLayout(null);
		
		JPanel Center_panel = new JPanel();
		Center_panel.setBackground(new Color(255, 255, 255));
		Center_panel.setBounds(0, 51,486, 408);
		frame.getContentPane().add(Center_panel);
	}
}

