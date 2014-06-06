package automatedsequence.gui;

import automatedsequence.constants.PathConstants;
import automatedsequence.fileInput.OCanada;
import automatedsequence.fileInput.ReadOCanadaFile;
import automatedsequence.fileInput.ReadScheduleFile;
import automatedsequence.fileOutput.WriteToOCanadaFile;
import automatedsequence.fileOutput.WriteToScheduleFile;
import java.io.File;
import javax.swing.AbstractListModel;
import javax.swing.JFileChooser;

/**
 * Purpose: Properties Class
 *
 * @author Brian Ho, Max Romanoff, Conor Norman 
 * June 5 2014
 */
public class Properties extends javax.swing.JFrame {

    private AbstractListModel tableModel;
    private String[] fileInformation;

    /**
     * Creates new form Properties and initializes it's components
     */
    public Properties() {
        populatePathBox(false);
        initComponents();
    }

    /**
     * Method populates the path box with O'Canada paths
     *
     * @param refresh true if updating
     */
    public void populatePathBox(boolean refresh) {
        fileInformation = new String[ReadOCanadaFile.getOCanadaVersionData().size()]; // make an array the same size as the OCanadaVersion arraylist

        for (OCanada oCanadaVersionData : ReadOCanadaFile.getOCanadaVersionData()) { // loops through all indexes
            fileInformation[oCanadaVersionData.getID()] = oCanadaVersionData.getPath(); // populates the array
        }
        tableModel = new AbstractListModel() {
            @Override
            public int getSize() {
                return fileInformation.length;
            }

            @Override
            public Object getElementAt(int i) {
                return fileInformation[i];
            }
        };
        if (refresh) { // true if updating
            oCanadaVersions.setModel(tableModel); // set the model
            oCanadaVersions.revalidate(); // revalidate
            oCanadaVersions.repaint(); // refreshes
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        morningRushLabel = new javax.swing.JLabel();
        morningRushPathTextBox = new javax.swing.JTextField();
        browseForMorningRush = new javax.swing.JButton();
        standUpForOCanadaLabel = new javax.swing.JLabel();
        standUpForOCanadaPathTextBox = new javax.swing.JTextField();
        browseForStandUpForOCanada = new javax.swing.JButton();
        oCanadaVersionsLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        oCanadaVersions = new javax.swing.JList();
        doneButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Properties");
        setResizable(false);

        morningRushLabel.setText("Current Morning Rush Song:");

        morningRushPathTextBox.setText(automatedsequence.fileInput.ReadScheduleFile.getScheduledEventData().get(PathConstants.morningRushEventID).getPath());

        browseForMorningRush.setText("Browse");
        browseForMorningRush.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseForMorningRushActionPerformed(evt);
            }
        });

        standUpForOCanadaLabel.setText("\"Please stand up for O'Canada\":");

        standUpForOCanadaPathTextBox.setText(automatedsequence.fileInput.ReadScheduleFile.getScheduledEventData().get(PathConstants.pleaseStandUpForOCanadaEventID).getPath());

        browseForStandUpForOCanada.setText("Browse");
        browseForStandUpForOCanada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseForStandUpForOCanadaActionPerformed(evt);
            }
        });

        oCanadaVersionsLabel.setText("O'Canada Versions:");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        oCanadaVersions.setModel(tableModel);
        jScrollPane2.setViewportView(oCanadaVersions);

        doneButton.setText("Done");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(standUpForOCanadaLabel)
                                    .addComponent(morningRushLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(morningRushPathTextBox)
                                    .addComponent(standUpForOCanadaPathTextBox, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(browseForMorningRush)
                                    .addComponent(browseForStandUpForOCanada)))
                            .addComponent(oCanadaVersionsLabel))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(doneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(morningRushLabel)
                    .addComponent(morningRushPathTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseForMorningRush))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(standUpForOCanadaPathTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseForStandUpForOCanada)
                    .addComponent(standUpForOCanadaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(oCanadaVersionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(removeButton)
                    .addComponent(doneButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action performed method for browse button for morning rush song
     *
     * @param evt
     */
    private void browseForMorningRushActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseForMorningRushActionPerformed
        JFileChooser chooser = new JFileChooser(); // makes a new file chooser window appear
        chooser.showOpenDialog(null);
        File fileToChoose = chooser.getSelectedFile(); // get the file
        try {
            String pathOfFile = fileToChoose.getAbsolutePath(); // get the path of the file
            morningRushPathTextBox.setText(pathOfFile); // write the path into the text field
            ReadScheduleFile.getScheduledEventData().get(PathConstants.morningRushEventID).setPath(morningRushPathTextBox.getText()); // change the path in the List arraylist
            WriteToScheduleFile.write(); // write to schedule file
        } catch (NullPointerException e) {
            System.out.println("No File Selected");
        }
    }//GEN-LAST:event_browseForMorningRushActionPerformed

    /**
     * Action performed method for browse button for browse button for stand up
     * for oCanada song
     *
     * @param evt
     */
    private void browseForStandUpForOCanadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseForStandUpForOCanadaActionPerformed
        JFileChooser chooser = new JFileChooser(); // make a new file choose window appear
        chooser.showOpenDialog(null);
        File fileToChoose = chooser.getSelectedFile(); // get the file
        try {
            String pathOfFile = fileToChoose.getAbsolutePath(); // get the path of the file
            standUpForOCanadaPathTextBox.setText(pathOfFile); // write the path into the text field
            ReadScheduleFile.getScheduledEventData().get(PathConstants.pleaseStandUpForOCanadaEventID).setPath(standUpForOCanadaPathTextBox.getText()); // change the path in the List arraylist
            WriteToScheduleFile.write(); // write to schedule file
        } catch (NullPointerException e) {
            System.out.println("No File Selected");
        }
    }//GEN-LAST:event_browseForStandUpForOCanadaActionPerformed

    /**
     * Action performed method for the remove button, it removes any selected
     * ocanada version
     *
     * @param evt
     */
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        if (oCanadaVersions.getSelectedIndex() >= 0 && oCanadaVersions.getSelectedIndex() < ReadOCanadaFile.getOCanadaVersionData().size()) { // if there is a selection
            ReadOCanadaFile.getOCanadaVersionData().remove(oCanadaVersions.getSelectedIndex()); // remove the index
            WriteToOCanadaFile.reorderAndWrite(); // deletes, reorders indexes and writes to ocanada file
            populatePathBox(true); // update the box to show deletion
        } else { // nothing selected
            Error errorPopup = new Error("Please select an item to remove!"); // passes string
            errorPopup.setLocationRelativeTo(null); // centers window
            errorPopup.setVisible(true); // make visible
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    /**
     * Action performed method for the add button, opens a browse window
     *
     * @param evt
     */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        JFileChooser chooser = new JFileChooser(); // file chooser window
        chooser.showOpenDialog(null);
        File fileToChoose = chooser.getSelectedFile(); // get the selected file
        try {
            String pathOfFile = fileToChoose.getAbsolutePath(); // get the path
            ReadOCanadaFile.getOCanadaVersionData().add(new OCanada(ReadOCanadaFile.getOCanadaVersionData().size(), pathOfFile)); // make a new object 
            WriteToOCanadaFile.write(); // writes to ocanada file
        } catch (NullPointerException e) {
            System.out.println("No File Selected");
        }
        populatePathBox(true); // update box to show addition
    }//GEN-LAST:event_addButtonActionPerformed

    /**
     * Action performed method for done button
     *
     * @param evt
     */
    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        dispose(); // close window
    }//GEN-LAST:event_doneButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton browseForMorningRush;
    private javax.swing.JButton browseForStandUpForOCanada;
    private javax.swing.JButton doneButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel morningRushLabel;
    private javax.swing.JTextField morningRushPathTextBox;
    private javax.swing.JList oCanadaVersions;
    private javax.swing.JLabel oCanadaVersionsLabel;
    private javax.swing.JButton removeButton;
    private javax.swing.JLabel standUpForOCanadaLabel;
    private javax.swing.JTextField standUpForOCanadaPathTextBox;
    // End of variables declaration//GEN-END:variables
}
