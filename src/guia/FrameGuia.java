package guia;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class FrameGuia extends JFrame {

    JEditorPane editorPane;

    public FrameGuia(JFrame frame) {
        super();
        setTitle("Ajuda");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        setLocation((int) frame.getLocation().getX() + frame.getWidth() - 10, (int) frame.getLocation().getY());

        editorPane = new JEditorPane();
        editorPane.setEditable(false);

        trocarPagina("ajuda.html");

        JScrollPane editorScrollPane = new JScrollPane(editorPane);
        editorScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        editorScrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        editorScrollPane.setPreferredSize(new Dimension(500, 600));
        editorScrollPane.setMinimumSize(new Dimension(10, 10));
        
        setSize(500, 600);

        add(editorScrollPane);
        setVisible(true);
    }

    public void trocarPagina(String url) {
        java.net.URL finalURL = FrameGuia.class.getResource("html/" + url);

        if (finalURL != null) {
            try {
                editorPane.setPage(finalURL);
            } catch (IOException e) {
                System.err.println("Attempted to read a bad URL: " + finalURL);
            }
        } else {
            System.err.println("Couldn't find file: TextSamplerDemoHelp.html");
        }
    }

}
