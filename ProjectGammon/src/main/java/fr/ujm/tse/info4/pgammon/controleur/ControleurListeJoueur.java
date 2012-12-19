package fr.ujm.tse.info4.pgammon.controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import fr.ujm.tse.info4.pgammon.models.Joueur;
import fr.ujm.tse.info4.pgammon.models.Profils;
import fr.ujm.tse.info4.pgammon.vues.VueAjouterJoueur;
import fr.ujm.tse.info4.pgammon.vues.VueListeJoueur;

public class ControleurListeJoueur {

	private VueListeJoueur vueListeJoueur;
	private ControleurPrincipal controleurPrincipal;
	private Profils profil;
	private VueAjouterJoueur vueAjouterJoueur;
	private Boolean flag = true;
    private Integer id = 0;
    
	public ControleurListeJoueur(ControleurPrincipal controleurPrincipal) 
	{
		this.controleurPrincipal = controleurPrincipal;
		//TODO a changer
		profil = Profils.getProfils();
		//
		
		vueListeJoueur = new VueListeJoueur(profil);
		controleurPrincipal.getFrame().setContentPane(vueListeJoueur);
		build();
	}
	
	public void build()
	{
		listenerBouttonRetour();
		listenerBouttonAjouter();
		listenerBouttonModifier();
		listenerBouttonSupprimer();
	}
	
	public void listenerBouttonRetour()
	{
		vueListeJoueur.getRetour().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				vueListeJoueur.setVisible(false);
				profil.sauvegarder();
				controleurPrincipal.retourMenu();
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
		});
	}

	public void listenerBouttonAjouter()
	{
		vueListeJoueur.getAjouter().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				vueListeJoueur.afficheEditerProfil();
				vueAjouterJoueur = vueListeJoueur.getVueAjouterJoueur();
				flag = true;
				buildEditerProfil();
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
		});
	}
	
	public void listenerBouttonModifier(){
		vueListeJoueur.getPanelDescription().getModifier().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				vueListeJoueur.afficheEditerProfil();
				vueAjouterJoueur = vueListeJoueur.getVueAjouterJoueur();
				flag = false;
				buildEditerProfil();
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
		});
	}
	
	public void listenerBouttonSupprimer(){
		vueListeJoueur.getPanelDescription().getSupprimer().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				profil.supprimer(vueListeJoueur.getPanelDescription().getJoueur());
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
		});
	}
		
	public void buildEditerProfil(){
		
		if(flag){
			vueAjouterJoueur.getnomPseudo().setText("");
		}else{
			vueAjouterJoueur.getnomPseudo().setText(vueListeJoueur.getPanelDescription().getJoueur().getPseudo());
		}
		
		listenerBouttonFermerEditerProfil();
		listenerBouttonEnregistrerEditerProfil();
	}
	
	public void listenerBouttonFermerEditerProfil(){
		vueAjouterJoueur.getRetour().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				vueListeJoueur.masqueEditerProfil();
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
		});
	}

	public void listenerBouttonEnregistrerEditerProfil(){
		vueAjouterJoueur.getenregistrer().addMouseListener(new MouseListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				if(flag){
					Joueur tmpJoueur = new Joueur();		 
					tmpJoueur.setPseudo(vueAjouterJoueur.getnomPseudo().getText());	
					
					Date date = new Date();
					id = 10000*date.getMonth()+1000*date.getDay()+100*date.getHours()+10*date.getMinutes()+date.getSeconds();
					
					tmpJoueur.setId(id);
					
					profil.getList().add(tmpJoueur);
					
				}else{
					vueListeJoueur.getPanelDescription().getJoueur().setPseudo(vueAjouterJoueur.getnomPseudo().getText());
				}
				vueListeJoueur.masqueEditerProfil();
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
		});
	}

				
	
}
