import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WordGUI extends JFrame {
	
	JTextArea masterArea;
	JTextArea validArea;
	JTextArea invalidArea;
	
	public WordGUI() {
		this.setSize(500, 500);
		this.setTitle("Project 1");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new GridLayout(1,3));
		
		masterArea = new JTextArea();
		validArea = new JTextArea();
		invalidArea = new JTextArea();
		
		JScrollPane scrollPane1 = new JScrollPane();
		JScrollPane scrollPane2 = new JScrollPane();
		JScrollPane scrollPane3 = new JScrollPane();
		
		scrollPane1.setViewportView(masterArea);
		scrollPane2.setViewportView(validArea);
		scrollPane3.setViewportView(invalidArea);
		
		this.add(scrollPane1);
		this.add(scrollPane2);
		this.add(scrollPane3);
		
		this.setVisible(true);
	}
	
	public void addtoMasterArea(String str) {
		masterArea.append(str);
	}
	public void addtoValidArea(String str) {
		validArea.append(str);
	}
	public void addtoInvalidArea(String str) {
		invalidArea.append(str);
	}
		
}
