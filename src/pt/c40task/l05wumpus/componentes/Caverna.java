package src.pt.c40task.l05wumpus.componentes;

import src.pt.c40task.l05wumpus.utils.Interacao;

public class Caverna {
    private final Sala[][] salas;

    public Caverna(){
        salas = new Sala[4][4];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                salas[i][j] = new Sala();
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

    public Sala getSala(int i, int j) {
        return salas[i][j];
    }

    public boolean adicionaComponenteNaSala(int i, int j, Componente comp) {
        return salas[i][j].adicionarComponente(comp);
    }


}
