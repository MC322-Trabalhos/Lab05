package src.pt.c40task.l05wumpus.componentes;
import java.util.ArrayList;
import java.util.Map;

import src.pt.c40task.l05wumpus.utils.Interacao;


public class Sala {
	private ArrayList<Componente> componentes = new ArrayList<>();
	private ArrayList<Componente> compAEliminar = new ArrayList<>();
	private Componente dominante;
    private boolean revelada = false;
	private static final Map<Character, Integer> prioridade = Map.of(
		'O', 3,
		'B', 3,
		'W', 3,
		'P', 2,
		'f', 1,
		'b', 0,
		'#', -1
	);

    public Interacao ocupa(Player jogador){
    	int scoreTotal = 0;
    	Interacao inter = new Interacao();
    	StringBuilder narracao = new StringBuilder();
    	for (Componente comp : componentes) {
    		inter = comp.interage(jogador);
    		narracao.append(inter.narracao);
    		narracao.append("\n");
    		scoreTotal += inter.score;
    	}
        componentes.add(jogador);
        removerComponentes();
        dominante = componenteDominante();
        revelada = true;
        return new Interacao(narracao.toString(), scoreTotal);
    }
    

    public void desocupa(Player jogador){
        componentes.remove(jogador);
        dominante = componenteDominante();
    }
    
    public boolean adicionarComponente(Componente comp) {
		if (dominante != null && prioridade.get(comp.tipo) == 3 && prioridade.get(dominante.tipo) == 3) return false;
    	componentes.add(comp);
		dominante = componenteDominante();
		return true;
    }

    public char apresenta(){
    	if (!revelada) return '-';
    	if (componentes.size() == 0) return '#';
		return dominante.getTipo();
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
    		if (comp.tipo == tipo) return comp;
    	}
    	return null;
    }
   
    
    public void excluirComponenteTardio(Componente comp) {
    	compAEliminar.add(comp);
    }
    
    public void removerComponentes() {
    	for (Componente comp : compAEliminar) {
    		componentes.remove(comp);
    	}
    	compAEliminar.clear();
    }
}
