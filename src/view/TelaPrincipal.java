package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Image;

import controller.ThreadSapo;

public class TelaPrincipal extends JFrame{
	JLabel labels[];
	JLabel chegada;
	int qtdSapos;
	int multiplicador;
	int tamanhopista;
	Image imgSapo = new ImageIcon(getClass().getResource("sapo.png")).getImage().getScaledInstance(45, 45, Image.SCALE_FAST);
	Image linha; 
	public TelaPrincipal(int tamanhoPista,int qtdSapos,int multiplicador) {
		super();
		this.multiplicador = multiplicador;
		this.setSize(tamanhoPista*(multiplicador+10),qtdSapos*90);
		this.tamanhopista = tamanhoPista;
		this.setTitle("Corrida de sapos");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		linha = new ImageIcon(getClass().getResource("linhaDeChegada.png")).getImage().getScaledInstance(30, getHeight(), Image.SCALE_FAST);
		this.setVisible(true);
		this.setResizable(false);
		this.qtdSapos = qtdSapos;
		labels = new JLabel[qtdSapos];
		init();
		initBackground();
	}
	
	private void init() {	
		for (int j = 0; j < labels.length; j++) {
			labels[j] = new JLabel(new ImageIcon(imgSapo));
			labels[j].setBounds(0, 20+(j*80), 50, 50);
			labels[j].setForeground(Color.BLACK);
			labels[j].setVisible(true);
			add(labels[j]);
		}		
		
	}
	
	private void initBackground() {
		chegada = new JLabel(new ImageIcon(linha));
		chegada.setBackground(Color.WHITE);
		chegada.setBounds(this.getWidth()-(tamanhopista*10),0,30,this.getHeight());
		chegada.setOpaque(true);
		add(chegada);
	}
	
	public void AtualizarPosicoes(ThreadSapo sapos[]) {
		for (int i = 0; i < qtdSapos; i++) {
			labels[i].setBounds(sapos[i].getPosicaoAtual(),labels[i].getY() ,labels[i].getWidth(), labels[i].getHeight());
			this.repaint();
		}
	}
}
