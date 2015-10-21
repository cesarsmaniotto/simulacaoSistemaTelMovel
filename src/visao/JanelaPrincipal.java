/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ProgressoSimulacao;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Estado;
import modelo.HistoricoEstados;
import modelo.InformacoesLogica;
import modelo.distribuicao.Distribuicao;
import modelo.evento.Evento;

/**
 *
 * @author rr
 */
public class JanelaPrincipal extends javax.swing.JFrame implements Observer{

    /**
     * Creates new form JanelaPrincipal
     */
    private Distribuicao ds;
    private ProgressoSimulacao ps;
    private FormTEC  ftc;
    private FormDuracaoChamada fdc1,fdc2;
    private FormProporcaoTipoChamada fpt;
    private FormRelatorio fr;
    public boolean definido = false;
    public boolean pausado = false;
    private int indiceTable;
    public int velocidade = 1000;
    //impedir de iniciar caso ds seja null

    public JanelaPrincipal() {
        initComponents();
        ps = new ProgressoSimulacao();
    }    
    
    public double getTEC1(){
        return ftc.getTECC1();
    }
    public double getTEC2(){
        return ftc.getTECC2();
    }
    public Distribuicao getDistriuicaoChamadasC1(){
        return fdc1.getDistribuicao();
    }
    public Distribuicao getDistriuicaoChamadasC2(){
        return fdc2.getDistribuicao();
    }
    public FormProporcaoTipoChamada getProporcao(){
        return fpt;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane9 = new javax.swing.JTabbedPane();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jButton2.setText("Pausar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Continuar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton6.setText("Iniciar");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        jTextField2.setText("Definir tempo de simulação, proporção de ligações e duração de chamadas");

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Identificador", "Tipo Evento", "Duração", "Ocupação C1", "Ocupação C2", "Tempo atual"
            }
        ));
        table.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(table);

        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel1.setText("Velocidade");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPane9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane9.addTab("Proporção Chamadas", jPanel17);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane9.addTab("Tempo entre Chamadas", jPanel18);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane9.addTab("Duração chamadas C1", jPanel19);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane9.addTab("Duração chamadas C2", jPanel20);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane9.addTab("Relatório", jPanel21);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTabbedPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton6))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jTabbedPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton6))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(jScrollPane2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        //verificar se todos os objetos foram instanciados para poder iniciar a bagaça
        String msg = "";      
        
        try {/*
            if (fdc1 == null || !fdc1.estaDefinido() || fdc2 == null || !fdc2.estaDefinido()) {
                msg += "Defina a duração de chamadas. ";
            }
            if (fpt == null || !fpt.estaDefinido()) {
                msg += "Defina a proporção dos tipos de chamada e tempo de simulação. ";
            }
            if (ftc == null || !fpt.estaDefinido()) {
                msg += "Defina o tempo entre chamadas.";
            }
            if (fpt.estaDefinido() && fdc1.estaDefinido() && ftc.estaDefinido() && fdc2.estaDefinido()) {
                msg += "Iniciando simulacao";
                definido = true;
            }
            */
            
            definido = true;
            
            
            
            jTextField2.setText(msg);
        } catch (NullPointerException e) {       
            jTextField2.setText("define");
            
            
        }


    }//GEN-LAST:event_jButton6MouseClicked
        
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        pausado = true;
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        ps.notifyObservers(false);
        pausado = false;
    }//GEN-LAST:event_jButton3MouseClicked
    
    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        if(!jSlider1.getValueIsAdjusting()){
            velocidade = 1400-jSlider1.getValue()*10;
        }
    }//GEN-LAST:event_jSlider1StateChanged

    private void jTabbedPane9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane9MouseClicked
        int opt = jTabbedPane9.getSelectedIndex();
        switch(opt){
            case 0:
            fpt = new FormProporcaoTipoChamada();
            fpt.setVisible(true);
            break;
            case 1:
            ftc = new FormTEC();
            ftc.setVisible(true);
            break;
            case 2:
            fdc1 = new FormDuracaoChamada();
            fdc1.setVisible(true);
            break;
            case 3:
            fdc2 = new FormDuracaoChamada();
            fdc2.setVisible(true);
            break;
            case 4:
                if(guia != null){
                    guia.setVisible(true);
                }
            break;
            default:
            break;

        }
    }//GEN-LAST:event_jTabbedPane9MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTabbedPane jTabbedPane9;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("chegou");
        boolean infoEstado = false;
        DefaultTableModel model= (DefaultTableModel)table.getModel();
        Object[] linha;        
        InformacoesLogica il;
        Evento evento;/*
        if(arg instanceof Estado && !pausado){
            estado = (Estado) arg;
            infoEstado = true;
            linha = new Object[]{indiceTable,"DEFINIR", "DEFINIR",estado.getOcupacaoCanal("C1"),estado.getOcupacaoCanal("C2"),estado.getTempoInicio().toString()};
            model.insertRow(indiceTable, linha);
            indiceTable++;
        }*/
        if(arg instanceof InformacoesLogica && !pausado){
            il = (InformacoesLogica) arg;
            linha = new Object[]{indiceTable,il.getInfoEvento()[0],il.getInfoEvento()[1],il.getInfoEstado()[0],il.getInfoEstado()[1],il.getInfoEstado()[2]};
            model.insertRow(indiceTable, linha);
            indiceTable++;
        }
    }

    public void adicionarObservadorProgresso(Observer ob) {
        ps.addObserver(ob);
    }
    Guia guia;
    public void gerarRelatorio(String s, float[] eixoX, float[] eixoY){
        guia = new Guia();
        guia.setRelatorio(s);
        
    }
}
