package src.pt.c40task.l05wumpus.componentes;

public class Caverna {
    Sala[][] salas;

    public Caverna(){
        salas = new Sala[4][4];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                salas[i][j] = new Sala(new Vazio());

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


}
