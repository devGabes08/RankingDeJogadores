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

    private Node menorNo(Node atual) {
        if (atual.getEsquerda() == null) {
            return atual;
        } else {
            return menorNo(atual.getEsquerda());
        }
    }

    private Node remove(Node atual, int ranking) {
        if (atual == null) {
            return null;
        }

        if (ranking < atual.getPlayer().getRanking()) {
            atual.setEsquerda(remove(atual.getEsquerda() , ranking));
        } else if (ranking > atual.getPlayer().getRanking()) {
            atual.setDireita(remove(atual.getDireita() , ranking));
        } else {
            if (atual.getEsquerda() == null && atual.getDireita() == null) {
                return null;
            }

            if (atual.getEsquerda() != null && atual.getDireita() == null) {
                return atual.getEsquerda();
            }

            if (atual.getEsquerda() == null && atual.getDireita() != null) {
                return atual.getDireita();
            } else {
                Node sucessor = menorNo(atual.getDireita());
                atual.setPlayer(sucessor.getPlayer());
                atual.setDireita(remove(atual.getDireita(), sucessor.getPlayer().getRanking()));
            }
        }
        return atual;
    }

    public Player remove(String nome) {
        if (!busca(nome)) {
            return null;
        } else {
            Node encontrado = busca(raiz, nome);
            remove(raiz, encontrado.getPlayer().getRanking());

            return encontrado.getPlayer();
        }
    }
}
