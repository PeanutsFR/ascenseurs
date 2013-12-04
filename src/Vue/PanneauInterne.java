package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.SystemAscenseur;

// Panneau de contrôle interne de l'ascenseur (les boutons qu'il y a dans l'ascenseur)

public class PanneauInterne {

	
	private JFrame frame;
	private SystemAscenseur system;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public PanneauInterne(SystemAscenseur system) {
		initialize();
		this.system = system;
		
	}
	
	public void addEtage(float etage){
		this.system.addEtage(etage);
	}
	
	private void arret_urgence() {
			this.system.arret_urgence();
		}
	
	public void stop_arret_urgence(){
			this.system.stop_arret_urgence();
	}
	
	public boolean getUrgence(){
		if(this.system.get_arret()==true)
			return true;
		else
			return false;
	}
	
	public void changerIcon(JButton bouton ,Icon icon)
	{
		bouton.setIcon(icon);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 490, 70, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		// ---------------------- PANEL : Interne ----------------------
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 124, 600);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		final Icon etage5_off = new ImageIcon("Ressources/etage5off.png");
		final Icon etage5_on = new ImageIcon("Ressources/etage5on.png");
		final JButton btnEtage_5 = new JButton();
		btnEtage_5.setIcon(etage5_off);
		btnEtage_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEtage(5);
				changerIcon(btnEtage_5,etage5_on);
			}
		});
		btnEtage_5.setBounds(10, 10, 70, 70);
		panel.add(btnEtage_5);
		
		
		final Icon etage4_off = new ImageIcon("Ressources/etage4off.png");
		final Icon etage4_on = new ImageIcon("Ressources/etage4on.png");
		
		final JButton btnEtage_4 = new JButton();
		btnEtage_4.setIcon(etage4_off);
				
		btnEtage_4.setBounds(10, 80, 70, 70);
		btnEtage_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				addEtage(4);
				changerIcon(btnEtage_4,etage4_on);
			}
			
		});
		panel.add(btnEtage_4);
		
		final Icon etage3_off = new ImageIcon("Ressources/etage3off.png");
		final Icon etage3_on = new ImageIcon("Ressources/etage3on.png");
		final JButton btnEtage_3 = new JButton();
		btnEtage_3.setIcon(etage3_off);
		btnEtage_3.setBounds(10, 150, 70, 70);
		btnEtage_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEtage(3);
				changerIcon(btnEtage_3,etage3_on);
			}
		});
		panel.add(btnEtage_3);
		
		final Icon etage2_off = new ImageIcon("Ressources/etage2off.png");
		final Icon etage2_on = new ImageIcon("Ressources/etage2on.png");
		final JButton btnEtage_2 = new JButton();
		btnEtage_2.setIcon(etage2_off);
		btnEtage_2.setBounds(10, 220, 70, 70);
		btnEtage_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEtage(2);
				changerIcon(btnEtage_2,etage2_on);
			}
		});
		panel.add(btnEtage_2);
		
		final Icon etage1_off = new ImageIcon("Ressources/etage1off.png");
		final Icon etage1_on = new ImageIcon("Ressources/etage1on.png");
		final JButton btnEtage_1 = new JButton();
		btnEtage_1.setIcon(etage1_off);
		btnEtage_1.setBounds(10, 290, 70, 70);
		btnEtage_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEtage(1);
				changerIcon(btnEtage_1,etage1_on);
			}
		});
		panel.add(btnEtage_1);
		

		
		final Icon etage0_off = new ImageIcon("Ressources/etage0off.png");
		final Icon etage0_on = new ImageIcon("Ressources/etage0on.png");
		final JButton btnEtage = new JButton();
		btnEtage.setIcon(etage0_off);
		
		btnEtage.setBounds(10, 360, 70, 70);
		btnEtage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEtage(0);
				changerIcon(btnEtage,etage0_on);
			}
		});
		panel.add(btnEtage);
		
		final Icon arretUrgence_off = new ImageIcon("Ressources/boutonsAUoff.png");
		final Icon arretUrgence_on = new ImageIcon("Ressources/boutonsAUon.png");
		final JButton btnAU = new JButton();
		btnAU.setIcon(arretUrgence_off);
		
		btnAU.setBounds(10, 420, 70, 70);
		btnAU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//addEtage(0);
				if(getUrgence()==false)
				{
					changerIcon(btnAU,arretUrgence_on);
				arret_urgence();
				}
				else
				{
					changerIcon(btnAU,arretUrgence_off);
					stop_arret_urgence();
				}
					
				
			}

			
		});
		panel.add(btnAU);
		
	
		
		frame.setVisible(true);
	}
	
}
