package src.pt.c40task.l05wumpus.componentes;

import src.pt.c40task.l05wumpus.utils.Interacao;

public class Buraco extends Componente implements ComponenteComEfeito{

    public Buraco(){
        tipo = 'B';
        prioridade = 3;
    }
    
    @Override
    public Interacao interage(Player jogador) {
    	jogador.morre();
    	return new Interacao("Voce caiu num buraco!", -1000);
	}

    public void colocarEfeito(int i, int j, Caverna caverna){
		ComponenteComEfeito.colocarEfeitoGeral(i, j, caverna, new Brisa());
	}

}
