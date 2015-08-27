import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private JTextField imageField;
	private JTextField inputField;
	private JTextField outputField;
	private String imgPath;
	private String imgName;
	private String inputPath;
	private String inputName;

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
		
		JLabel lblImage = new JLabel("Image (.png)");
		lblImage.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblImage.setBounds(10, 30, 87, 21);
		encryptPanel.add(lblImage);
		
		JLabel lblInput = new JLabel("Input (.txt)");
		lblInput.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblInput.setBounds(10, 84, 75, 21);
		encryptPanel.add(lblInput);
		
		JLabel lblOutput = new JLabel("Output (.png)");
		lblOutput.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblOutput.setBounds(10, 140, 87, 21);
		encryptPanel.add(lblOutput);
		
		imageField = new JTextField();
		imageField.setBounds(95, 31, 200, 20);
		encryptPanel.add(imageField);
		imageField.setColumns(10);
		
		inputField = new JTextField();
		inputField.setBounds(95, 85, 200, 20);
		encryptPanel.add(inputField);
		inputField.setColumns(10);
		
		outputField = new JTextField();
		outputField.setBounds(95, 141, 200, 20);
		encryptPanel.add(outputField);
		outputField.setColumns(10);
		
		JButton imgBtn = new JButton("Browse");
		imgBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File file = chooser.getSelectedFile();
				imgPath = file.getAbsolutePath();
				imgName = file.getName();
				imageField.setText(imgName);
			}
		});
		imgBtn.setBounds(312, 30, 87, 23);
		encryptPanel.add(imgBtn);
		
		JButton inputBtn = new JButton("Browse");
		inputBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File file = chooser.getSelectedFile();
				inputPath = file.getAbsolutePath();
				inputName = file.getName();
				inputField.setText(inputName);
			}
		});
		inputBtn.setBounds(312, 84, 87, 23);
		encryptPanel.add(inputBtn);
		
		JButton btnEncode = new JButton("Encode");
		btnEncode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Encode.encode(imgPath, inputPath);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEncode.setBounds(206, 172, 89, 23);
		encryptPanel.add(btnEncode);
		
		JPanel decryptPanel = new JPanel();
		tabbedPane.addTab("Decrypt", null, decryptPanel, null);
		decryptPanel.setLayout(null);
	}
}
