
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class FramePropriedades extends javax.swing.JInternalFrame {

    PropriedadesProcesso propriedadesProcesso;
    ProcessHandle.Info infoProcesso;

    public FramePropriedades(PropriedadesProcesso propriedadesProcesso) {
        initComponents();

        this.propriedadesProcesso = propriedadesProcesso;
        this.infoProcesso = propriedadesProcesso.getPropriedades();

        atualizar();
        
        requestFocusInWindow();
        DesktopFrame.frameGuia.trocarPagina("propriedades.html");
    }

    final public void atualizar() {

        setTitle("Propriedades de " + propriedadesProcesso.getNome());
        
        labelPID.setText(String.valueOf(propriedadesProcesso.getPid()));
        labelNome.setText(propriedadesProcesso.getNome());
        
        if (infoProcesso.arguments().isPresent()) {
            labelArgumentos.setText(formataArray(infoProcesso.arguments()));
        } else {
            labelArgumentos.setText("");
        }

        /*
        if (infoProcesso.command().isPresent()) {
            labelNome.setText(infoProcesso.command().get());
        } else {
            labelNome.setText("");
        }
        */

        if (infoProcesso.command().isPresent()) {
            labelExecutavel.setText(infoProcesso.command().get());
        } else {
            labelExecutavel.setText("");
        }

        if (infoProcesso.startInstant().isPresent()) {
            labelTempo.setText(formataData(infoProcesso.startInstant().get()));
        } else {
            labelTempo.setText("");
        }

        if (infoProcesso.totalCpuDuration().isPresent()) {
            labelCPU.setText(formataHora(infoProcesso.totalCpuDuration().get()));
        } else {
            labelCPU.setText("");
        }

        if (infoProcesso.user().isPresent()) {
            labelUsuario.setText(infoProcesso.user().get());
        } else {
            labelUsuario.setText("");
        }

        
        if (propriedadesProcesso.getIcone() != null)
            setFrameIcon(propriedadesProcesso.getIcone());
    }
    
    private static final String PADRAO_DATA = "HH:mm dd/MM/yyyy";

    private String formataData(Instant tempo) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PADRAO_DATA)
                .withZone(ZoneId.systemDefault());

        String tempoFormatado = formatter.format(tempo);

        return tempoFormatado;
    }

    private String formataHora(Duration tempo) {
        return String.format("%02d:%02d:%02d", tempo.toHours(), tempo.toMinutes(), tempo.toSeconds());
    }

    public String formataArray(Optional<String[]> array) {

        String resultado = "";

        if (array.isEmpty()) {
            return resultado;
        }

        String[] strings = array.get();

        for (int i = 0; i < strings.length; i++) {
            resultado += strings[i] + "\n";
        }

        return resultado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContainer = new javax.swing.JPanel();
        txtPID = new javax.swing.JLabel();
        txtNome = new javax.swing.JLabel();
        txtArgumentos = new javax.swing.JLabel();
        txtExecutavel = new javax.swing.JLabel();
        txtTempo = new javax.swing.JLabel();
        txtCPU = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        labelPID = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        labelArgumentos = new javax.swing.JLabel();
        labelExecutavel = new javax.swing.JLabel();
        labelTempo = new javax.swing.JLabel();
        labelCPU = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();

        setClosable(true);

        panelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtPID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtPID.setText("PID:");
        txtPID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtPID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPIDMouseClicked(evt);
            }
        });

        txtNome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNome.setText("Nome:");
        txtNome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNomeMouseClicked(evt);
            }
        });

        txtArgumentos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtArgumentos.setText("Argumentos:");
        txtArgumentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtArgumentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtArgumentosMouseClicked(evt);
            }
        });

        txtExecutavel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtExecutavel.setText("Caminho do Executável:");
        txtExecutavel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtExecutavel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtExecutavelMouseClicked(evt);
            }
        });

        txtTempo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTempo.setText("Instante do Início:");
        txtTempo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtTempo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTempoMouseClicked(evt);
            }
        });

        txtCPU.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCPU.setText("Tempo de CPU:");
        txtCPU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtCPU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCPUMouseClicked(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtUsuario.setText("Usuário:");
        txtUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsuarioMouseClicked(evt);
            }
        });

        labelPID.setText("PID:");

        labelNome.setText("Nome:");

        labelArgumentos.setText("Argumentos:");

        labelExecutavel.setText("Caminho do Executável:");

        labelTempo.setText("Instante do Início:");

        labelCPU.setText("Tempo de CPU:");

        labelUsuario.setText("Usuário:");

        javax.swing.GroupLayout panelContainerLayout = new javax.swing.GroupLayout(panelContainer);
        panelContainer.setLayout(panelContainerLayout);
        panelContainerLayout.setHorizontalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContainerLayout.createSequentialGroup()
                        .addComponent(txtPID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelContainerLayout.createSequentialGroup()
                        .addComponent(txtNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelContainerLayout.createSequentialGroup()
                        .addComponent(txtCPU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCPU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelContainerLayout.createSequentialGroup()
                        .addComponent(txtArgumentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelArgumentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelContainerLayout.createSequentialGroup()
                        .addComponent(txtExecutavel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelExecutavel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                    .addGroup(panelContainerLayout.createSequentialGroup()
                        .addComponent(txtTempo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelContainerLayout.createSequentialGroup()
                        .addComponent(txtUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelContainerLayout.setVerticalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPID)
                    .addComponent(labelPID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome)
                    .addComponent(labelNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArgumentos)
                    .addComponent(labelArgumentos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExecutavel)
                    .addComponent(labelExecutavel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTempo)
                    .addComponent(labelTempo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCPU)
                    .addComponent(labelCPU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario)
                    .addComponent(labelUsuario))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPIDMouseClicked
        DesktopFrame.frameGuia.trocarPagina("pid.html");
    }//GEN-LAST:event_txtPIDMouseClicked

    private void txtNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNomeMouseClicked
        DesktopFrame.frameGuia.trocarPagina("nome.html");
    }//GEN-LAST:event_txtNomeMouseClicked

    private void txtCPUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCPUMouseClicked
       DesktopFrame.frameGuia.trocarPagina("cpu.html");
    }//GEN-LAST:event_txtCPUMouseClicked

    private void txtUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMouseClicked
        DesktopFrame.frameGuia.trocarPagina("sessao.html");
    }//GEN-LAST:event_txtUsuarioMouseClicked

    private void txtArgumentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtArgumentosMouseClicked
        DesktopFrame.frameGuia.trocarPagina("argumentos.html");
    }//GEN-LAST:event_txtArgumentosMouseClicked

    private void txtExecutavelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExecutavelMouseClicked
        DesktopFrame.frameGuia.trocarPagina("caminho.html");
    }//GEN-LAST:event_txtExecutavelMouseClicked

    private void txtTempoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTempoMouseClicked
        DesktopFrame.frameGuia.trocarPagina("inicio.html");
    }//GEN-LAST:event_txtTempoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelArgumentos;
    private javax.swing.JLabel labelCPU;
    private javax.swing.JLabel labelExecutavel;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelPID;
    private javax.swing.JLabel labelTempo;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panelContainer;
    private javax.swing.JLabel txtArgumentos;
    private javax.swing.JLabel txtCPU;
    private javax.swing.JLabel txtExecutavel;
    private javax.swing.JLabel txtNome;
    private javax.swing.JLabel txtPID;
    private javax.swing.JLabel txtTempo;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
