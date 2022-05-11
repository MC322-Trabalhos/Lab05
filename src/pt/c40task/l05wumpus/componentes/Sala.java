package src.pt.c40task.l05wumpus.componentes;

public class Sala {
    protected boolean revealed = true;

    public char apresenta(){
        return revealed ? '#' : '-';
    }
}
