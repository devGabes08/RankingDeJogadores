public class ArvoreDeBuscaBinaria {
    private Node raiz;

    public ArvoreDeBuscaBinaria() {
        this.raiz = null;
    }

    public void insercao(Player player) {
        raiz = insercao(raiz, player);
    }

    private Node insercao(Node atual, Player player) {
        if (atual == null) {
            return new Node(player);
        }

        if (player.getRanking() < atual.getPlayer().getRanking()) {
            atual.setEsquerda(insercao(atual.getEsquerda(), player));
        } else if (player.getRanking() > atual.getPlayer().getRanking()) {
            atual.setDireita(insercao(atual.getDireita(), player));
        }
        return atual;
    }
}
