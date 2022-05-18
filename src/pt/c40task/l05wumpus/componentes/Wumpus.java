package src.pt.c40task.l05wumpus.componentes;

import java.util.Random;

import src.pt.c40task.l05wumpus.utils.Interacao;

public class Wumpus extends Componente implements ComponenteComEfeito {
	private Sala salaWumpus;
	
    public Wumpus(Sala salaWumpus){
        tipo = 'W';
        this.salaWumpus = salaWumpus;
		prioridade = 3;
    }
    
    public void morrer() {
    	salaWumpus.excluirComponenteTardio(this);
    }
   
    @Override
    public Interacao interage(Player jogador) {
    	Random random = new Random();
    	boolean b = random.nextBoolean();
    	if (jogador.isFlechaAtirada() && b) {
    		this.morrer(); //wumpus morre
    		return new Interacao("Voce matou o Wumpus!", 500);
    	} else {
    		jogador.morre();
    		return new Interacao("Voce foi morto pelo Wumpus!", -1000);
    	}
    }

	public void colocarEfeito(int i, int j, Caverna caverna){
		ComponenteComEfeito.colocarEfeitoGeral(i, j, caverna, new Fedor());
	}
}
