import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class frmMain extends JFrame {
		
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public frmMain() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmMain.class.getResource("/images/imgpass (1).png")));
		setResizable(false);
		setTitle("PlayFair Algorithm");
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Verdana", Font.PLAIN, 16));
		panel.setBackground(new Color(176, 224, 230));
		panel.setBorder(new TitledBorder(UIManager.getBorder("ToolBar.border"), "About PlayFair", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(562, 74, 220, 273);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea txtrPlayfairEshteNje = new JTextArea();
		txtrPlayfairEshteNje.setLineWrap(true);
		txtrPlayfairEshteNje.setRows(20);
		txtrPlayfairEshteNje.setWrapStyleWord(true);
		txtrPlayfairEshteNje.setEditable(false);
		txtrPlayfairEshteNje.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtrPlayfairEshteNje.setText("The Playfair cipher or Playfair square or Wheatstone-Playfair cipher is a manual symmetric encryption technique and was the first literal digram substitution cipher. The scheme was invented in 1854 by Charles Wheatstone, but bears the name of Lord Playfair for promoting its use. The Playfair is harder to break since the frequency analysis used for simple substitution ciphers does not work with it.");
		txtrPlayfairEshteNje.setBounds(10, 22, 200, 240);
		panel.add(txtrPlayfairEshteNje);
		
		JLabel lblPlayfair = new JLabel("PlayFair ");
		lblPlayfair.setForeground(new Color(0, 0, 0));
		lblPlayfair.setBackground(new Color(0, 255, 255));
		lblPlayfair.setFont(new Font("Cambria", Font.BOLD, 30));
		lblPlayfair.setBounds(323, 56, 133, 72);
		contentPane.add(lblPlayfair);
		
		JButton btnEncryptDecrypt = new JButton("Encrypt / Decrypt");
		btnEncryptDecrypt.setForeground(Color.WHITE);
		btnEncryptDecrypt.setBackground(new Color(0, 153, 204));
		btnEncryptDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayFair objPlayFair=new PlayFair();
				objPlayFair.setVisible(true);
				objPlayFair.setLocationRelativeTo(null);
				//objPlayFair.setAlwaysOnTop(true);
				dispose();
			}
		});
		btnEncryptDecrypt.setFont(new Font("Verdana", Font.BOLD, 22));
		btnEncryptDecrypt.setBounds(240, 164, 280, 60);
		contentPane.add(btnEncryptDecrypt);
		
		JLabel lblMain = new JLabel("Main");
		lblMain.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblMain.setBounds(0, 0, 792, 400);
		contentPane.add(lblMain);
		lblMain.setBackground(SystemColor.activeCaption);
		lblMain.setIcon(new ImageIcon(frmMain.class.getResource("images/background1 (1).jpeg")));
	}
}
