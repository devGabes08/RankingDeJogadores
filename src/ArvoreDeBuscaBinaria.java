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

    private Node busca(Node atual, String nome) {
        if (atual == null) {
            return null;
        }

        if (atual.getPlayer().getNickName().equals(nome)) {
            return atual;
        }

        Node resultado = busca(atual.getEsquerda(), nome);

        if (resultado != null) {
            return resultado;
        }
        return busca(atual.getDireita(), nome);
    }

    public boolean busca(String nome) {
        return busca(raiz, nome) != null;
    }
}
