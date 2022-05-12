package src.pt.c40task.l05wumpus.componentes;

import src.pt.c40task.l05wumpus.utils.Acao;

public class Player {
    private final String nome;
    private boolean flechaEquipada = false, vivo = true;
    private int numFlechas = 2;
    private int[] pos;

    public Player(String nome) {
        this.nome = nome;
        pos = new int[]{0, 0};
    }

    public void equipaFlecha() {
        if (!isFlechaEquipada() && numFlechas > 0) {
            this.flechaEquipada = true;
            numFlechas--;
        }
    }

    public boolean agir(Acao acao){
        switch (acao){
            case UP:
                if (pos[0] - 1 >= 0) pos[0]--;
                break;
            case DOWN:
                if (pos[0] + 1 < 4) pos[0]++;
                break;
            case LEFT:
                if (pos[1] - 1 >= 0) pos[1]--;
                break;
            case RIGHT:
                if (pos[1] + 1 < 4) pos[1]++;
                break;
        }
        return true;
    }

    public int[] getPos() {
        return pos;
    }

    public boolean isFlechaEquipada() {
        return flechaEquipada;
    }

    public String getNome() {
        return nome;
    }

    public char apresenta() {
        return 'P';
    }

    public boolean isVivo() {
        return vivo;
    }

    public void morre() {
        vivo = false;
    }


}
