package src.pt.c40task.l05wumpus.componentes;

public class Caverna {
    private final Sala[][] salas;

    public Caverna(Sala[][] salas){
        this.salas = salas;
    }

    public void desocupaSala(Player jogador){
        getSala(jogador.getPos()).desocupa();
    }

    public void ocupaNovaSala(Player jogador){
        getSala(jogador.getPos()).ocupa(jogador);
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Sala[] linha : salas){
            for (Sala sala: linha){
                stringBuilder.append(sala.apresenta());
                stringBuilder.append(" ");
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    public Sala getSala(int[] pos) {
        return salas[pos[0]][pos[1]];
    }
}
