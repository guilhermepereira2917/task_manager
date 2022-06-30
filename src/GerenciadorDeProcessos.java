
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Optional;

public class GerenciadorDeProcessos {

    public static ArrayList<ArrayList<Object>> retornarProcessos() {
        try {
            Process process = Runtime.getRuntime().exec("tasklist /NH /FO csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            ArrayList<ArrayList<Object>> processos = new ArrayList();

            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split("\",\"");

                // Remove as aspas duplas
                dados[0] = dados[0].substring(1, dados[0].length());
                dados[4] = dados[4].substring(0, dados[4].length() - 1);

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

    public static void encerrarProcesso(int pid) {
        try {
            Runtime.getRuntime().exec("taskkill /PID " + pid);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static PropriedadesProcesso retornarPropriedadesProcesso(int pid, String nome) {
        Optional<ProcessHandle> optional = ProcessHandle.of(pid);
        
        if (optional.isEmpty()) {
            return null;
        }
        
        PropriedadesProcesso propriedadesProcesso = new PropriedadesProcesso(nome, pid, ((ProcessHandle) optional.get()).info());
        return propriedadesProcesso;
    }
    
}
