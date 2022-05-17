package src.pt.c40task.l05wumpus;

import src.pt.c40task.l05wumpus.utils.Acao;

import java.util.Scanner;

public class ControleJogo {
    private final Scanner keyboard = new Scanner(System.in);
    private int score = 0;

    public int getScore() {
        return score;
    }

    public void addScore(int val){
        score += val;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String leString(){
        return keyboard.nextLine();
    }

    public Acao charToAcao(char c){
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

    public Acao leAcao() {
        String input = keyboard.nextLine();
        char c = input.charAt(0);
        return charToAcao(c);
    }
}
