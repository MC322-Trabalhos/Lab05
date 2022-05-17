package src.pt.c40task.l05wumpus.componentes;

public interface ComponenteComEfeito {
    public static void colocarEfeito(int i, int j, Caverna caverna, Componente efeito){
		if (i - 1 >= 0) {
			caverna.adicionaComponenteNaSala(i - 1, j, efeito.clone());
		}
		if (i + 1 < 4) {
			caverna.adicionaComponenteNaSala(i + 1, j, efeito.clone());
		}
		if (j - 1 >= 0) {
			caverna.adicionaComponenteNaSala(i, j - 1, efeito.clone());
		}
		if (j + 1 < 4) {
			caverna.adicionaComponenteNaSala(i, j + 1, efeito.clone());
		}
	}
}