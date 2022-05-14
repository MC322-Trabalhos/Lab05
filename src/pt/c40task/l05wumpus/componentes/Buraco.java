package src.pt.c40task.l05wumpus.componentes;

import src.pt.c40task.l05wumpus.utils.Interacao;

public class Buraco extends Componente{

    public Buraco(){
        tipo = 'B';
    }
    
    @Override
    public Interacao interage(Player jogador) {
    	jogador.morre();
    	return new Interacao("Voce caiu num buraco!", -1000);
	}

}
