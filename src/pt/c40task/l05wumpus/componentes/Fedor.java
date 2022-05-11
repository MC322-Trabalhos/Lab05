package src.pt.c40task.l05wumpus.componentes;

public class Fedor extends Sala {
    @Override
    public char apresenta() {
        return revealed ? 'f' : '-';
    }
}
