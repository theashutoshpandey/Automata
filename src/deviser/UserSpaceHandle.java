package deviser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.util.Date;

public class UserSpaceHandle extends JFrame implements ActionListener {

    private boolean isEventRecorderOn = false;

    Container container = getContentPane();

    JLabel logo = new JLabel();
    JLabel user = new JLabel();
    JLabel message = new JLabel();

    JLabel userDetail = new JLabel("Welcome !");
    JLabel fileExtension = new JLabel(".test");
    JLabel description = new JLabel(" DESCRIPTION : ");
    JLabel fileLabel = new JLabel(" TEST FILE NAME : ");
    JLabel maxDescLimit = new JLabel("max 100 Character");

    JTextArea descTextArea = new JTextArea();
    JTextField fileTextField = new JTextField();

    JButton startButton = new JButton("START");
    JButton pauseButton = new JButton("PAUSE");
    JButton stopButton = new JButton("STOP");

    GlobalEventListener globEventListener = new GlobalEventListener();

    public void createUserHandleGui() {
        setTitle("Automata Test - Let,s Make Things Automatic");
        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        setBounds(10, 10, 560, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(icon);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    UserSpaceHandle() {
        setFrameDetails();
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        addBorder();
    }

    public void setFrameDetails() {
        logo.setIcon(new ImageIcon("logo.png"));
        user.setIcon(new ImageIcon("user.png"));
        user.setText(" " + System.getProperty("user.name").toUpperCase());
    }

    public void setLayoutManager() {
        descTextArea.setLineWrap(true);
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        user.setBounds(380, 12, 200, 60);
        logo.setBounds(10, 10, 200, 60);
        userDetail.setBounds(420, 0, 200, 60);
        message.setBounds(50, 270, 250, 30);
        fileLabel.setBounds(50, 100, 150, 30);
        startButton.setBounds(50, 240, 100, 20);
        stopButton.setBounds(400, 240, 100, 20);
        description.setBounds(50, 150, 250, 30);
        fileExtension.setBounds(415, 110, 150, 25);
        pauseButton.setBounds(230, 240, 100, 20);
        descTextArea.setBounds(160, 150, 250, 42);
        maxDescLimit.setBounds(160, 180, 250, 42);
        fileTextField.setBounds(160, 100, 250, 30);
    }

    public void addComponentsToContainer() {
        container.add(logo);
        container.add(user);
        container.add(message);
        container.add(fileLabel);
        container.add(userDetail);
        container.add(description);
        container.add(fileTextField);
        container.add(fileExtension);
        container.add(descTextArea);
        container.add(maxDescLimit);
        container.add(startButton);
        container.add(pauseButton);
        container.add(stopButton);
    }

    public void addBorder() {
        stopButton.setBorder(new RoundedBorder(18));
        pauseButton.setBorder(new RoundedBorder(18));
        startButton.setBorder(new RoundedBorder(18));
        descTextArea.setBorder(new RoundedBorder(6));
        fileTextField.setBorder(new RoundedBorder(6));
    }

    public void addActionEvent() {
        stopButton.addActionListener(this);
        pauseButton.addActionListener(this);
        startButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Coding Part of event handler
        if (e.getSource() == startButton) {
            String testFileName = System.getProperty("user.home") + File.separator + "AutoMata" + File.separator;
            String desc = !descTextArea.getText().equals("") ? descTextArea.getText() : "the description not provided";

            if (desc.length() > 100) {
                message.setText("Description characters is more then 100.");
                return;
            }

            File file = new File(testFileName);
            if (!file.exists())
                file.mkdir();

            String fileName = fileTextField.getText();
            if (!fileName.equals("") && !fileName.replaceAll("(\\s)+", "").isEmpty()) {
                isEventRecorderOn = true;
                TabularEventFileWriter.isAllowedToWrite = true;
                TabularEventFileWriter.testFilePath = testFileName + fileName + ".test";
                TabularEventFileWriter.bufferFileWriter("AUTOMATA_TEST_INFO,TEST NAME : " + fileName
                        + ",TEST FILE PATH : " + testFileName + fileName + ".test"
                        + ",TEST DESCRIPTION : " + desc + ",SYSTEM OS NAME : " + System.getProperty("os.name")
                        + ",TEST CREATED DATE : " + DateFormat.getDateTimeInstance().format(new Date()));
                if(!globEventListener.isEventListenerOn())
                    globEventListener.initiateEventListener();

                message.setText("Ready to learn, Just show me how to do it!");
                setState(Frame.ICONIFIED);
            } else {
                message.setText("Test filename is mandatory *");
            }

        } else if (e.getSource() == pauseButton) {
            if (pauseButton.getText() == "PAUSE" && isEventRecorderOn) {
                TabularEventFileWriter.bufferFileWriter("NATIVE_EVENT_PAUSED");
                pauseButton.setText("RESUME");
                message.setText("Pause Mode Activated !");
                isEventRecorderOn = false;
                TabularEventFileWriter.isAllowedToWrite = false;
            } else if (pauseButton.getText() == "RESUME" && !isEventRecorderOn) {
                TabularEventFileWriter.isAllowedToWrite = true;
                TabularEventFileWriter.bufferFileWriter("NATIVE_EVENT_RESUMED");
                pauseButton.setText("PAUSE");
                message.setText("Learning Mode Again Activated !");
                isEventRecorderOn = true;
            }

        } else {
            if (isEventRecorderOn) {
                setVisible(false);
                isEventRecorderOn = false;
                TabularEventFileWriter.isAllowedToWrite = false;
                JOptionPane.showMessageDialog(this, "Test script generated successfully !",
                        "Automata Test",
                        JOptionPane.INFORMATION_MESSAGE);
                setVisible(true);
            }
            message.setText("");
            fileTextField.setText("");
            descTextArea.setText("");
        }
    }

}
