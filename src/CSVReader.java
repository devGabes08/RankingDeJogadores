import java.io.BufferedReader;
import java.io.FileReader;

public class CSVReader {

    public void carregar(String caminho, ArvoreDeBuscaBinaria arvore) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(caminho));


            br.readLine();

            Stack<String> pilha = new Stack<>();
            String linha = br.readLine();

            while (linha != null) {
                pilha.push(linha);
                linha = br.readLine();
            }

            while (!pilha.isEmpty()) {
                linha = pilha.pop();
                System.out.println(linha);
                String[] partes = linha.split(",");

                arvore.insercao(new Player(partes[0], Integer.parseInt(partes[1])));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
