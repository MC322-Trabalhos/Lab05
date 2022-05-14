package src.pt.c40task.l05wumpus.componentes;

import src.pt.c40task.l05wumpus.utils.Interacao;

public abstract class Componente {
	protected char tipo;
	
	public char getTipo() {
		return tipo;
	}
	
	public abstract Interacao interage(Player jogador);
}
