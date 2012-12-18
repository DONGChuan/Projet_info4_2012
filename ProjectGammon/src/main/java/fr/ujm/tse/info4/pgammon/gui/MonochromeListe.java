package fr.ujm.tse.info4.pgammon.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

public class MonochromeListe<T> extends MonochromePanel{
	private static final long serialVersionUID = 1L;
	
	private JList<T> list;
	private JScrollPane scrollpane;
	public MonochromeListe(String titre, Vector<T> liste, ListCellRenderer<T> cellRenderer) {
		super(titre);
		setLayout(null);
		setOpaque(false);
		
		list = new JList<T>(liste);
		list.setCellRenderer(cellRenderer);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollpane = new JScrollPane(list);
		scrollpane.setBounds(0,0,getPreferredSize().width,getPreferredSize().height);

		list.setOpaque(false);
		scrollpane.setOpaque(false);
		add(scrollpane);

		setBackground(Color.BLACK);
		list.setBackground(Color.BLACK);
		scrollpane.setBackground(Color.BLACK);

		scrollpane.getViewport().setBackground(null);
		scrollpane.setOpaque(true);
		scrollpane.getViewport().setBorder(null);
		scrollpane.setBorder(null);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		scrollpane.setBounds(5,5+MonochromePanel.TITLE_HEIGHT,getBounds().width-10,getBounds().height-10-MonochromePanel.TITLE_HEIGHT);
		
		super.paintComponent(g);
	}
	
	public T getSelectedValue(){
		return list.getSelectedValue();
	}
	
	public JList<T> getList(){
		return list;
	}
	
}