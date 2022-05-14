package src.pt.c40task.l05wumpus;

import src.pt.c40task.l05wumpus.componentes.Caverna;
import src.pt.c40task.l05wumpus.componentes.Player;
import src.pt.c40task.l05wumpus.utils.Acao;
import src.pt.c40task.l05wumpus.utils.Interacao;

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
        while (comando != Acao.QUIT && jogador.isVivo()) {
            comando = leAcao();
            caverna.desocupaSala(jogador);
            Interacao acaoJogador = jogador.agir(comando);
            Interacao inter = caverna.ocupaNovaSala(jogador);
            score += inter.score + acaoJogador.score;
            System.out.print(caverna);
            System.out.println("Player: " + jogador.getNome());
            System.out.print(acaoJogador.narracao + inter.narracao);
            
            System.out.println("Score: " + score);
            if (jogador.hasEscaped()) {
            	break;
            }
            if (!jogador.isVivo()) {
            	System.out.println("Voce morreu!");
            	break;
            }
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
