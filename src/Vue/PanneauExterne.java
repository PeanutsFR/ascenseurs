package Vue;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.SystemAscenseur;

// Panneau externe de l'ascenseur (les boutons qu'il y a dehors, pour appeler l'ascenseur)

public class PanneauExterne {
	
	private JFrame frame;
	private SystemAscenseur system;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public PanneauExterne(SystemAscenseur system) {
		initialize();
		this.system = system;
		
	}
	
	public void addUp(float etage){
		this.system.addMonter(etage);
	}
	
	public void addDown(float etage){
		this.system.addDescendre(etage);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
	
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(6,3));
		//frame.setBounds(400, 450, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(null);
		
		Icon haut = new ImageIcon("Ressources/fleche_haut.gif");
		Icon bas = new ImageIcon("Ressources/fleche_bas.gif");
		
		JButton etage0 = new JButton("Etage 0");
		etage0.setEnabled(false);
		JButton etage1 = new JButton("Etage 1");
		etage1.setEnabled(false);
		JButton etage2 = new JButton("Etage 2");
		etage2.setEnabled(false);
		JButton etage3 = new JButton("Etage 3");
		etage3.setEnabled(false);
		JButton etage4 = new JButton("Etage 4");
		etage4.setEnabled(false);
		JButton etage5 = new JButton("Etage 5");
		etage5.setEnabled(false);
		JButton vide1 = new JButton("");
		vide1.setEnabled(false);
		JButton vide2 = new JButton("");
		vide2.setEnabled(false);
		
		JButton btnUpEtage0 = new JButton("");
		btnUpEtage0.setIcon(haut);
		//btnNewButton_2.setBounds(10, 244, 76, 23);
		btnUpEtage0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addUp(0);
			}
		});
		
		
		JButton btnDownEtage1 = new JButton("");
		btnDownEtage1.setIcon(bas);
		//btnDown.setBounds(10, 210, 76, 23);
		btnDownEtage1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addDown(1);
			}
		});
		
		
		JButton btnUpEtage1 = new JButton("");
		//btnUp.setBounds(10, 176, 76, 23);
		btnUpEtage1.setIcon(haut);
		btnUpEtage1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addUp(1);
			}
		});
	
		
		JButton btnDownEtage2 = new JButton("");
		btnDownEtage2.setIcon(bas);
		//btnDown_2.setBounds(96, 210, 67, 23);
		btnDownEtage2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addDown(2);
			}
		});
	
		
		JButton btnUpEtage2 = new JButton("");
		btnUpEtage2.setIcon(haut);
		//btnUp_1.setBounds(96, 176, 67, 23);
		btnUpEtage2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addUp(2);
			}
		});
	
		
		JButton btnDownEtage3 = new JButton("");
		btnDownEtage3.setIcon(bas);
		//btnDown_1.setBounds(10, 125, 76, 23);
		btnDownEtage3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addDown(3);
			}
		});
	
		
		JButton btnUpEtage3 = new JButton("");
		btnUpEtage3.setIcon(haut);
		//btnUp_2.setBounds(10, 91, 76, 23);
		btnUpEtage3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addUp(3);
			}
		});
	
		
		JButton btnDownEtage4 = new JButton("");
		btnDownEtage4.setIcon(bas);
		//btnDown_3.setBounds(96, 125, 67, 23);
		btnDownEtage4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addDown(4);
			}
		});
	
		
		JButton btnUpEtage4 = new JButton("");
		btnUpEtage4.setIcon(haut);
		//btnUp_3.setBounds(96, 91, 67, 23);
		btnUpEtage4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addUp(4);
			}
		});
	
		
		JButton btnDownEtage5 = new JButton("");
		btnDownEtage5.setIcon(bas);
		//btnDown_4.setBounds(10, 57, 76, 23);
		btnDownEtage5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addDown(5);
			}
		});
		
		
		
		frame.getContentPane().add(etage0);
		frame.getContentPane().add(btnUpEtage0);
		frame.getContentPane().add(vide1);
		frame.getContentPane().add(etage1);
		frame.getContentPane().add(btnUpEtage1);
		frame.getContentPane().add(btnDownEtage1);
		frame.getContentPane().add(etage2);
		frame.getContentPane().add(btnUpEtage2);
		frame.getContentPane().add(btnDownEtage2);
		frame.getContentPane().add(etage3);
		frame.getContentPane().add(btnUpEtage3);
		frame.getContentPane().add(btnDownEtage3);
		frame.getContentPane().add(etage4);
		frame.getContentPane().add(btnUpEtage4);
		frame.getContentPane().add(btnDownEtage4);
		frame.getContentPane().add(etage5);
		frame.getContentPane().add(vide2);
		frame.getContentPane().add(btnDownEtage5);
		
		
		
		
	
		
		frame.setVisible(true);
	}
}
