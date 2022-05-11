package src.pt.c40task.l05wumpus.componentes;

public class Brisa extends Sala{
    @Override
    public char apresenta() {
        return revealed ? 'b' : '-';
    }
}
