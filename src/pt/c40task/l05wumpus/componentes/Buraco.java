package src.pt.c40task.l05wumpus.componentes;

public class Buraco extends Componente{

    public Buraco(){
        tipo = 'B';
    }
    
    @Override
    public void interage(Player jogador) {
		jogador.morre();
	}

    @Override
    public String toString() {
        return "Buraco";
    }
}
