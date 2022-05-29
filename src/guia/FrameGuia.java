package guia;


import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class FrameGuia extends JFrame{

    public FrameGuia(JFrame frame) {
        super();
        setTitle("Ajuda");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        setLocation((int) frame.getLocation().getX() + frame.getWidth(), (int) frame.getLocation().getY());
        
        
        
        JEditorPane editorPane = new JEditorPane();
        editorPane.setEditable(false);

        java.net.URL helpURL = FrameGuia.class.getResource("ajuda.html");

        if (helpURL != null) {
            try {
                editorPane.setPage(helpURL);
            } catch (IOException e) {
                System.err.println("Attempted to read a bad URL: " + helpURL);
            }
        } else {
            System.err.println("Couldn't find file: TextSamplerDemoHelp.html");
        }

        JScrollPane editorScrollPane = new JScrollPane(editorPane);
        editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        editorScrollPane.setPreferredSize(new Dimension(250, 145));
        editorScrollPane.setMinimumSize(new Dimension(10, 10));
        
        setSize(400, 300);
        add(editorPane);
        setVisible(true);
    }

}
