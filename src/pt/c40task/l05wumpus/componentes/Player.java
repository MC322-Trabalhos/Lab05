package src.pt.c40task.l05wumpus.componentes;

import src.pt.c40task.l05wumpus.utils.Acao;
import src.pt.c40task.l05wumpus.utils.Interacao;

public class Player extends Componente{
    private final String nome;
    private boolean flechaEquipada = false, flechaAtirada = false,vivo = true, escapou = false;
    private int numFlechas = 1;
    private int[] pos;
    private boolean pegouOuro = false;
    private boolean tentaCapturarOuro = false;

    public Player(String nome) {
        this.nome = nome;
        pos = new int[]{0, 0};
        tipo = 'P';
        prioridade = 2;
    }

    public void equipaFlecha() {
        if (!flechaEquipada && numFlechas > 0) {
            this.flechaEquipada = true;
            numFlechas--;
        }
    }

    public Interacao agir(Acao acao){
    	
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
            case ARROW:
            	equipaFlecha();
            	if (flechaEquipada) return new Interacao("Voce equipa uma flecha...\n", 0);
            	else return new Interacao("Nao ha flechas restantes!\n", 0);
            case CAPTURE:
            	tentaCapturarOuro = true;
            	String resultadoOuro = "";
            	if (pegouOuro){
            		resultadoOuro = "Voce ja pegou o ouro!\n";
            		tentaCapturarOuro = false;
            	}
            	return new Interacao("Voce tenta capturar o Ouro...\n" + resultadoOuro, 0);
            case QUIT:
            	return new Interacao("Volte sempre!\n", 0);
            default:
            	return new Interacao("Tecla inv�lida!\n", 0);
        }
        String finalNarracao = "";
        int finalScore = -15;
        if (flechaAtirada) flechaAtirada = false;
        if (flechaEquipada) {
        	flechaEquipada = false;
        	flechaAtirada = true;
        	finalNarracao += "Voce atirou sua flecha!\n";
            finalScore -= 100;
        }
    	if (tentaCapturarOuro && pegouOuro == false) {
    		finalNarracao += "O Ouro nao estava naquela sala!\n"; 
    		tentaCapturarOuro = false;
    	}
        if (temOuro() && pos[0] == 0 && pos[1] == 0) {
    		escapar();
    		finalNarracao += "Voce escapou da caverna!\n";
            finalScore += 1000;
    	}
        return new Interacao(finalNarracao, finalScore);
    }

    public int[] getPos() {
        return pos;
    }

    public boolean isFlechaAtirada() {
        return flechaAtirada;
    }

    public String getNome() {
        return nome;
    }

    public char apresenta() {
        return 'P';
    }
    
    public boolean tentouCapturarOuro() {
    	return tentaCapturarOuro;
    }
    
    public void capturarOuro() {
    	pegouOuro = true;
    }
    
    public boolean temOuro() {
    	return pegouOuro;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void morre() {
        vivo = false;
    }
    
    public void escapar() {
    	escapou = true;
    }
    
    public boolean hasEscaped() {
    	return escapou;
    }

    @Override
    public Interacao interage(Player jogador) {
    	return null;
    }
}
