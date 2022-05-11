package src.pt.c40task.l05wumpus.componentes;

public class Buraco extends Sala{

    @Override
    public char apresenta() {
        return revealed ? 'B' : '-';
    }
}
