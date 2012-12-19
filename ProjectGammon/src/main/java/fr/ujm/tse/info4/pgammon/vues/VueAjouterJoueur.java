package fr.ujm.tse.info4.pgammon.vues;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.ujm.tse.info4.pgammon.gui.Avatar;
import fr.ujm.tse.info4.pgammon.gui.AvatarList;
import fr.ujm.tse.info4.pgammon.gui.ImageAvatar;
import fr.ujm.tse.info4.pgammon.gui.MonochromeButton;
import fr.ujm.tse.info4.pgammon.gui.MonochromePanel;

public class VueAjouterJoueur extends MonochromePanel{



	private static final long serialVersionUID = 3196089768815616270L;
	
	private MonochromeButton changerAvatar;
	private MonochromeButton supprimerAvatar;
	private MonochromeButton annuler;
	private MonochromeButton enregistrer;
	
	private JTextField nomPseudo;
	
	private ImageAvatar imgjoueur;
	
	private String chemin = Avatar.CHOUETTE.getPath();
	
	public VueAjouterJoueur(){
		super("Edition de profil");
		build();
		
	}
	
	public void setPath(String p){
		chemin = p;
		updateData();
	}

	private void updateData() {
		imgjoueur.setPath(chemin);
		
	}

	private void build() {
		setLayout(null);
		
		imgjoueur = new ImageAvatar(chemin);
		imgjoueur.setBounds(25, 130, 105, 105);
		add(imgjoueur);
		
		changerAvatar = new MonochromeButton("Changer l'avatar");
		changerAvatar.setBounds(150, 130, 230, 40);
		add(changerAvatar);
		
		supprimerAvatar = new MonochromeButton("Supprimer l'avatar");
		supprimerAvatar.setBounds(150, 180, 230, 40);
		add(supprimerAvatar);
		
		annuler = new MonochromeButton("Annuler");
		annuler.setBounds(40, 245, 150, 40);
		add(annuler);
		
		enregistrer = new MonochromeButton("Enregistrer");
		enregistrer.setBounds(200, 245, 150, 40);
		add(enregistrer);
		
		nomPseudo = new JTextField();
		nomPseudo.setBounds(10, 60, 380, 40);
		nomPseudo.setBackground(new Color(0x61685A));
		nomPseudo.setForeground(new Color(0xCCCCCC));
		add(nomPseudo);
		
		
		JLabel pseudo = new JLabel("Pseudo");
		pseudo.setForeground(new Color(0xCCCCCC));
		pseudo.setBounds(10, 20, 100, 50);
		add(pseudo);
		
		JLabel Avatar = new JLabel("Avatar");
		Avatar.setForeground(new Color(0xCCCCCC));
		Avatar.setBounds(10, 90, 100, 50);
		add(Avatar);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create(); 
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		
		Paint p;
		int h = getHeight(); 
		int w = getWidth(); 
		
		
		
		
		g2.dispose(); 
		super.paintComponent(g);
		
	}
	
	public MonochromeButton getRetour() {
		return annuler;
	}
	
	public MonochromeButton getchangerAvatar() {
		return changerAvatar;
	}
	
	public MonochromeButton getsupprimerAvatar() {
		return supprimerAvatar;
	}
	
	public MonochromeButton getenregistrer() {
		return enregistrer;
	}
	
	public JTextField getnomPseudo() {
		return nomPseudo;
	}
}
