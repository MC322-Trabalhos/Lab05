package src.pt.c40task.l05wumpus;

import src.pt.c40task.l05wumpus.componentes.Caverna;
import src.pt.c40task.l05wumpus.componentes.Player;
import src.pt.c40task.l05wumpus.utils.Acao;

import java.util.Scanner;

public class ControleJogo {
    private final Scanner keyboard = new Scanner(System.in);
    private Caverna caverna;
    private Player jogador;
    private int score = 0;

    public ControleJogo(String[][] arquivoCaverna){
        caverna = MontadorCaverna.montaCaverna(arquivoCaverna);
        System.out.print("Entre com um nome: ");
        String nome = keyboard.nextLine();
        jogador = new Player(nome);
    }

    public void run() {
        Acao comando = Acao.INVALID;
        caverna.ocupaNovaSala(jogador);
        System.out.println(caverna);
        System.out.println("Player: " + jogador.getNome());
        while (comando != Acao.QUIT) {
            comando = leAcao();
            caverna.desocupaSala(jogador);
            jogador.agir(comando);
            caverna.ocupaNovaSala(jogador);

            System.out.println(caverna);
            System.out.println("Player: " + jogador.getNome());
            System.out.println(caverna.getSala(jogador.getPos()));
            System.out.println("Score: " + score);
            if (comando == Acao.QUIT) System.out.println("Volte sempre !");
        }
    }

    private Acao leAcao() {
        String input = keyboard.nextLine();
        char c = input.charAt(0);
        Acao acao = Acao.INVALID;
        switch (c) {
            case 'w':
                acao = Acao.UP;
                break;
            case 's':
                acao = Acao.DOWN;
                break;
            case 'a':
                acao = Acao.LEFT;
                break;
            case 'd':
                acao = Acao.RIGHT;
                break;
            case 'k':
                acao = Acao.ARROW;
                break;
            case 'c':
                acao = Acao.CAPTURE;
                break;
            case 'q':
                acao = Acao.QUIT;
                break;
        }
        return acao;
    }
}
