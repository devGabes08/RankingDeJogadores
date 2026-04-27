import javax.swing.*;
import java.awt.*;

public class ArvoreVisualizer extends JPanel {
    private ArvoreDeBuscaBinaria arvore;

    public ArvoreVisualizer(ArvoreDeBuscaBinaria arvore) {
        this.arvore = arvore;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("paintComponent chamado, raiz: " + arvore.getRaiz());
        desenharNo(g, arvore.getRaiz(), 6000, 40, 400);

    }

    private void desenharNo(Graphics g, Node no, int x, int y, int espacamento) {
        if (no == null) return;

        g.setColor(new Color(100, 149, 237));
        g.fillOval(x - 20, y - 20, 40, 40);
        g.setColor(Color.WHITE);
        g.drawString("x" + no.getPlayer().getNickName(), x - 15, y + 5);
        g.setColor(Color.BLACK);
        g.drawOval(x - 20, y - 20, 40, 40);
        g.drawOval(x - 20, y - 20, 40, 40);

        g.drawString("x" + no.getPlayer().getNickName(), x - 15, y + 5);

        if (no.getEsquerda() != null) {
            g.drawLine(x, y, x - espacamento, y + 40);
            desenharNo(g, no.getEsquerda(), x - espacamento, y + 40, espacamento * 2 / 3);
        }

        if (no.getDireita() != null) {
            g.drawLine(x, y, x + espacamento, y + 40);
            desenharNo(g, no.getDireita(), x + espacamento, y + 40, espacamento * 2 / 3);
        }
    }
}
