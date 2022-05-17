package src.pt.c40task.l05wumpus.componentes;

import src.pt.c40task.l05wumpus.utils.Interacao;

public class Brisa extends Componente{

    public Brisa(){
        tipo = 'b';
    }
    
    
    @Override
    public Interacao interage(Player jogador) {
    	return new Interacao("Voce sente uma leve brisa!", 0);
    }

    @Override
    public Componente clone() {
        return new Brisa();
    }
}
