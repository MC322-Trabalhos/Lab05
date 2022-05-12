package src.pt.c40task.l05wumpus;

import src.pt.c40task.l05wumpus.componentes.*;

import java.util.ArrayList;

public class MontadorCaverna {

    public static Caverna montaCaverna(String[][] input) {
        Sala[][] salas = new Sala[4][4];
        if (input[0][2].charAt(0) != 'P') return null;
        
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                salas[i][j] = new Sala();
           
        for (String[] linha : input) {
            int i = linha[0].charAt(0) - '1';
            int j = linha[1].charAt(0) - '1';
            colocaSala(i, j, linha[2].charAt(0), salas);
        }

        return new Caverna(salas);
    }
    
 
    private static void colocarEfeito(int i, int j, char tipo, Sala[][] salas) {
        if (i - 1 >= 0) {
            colocaSala(i - 1, j, tipo, salas);
        }
        if (i + 1 < 4) {
            colocaSala(i + 1, j, tipo, salas);
        }
        if (j - 1 >= 0) {
            colocaSala(i, j - 1, tipo, salas);
        }
        if (j + 1 < 4) {
            colocaSala(i, j + 1, tipo, salas);
        }
    }

    private static void colocaSala(int i, int j, char tipo, Sala[][] salas) {
        switch (tipo) {
            case 'W':
                salas[i][j].adicionarComponente(new Wumpus());
                colocarEfeito(i, j, 'f', salas);
                break;
            case 'B':
            	salas[i][j].adicionarComponente(new Buraco());
                colocarEfeito(i, j, 'b', salas);
                break;
            case 'O':
            	salas[i][j].adicionarComponente(new Ouro());
                break;
            case 'b':
            	salas[i][j].adicionarComponente(new Brisa());
                
                break;
            case 'f':
            	salas[i][j].adicionarComponente(new Fedor());
                break;
        }
    }
}
