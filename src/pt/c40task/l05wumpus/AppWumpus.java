package src.pt.c40task.l05wumpus;

import src.pt.c40task.l05wumpus.componentes.Caverna;
import src.pt.c40task.l05wumpus.componentes.Player;
import src.pt.c40task.l05wumpus.utils.Acao;
import src.pt.c40task.l05wumpus.utils.Interacao;

public class AppWumpus {

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

      Caverna caverna = MontadorCaverna.montaCaverna(cave);
      if (caverna == null){
         tk.stop();
         System.out.println("Tabuleiro invalido");
         return;
      }

      ControleJogo controle = new ControleJogo();
      String nomeJogador = "Alcebiades";

      if (arquivoMovimentos == null){
         System.out.println("=== Caverna");
         System.out.print("Entre com um nome: ");
         nomeJogador = controle.leString();
      }

      Player jogador = new Player(nomeJogador);
      Acao comando = Acao.INVALID;
      caverna.ocupaNovaSala(jogador);

      if (arquivoMovimentos == null){
         System.out.println(caverna);
         System.out.println("Player: " + jogador.getNome());
         while (comando != Acao.QUIT && jogador.isVivo() && !jogador.hasEscaped()) {
            comando = controle.leAcao();
            caverna.desocupaSala(jogador);
            
            Interacao acaoJogador = jogador.agir(comando);
            Interacao interacaoComSala = caverna.ocupaNovaSala(jogador);
            controle.addScore(interacaoComSala.score + acaoJogador.score);
      
            System.out.print(caverna);
            System.out.println("Player: " + jogador.getNome());
            System.out.print(acaoJogador.narracao + interacaoComSala.narracao);
            if (!jogador.isVivo()) {
               System.out.println("Voce morreu!");
            }
            System.out.println("Score: " + controle.getScore());
         }
      } else {
         String movimentos = tk.retrieveMovements();
         char status = 'P';
         for (int i = 0; i < movimentos.length(); i++){
            comando = controle.charToAcao(movimentos.charAt(i));
            if (comando == Acao.QUIT) break;
            caverna.desocupaSala(jogador);
            
            Interacao acaoJogador = jogador.agir(comando);
            Interacao interacaoComSala = caverna.ocupaNovaSala(jogador);
            controle.addScore(interacaoComSala.score + acaoJogador.score);
      
            if (!jogador.isVivo()) status = 'L';
            else if (jogador.hasEscaped()) status = 'W';
            tk.writeBoard(caverna.apresenta(), controle.getScore(), status);
         }
      }


         

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
