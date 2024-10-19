
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author 50488
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        hashtagField = new javax.swing.JTextField();
        xd = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultsArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        hashtagField.setText("jTextField1");

        xd.setText("buscar");
        xd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xdMouseClicked(evt);
            }
        });

        jButton2.setText("volver");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        resultsArea.setColumns(20);
        resultsArea.setRows(5);
        jScrollPane1.setViewportView(resultsArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(173, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(hashtagField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(xd)
                        .addGap(152, 152, 152)
                        .addComponent(jButton2)
                        .addGap(205, 205, 205))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(hashtagField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xd)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void xdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xdMouseClicked
String hashtag = hashtagField.getText().trim();
if (hashtag.isEmpty()) {
    JOptionPane.showMessageDialog(this, "El hashtag no puede estar vacío.");
    return;
}

// Obtener los tweets que contienen el hashtag
String[] tweetsConHashtag = obtenerTweetsConHashtag(hashtag);

// Mostrar los tweets en el área de texto
if (tweetsConHashtag.length == 0) {
    resultsArea.setText("No se encontraron tweets con el hashtag #" + hashtag);
} else {
    resultsArea.setText("Tweets con el hashtag #" + hashtag + ":\n\n");
    for (String tweet : tweetsConHashtag) {
        resultsArea.append(tweet + "\n\n");
    }
}    
    }//GEN-LAST:event_xdMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        menu_principal xd = new menu_principal();
        xd.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton2MouseClicked
public String[] obtenerTweetsConHashtag(String hashtag) {
    // Estimar un tamaño máximo para los resultados
    final int MAX_TWEETS = 1000;
    String[] resultados = new String[MAX_TWEETS];
    int contadorResultados = 0;

    // Iterar sobre todos los usuarios
    for (int i = 0; i < UsuarioInfo.getContador(); i++) {
        UsuarioInfo usuario = UsuarioInfo.getCuenta(i);
        if (usuario.isCuentaActiva()) { // Solo procesar usuarios con cuenta activa
            Twit[] twits = usuario.obtenerTwits();
            for (Twit twit : twits) {
                if (twit.getContenido().contains("#" + hashtag)) {
                    if (contadorResultados < MAX_TWEETS) {
                        resultados[contadorResultados] = twit.toString();
                        contadorResultados++;
                    }
                }
            }
        }
    }

    // Convertir el arreglo a un tamaño exacto
    String[] tweetsFiltrados = new String[contadorResultados];
    System.arraycopy(resultados, 0, tweetsFiltrados, 0, contadorResultados);

    return tweetsFiltrados;
}
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField hashtagField;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea resultsArea;
    private javax.swing.JButton xd;
    // End of variables declaration//GEN-END:variables
}