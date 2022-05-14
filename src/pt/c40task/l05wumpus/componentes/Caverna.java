package src.pt.c40task.l05wumpus.componentes;

import src.pt.c40task.l05wumpus.utils.Interacao;

public class Caverna {
    private final Sala[][] salas;

    public Caverna(Sala[][] salas){
        this.salas = salas;
    }

    public void desocupaSala(Player jogador){
        getSala(jogador.getPos()).desocupa(jogador);
    }

    public Interacao ocupaNovaSala(Player jogador){
    	int[] posJogador = jogador.getPos();
    	if (jogador.temOuro() && posJogador[0] == 0 && posJogador[1] == 0) {
    		jogador.escapar();
    		return new Interacao("Voce escapou da caverna!\n", 1000);
    	}
        return getSala(jogador.getPos()).ocupa(jogador);
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Sala[] linha : salas){
            for (Sala sala: linha){
                stringBuilder.append(sala.apresenta());
                stringBuilder.append(" ");
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    public Sala getSala(int[] pos) {
        return salas[pos[0]][pos[1]];
    }
}
