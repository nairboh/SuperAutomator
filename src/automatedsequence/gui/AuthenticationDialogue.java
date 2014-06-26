package automatedsequence.gui;

import automatedsequence.Timer;
import java.awt.Color;
import java.util.Arrays;

/**
 * Purpose: Authentication Dialogue (accepts password form user before launching
 * main program)
 *
 * @author Brian Ho, Max Romanoff, Conor Norman 
 * June 5 2014
 */
public class AuthenticationDialogue extends javax.swing.JFrame {

    private final char[] PASSWORD = new char[]{'s', 't', 'm', 'a', 'x'};
    private static MainProgram mainProgram;
    private static Timer timer;

    /**
     * Creates new form AuthenticationDialogue
     */
    public AuthenticationDialogue() {
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

        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        submitPasswordButton = new javax.swing.JButton();
        instructionalText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Authentication");
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        passwordLabel.setText("Password");

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        submitPasswordButton.setText("Start Program");
        submitPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitPasswordButtonActionPerformed(evt);
            }
        });

        instructionalText.setText("Please enter your password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(221, Short.MAX_VALUE)
                        .addComponent(submitPasswordButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(instructionalText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(passwordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passwordField)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(instructionalText)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submitPasswordButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method runs the passwordFieldActionPerformed method when enter is hit on
     * the keyboard
     *
     * @param evt
     */
    private void submitPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitPasswordButtonActionPerformed
        passwordFieldActionPerformed(evt); // Same result as below, instead of pressing enter, button is pressed
    }//GEN-LAST:event_submitPasswordButtonActionPerformed

    /**
     * Method launches the main GUI once the correct password is inputted, as
     * well as start background threads
     *
     * @param evt
     */
    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        mainProgram = new MainProgram(); // mainprogram object; opens gui
        timer = new Timer(); // timer object
        if (Arrays.equals(passwordField.getPassword(), PASSWORD)) { // if the array is equal to password
            dispose(); // kills the authentication window
            mainProgram.setLocationRelativeTo(null); // centers the main gui 
            mainProgram.setVisible(true); // makes the main gui visible
            (new Thread(timer)).start(); // starts the timer thread
        } else {
            instructionalText.setForeground(Color.red); // makes text below appear red
            instructionalText.setText("You have entered the wrong password, Try Again!");
        }
    }//GEN-LAST:event_passwordFieldActionPerformed

    /**
     * Returns the current instance of the main program
     *
     * @return current instance of main program
     */
    public static MainProgram getMainProgramInstance() {
        return mainProgram;
    }

    /**
     * Returns the current instance of timer
     *
     * @return current instance of timer
     */
    public static Timer getTimerInstance() {
        return timer;
    }

    /**
     * Main method for running GUI
     *
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuthenticationDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /**try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuthenticationDialogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }**/
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AuthenticationDialogue window = new AuthenticationDialogue(); // creates an object of this class (non-static methods)
                window.setLocationRelativeTo(null); // centers the authentication window
                window.setVisible(true); // makes the authentication window visible
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel instructionalText;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton submitPasswordButton;
    // End of variables declaration//GEN-END:variables
}
