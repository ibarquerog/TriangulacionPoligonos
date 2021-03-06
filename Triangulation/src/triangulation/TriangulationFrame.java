package triangulation;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author josep
 */
public class TriangulationFrame extends javax.swing.JFrame {
    View view;
    int vertices=0;
    public TriangulationFrame() {    
        view  =new View();
        initComponents();
        this.add(view);
        this.pack();      
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        input = new javax.swing.JTextField();
        generateBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        openFileBtn = new javax.swing.JButton();
        triangulateBtn = new javax.swing.JButton();
        increaseBtn = new javax.swing.JButton();
        decreaseBtn = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ear Clipping Polygon Triangulation");
        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(102, 102, 102));
        setMinimumSize(new java.awt.Dimension(1000, 750));
        setName("mainFrame"); // NOI18N
        setSize(this.view.getWidth()+1,this.view.getHeight()+1);

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel1.setText("Points");
        jLabel1.setToolTipText("");

        input.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 204), 2, true));
        input.setCaretColor(new java.awt.Color(255, 255, 255));
        input.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        generateBtn.setText("Generate");
        generateBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 204), 2, true));
        generateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBtnActionPerformed(evt);
            }
        });

        jButton1.setText("Clear Canvas");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 204), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        openFileBtn.setText("Open Image");
        openFileBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 204), 2));
        openFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileBtnActionPerformed(evt);
            }
        });

        triangulateBtn.setText("Triangulate");
        triangulateBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 204), 2));
        triangulateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triangulateBtnActionPerformed(evt);
            }
        });

        increaseBtn.setText("Increase canvas size");
        increaseBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 204), 2));
        increaseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseBtnActionPerformed(evt);
            }
        });

        decreaseBtn.setText("Decrease canvas size");
        decreaseBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 204), 2));
        decreaseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(openFileBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                    .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(generateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(triangulateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(increaseBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(decreaseBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(generateBtn)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(triangulateBtn)
                .addGap(18, 18, 18)
                .addComponent(openFileBtn)
                .addGap(18, 18, 18)
                .addComponent(increaseBtn)
                .addGap(18, 18, 18)
                .addComponent(decreaseBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(531, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(282, Short.MAX_VALUE))
        );

        setBounds(0, 0, 830, 612);
    }// </editor-fold>//GEN-END:initComponents
    
    private void generateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBtnActionPerformed
        // TODO add your handling code here:
        try{
            if(this.input.getText().length() == 0){
                JOptionPane.showMessageDialog(null, "Input a number please.");
            }else if(Integer.parseInt(this.input.getText()) <3){
                JOptionPane.showMessageDialog(null, "Input a number please greater or equal to 3");
            }else{
               int pointsInput = Integer.parseInt(this.input.getText());
               this.view.generatePoints(pointsInput);
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error in the input.");
        }
    }//GEN-LAST:event_generateBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.remove(view);
        this.repaint();
        this.view = new View();
        this.add(view);
        this.pack();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void triangulateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triangulateBtnActionPerformed
        // TODO add your handling code here:
        this.view.triangulatePolygon();
        repaint();
    }//GEN-LAST:event_triangulateBtnActionPerformed

    private void openFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileBtnActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChoose = new JFileChooser();
        fileChoose.showOpenDialog(this);
        String selectedPath = fileChoose.getSelectedFile().getPath();
        System.out.println("Selected file path: "+selectedPath);
        try {
            BufferedImage img = ImageIO.read(new File(selectedPath));
            this.remove(view);
            this.repaint();
            this.view = new View(img);
            this.add(view);
            this.setSize(view.getWidth()+10,view.getHeight()+10);
            this.pack();
        } catch (IOException ex) {
            Logger.getLogger(TriangulationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NullPointerException x){
            JOptionPane.showMessageDialog(null,"No file selected.");
        }
        
    }//GEN-LAST:event_openFileBtnActionPerformed

    private void increaseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseBtnActionPerformed
        // TODO add your handling code here:
        this.view.setSize(view.getWidth()+10, view.getHeight()+10);
        this.setSize(this.getWidth()+10, this.getHeight()+10); 
        this.add(view);
        this.repaint();
    }//GEN-LAST:event_increaseBtnActionPerformed

    private void decreaseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseBtnActionPerformed
        // TODO add your handling code here:
        this.view.setSize(view.getWidth()-10, view.getHeight()-10);
        this.setSize(this.getWidth()-10, this.getHeight()-10);  
        this.add(view);
        this.repaint();
    }//GEN-LAST:event_decreaseBtnActionPerformed

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputActionPerformed

    public static void main(String args[]) {
        /* Set the Darcula look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Darcula (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TriangulationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TriangulationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TriangulationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TriangulationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TriangulationFrame framy =new TriangulationFrame();
                framy.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton decreaseBtn;
    private javax.swing.JButton generateBtn;
    private javax.swing.JButton increaseBtn;
    private javax.swing.JTextField input;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton openFileBtn;
    private javax.swing.JButton triangulateBtn;
    // End of variables declaration//GEN-END:variables
}
