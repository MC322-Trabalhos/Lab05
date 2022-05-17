package src.pt.c40task.l05wumpus;

import src.pt.c40task.l05wumpus.componentes.*;

public class MontadorCaverna {

    public static Caverna montaCaverna(String[][] input) {
        Caverna caverna = new Caverna();
        if (input[0][2].charAt(0) != 'P') return null;
        int wumpusCount = 0, buracoCount = 0, ouroCount = 0;
           
        for (String[] linha : input) {
            int i = linha[0].charAt(0) - '1';
            int j = linha[1].charAt(0) - '1';
            Componente comp = null;

            switch (linha[2].charAt(0)) {
                case 'W':
                    Wumpus wumpus = new Wumpus(caverna.getSala(i, j));
                    wumpus.colocarEfeito(i, j, caverna);
                    wumpusCount++;
                    comp = wumpus;
                    break;
                case 'B':
                    Buraco buraco = new Buraco();
                    buraco.colocarEfeito(i, j, caverna);
                    buracoCount++;
                    comp = buraco;
                    break;
                case 'O':
                    comp = new Ouro(caverna.getSala(i, j));
                    ouroCount++;
                    break;
                case 'P':
                    if (i != 0 || j != 0 ) return null;
            }
            if (comp != null) caverna.adicionaComponenteNaSala(i, j, comp);

        }

        if (wumpusCount != 1 || ouroCount != 1 || buracoCount > 3 || buracoCount < 2) return null;

        return caverna;
    }
}
