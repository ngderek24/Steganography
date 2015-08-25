import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Steganography");
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(tabbedPane);
		
		JPanel encryptPanel = new JPanel();
		tabbedPane.addTab("Encrypt", null, encryptPanel, null);
		encryptPanel.setLayout(null);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblImage.setBounds(35, 30, 43, 21);
		encryptPanel.add(lblImage);
		
		JLabel lblInputText = new JLabel("Input Text");
		lblInputText.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblInputText.setBounds(35, 83, 71, 21);
		encryptPanel.add(lblInputText);
		
		JLabel lblOutputText = new JLabel("Output Text");
		lblOutputText.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblOutputText.setBounds(35, 138, 82, 21);
		encryptPanel.add(lblOutputText);
		
		JPanel decryptPanel = new JPanel();
		tabbedPane.addTab("Decrypt", null, decryptPanel, null);
		decryptPanel.setLayout(null);
	}
}
