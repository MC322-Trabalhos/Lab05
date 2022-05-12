package src.pt.c40task.l05wumpus.componentes;

public class Wumpus extends Sala{

    public Wumpus(){
        tipo = 'W';
    }

    @Override
    public void ocupa(Player jogador) {
        atual = tipo;
    }

    @Override
    public String toString() {
        return "Voce encontrou o WUMPUS";
    }
}
