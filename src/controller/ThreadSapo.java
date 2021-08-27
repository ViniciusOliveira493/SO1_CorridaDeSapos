package controller;

public class ThreadSapo extends Thread{
	int tamanhoPista;
	int posicaoAtual = 0;
	int numeroSapo;
	int multiplicador;
	public int getNumeroSapo() {
		return numeroSapo;
	}

	public ThreadSapo(int numeroSapo, int tamanhoPista,int multiplicador) {
		this.numeroSapo = numeroSapo;
		this.tamanhoPista = tamanhoPista*multiplicador;		
		this.multiplicador = multiplicador;
	}
		
	public int getPosicaoAtual() {
		return posicaoAtual;
	}

	@Override
	public void run() {
		while (posicaoAtual<tamanhoPista) {
			pular();
			try {
				this.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
		System.err.println("O sapo "+(numeroSapo+1)+" terminou a corrida");		
	}

	private void pular() {
		int distancia = (int) (Math.random()*3);
		posicaoAtual += distancia*multiplicador;
		
		System.out.println("O sapo " + (numeroSapo+1) + " pulou " + distancia + " metros e percorreu " + posicaoAtual/multiplicador+" metros no total");
	}
}
