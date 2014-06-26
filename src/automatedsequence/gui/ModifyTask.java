package automatedsequence.gui;

import automatedsequence.fileInput.Line;
import automatedsequence.fileInput.ReadScheduleFile;
import automatedsequence.fileOutput.WriteToScheduleFile;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Purpose: Modify Events Class
 *
 * @author Brian Ho, Max Romanoff, Conor Norman 
 * June 5 2014
 */
public class ModifyTask extends javax.swing.JFrame {

    private int indexOfEvent;

    /**
     * Creates new form ModifyTask
     *
     * @param indexOfEvent The id/index of the event that the user wishes to
     * modify
     */
    public ModifyTask(int indexOfEvent) {
        this.indexOfEvent = indexOfEvent; // gets the index of event from mainprogram
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

        pathField = new javax.swing.JTextField();
        pathLabel = new javax.swing.JLabel();
        browseButton = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        startTimeLabel = new javax.swing.JLabel();
        endTimeLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        startTimeField = new javax.swing.JTextField();
        endTimeField = new javax.swing.JTextField();
        dateField = new javax.swing.JTextField();
        recurCheckbox = new javax.swing.JCheckBox();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modify Task");
        setResizable(false);

        pathField.setText(automatedsequence.fileInput.ReadScheduleFile.getScheduledEventData().get(indexOfEvent).getPath());

        pathLabel.setText("Path to MP3");

        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        nameField.setText(ReadScheduleFile.getScheduledEventData().get(indexOfEvent).getName());

        nameLabel.setText("Name of event");

        startTimeLabel.setText("Start Time");

        endTimeLabel.setText("End Time");

        dateLabel.setText("Day to Execute");

        startTimeField.setText(Line.getFormattedTime(automatedsequence.fileInput.ReadScheduleFile.getScheduledEventData().get(indexOfEvent).getStartTime()));

        endTimeField.setText(Line.getFormattedTime(automatedsequence.fileInput.ReadScheduleFile.getScheduledEventData().get(indexOfEvent).getEndTime()));

        dateField.setText(automatedsequence.fileInput.ReadScheduleFile.getScheduledEventData().get(indexOfEvent).getDate());

        recurCheckbox.setText("Recur");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pathLabel)
                    .addComponent(nameLabel)
                    .addComponent(startTimeLabel)
                    .addComponent(endTimeLabel)
                    .addComponent(dateLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(startTimeField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pathField)
                            .addComponent(endTimeField, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateField, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(browseButton)
                    .addComponent(recurCheckbox))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pathLabel)
                    .addComponent(browseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startTimeLabel)
                    .addComponent(startTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endTimeLabel)
                    .addComponent(endTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recurCheckbox)
                    .addComponent(dateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(saveButton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action performed handler for the save button
     *
     * @param evt
     */
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        ReadScheduleFile.getScheduledEventData().get(indexOfEvent).setName(nameField.getText()); // write name changes to array index
        ReadScheduleFile.getScheduledEventData().get(indexOfEvent).setPath(pathField.getText()); // write path changes to array index

        int startHour = ((startTimeField.getText().charAt(0) - 48) * 10 + (startTimeField.getText().charAt(1) - 48)) * 3600; // get the start hour
        int startMin = ((startTimeField.getText().charAt(3) - 48) * 10 + (startTimeField.getText().charAt(4) - 48)) * 60; // get the start min
        int startSecond = (startTimeField.getText().charAt(6) - 48) * 10 + (startTimeField.getText().charAt(7) - 48); // get the start second
        ReadScheduleFile.getScheduledEventData().get(indexOfEvent).setStartTime(startHour + startMin + startSecond); // write the start time changes to array index

        int endHour = ((endTimeField.getText().charAt(0) - 48) * 10 + (endTimeField.getText().charAt(1) - 48)) * 3600; // get the end hour
        int endMin = ((endTimeField.getText().charAt(3) - 48) * 10 + (endTimeField.getText().charAt(4) - 48)) * 60; // get the end minute
        int endSecond = (endTimeField.getText().charAt(6) - 48) * 10 + (endTimeField.getText().charAt(7) - 48); // get the end second
        ReadScheduleFile.getScheduledEventData().get(indexOfEvent).setEndTime(endHour + endMin + endSecond); // write end time changes to array index

        ReadScheduleFile.getScheduledEventData().get(indexOfEvent).setDate(recurCheckbox.isSelected() ? (ReadScheduleFile.getScheduledEventData().get(indexOfEvent).getPath().equalsIgnoreCase("NOPATH") ? "1/1/YEARLY" : "EVERYDAY") : dateField.getText()); // if checkbox is checked write "EVERYDAY" or "YEARLY" otherwise write the value inside the textbox

        WriteToScheduleFile.write();
        AuthenticationDialogue.getMainProgramInstance().populateScheduledBox(true); // update scheduled box
        dispose();
    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     * Action performed handler for the browser button
     *
     * @param evt
     */
    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        JFileChooser chooser = new JFileChooser(); // new file chooser window
        FileFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3", "mpeg3"); // mp3
        File dir = new File(System.getProperty("user.dir"));
        chooser.setCurrentDirectory(dir); // set current directory to program location folder
        chooser.setFileFilter(filter); // sets the filter
        chooser.setAcceptAllFileFilterUsed(false); // disallows all files option
        chooser.showOpenDialog(null);
        File fileToChoose = chooser.getSelectedFile(); // get file
        try {
            String pathOfFile = fileToChoose.getAbsolutePath(); // get path
            pathField.setText(pathOfFile); // set the path to the textbox
        } catch (NullPointerException e) {
            System.out.println("No File Selected");
        }
    }//GEN-LAST:event_browseButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JTextField dateField;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField endTimeField;
    private javax.swing.JLabel endTimeLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField pathField;
    private javax.swing.JLabel pathLabel;
    private javax.swing.JCheckBox recurCheckbox;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField startTimeField;
    private javax.swing.JLabel startTimeLabel;
    // End of variables declaration//GEN-END:variables
}
