package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import modele.SystemAscenseur;

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
	
	
	public void addUp(float etage){
		this.system.addMonter(etage);
	}
	
	public void addDown(float etage){
		this.system.addDescendre(etage);
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
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 124, 278);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton_1 = new JButton("Etage 5");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEtage(5);
			}
		});
		btnNewButton_1.setBounds(10, 11, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnEtage_4 = new JButton("Etage 4");
		btnEtage_4.setBounds(10, 55, 89, 23);
		btnEtage_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEtage(4);
			}
		});
		panel.add(btnEtage_4);
		
		JButton btnEtage_3 = new JButton("Etage 3");
		btnEtage_3.setBounds(10, 100, 89, 23);
		btnEtage_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEtage(3);
			}
		});
		panel.add(btnEtage_3);
		
		JButton btnEtage_2 = new JButton("Etage 2");
		btnEtage_2.setBounds(10, 146, 89, 23);
		btnEtage_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEtage(2);
			}
		});
		panel.add(btnEtage_2);
		
		JButton btnEtage_1 = new JButton("Etage 1");
		btnEtage_1.setBounds(10, 193, 89, 23);
		btnEtage_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEtage(1);
			}
		});
		panel.add(btnEtage_1);
		
		JButton btnEtage = new JButton("Etage 0");
		btnEtage.setBounds(10, 244, 89, 23);
		btnEtage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEtage(0);
			}
		});
		panel.add(btnEtage);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(251, 11, 173, 278);
		panel_1.setLayout(null);
		frame.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("up 0");
		btnNewButton_2.setBounds(10, 244, 76, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addUp(0);
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnDown = new JButton("down 1");
		btnDown.setBounds(10, 210, 76, 23);
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addDown(1);
			}
		});
		panel_1.add(btnDown);
		
		JButton btnUp = new JButton("up 1");
		btnUp.setBounds(10, 176, 76, 23);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addUp(1);
			}
		});
		panel_1.add(btnUp);
		
		JButton btnDown_2 = new JButton("down 2");
		btnDown_2.setBounds(96, 210, 67, 23);
		btnDown_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addDown(2);
			}
		});
		panel_1.add(btnDown_2);
		
		JButton btnUp_1 = new JButton("up 2");
		btnUp_1.setBounds(96, 176, 67, 23);
		btnUp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addUp(2);
			}
		});
		panel_1.add(btnUp_1);
		
		JButton btnDown_1 = new JButton("down 3");
		btnDown_1.setBounds(10, 125, 76, 23);
		btnDown_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addDown(3);
			}
		});
		panel_1.add(btnDown_1);
		
		JButton btnUp_2 = new JButton("up 3");
		btnUp_2.setBounds(10, 91, 76, 23);
		btnUp_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addUp(3);
			}
		});
		panel_1.add(btnUp_2);
		
		JButton btnDown_3 = new JButton("down 4");
		btnDown_3.setBounds(96, 125, 67, 23);
		btnDown_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addDown(4);
			}
		});
		panel_1.add(btnDown_3);
		
		JButton btnUp_3 = new JButton("up 4 ");
		btnUp_3.setBounds(96, 91, 67, 23);
		btnUp_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addUp(4);
			}
		});
		panel_1.add(btnUp_3);
		
		JButton btnDown_4 = new JButton("down 5");
		btnDown_4.setBounds(10, 57, 76, 23);
		btnDown_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addDown(5);
			}
		});
		panel_1.add(btnDown_4);
		
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
