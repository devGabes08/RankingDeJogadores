import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ArvoreDeBuscaBinaria arvore = new ArvoreDeBuscaBinaria();
        CSVReader csv = new CSVReader();

        csv.carregar("players.csv", arvore);

        JFrame frame = new JFrame("Ranking de Jogadores");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2000, 1200);
        ArvoreVisualizer visualizer = new ArvoreVisualizer(arvore);
        visualizer.setPreferredSize(new Dimension(8000, 5000));
        JScrollPane scroll = new JScrollPane(visualizer);
        frame.add(scroll);
        frame.setVisible(true);


        System.out.println(arvore.busca("KDA_Kitsune"));
        System.out.println(arvore.busca("Inexistente"));
        System.out.println(arvore.remove("KDA_Kitsune").getNickName());
        System.out.println(arvore.busca("KDA_Kitsune"));
    }
}
