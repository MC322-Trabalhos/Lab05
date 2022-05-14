package src.pt.c40task.l05wumpus.utils;

public class Interacao {
	public final String narracao;
	public final int score;
	
	public Interacao() {
		narracao = "";
		score = 0;
	}
	
	public Interacao(String narr, int sc){
		narracao = narr;
		score = sc;
	}
}
