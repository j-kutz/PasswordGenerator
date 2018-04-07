import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PasswordGenerator extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordGenerator frame = new PasswordGenerator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PasswordGenerator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 423);
		setTitle("Password Generator");
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JSlider lengthSlider = new JSlider();
		lengthSlider.setValue(16);
		lengthSlider.setPaintLabels(true);
		lengthSlider.setMajorTickSpacing(2);
		lengthSlider.setMaximum(24);
		lengthSlider.setMinimum(8);
		lengthSlider.setSnapToTicks(true);
		lengthSlider.setPaintTicks(true);
		lengthSlider.setBounds(10, 336, 200, 37);
		getContentPane().add(lengthSlider);
		
		JSlider numOfSlider = new JSlider();
		numOfSlider.setPaintLabels(true);
		numOfSlider.setMajorTickSpacing(10);
		numOfSlider.setSnapToTicks(true);
		numOfSlider.setPaintTicks(true);
		numOfSlider.setBounds(10, 298, 200, 36);
		getContentPane().add(numOfSlider);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 418, 276);
		getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JLabel lblOfPasswords = new JLabel("# of passwords");
		lblOfPasswords.setBorder(null);
		lblOfPasswords.setBounds(212, 311, 89, 14);
		getContentPane().add(lblOfPasswords);
		
		JLabel lblNewLabel = new JLabel("     length");
		lblNewLabel.setBounds(212, 347, 69, 14);
		getContentPane().add(lblNewLabel);
		
		JButton generateButton = new JButton("GENERATE ");
		generateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				for(int i=0; i<numOfSlider.getValue(); i++) {
					textArea.append(genPassword(lengthSlider.getValue()) + "\n");
				}
			}
		});
		generateButton.setBounds(311, 336, 117, 37);
		getContentPane().add(generateButton);
		
		JButton resetButton = new JButton("RESET");
		resetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
			}
		});
		resetButton.setBounds(311, 298, 117, 31);
		getContentPane().add(resetButton);
	}
	
	public String genPassword(int length) {
		Random rand = new Random();
		String password="";
		char c;
		
		for(int i=0; i<length; i++) {
			c = (char) (rand.nextInt(89)+33);
			password += c;
		}
		
		return password;
	}
}