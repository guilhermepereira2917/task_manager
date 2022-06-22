
import guia.FrameGuia;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;

public class FrameProcessos extends javax.swing.JInternalFrame {

    FrameGuia frameGuia;

    public FrameProcessos(FrameGuia frameGuia) {
        initComponents();

        this.frameGuia = frameGuia;

        // Thread que atualiza os processo na tela
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        atualizar();
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }.start();

        tabela.getTableHeader().addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    Point point = evt.getPoint();
                    int colunaClicada = tabela.columnAtPoint(point);
                    
                    String pagina = null;
                    
                    switch (colunaClicada) {
                        case 0:
                            pagina = "pid.html";
                            break;
                        case 1:
                            pagina = "nome.html";
                            break;
                        case 2:
                            pagina = "cpu.html";
                            break;
                        case 3:
                            pagina = "memoria.html";
                            break;
                    }
                    
                    if (pagina == null)
                        return;
                    
                    frameGuia.trocarPagina(pagina);
                }
            }
        );
    }

    public synchronized void atualizar() {
        ArrayList<ArrayList<Object>> processos = GerenciadorDeProcessos.retornarProcessos();

        DefaultTableModel tableModel = (DefaultTableModel) tabela.getModel();
        tableModel.setRowCount(processos.size());
        tabela.setModel(tableModel);

        setupPopup();
        tabela.setComponentPopupMenu(popupProcesso);

        for (int i = 0; i < processos.size(); i++) {
            for (int j = 0; j < processos.get(i).size(); j++) {
                tabela.getModel().setValueAt(processos.get(i).get(j), i, j);
            }
        }
    }

    public int retornaPIDSelecionado() {
        int linhaSelecionada = tabela.getSelectedRow();
        int colunaPID = 0;

        return Integer.parseInt((String) tabela.getValueAt(linhaSelecionada, colunaPID));
    }

    public String retornaNomeSelecionado() {
        int linhaSelecionada = tabela.getSelectedRow();
        int colunaNome = 1;

        return (String) tabela.getValueAt(linhaSelecionada, colunaNome);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupProcesso = new javax.swing.JPopupMenu();
        menuEncerrar = new javax.swing.JMenuItem();
        menuPropriedades = new javax.swing.JMenuItem();
        buttonAtualizar = new javax.swing.JButton();
        scroll1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        buttonAtualizar1 = new javax.swing.JButton();
        scroll2 = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        barraDeMenu1 = new javax.swing.JMenuBar();
        barraDeMenu = new javax.swing.JMenuBar();

        menuEncerrar.setText("Encerrar");
        menuEncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEncerrarActionPerformed(evt);
            }
        });
        popupProcesso.add(menuEncerrar);

        menuPropriedades.setText("Propriedades");
        menuPropriedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPropriedadesActionPerformed(evt);
            }
        });
        popupProcesso.add(menuPropriedades);

        setIconifiable(true);
        setTitle("Lista de Processos");

        buttonAtualizar.setText("Atualizar");
        buttonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtualizarActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PID", "Nome", "Tempo de CPU", "Uso de Memória", "Sessão", "Usuário", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        scroll1.setViewportView(tabela);

        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setTitle("Lista de Processos");

        buttonAtualizar1.setText("Atualizar");
        buttonAtualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtualizar1ActionPerformed(evt);
            }
        });

        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PID", "Nome", "Tempo de CPU", "Uso de Memória", "Sessão", "Usuário", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela1MouseClicked(evt);
            }
        });
        scroll2.setViewportView(tabela1);

        jInternalFrame1.setJMenuBar(barraDeMenu1);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonAtualizar1))
                    .addComponent(scroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonAtualizar1)
                .addContainerGap())
        );

        setJMenuBar(barraDeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonAtualizar))
                    .addComponent(scroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAtualizar)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 191, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 192, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtualizarActionPerformed
        atualizar();
    }//GEN-LAST:event_buttonAtualizarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        frameGuia.trocarPagina("lista.html");
    }//GEN-LAST:event_tabelaMouseClicked

    private void menuEncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEncerrarActionPerformed
        GerenciadorDeProcessos.encerrarProcesso(retornaPIDSelecionado());
    }//GEN-LAST:event_menuEncerrarActionPerformed

    private void menuPropriedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPropriedadesActionPerformed
        PropriedadesProcesso propriedadesProcesso
                = GerenciadorDeProcessos.retornarPropriedadesProcesso(retornaPIDSelecionado(), retornaNomeSelecionado());

        if (propriedadesProcesso == null) {
            JOptionPane.showMessageDialog(this, "Não é possível abrir as propriedades desse processo.", "Processo Inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        FramePropriedades framePropriedades = new FramePropriedades(propriedadesProcesso);
        framePropriedades.setVisible(true);

        getParent().add(framePropriedades);
    }//GEN-LAST:event_menuPropriedadesActionPerformed

    private void buttonAtualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtualizar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAtualizar1ActionPerformed

    private void tabela1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabela1MouseClicked

    public void setupPopup() {
        popupProcesso.addPopupMenuListener(new PopupMenuListener() {

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        int rowAtPoint = tabela.rowAtPoint(SwingUtilities.convertPoint(popupProcesso, new Point(0, 0), tabela));
                        if (rowAtPoint > -1) {
                            tabela.setRowSelectionInterval(rowAtPoint, rowAtPoint);
                        }
                    }
                });
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                // TODO Auto-generated method stub

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraDeMenu;
    private javax.swing.JMenuBar barraDeMenu1;
    private javax.swing.JButton buttonAtualizar;
    private javax.swing.JButton buttonAtualizar1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenuItem menuEncerrar;
    private javax.swing.JMenuItem menuPropriedades;
    private javax.swing.JPopupMenu popupProcesso;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JScrollPane scroll2;
    private javax.swing.JTable tabela;
    private javax.swing.JTable tabela1;
    // End of variables declaration//GEN-END:variables
}
