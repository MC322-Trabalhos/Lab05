package src.pt.c40task.l05wumpus;

import src.pt.c40task.l05wumpus.componentes.Caverna;
import src.pt.c40task.l05wumpus.utils.Acao;


public class AppWumpus {

//   public static void main(String[] args) {
//
//   }
   public static void main(String[] args) {
      AppWumpus.executaJogo(
            (args.length > 0) ? args[0] : null,
            (args.length > 1) ? args[1] : null,
            (args.length > 2) ? args[2] : null);
   }
   
   public static void executaJogo(String arquivoCaverna, String arquivoSaida,
                                  String arquivoMovimentos) {
      Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
      
      String[][] cave = tk.retrieveCave();
      System.out.println("=== Caverna");
      // TODO CHECAR IRREGULARIDADES COM O MAPA
      // TODO FAZER A CLASSE JOGO
      // TODO MOVIMENTO DO JOGADOR
      Caverna c = MontadorCaverna.montaCaverna(cave);
      System.out.println(c);

//      for (String[] strings : cave) {
//         for (int c = 0; c < strings.length; c++)
//            System.out.print(strings[c] + ((c < strings.length - 1) ? ", " : ""));
//         System.out.println();
//      }
//
//      String movements = tk.retrieveMovements();
//      System.out.println("=== Movimentos");
//      System.out.println(movements);
//
//      System.out.println("=== Caverna Intermediaria");
//      char[][] partialCave = {
//         {'#', '#', 'b', '-'},
//         {'#', 'b', '-', '-'},
//         {'b', '-', '-', '-'},
//         {'p', '-', '-', '-'}
//      };
//      int score = -120;
//      char status = 'x'; // 'w' para venceu; 'n' para perdeu; 'x' intermediárias
//      tk.writeBoard(partialCave, score, status);
//
//      System.out.println("=== Última Caverna");
//      char[][] finalCave = {
//         {'#', '#', 'b', '-'},
//         {'#', 'b', '#', 'f'},
//         {'b', '-', '-', 'w'},
//         {'#', '-', '-', '-'}
//      };
//      score = -1210;
//      status = 'n'; // 'w' para venceu; 'n' para perdeu; 'x' intermediárias
//      tk.writeBoard(finalCave, score, status);
      
      tk.stop();
   }

}