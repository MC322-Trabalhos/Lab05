# Lab05 - O Mundo de Wumpus
[Arquivos .java](src/pt/c04task/l05wumpus/)
## Detalhes da equipe:
- Curso: Engenharia da Computação
- Nome da equipe: FOXHOUND
- Integrantes:
    - Rafael Gregori de Souza - RA247346
    - Luc Joffily Ribas - RA247231
## Destaques de arquitetura:

### Destaque I:

```
public class Interacao {

  public final String narracao;
  public final int score;

  public Interacao(String narr, int sc){
    narracao = narr;
    score = sc;
  }
  
}
```
No jogo, todas as ações do jogador e interações com os demais componentes possuem uma descrição do ocorrido (de modo que o jogo fique mais interativo) e eventualmente um score associado. Nesse sentido, optamos por criar uma classe que representa a associação entre esses dois dados para que seja possível registrar esses valores e combinar com outros efeitos que podem ter ocorrido na mesma ação. Parte da ideia da implementação desta classe está na estrutura de dados Pair, presente na linguagem C++.  

### Destaque II:

```
public Interacao ocupa(Player jogador){
  ...
  for (Componente comp : componentes) {
    inter = comp.interage(jogador);
    narracao.append(inter.narracao);
    narracao.append("\n");
    scoreTotal += inter.score;
  }
  componentes.add(jogador);
  ...
  return new Interacao(narracao.toString(), scoreTotal);
}
```
Através do polimorfismo é possível que, quando o jogador ocupe uma sala, ele interaja com todos os componentes presentes nela. Cada componente tem uma interação própria implementada em sua respectiva classe, que retorna uma Interação, ou seja, uma string referente à narração do jogo e o score resultante. Dessa maneira, é possível, muito facilmente, adicionar novos componentes numa sala, pois quando ele é adicionado ao ArrayList de componentes, ele automaticamente interagirá com o jogador, assim que este ocupar a sala. Além disso, a interação com todos os componentes fica registrada para que a narração do jogo fique completa e score fique apropriadamente atualizado.

### Destaque III:

```
public abstract class Componente {
  protected char tipo;
  protected int prioridade;

  public int getPrioridade() {return prioridade;}
  public char getTipo() {return tipo;}

  public abstract Interacao interage(Player jogador);

  public Componente clone(){return null;}
  ...
}
```
Esta classe generaliza um componente e suas funcionalidades e atributos básicos. Como esta classe é abstrata, uma instância nunca é feita e portanto fica a cargo das subclasses escolher um tipo e uma prioridade e implementar sua interação com o jogador. Dessa maneira, a criação de novos componentes é simples. Por exemplo, caso alguém quisesse adicionar ao jogo um componente Arsenal, que adiciona uma flecha ao jogador, bastaria herdar esta classe, criar um tipo (ex: `'A'`), atribuir uma prioridade (ex: `3`), implementar no jogador uma função `void adicionaFlecha()` e, por fim, elaborar a função `Interacao interage(Player jogador);` que chamaria a função `adicionaFlecha()` do jogador e retornaria uma certa interação com uma narração (ex: `Você pegou uma flecha`) e um score associado (ex: `-20`).
