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
                    comp = new Wumpus(caverna.getSala(i, j));
                    Wumpus.colocarFedor(i, j, caverna);
                    wumpusCount++;
                    break;
                case 'B':
                    comp = new Buraco();
                    Buraco.colocarBrisa(i, j, caverna);
                    buracoCount++;
                    break;
                case 'O':
                    comp = new Ouro(caverna.getSala(i, j));
                    ouroCount++;
                    break;
                case 'P':
                    if (i != 0 || j != 0 ) return null;
            }
            if (comp != null) if (!caverna.adicionaComponenteNaSala(i, j, comp)) return null;

        }

        if (wumpusCount != 1 || ouroCount != 1 || buracoCount > 3 || buracoCount < 2) return null;

        return caverna;
    }
}
