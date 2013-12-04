package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import Model.SystemAscenseur;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JTextField;

public class Test {

	private JFrame frame;
	private SystemAscenseur system;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public Test(SystemAscenseur system) {
		initialize();
		this.system = system;
		TimerTask task = new TimerTask()
		{
			@Override
			public void run() 
			{
				afficheDemande();
				etageCourant();
				etageDestination();
			}	
		};
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, 100);
	}

	public void addEtage(float etage){
		this.system.addEtage(etage);
	}
	
	

	
	public void afficheDemande(){
			ArrayList tampon = this.system.getetage();
			String retour = "";
			for(int i = 0;i<tampon.size();i++){
				retour += tampon.get(i)+","; 	
			}
			this.textField.setText("Demande Etage : "+retour);
	}
	
	
	public void etageCourant(){
		this.textField_1.setText("Etage : "+this.system.getEtage_courant());
	}
	
	public void etageDestination(){
		this.textField_2.setText("Dest. : "+this.system.getEtageDestination());
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
					
		
		// ---------------------- 3 Rectangles de text : position ascenseur ----------------------
		
		textField = new JTextField();
		textField.setBounds(144, 11, 280, 53);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(144, 144, 86, 63);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(144, 75, 86, 58);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		frame.setVisible(true);
	}
}
