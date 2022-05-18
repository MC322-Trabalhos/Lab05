package src.pt.c40task.l05wumpus.componentes;

import src.pt.c40task.l05wumpus.utils.Interacao;

public class Ouro extends Componente{
	private Sala salaOuro;
	
	
    public Ouro(Sala salaOuro){
        tipo = 'O';
        this.salaOuro = salaOuro;
        prioridade = 3;
    }
    
    @Override
    public Interacao interage(Player jogador) {
    	if (jogador.tentouCapturarOuro()) {
    		jogador.capturarOuro();
    		salaOuro.excluirComponenteTardio(this);
    		return new Interacao("Voce capturou o Ouro!", 0);
    	}
    	return new Interacao("Voce encontrou o Ouro!", 0);
    }
    
}
