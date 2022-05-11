package src.pt.c40task.l05wumpus.componentes;

public class Ouro extends Sala{
    @Override
    public char apresenta() {
        return revealed ? 'O' : '-';
    }
}
