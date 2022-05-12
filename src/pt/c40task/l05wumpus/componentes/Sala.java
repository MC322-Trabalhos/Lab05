package src.pt.c40task.l05wumpus.componentes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Sala {
	private ArrayList<Componente> componentes = new ArrayList<Componente>();
	private Componente dominante;
    private boolean revelada = false;
	private static Map<Character, Integer> prioridade = Map.of(
		'O', 3,
		'B', 3,
		'W', 3,
		'P', 2,
		'f', 1,
		'b', 0,
		'#', -1
	);

    public void ocupa(Player jogador){
    	for (Componente comp : componentes) {
    		comp.interage(jogador);
    	}
        componentes.add(jogador);
        dominante = componenteDominante();
        revelada = true;
    }
    

    public void desocupa(Player jogador){
        componentes.remove(jogador);
        dominante = componenteDominante();
    }
    
    public void adicionarComponente(Componente comp) {
    	componentes.add(comp);
    	dominante = componenteDominante();
    }

    public char apresenta(){
    	if (!revelada) return '-';
    	if (componentes.size() == 0) return '#';
        return dominante.getTipo();
    }

    public String toString() {
    	if (componentes.size() == 1) return "Voce entrou em uma sala vazia\n";
    	StringBuilder stringBuilder = new StringBuilder();
    	stringBuilder.append("Voce encontrou:\n");
    	for (Componente comp : componentes) {
    		if(comp.getTipo() != 'P') {
    			stringBuilder.append(comp.toString());
    			stringBuilder.append('\n');
    		}
    	}
        return stringBuilder.toString();
    }
    
    
    public Componente componenteDominante() {
    	if (componentes.size() == 0) return null;
    	Componente prioritario = componentes.get(0);
    	for (int i = 1; i < componentes.size(); i++) {
    		if (prioridade.get(componentes.get(i).getTipo()) > prioridade.get(prioritario.getTipo())) {
    			prioritario = componentes.get(i);
    		}
    	}
    	return prioritario;
    }
    
    public Componente getComponente(char tipo) {
    	for (Componente comp : componentes) {
    		if (comp.tipo == 'O') return comp;
    	}
    	return null;
    }
   
    
    public void retirarComponente(Componente comp) {
    	componentes.remove(comp);
    }
}
