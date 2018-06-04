import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


//import ProjektiKNK.frmLoginProjekt;

//import ProjektiKNK.frmLoginProjekt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Component;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;

public class PlayFair extends JFrame {
	String filename;
	private JPanel contentPane;
	private JTextField txtKeyword;
	private String keyType="Only alphabet (5x5)";
	private int matrica=5;

	/**
	 * Create the frame.
	 */
	public PlayFair() {
		setTitle("PlayFair Algorithm");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PlayFair.class.getResource("/images/imgpass (1).png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1103, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 200, 420, 150);
		contentPane.add(scrollPane);
		

		
		JTextArea txtPlaintext = new JTextArea();
		scrollPane.setViewportView(txtPlaintext);
		txtPlaintext.setLineWrap(true);
		txtPlaintext.setWrapStyleWord(true);
		txtPlaintext.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(656, 200, 420, 150);
		contentPane.add(scrollPane_1);
		
		JTextArea txtCiphertext = new JTextArea();
		scrollPane_1.setViewportView(txtCiphertext);
		txtCiphertext.setLineWrap(true);
		txtCiphertext.setWrapStyleWord(true);
		txtCiphertext.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
		
		JTextArea txtFileChoosedCipher = new JTextArea();
		txtFileChoosedCipher.setEditable(false);
		txtFileChoosedCipher.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
		txtFileChoosedCipher.setBounds(767, 443, 309, 22);
		contentPane.add(txtFileChoosedCipher);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener()  {
			public void itemStateChanged(ItemEvent arg0) {
				keyType=String.valueOf(comboBox.getSelectedItem());
				if(keyType=="Only alphabet (5x5)")matrica=5;
				else matrica=8;
			}
		});
		comboBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 14));
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(Color.BLACK);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Only alphabet (5x5)", "Alphabet, numbers and special chars (8x8)"}));
		comboBox.setBounds(348, 120, 362, 27);
		contentPane.add(comboBox);
		
		JButton btnChooseFileCypher = new JButton("Choose File");
		btnChooseFileCypher.setFocusPainted(false);
		btnChooseFileCypher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JFileChooser chooser=new JFileChooser();
					FileFilter filter = new FileNameExtensionFilter("Text file","txt");
					chooser.setAcceptAllFileFilterUsed(false);
					chooser.setFileFilter(filter);
					chooser.setDialogTitle("Open CypherText File");
					chooser.showOpenDialog(null);
					File f=chooser.getSelectedFile();
					filename=f.getAbsolutePath();
					txtFileChoosedCipher.setText(filename);
					txtCiphertext.setText(readFile(new File(filename)));
				} catch (Exception e) {
				}				
			}
		});
		
		JLabel lblPlayFair = new JLabel("PlayFair Algorithm");
		lblPlayFair.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblPlayFair.setForeground(Color.ORANGE);
		lblPlayFair.setBounds(436, 11, 219, 27);
		contentPane.add(lblPlayFair);
		
		JTextArea txtFileChoosedPlain = new JTextArea();
		txtFileChoosedPlain.setEditable(false);
		txtFileChoosedPlain.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
		txtFileChoosedPlain.setBounds(121, 443, 309, 22);
		contentPane.add(txtFileChoosedPlain);
		
		btnChooseFileCypher.setForeground(Color.WHITE);
		btnChooseFileCypher.setFont(new Font("Verdana", Font.BOLD, 13));
		btnChooseFileCypher.setBackground(new Color(0, 191, 255));
		btnChooseFileCypher.setBounds(803, 380, 127, 39);
		contentPane.add(btnChooseFileCypher);
		
		JLabel lblPlainText = new JLabel("Plaintext:");
		lblPlainText.setForeground(Color.WHITE);
		lblPlainText.setBounds(184, 162, 73, 27);
		contentPane.add(lblPlainText);
		lblPlainText.setBackground(Color.CYAN);
		lblPlainText.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JButton btnEncrypt = new JButton("Encrypt ->");
		btnEncrypt.setFocusPainted(false);
		btnEncrypt.setForeground(Color.WHITE);
		btnEncrypt.setBounds(472, 214, 151, 39);
		contentPane.add(btnEncrypt);
		btnEncrypt.setBackground(new Color(0, 191, 255));
		btnEncrypt.addActionListener(new ActionListener() {
			//Encrypt Buttoni
			public void actionPerformed(ActionEvent e) {
				txtCiphertext.setText(Encrypt(keyGenerator(), txtPlaintext.getText()));	
			}
		});
		btnEncrypt.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JButton btnDecrypt = new JButton("<- Decrypt");
		btnDecrypt.setFocusPainted(false);
		btnDecrypt.setForeground(Color.WHITE);
		btnDecrypt.setBounds(472, 281, 151, 39);
		contentPane.add(btnDecrypt);
		btnDecrypt.setBackground(new Color(0, 191, 255));
		btnDecrypt.addActionListener(new ActionListener() {
			//Decrypt Butoni
			public void actionPerformed(ActionEvent e) {
				txtPlaintext.setText(Decrypt(keyGenerator(), txtCiphertext.getText()));			
			}
		});
		btnDecrypt.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JLabel lblCiphertext = new JLabel("Ciphertext:");
		lblCiphertext.setForeground(Color.WHITE);
		lblCiphertext.setBounds(824, 162, 85, 27);
		contentPane.add(lblCiphertext);
		lblCiphertext.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JButton btnGenerateKey = new JButton("Generate Key");
		btnGenerateKey.setFocusPainted(false);
		btnGenerateKey.setForeground(Color.WHITE);
		btnGenerateKey.setBounds(710, 64, 165, 39);
		contentPane.add(btnGenerateKey);
		btnGenerateKey.setBackground(new Color(0, 191, 255));
		btnGenerateKey.addActionListener(new ActionListener() {
			//GenerateKey Buttoni
			public void actionPerformed(ActionEvent e) {
				txtKeyword.setText(keywordGenerator());					
			}
		});
		btnGenerateKey.setFont(new Font("Verdana", Font.BOLD, 13));
		
		JButton btnChooseFilePlain = new JButton("Choose File");
		btnChooseFilePlain.setFocusPainted(false);
		btnChooseFilePlain.setBounds(157, 380, 127, 39);
		contentPane.add(btnChooseFilePlain);
		btnChooseFilePlain.setBackground(new Color(0, 191, 255));
		btnChooseFilePlain.setForeground(Color.WHITE);
		btnChooseFilePlain.addActionListener(new ActionListener() {
			//ChoseFile Button
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser chooser=new JFileChooser();
					FileFilter filter = new FileNameExtensionFilter("Text file","txt");
					chooser.setAcceptAllFileFilterUsed(false);
					chooser.setFileFilter(filter);
					chooser.setDialogTitle("Open PlainText File");				
					chooser.showOpenDialog(null);
					File f=chooser.getSelectedFile();
					filename=f.getAbsolutePath();
					txtFileChoosedPlain.setText(filename);
					txtPlaintext.setText(readFile(new File(filename)));
				} catch (Exception e1) {
				}
			}
		});
		btnChooseFilePlain.setFont(new Font("Verdana", Font.BOLD, 13));
		
		txtKeyword = new JTextField();
		txtKeyword.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
		txtKeyword.setBounds(348, 72, 309, 27);
		txtKeyword.setColumns(10);
		contentPane.add(txtKeyword);
		
		JLabel lblSelectedFile = new JLabel("Selected File:");
		lblSelectedFile.setForeground(Color.WHITE);
		lblSelectedFile.setBounds(656, 447, 101, 13);
		contentPane.add(lblSelectedFile);
		lblSelectedFile.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("or");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(857, 362, 18, 13);
		contentPane.add(label_2);
		label_2.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("or");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(211, 362, 18, 13);
		contentPane.add(label_1);
		label_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JLabel lblFileChoosed = new JLabel("Selected File:");
		lblFileChoosed.setForeground(Color.WHITE);
		lblFileChoosed.setBounds(10, 447, 101, 13);
		contentPane.add(lblFileChoosed);
		lblFileChoosed.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JLabel label = new JLabel("or");
		label.setForeground(Color.WHITE);
		label.setBounds(667, 83, 18, 13);
		contentPane.add(label);
		label.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JLabel lblKeyword = new JLabel("Keyword:");
		lblKeyword.setForeground(Color.WHITE);
		lblKeyword.setBounds(265, 70, 73, 27);
		contentPane.add(lblKeyword);
		lblKeyword.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		
		
		JButton btnSave = new JButton("Save Cipher");
		btnSave.setFocusPainted(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JFileChooser chooser=new JFileChooser();
					FileFilter filter = new FileNameExtensionFilter("Text file", "txt");
					chooser.setDialogTitle("Save CipherText");
					chooser.addChoosableFileFilter(filter);
					chooser.setAcceptAllFileFilterUsed(false);
					chooser.setSelectedFile(new File("crypto.txt"));
					chooser.showSaveDialog(null);
					File f=chooser.getSelectedFile();
					filename=f.getAbsolutePath();
					if(!filename.matches(".+[.]txt$")) {
						f=new File(filename+".txt");
					}
					writeFile(f, txtCiphertext.getText());
				} catch (Exception e) {
				}
			}
		});
		
		JLabel lblKeyType = new JLabel("Key Type:");
		lblKeyType.setForeground(Color.WHITE);
		lblKeyType.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblKeyType.setBounds(265, 120, 73, 27);
		contentPane.add(lblKeyType);
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Verdana", Font.BOLD, 13));
		btnSave.setBackground(new Color(0, 191, 255));
		btnSave.setBounds(472, 358, 151, 39);
		contentPane.add(btnSave);
		
		JButton btnClear = new JButton("Clear Fields");
		btnClear.setFocusPainted(false);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPlaintext.setText("");
				txtCiphertext.setText("");
				txtFileChoosedCipher.setText("");
				txtFileChoosedPlain.setText("");
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Verdana", Font.BOLD, 13));
		btnClear.setBackground(new Color(0, 191, 255));
		btnClear.setBounds(472, 408, 151, 39);
		contentPane.add(btnClear);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblBackground.setIcon(new ImageIcon(PlayFair.class.getResource("/images/background.PNG")));
		lblBackground.setBounds(0, 0, 1093, 533);
		contentPane.add(lblBackground);
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (InstantiationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IllegalAccessException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (UnsupportedLookAndFeelException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
	}
		//Metoda per gjenerimin e celesit
		private char[][] keyGenerator() {
			String keyword=txtKeyword.getText();
			keyword=keyword.toUpperCase();
			int kFillo, kMbaro;
			if(this.keyType=="Only alphabet (5x5)") {
				kFillo=65;
				kMbaro=91;
			}
			else {
				kFillo=33;
				kMbaro=97;
			}			
			String shkronjat="";
			for(int k=kFillo; k<kMbaro;k++) {
				if(k==74 && this.matrica==8) {
					k=123;
					if(keyword.indexOf((char)k)==-1)
						shkronjat+=(char)k;
					k=74; continue;
				}
				if(k==74 && this.matrica==5) {
					continue;
				}
				if(keyword.indexOf((char)k)==-1)
				shkronjat+=(char)k;
			}
			String order=keyword+shkronjat;
			char key[][]=new char[this.matrica][this.matrica];
			int k=0;
			for (int i = 0; i < this.matrica; i++) {				
				for(int j=0; j<this.matrica; j++) {
					key[i][j]=order.charAt(j+k);
				}
				k+=this.matrica;
			}
			
			return key;
		}
		
		//Metoda per enkriptim
		private String Encrypt(char[][] key, String plaintext) {
			plaintext=plaintext.toUpperCase();
			plaintext=plaintext.replaceAll(" ", "");
			plaintext=plaintext.replaceAll("J", "I");
			StringBuilder sb=new StringBuilder();
			sb.append(plaintext);
			for (int i = 0; i < plaintext.length(); i++) {				
				if((i+1)<sb.length()){
					if(sb.charAt(i)==sb.charAt(i+1)) {
						sb.insert(i+1, 'X');
					}
				}
			}
			if (sb.length()%2!=0) {
				sb.append('X');
			}
			
			for(int i=0; i<sb.length()-1; i+=2) {
				char letter1 = sb.charAt(i);
				char letter2 = sb.charAt(i+1);
				int letter1row = 0, letter1column = 0;
				int letter2row = 0, letter2column = 0;
				boolean stopFlag = false;
				
				for (int r = 0; r < matrica; r++){
					for (int c = 0; c < matrica; c++){
						if (letter1 == key[r][c]){
							letter1row = r;
							letter1column = c;
							stopFlag = true;
							break;
						}
					}
					if (stopFlag) break;
				}
				
				stopFlag = false;
				for (int r = 0; r < matrica; r++){
					for (int c = 0; c < matrica; c++){
						if (letter2 == key[r][c]){
							letter2row = r;
							letter2column = c;
							stopFlag = true;
							break;
						}
					}
					if (stopFlag) break;
				}
				char letter1n, letter2n;
				if (letter1row == letter2row){
					letter1n = key[letter1row][(letter1column + 1) % matrica];
					letter2n = key[letter2row][(letter2column + 1) % matrica];
				}
				else if (letter1column == letter2column){
					letter1n = key[(letter1row + 1) % matrica][letter1column];
					letter2n = key[(letter2row + 1) % matrica][letter2column];
				}
				else{
					letter1n = key[letter1row][letter2column];
					letter2n = key[letter2row][letter1column];
				}
				sb.setCharAt(i, letter1n);
				sb.setCharAt(i+1, letter2n);
			}
			return sb.toString();
		}
		
		//Metoda per Dekriptim
		private String Decrypt(char[][] key, String ciphertext) {
			ciphertext=ciphertext.toUpperCase();
			StringBuilder sb=new StringBuilder();
			sb.append(ciphertext);
			
			for(int i=0; i<sb.length(); i+=2) {
				char letter1 = sb.charAt(i);
				char letter2 = sb.charAt(i+1);
				int letter1row = 0, letter1column = 0;
				int letter2row = 0, letter2column = 0;
				boolean stopFlag = false;
				
				for (int r = 0; r < matrica; r++){
					for (int c = 0; c < matrica; c++){
						if (letter1 == key[r][c]){
							letter1row = r;
							letter1column = c;
							stopFlag = true;
							break;
						}
					}
					if (stopFlag) break;
				}
				
				stopFlag = false;
				for (int r = 0; r < matrica; r++){
					for (int c = 0; c < matrica; c++){
						if (letter2 == key[r][c]){
							letter2row = r;
							letter2column = c;
							stopFlag = true;
							break;
						}
					}
					if (stopFlag) break;
				}
				char letter1n, letter2n;
				if (letter1row == letter2row){
					letter1n = key[letter1row][(letter1column - 1+matrica) % matrica];
					letter2n = key[letter2row][(letter2column - 1+matrica) % matrica];
				}
				else if (letter1column == letter2column){
					letter1n = key[(letter1row - 1+matrica) % matrica][letter1column];
					letter2n = key[(letter2row - 1+matrica) % matrica][letter2column];
				}
				else{
					letter1n = key[letter1row][letter2column];
					letter2n = key[letter2row][letter1column];
				}
				sb.setCharAt(i, letter1n);
				sb.setCharAt(i+1, letter2n);
			}
			return sb.toString();
		}
		
		//Metoda per lexim nga fajlli
		public String readFile(File f) {		
			Scanner input;
			try {
				input = new Scanner(f);
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Ky fajll nuk ekziston","Gabim",JOptionPane.ERROR_MESSAGE);	
				return "";
			}
			StringBuilder sb=new StringBuilder();
			while(input.hasNextLine()) {
				sb.append(input.nextLine());
			}
			input.close();
			return sb.toString();
		}
		
		//Metoda per shkrim ne fajll
		public void writeFile(File f, String textToWrite) {
			try {
			PrintWriter pw=new PrintWriter(f);
			pw.print(textToWrite);
			pw.close();
			}
			catch(FileNotFoundException e){
				JOptionPane.showMessageDialog(null, "Nuk mund te krijohet ky fajll","Gabim",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		//Metoda per gjenerimin e keywordit
		private String keywordGenerator() {
			Random randNumber=new Random();
			Random randLength=new Random();
			StringBuilder sb=new StringBuilder();
			int nrCharacters=randLength.nextInt(25);
			while(nrCharacters<5) {
				nrCharacters=randLength.nextInt(25);
			}
			for (int i = 0; i <= nrCharacters; i++) {
				int nrRandom=randNumber.nextInt(26)+65;
				if(nrRandom==74) {
					nrRandom=73;
				}
				if(sb.indexOf(String.valueOf((char)nrRandom))!=-1) {
					continue;
				}
				else {
					sb.append((char)nrRandom);
				}			
			}
			return sb.toString();		
		}
}