package automatedsequence.gui;

import automatedsequence.fileInput.Line;
import automatedsequence.fileInput.ReadScheduleFile;
import automatedsequence.fileOutput.WriteToScheduleFile;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Purpose: Command Scheduler Class
 *
 * @author Brian Ho, Max Romanoff, Conor Norman 
 * June 5 2014
 */
public class CommandScheduler extends javax.swing.JFrame {

    /**
     * Creates new form CommandScheduler
     */
    public CommandScheduler() {
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

        startYearLabel = new javax.swing.JLabel();
        startMonthLabel = new javax.swing.JLabel();
        startDayLabel = new javax.swing.JLabel();
        startHourLabel = new javax.swing.JLabel();
        startMinuteLabel = new javax.swing.JLabel();
        startSecondLabel = new javax.swing.JLabel();
        mp3FileLabel = new javax.swing.JLabel();
        pathOfMP3 = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        recurDailyCheckbox = new javax.swing.JCheckBox();
        saveButton = new javax.swing.JButton();
        yearDropdownStart = new javax.swing.JComboBox();
        hourDropdownStart = new javax.swing.JComboBox();
        monthDropdownStart = new javax.swing.JComboBox();
        minuteDropdownStart = new javax.swing.JComboBox();
        dayDropdownStart = new javax.swing.JComboBox();
        secondDropboxStart = new javax.swing.JComboBox();
        nameOfEvent = new javax.swing.JTextField();
        nameOfEventLabel = new javax.swing.JLabel();
        hourDropdownEnd = new javax.swing.JComboBox();
        minuteDropdownEnd = new javax.swing.JComboBox();
        secondDropboxEnd = new javax.swing.JComboBox();
        endSecondLabel = new javax.swing.JLabel();
        endMinuteLabel = new javax.swing.JLabel();
        endHourLabel = new javax.swing.JLabel();
        startTimeLabel = new javax.swing.JLabel();
        endTimeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Schedule Task");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        startYearLabel.setText("Year");

        startMonthLabel.setText("Month");

        startDayLabel.setText("Day");

        startHourLabel.setText("Hour");

        startMinuteLabel.setText("Minute");

        startSecondLabel.setText("Second");

        mp3FileLabel.setText("MP3 File To Play:");

        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        recurDailyCheckbox.setText("Recur Daily");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        yearDropdownStart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068"}));

        hourDropdownStart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00" , "01", "02", "03", "04", "05" , "06", "07", "08", "09" ,"10" , "11", "12", "13", "14", "15" , "16", "17", "18", "19", "20", "21", "22", "23"}));

        monthDropdownStart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        minuteDropdownStart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));

        dayDropdownStart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));

        secondDropboxStart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        nameOfEventLabel.setText("Name of event:");

        hourDropdownEnd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00" , "01", "02", "03", "04", "05" , "06", "07", "08", "09" ,"10" , "11", "12", "13", "14", "15" , "16", "17", "18", "19", "20", "21", "22", "23"}));

        minuteDropdownEnd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));

        secondDropboxEnd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        endSecondLabel.setText("Second");

        endMinuteLabel.setText("Minute");

        endHourLabel.setText("Hour");

        startTimeLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        startTimeLabel.setText("Start Time");

        endTimeLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        endTimeLabel.setText("End Time");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(recurDailyCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(mp3FileLabel)
                                    .addComponent(nameOfEventLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameOfEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pathOfMP3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(startYearLabel)
                                            .addComponent(startDayLabel)
                                            .addComponent(startTimeLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(yearDropdownStart, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(dayDropdownStart, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(startMonthLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(monthDropdownStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(startHourLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(startMinuteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(hourDropdownStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(secondDropboxStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(minuteDropdownStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(startSecondLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(endSecondLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(endHourLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(endMinuteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addGap(16, 16, 16)
                                                    .addComponent(hourDropdownEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(secondDropboxEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minuteDropdownEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(browseButton)
                                            .addGap(11, 11, 11))
                                        .addComponent(saveButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(endTimeLabel)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startTimeLabel)
                    .addComponent(endTimeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startYearLabel)
                            .addComponent(startHourLabel)
                            .addComponent(yearDropdownStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hourDropdownStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startMonthLabel)
                            .addComponent(startMinuteLabel)
                            .addComponent(minuteDropdownStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthDropdownStart))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(startDayLabel)
                                .addComponent(startSecondLabel)
                                .addComponent(secondDropboxStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dayDropdownStart))
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(endHourLabel)
                            .addComponent(hourDropdownEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(endMinuteLabel)
                            .addComponent(minuteDropdownEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(endSecondLabel)
                            .addComponent(secondDropboxEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameOfEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameOfEventLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mp3FileLabel)
                    .addComponent(pathOfMP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recurDailyCheckbox)
                    .addComponent(saveButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action performed method for save button
     *
     * @param evt
     */
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        int id = ReadScheduleFile.getScheduledEventData().size(); // size of arraylist
        int startTimeInSeconds = (secondDropboxStart.getSelectedIndex() + (minuteDropdownStart.getSelectedIndex() * 60) + (hourDropdownStart.getSelectedIndex() * 3600)); // converts all values into seconds
        int endTimeInSeconds = (secondDropboxEnd.getSelectedIndex() + (minuteDropdownEnd.getSelectedIndex() * 60) + (hourDropdownEnd.getSelectedIndex() * 3600)); // converts all values into seconds
        String date = recurDailyCheckbox.isSelected() ? "EVERYDAY" : (monthDropdownStart.getSelectedIndex() + 1) + "/" + (dayDropdownStart.getSelectedIndex() + 1) + "/" + (yearDropdownStart.getSelectedIndex() + 2014); // formats date string
        ReadScheduleFile.getScheduledEventData().add(new Line(id, nameOfEvent.getText(), pathOfMP3.getText(), startTimeInSeconds, endTimeInSeconds, date)); // cretes a new line object and adds to arraylist

        WriteToScheduleFile.write(); // write to schedule file
        AuthenticationDialogue.getMainProgramInstance().populateScheduledBox(true); // update schedule box
        dispose(); // close the window
    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     * Action performed method for browse button
     *
     * @param evt
     */
    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        JFileChooser chooser = new JFileChooser(); // new file chooser
        FileFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3", "mpeg3"); // mp3
        File dir = new File(System.getProperty("user.dir"));        
        chooser.setCurrentDirectory(dir); // set current directory to program location folder
        chooser.setFileFilter(filter); // sets the filter
        chooser.setAcceptAllFileFilterUsed(false); // disallows all files option
        chooser.showOpenDialog(null);
        File fileToChoose = chooser.getSelectedFile(); // get file
        try {
            String pathOfFile = fileToChoose.getAbsolutePath(); // get path
            pathOfMP3.setText(pathOfFile); // sets the text in the field to be the path
        } catch (NullPointerException e) {
            System.out.println("No File Selected");
        }
    }//GEN-LAST:event_browseButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JComboBox dayDropdownStart;
    private javax.swing.JLabel endHourLabel;
    private javax.swing.JLabel endMinuteLabel;
    private javax.swing.JLabel endSecondLabel;
    private javax.swing.JLabel endTimeLabel;
    private javax.swing.JComboBox hourDropdownEnd;
    private javax.swing.JComboBox hourDropdownStart;
    private javax.swing.JComboBox minuteDropdownEnd;
    private javax.swing.JComboBox minuteDropdownStart;
    private javax.swing.JComboBox monthDropdownStart;
    private javax.swing.JLabel mp3FileLabel;
    private javax.swing.JTextField nameOfEvent;
    private javax.swing.JLabel nameOfEventLabel;
    private javax.swing.JTextField pathOfMP3;
    private javax.swing.JCheckBox recurDailyCheckbox;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox secondDropboxEnd;
    private javax.swing.JComboBox secondDropboxStart;
    private javax.swing.JLabel startDayLabel;
    private javax.swing.JLabel startHourLabel;
    private javax.swing.JLabel startMinuteLabel;
    private javax.swing.JLabel startMonthLabel;
    private javax.swing.JLabel startSecondLabel;
    private javax.swing.JLabel startTimeLabel;
    private javax.swing.JLabel startYearLabel;
    private javax.swing.JComboBox yearDropdownStart;
    // End of variables declaration//GEN-END:variables
}
