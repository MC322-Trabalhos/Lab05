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

    public static void colocarBrisa(int i, int j, Caverna caverna){
        if (i - 1 >= 0) {
            caverna.adicionaComponenteNaSala(i - 1, j, new Brisa());
        }
        if (i + 1 < 4) {
            caverna.adicionaComponenteNaSala(i + 1, j, new Brisa());
        }
        if (j - 1 >= 0) {
            caverna.adicionaComponenteNaSala(i, j - 1, new Brisa());
        }
        if (j + 1 < 4) {
            caverna.adicionaComponenteNaSala(i, j + 1, new Brisa());
        }
    }

}
