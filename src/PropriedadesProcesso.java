
import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;


public class PropriedadesProcesso {

    Icon icone;
    String nome;
    int pid;
    
    ProcessHandle.Info propriedades;
    
    
    public PropriedadesProcesso(String nome, int pid, ProcessHandle.Info propriedades) {
        this.nome = nome;
        this.pid = pid;
        
        this.propriedades = propriedades;
        
        carregaIcone();
    }

    public Icon getIcone() {
        return icone;
    }

    public String getNome() {
        return nome;
    }

    public int getPid() {
        return pid;
    }

    public ProcessHandle.Info getPropriedades() {
        return propriedades;
    }
    
    private void carregaIcone() {
        
        if (propriedades.command().isEmpty())
            return;
        
        String caminho = propriedades.command().get();
        icone  = FileSystemView.getFileSystemView()
         .getSystemIcon(new File(caminho));
    }
    
}
