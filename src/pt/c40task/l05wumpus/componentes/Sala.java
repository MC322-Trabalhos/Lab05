package src.pt.c40task.l05wumpus.componentes;

public class Sala {
    protected boolean revealed = false;
    private Componente componente;

    Sala(Componente componente){
        this.componente = componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public char apresenta(){
        return revealed ? componente.apresenta() : '-';
    }
}
