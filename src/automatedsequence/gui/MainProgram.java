package automatedsequence.gui;

import automatedsequence.MP3Player;
import automatedsequence.RandomizeOCanada;
import automatedsequence.Timer;
import automatedsequence.dateAndTime.SuperCalendar;
import automatedsequence.fileInput.Line;
import automatedsequence.fileInput.ReadOCanadaFile;
import automatedsequence.fileInput.ReadScheduleFile;
import automatedsequence.fileOutput.WriteToScheduleFile;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

/**
 * Purpose: Main Program Class
 *
 * @author Brian Ho, Max Romanoff, Conor Norman 
 * June 5 2014
 */
public class MainProgram extends javax.swing.JFrame {

    private MP3Player player = new MP3Player();
    private ReadScheduleFile scheduleFile = new ReadScheduleFile(); // run the constructor
    private ReadOCanadaFile oCanadaFile = new ReadOCanadaFile(); // run the constructor
    private RandomizeOCanada oCanada = new RandomizeOCanada();
    private String time, information; // storing time and ocanada info
    private SuperCalendar calendar = new SuperCalendar();
    private boolean isForcedStartActive = false; // is any events forced to play
    private String dayOfWeek, month;
    private int dayOfMonth, year, hour, minute, sec;

    private AbstractListModel tableModel;
    private String[] fileInformation;
    private boolean isStopped = false; // stopped or not

    /**
     * Creates new form MainProgram
     */
    public MainProgram() {
        populateScheduledBox(false);
        initComponents(); // initializes all the components in the gui
    }

    /**
     * Method gets the instance of the mp3 player
     *
     * @return instance of mp3 player
     */
    public MP3Player getMP3PlayerInstance() {
        return player;
    }

    /**
     * Method updates the scheduled box
     *
     * @param refresh true if updating
     */
    public void populateScheduledBox(boolean refresh) {
        fileInformation = new String[ReadScheduleFile.getScheduledEventData().size()]; // match size of arralist
        for (Line genericEventData : ReadScheduleFile.getScheduledEventData()) { // loop through all indexes
            fileInformation[genericEventData.getEventID()] = "[" + Line.getFormattedTime(ReadScheduleFile.getScheduledEventData().get(genericEventData.getEventID()).getStartTime()) + " - " + Line.getFormattedTime(ReadScheduleFile.getScheduledEventData().get(genericEventData.getEventID()).getEndTime()) + "] " + ReadScheduleFile.getScheduledEventData().get(genericEventData.getEventID()).getName(); // format and populate
        }
        tableModel = new AbstractListModel() {

            public int getSize() {
                return fileInformation.length;
            }

            public Object getElementAt(int i) {
                return fileInformation[i];
            }
        };
        if (refresh) { // only true when updating
            scheduledTasks.setModel(tableModel); // set model
            scheduledTasks.revalidate(); // revalidate
            scheduledTasks.repaint(); // refreshes
        }
    }

