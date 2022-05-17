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

    public void adicionaComponenteNaSala(int i, int j, Componente comp) {
        salas[i][j].adicionarComponente(comp);
    }

    public char[][] apresenta(){
        char[][] matrizCaverna = new char[4][4];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                matrizCaverna[i][j] = getSala(i, j).apresenta();
        return matrizCaverna;
    }


}
