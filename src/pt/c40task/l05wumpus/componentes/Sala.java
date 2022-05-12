package src.pt.c40task.l05wumpus.componentes;

public class Sala {
    protected char atual = '-', tipo = '#';

    public void ocupa(Player jogador){
        atual = 'P';
    }

    public void desocupa(){
        atual = tipo;
    }

    public char apresenta(){
        return atual;
    }

    public String toString() {
        return "Voce entrou em uma sala vazia";
    }
}