    /**
     * Method returns if there is a manual event executing
     *
     * @param isForcedStart is there a manual event executing
     */
    public void setForcedStartActive(boolean isForcedStart) {
        isForcedStartActive = isForcedStart;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scheduleCommandButton = new javax.swing.JButton();
        infoPane = new javax.swing.JScrollPane();
        informationBox = new javax.swing.JTextArea();
        infoLabel = new javax.swing.JLabel();
        scheduledTasksLabel = new javax.swing.JLabel();
        dateAndTimeLabel = new javax.swing.JLabel();
        stopToggleButton = new javax.swing.JToggleButton();
        propertiesButton = new javax.swing.JButton();
        postponeToggleButton = new javax.swing.JToggleButton();
        postponeDurationInMinutes = new javax.swing.JTextField();
        minutesLabel = new javax.swing.JLabel();
        scheduleHolidaysButton = new javax.swing.JButton();
        startNowButton = new javax.swing.JButton();
        scheduledTasksPane = new javax.swing.JScrollPane();
        scheduledTasks = new javax.swing.JList();
        deleteButton = new javax.swing.JButton();
        modifyTasksButton = new javax.swing.JButton();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Super Automator (Brian Ho, Maxim Romanoff, Conor Norman)");
        setResizable(false);

        scheduleCommandButton.setText("Schedule Command");
        scheduleCommandButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleCommandButtonActionPerformed(evt);
            }
        });

        informationBox.setColumns(1);
        informationBox.setRows(1);
        informationBox.setEditable(false); // cannot edit text being displayed
        informationBox.setText(information);
        infoPane.setViewportView(informationBox);

        infoLabel.setText("Info");

        scheduledTasksLabel.setText("SCHEDULED TASKS");

        dateAndTimeLabel.setText(time);

        stopToggleButton.setText("Stop");
        stopToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopToggleButtonActionPerformed(evt);
            }
        });

        propertiesButton.setText("Properties");
        propertiesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertiesButtonActionPerformed(evt);
            }
        });

        postponeToggleButton.setText("Postpone");
        postponeToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postponeToggleButtonActionPerformed(evt);
            }
        });

        postponeDurationInMinutes.setText("5");

        minutesLabel.setText("Minutes");

        scheduleHolidaysButton.setText("Schedule Holidays");
        scheduleHolidaysButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleHolidaysButtonActionPerformed(evt);
            }
        });

        startNowButton.setText("START NOW");
        startNowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startNowButtonActionPerformed(evt);
            }
        });

        scheduledTasks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scheduledTasks.setModel(tableModel);
        scheduledTasksPane.setViewportView(scheduledTasks);

        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        modifyTasksButton.setText("MODIFY");
        modifyTasksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyTasksButtonActionPerformed(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/pic.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(dateAndTimeLabel))
                    .addComponent(scheduleHolidaysButton)
                    .addComponent(scheduledTasksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scheduledTasksPane, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scheduleCommandButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(propertiesButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(stopToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(postponeToggleButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(postponeDurationInMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minutesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modifyTasksButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(startNowButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(infoPane, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(logo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scheduledTasksLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scheduledTasksPane, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(stopToggleButton)
                                    .addComponent(postponeToggleButton)
                                    .addComponent(postponeDurationInMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(minutesLabel))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(scheduleCommandButton)
                                    .addComponent(propertiesButton)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(startNowButton)
                                .addGap(10, 10, 10)
                                .addComponent(modifyTasksButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(scheduleHolidaysButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateAndTimeLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(infoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoPane, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        new Thread(){
            public void run(){
                while (true){
                    Calendar c = new GregorianCalendar();
                    dayOfWeek = (calendar.getDayOfWeek(c.get(Calendar.DAY_OF_WEEK)));
                    month = (calendar.getMonth(c.get(Calendar.MONTH) + 1)); // because starts at 0
                    dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
                    year = c.get(Calendar.YEAR);
                    hour = c.get(Calendar.HOUR_OF_DAY);
                    minute = c.get(Calendar.MINUTE);
                    sec = c.get(Calendar.SECOND);
                    time = dayOfWeek + " " + month + " " + dayOfMonth + " " + year + " [EDT " + hour +":" + ((minute < 10) ? "0" + minute : minute) + ":" + ((sec < 10) ? "0" + sec : sec) + "]"; // format and print time
                    dateAndTimeLabel.setText(time); // updates the time every second
                    information = "[INFO] O'CANADA VERSION " + Timer.getOCanadaVersion() +" SELECTED"; // shows the version of O'Canada selected, updates every second
                    informationBox.setText(!Timer.isOCanadaPlaying() ? "Waiting to start O'Canada..." : information); // if O canada is not detected to be playing; display this

                    try {
                        Thread.sleep(1000); // loop once every second, reduces toll on cpu
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                }
            }
        }.start();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method stops the music when the override button is toggled true
     *
     * @param evt
     */
    private void stopToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopToggleButtonActionPerformed
        if (!isStopped) {
            stopToggleButton.setText("Stopped");
            isStopped = true;
        } else { // reset text
            stopToggleButton.setText("Stop");
            isStopped = false;
        }
        player.Stop(); // stops the music from playing
        isForcedStartActive = false; // no songs being manually played
        Timer.setIsOCanadaPlaying(false); // incase user stops ocanada
        Timer.isManuallyStopped(true); // resets the time if user stops a manual event
    }//GEN-LAST:event_stopToggleButtonActionPerformed

    /**
     * Method creates a commandsGUI object and launches a new window
     *
     * @param evt
     */
    private void scheduleCommandButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleCommandButtonActionPerformed
        if (!isForcedStartActive) { // if there is no manual event executing
            if (!postponeToggleButton.isSelected()) { // if postpone button is not selected
                CommandScheduler commandsGUI = new CommandScheduler(); // command gui object
                commandsGUI.setLocationRelativeTo(null); // centers window
                commandsGUI.setVisible(true); // make visible
            } else { // is postponed
                Error errorPopup = new Error("Please de-select the postpone button!"); // passes string
                errorPopup.setLocationRelativeTo(null); // centers window
                errorPopup.setVisible(true); // make visible
            }
        } else { // manual event is active
            Error errorPopup = new Error("Please stop the manual event first!"); // passes string
            errorPopup.setLocationRelativeTo(null); // centers window
            errorPopup.setVisible(true); // make visible
        }
    }//GEN-LAST:event_scheduleCommandButtonActionPerformed

    /**
     * Method postpones the events by the duration that the user enters and when
     * button is released, value resets to normal
     *
     * @param evt
     */
    private void postponeToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postponeToggleButtonActionPerformed
        if (!isForcedStartActive) { // if there is no manual event executing
            for (Line genericEventData : ReadScheduleFile.getScheduledEventData()) { // loop through all indexes
                if (postponeToggleButton.isSelected()) {
                    if (!genericEventData.getPath().equalsIgnoreCase("NOPATH")) { // if it is not a holiday
                        genericEventData.postponeStartTime(Integer.parseInt(postponeDurationInMinutes.getText()));
                        genericEventData.postponeEndTime(Integer.parseInt(postponeDurationInMinutes.getText()));
                    }
                    postponeDurationInMinutes.setEditable(false); // avoid potential bug, does not let user change value after button is pressed
                    populateScheduledBox(true); // refreshes info box
                } else {
                    if (!genericEventData.getPath().equalsIgnoreCase("NOPATH")) { // if it is not a holiday
                        genericEventData.postponeStartTime(-Integer.parseInt(postponeDurationInMinutes.getText()));
                        genericEventData.postponeEndTime(-Integer.parseInt(postponeDurationInMinutes.getText()));
                    }
                    postponeDurationInMinutes.setEditable(true);
                    populateScheduledBox(true); // refreshes info box
                }
            }
        } else { // manual event is active
            Error errorPopup = new Error("Please stop the manual event first!"); // passes string
            errorPopup.setLocationRelativeTo(null); // centers window
            errorPopup.setVisible(true); // make visible
        }
    }//GEN-LAST:event_postponeToggleButtonActionPerformed

    /**
     * Method creates a propertiesGUI object and launches a new window
     *
     * @param evt
     */
    private void propertiesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertiesButtonActionPerformed
        if (!isForcedStartActive) { // if there is no manual event executing
            if (!postponeToggleButton.isSelected()) { // if postpone button is not selected
                Properties propertiesGUI = new Properties(); // properties gui object
                propertiesGUI.setLocationRelativeTo(null); // centers window
                propertiesGUI.setVisible(true); // make visible
            } else { // is postponed
                Error errorPopup = new Error("Please de-select the postpone button!"); // passes string
                errorPopup.setLocationRelativeTo(null); // centers window
                errorPopup.setVisible(true); // make visible
            }
        } else { // manual event is active
            Error errorPopup = new Error("Please stop the manual event first!"); // passes string
            errorPopup.setLocationRelativeTo(null); // centers window
            errorPopup.setVisible(true); // make visible
        }
    }//GEN-LAST:event_propertiesButtonActionPerformed

    /**
     * Method plays selected file in "SCHEDULED TASKS" box when clicked
     *
     * @param evt
     */
    private void startNowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startNowButtonActionPerformed
        if (!stopToggleButton.isSelected()) { // if the override button is not selected
            if (scheduledTasks.getSelectedIndex() >= 0 && scheduledTasks.getSelectedIndex() < ReadScheduleFile.getScheduledEventData().size()) {
                if (!isForcedStartActive && !Timer.getIsPlaying()) { // if nothing is playing
                    isForcedStartActive = true;
                    int durationOfEvent = ReadScheduleFile.getScheduledEventData().get(scheduledTasks.getSelectedIndex()).getDuration(); // get duration of event
                    int currentTimeInSeconds = Timer.getCurrentTimeInSeconds(); // get current time in seconds
                    int initialStartTime = ReadScheduleFile.getScheduledEventData().get(scheduledTasks.getSelectedIndex()).getStartTime(); // save the original start time to memory
                    int initialEndTime = ReadScheduleFile.getScheduledEventData().get(scheduledTasks.getSelectedIndex()).getEndTime(); // save the original end time to memory
                    String initialExecutionDate = ReadScheduleFile.getScheduledEventData().get(scheduledTasks.getSelectedIndex()).getDate(); // save the original execution date to memory
                    
                    ReadScheduleFile.getScheduledEventData().get(scheduledTasks.getSelectedIndex()).setStartTime(currentTimeInSeconds + 1); // set time to now (1 sec delay incase of latency)
                    ReadScheduleFile.getScheduledEventData().get(scheduledTasks.getSelectedIndex()).setEndTime(currentTimeInSeconds + durationOfEvent + 1); // set end time (1 sec delay incase of latency)
                    ReadScheduleFile.getScheduledEventData().get(scheduledTasks.getSelectedIndex()).setDate(Timer.getCurrentDate());

                    Timer.isManuallyStarted(true, scheduledTasks.getSelectedIndex(), initialStartTime, initialEndTime, initialExecutionDate); // passes information to timer to know it is a forced start
                    populateScheduledBox(true); // resets the box
                } else {
                    Error errorPopup = new Error("An event is currently playing!"); // passes string
                    errorPopup.setLocationRelativeTo(null); // centers window
                    errorPopup.setVisible(true); // make visible
                }
            } else { // no selection
                Error errorPopup = new Error("Please select an item in Scheduled Tasks!"); // passes string
                errorPopup.setLocationRelativeTo(null); // centers window
                errorPopup.setVisible(true); // make visible
            }
        } else { // schedule stopped
            Error errorPopup = new Error("Please de-select the stop button!"); // passes string
            errorPopup.setLocationRelativeTo(null); // centers window
            errorPopup.setVisible(true); // make visible
        }
    }//GEN-LAST:event_startNowButtonActionPerformed

    /**
     * Method creates a holidaysGUI object and launches a new window
     *
     * @param evt
     */
    private void scheduleHolidaysButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleHolidaysButtonActionPerformed
        if (!isForcedStartActive) { // if there is no manual event executing
            if (!postponeToggleButton.isSelected()) { // if postpone button is not selected
                HolidayScheduler holidaysGUI = new HolidayScheduler(); // holiday gui object
                holidaysGUI.setLocationRelativeTo(null); // centers window
                holidaysGUI.setVisible(true); // make visible
            } else { // is postponed
                Error errorPopup = new Error("Please de-select the postpone button!"); // passes string
                errorPopup.setLocationRelativeTo(null); // centers window
                errorPopup.setVisible(true); // make visible
            }
        } else { // manual event is active
            Error errorPopup = new Error("Please stop the manual event first!"); // passes string
            errorPopup.setLocationRelativeTo(null); // centers window
            errorPopup.setVisible(true); // make visible
        }
    }//GEN-LAST:event_scheduleHolidaysButtonActionPerformed

    /**
     * Action performed method for delete button
     *
     * @param evt
     */
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (!isForcedStartActive) { // if there is no manual event executing
            if (!postponeToggleButton.isSelected()) { // if postpone button is not selected
                if (scheduledTasks.getSelectedIndex() >= 0 && scheduledTasks.getSelectedIndex() < ReadScheduleFile.getScheduledEventData().size()) { // if there is a selection
                    ReadScheduleFile.getScheduledEventData().remove(scheduledTasks.getSelectedIndex());
                    WriteToScheduleFile.reorderAndWrite();
                    populateScheduledBox(true); // update scheduled box
                } else { // no selection
                    Error errorPopup = new Error("Please select an item in Scheduled Tasks!"); // passes string
                    errorPopup.setLocationRelativeTo(null); // centers window
                    errorPopup.setVisible(true); // make visible
                }
            } else { // is postponed
                Error errorPopup = new Error("Please de-select the postpone button!"); // passes string
                errorPopup.setLocationRelativeTo(null); // centers window
                errorPopup.setVisible(true); // make visible
            }
        } else { // manual event is active
            Error errorPopup = new Error("Please stop the manual event first!"); // passes string
            errorPopup.setLocationRelativeTo(null); // centers window
            errorPopup.setVisible(true); // make visible
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    /**
     * Action performed method for modify button
     *
     * @param evt
     */
    private void modifyTasksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyTasksButtonActionPerformed
        if (!isForcedStartActive) { // if there is no manual event executing
            if (!postponeToggleButton.isSelected()) { // if postpone button is not selected
                if (scheduledTasks.getSelectedIndex() >= 0) { // if there is a selection
                    ModifyTask modifyGUI = new ModifyTask(scheduledTasks.getSelectedIndex()); // modify task gui object
                    modifyGUI.setLocationRelativeTo(null); // centers window
                    modifyGUI.setVisible(true); // make visible
                } else { // no selection
                    Error errorPopup = new Error("Please select an item in Scheduled Tasks!"); // passes string
                    errorPopup.setLocationRelativeTo(null); // centers window
                    errorPopup.setVisible(true); // make visible
                }
            } else { // is postponed
                Error errorPopup = new Error("Please de-select the postpone button!"); // passes string
                errorPopup.setLocationRelativeTo(null); // centers window
                errorPopup.setVisible(true); // make visible
            }
        } else { // manual event is active
            Error errorPopup = new Error("Please stop the manual event first!"); // passes string
            errorPopup.setLocationRelativeTo(null); // centers window
            errorPopup.setVisible(true); // make visible
        }
    }//GEN-LAST:event_modifyTasksButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateAndTimeLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JScrollPane infoPane;
    private javax.swing.JTextArea informationBox;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel minutesLabel;
    private javax.swing.JButton modifyTasksButton;
    private javax.swing.JTextField postponeDurationInMinutes;
    private javax.swing.JToggleButton postponeToggleButton;
    private javax.swing.JButton propertiesButton;
    private javax.swing.JButton scheduleCommandButton;
    private javax.swing.JButton scheduleHolidaysButton;
    private javax.swing.JList scheduledTasks;
    private javax.swing.JLabel scheduledTasksLabel;
    private javax.swing.JScrollPane scheduledTasksPane;
    private javax.swing.JButton startNowButton;
    private javax.swing.JToggleButton stopToggleButton;
    // End of variables declaration//GEN-END:variables
}
