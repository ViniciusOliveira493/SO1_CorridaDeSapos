package view;

import javax.swing.JOptionPane;

import controller.ThreadSapo;

public class Principal {
	public static void main(String[] args) {
		int qtdSapos = 5;
		int tamanhoPista = 20;
		int multiplicador = 40;
		ThreadSapo sapos[] = new ThreadSapo[qtdSapos];
		for (int i = 0; i < qtdSapos; i++) {
			ThreadSapo sapo = new ThreadSapo(i, tamanhoPista,multiplicador);
			sapos[i] = sapo;
		}
		//TelaPrincipal tela = new TelaPrincipal(tamanhoPista,qtdSapos,multiplicador);
		
		for(ThreadSapo sapo : sapos) {
			sapo.start();
		}
		
		
		int ordemDeChegada[] = new int[qtdSapos];
		int saposQueTerminaramACorrida = 0;
		ThreadSapo saposVerificar[] = sapos;
		
		while (saposVerificar.length>0) {
			//tela.AtualizarPosicoes(sapos);
			//verificando se os sapos já terminaram a corrida
			for (int i = 0; i < saposVerificar.length; i++) {
				if (saposVerificar[i].getPosicaoAtual()>(tamanhoPista*multiplicador-1)) {
					
					//registrando a posição do sapo que terminou a corrida
					ordemDeChegada[saposQueTerminaramACorrida] = saposVerificar[i].getNumeroSapo();				
					saposQueTerminaramACorrida++;
					
					//removendo o sapo que já acabou a corrida da lista
					ThreadSapo rSapos[] = new ThreadSapo[saposVerificar.length-1];
					int saposQueNaoTerminaramAcorrida = 0;
					for (int j = 0; j < saposVerificar.length; j++) {
						if (saposVerificar[j]!=saposVerificar[i]) {
							rSapos[saposQueNaoTerminaramAcorrida] = saposVerificar[j];
							saposQueNaoTerminaramAcorrida++;
						}
					}
					saposVerificar = rSapos;
				}
			}		
		}
		//tela.AtualizarPosicoes(sapos);
		String posicoes = "";
		for (int i = 0; i < ordemDeChegada.length; i++) {
			posicoes+=((i+1)+"º lugar: sapo "+(ordemDeChegada[i]+1)+" \n");
		}
		
		System.out.println("\n"+posicoes);
		//JOptionPane.showMessageDialog(null, posicoes);
		
	}
}
