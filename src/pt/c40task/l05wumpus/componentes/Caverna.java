package src.pt.c40task.l05wumpus.componentes;

public class Caverna {
    Sala[][] salas;

    public Caverna(Sala[][] salas){
        this.salas = salas;
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
