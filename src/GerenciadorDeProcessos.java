
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GerenciadorDeProcessos {

    public ArrayList<ArrayList<Object>> retornarProcessos() {
        try {
            Process process = Runtime.getRuntime().exec("tasklist /NH /FO csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            ArrayList<ArrayList<Object>> processos = new ArrayList();
            
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(",");
                
                ArrayList<Object> dadosFinais = new ArrayList();
                dadosFinais.add(dados[0]);
                dadosFinais.add(dados[1]);
                dadosFinais.add(dados[2]);
                dadosFinais.add(dados[3]);
                dadosFinais.add(dados[4]);
                
                for (int i = 0; i < dadosFinais.size(); i++) {
                    String dado = (String) dadosFinais.get(i);
                    // dadosFinais.set(i, dado.substring(1, dado.length() - 1));
                }
                
                processos.add(dadosFinais);
            }
            
            return processos;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }

}
