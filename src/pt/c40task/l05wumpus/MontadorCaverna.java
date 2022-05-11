package src.pt.c40task.l05wumpus;

import src.pt.c40task.l05wumpus.componentes.*;

import java.util.ArrayList;

public class MontadorCaverna {

    public static Caverna montaCaverna(String[][] input) {
        Sala[][] salas = new Sala[4][4];
        ArrayList<int[]> posicoesBuraco = new ArrayList<>();
        int[] posicaoWumpus = new int[2];
        int[] posicaoOuro = new int[2];
        for (String[] linha : input) {
            int i = linha[0].charAt(0) - '1';
            int j = linha[1].charAt(0) - '1';
            switch (linha[2].charAt(0)) {
                case 'W':
                    posicaoWumpus[0] = i;
                    posicaoWumpus[1] = j;
                    break;
                case 'B':
                    posicoesBuraco.add(new int[]{i, j});
                    break;
                case 'O':
                    posicaoOuro[0] = i;
                    posicaoOuro[1] = j;
                    break;
            }
        }


        colocaBuraco(posicoesBuraco, salas);
        colocaSala(posicaoWumpus[0], posicaoWumpus[1], 'W', salas);
        colocarEfeito(posicaoWumpus, 'f', salas);
        colocaSala(posicaoOuro[0], posicaoOuro[1], 'O', salas);

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++){
                if (salas[i][j] == null) salas[i][j] = new Sala();
            }
        
        return new Caverna(salas);
    }
    
    private static void colocaBuraco(ArrayList<int[]> posicoes, Sala[][] salas){
        for (int[] posicao: posicoes){
            colocaSala(posicao[0], posicao[1], 'B', salas);
            colocarEfeito(posicao, 'b', salas);
        }
        
    }
    private static void colocarEfeito(int[] pos, char tipo, Sala[][] salas) {
        if (pos[0] - 1 >= 0) {
            colocaSala(pos[0] - 1, pos[1], tipo, salas);
        }
        if (pos[0] + 1 < 4) {
            colocaSala(pos[0] + 1, pos[1], tipo, salas);
        }
        if (pos[1] - 1 >= 0) {
            colocaSala(pos[0], pos[1] - 1, tipo, salas);
        }
        if (pos[1] + 1 < 4) {
            colocaSala(pos[0], pos[1] + 1, tipo, salas);
        }
    }

    private static void colocaSala(int i, int j, char tipo, Sala[][] salas) {
        switch (tipo) {
            case 'W':
                salas[i][j] = new Wumpus();
                break;
            case 'B':
                salas[i][j] = new Buraco();
                break;
            case 'O':
                salas[i][j] = new Ouro();
                break;
            case 'b':
                salas[i][j] = new Brisa();
                break;
            case 'f':
                salas[i][j] = new Fedor();
                break;
            default:
                salas[i][j] = new Sala();
        }
    }
}
