package studio;

import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UserCaseImpl extends JFrame implements ActionListener {

    /**
     * @author ashutoshpandey
     */
    // Components of the UI
    private static final long serialVersionUID = 1L;
    private Container c;
    private JLabel title;
    private JLabel userDetail;
    private JLabel name;
    private JLabel group;
    private JRadioButton record;
    private JRadioButton pack;
    private ButtonGroup gengp;
    private JLabel add;
    private JCheckBox term;
    private JButton run;
    private JButton reset;
    private JButton open;
    private JLabel res;
    private JLabel foot;
    private JCheckBox push;
    private JCheckBox get;
    private SelectScript f1;

    public static JTextArea cout;
    public static JTextField tname;

    // constructor, to initialize the components
    // with default values.
    public UserCaseImpl() {
        f1 = new SelectScript();

        setTitle("Automata Test Studio - Let,s execute it!");
        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        setSize(755, 580);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(icon);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel();
        title.setIcon(new ImageIcon("logo.png"));
        title.setFont(new Font("Arial", Font.ITALIC, 30));
        title.setSize(300, 60);
        title.setLocation(25, 25);
        c.add(title);

        userDetail = new JLabel("Welcome !");
        userDetail.setFont(new Font("Arial", Font.ITALIC, 12));
        userDetail.setIcon(new ImageIcon("user.png"));
        userDetail.setText(userDetail.getText() + " " + System.getProperty("user.name").toUpperCase());
        userDetail.setSize(300, 60);
        userDetail.setLocation(500, 25);
        c.add(userDetail);

        // input file
        name = new JLabel("Test Script ");
        name.setFont(new Font("Arial", Font.PLAIN, 18));
        name.setSize(100, 28);
        name.setLocation(60, 120);
        c.add(name);

        tname = new JTextField("Please choose test script ");
        tname.setFont(new Font("Arial", Font.ITALIC, 14));
        tname.setBorder(new RoundedBorder(6));
        tname.setSize(400, 28);
        tname.setLocation(160, 120);
        c.add(tname);

        open = new JButton("open");
        open.setFont(new Font("Arial", Font.PLAIN, 15));
        open.setBorder(new RoundedBorder(6));
        open.setSize(80, 28);
        open.setLocation(570, 120);
        open.addActionListener(f1);
        c.add(open);

        // code for screen recording
        group = new JLabel("Record Test ");
        group.setFont(new Font("Arial", Font.PLAIN, 18));
        group.setSize(150, 20);
        group.setLocation(60, 170);
        c.add(group);

        record = new JRadioButton("Yes");
        record.setFont(new Font("Arial", Font.PLAIN, 15));
        record.setToolTipText("select YES for record screen of test execution ");
        record.setSelected(false);
        record.setSize(110, 25);
        record.setLocation(180, 170);
        c.add(record);

        pack = new JRadioButton("No");
        pack.setFont(new Font("Arial", Font.PLAIN, 15));
        pack.setSelected(true);
        pack.setSize(110, 25);
        pack.setLocation(300, 170);
        c.add(pack);

        gengp = new ButtonGroup();
        gengp.add(record);
        gengp.add(pack);

        // report generator
        add = new JLabel("Generate ");
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setSize(120, 20);
        add.setLocation(60, 220);
        c.add(add);

        push = new JCheckBox(" Report");
        push.setFont(new Font("Arial", Font.PLAIN, 15));
        push.setSize(80, 20);
        push.setLocation(180, 220);
        c.add(push);

        get = new JCheckBox(" Log");
        get.setFont(new Font("Arial", Font.PLAIN, 15));
        get.setSize(80, 20);
        get.setLocation(300, 220);
        c.add(get);

        // Term and condition
        term = new JCheckBox(" Accept above information is correct.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(280, 20);
        term.setLocation(80, 260);
        c.add(term);

        // notify
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 12));
        res.setSize(500, 20);
        res.setLocation(60, 290);
        c.add(res);

        run = new JButton("Start");
        run.setFont(new Font("Arial", Font.PLAIN, 15));
        run.setBorder(new RoundedBorder(18));
        run.setSize(100, 20);
        run.setLocation(400, 290);
        run.addActionListener(this);
        c.add(run);

        reset = new JButton("Refresh");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setBorder(new RoundedBorder(18));
        reset.setSize(100, 20);
        reset.setLocation(550, 290);
        reset.addActionListener(this);
        c.add(reset);

        add = new JLabel("Console:");
        add.setFont(new Font("Arial", Font.BOLD, 15));
        add.setSize(80, 20);
        add.setLocation(20, 320);
        c.add(add);

        cout = new JTextArea();
        cout.setFont(new Font("Arial", Font.PLAIN, 12));
        cout.setBorder(new RoundedBorder(18));
        cout.setSize(700, 170);
        cout.setLocation(20, 340);
        cout.setLineWrap(true);
        cout.setEditable(false);
        c.add(cout);

        // footer
        foot = new JLabel("Made By Ashutosh Pandey");
        foot.setFont(new Font("Arial", Font.PLAIN, 10));
        foot.setSize(400, 25);
        foot.setLocation(590, 510);
        c.add(foot);

        setVisible(true);
    }

    // method actionPerformed() to get the action performed by the user and act
    // accordingly
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == run) {
            if (term.isSelected()) {
                String scripFileName = tname.getText().trim();
                if (!scripFileName.contains(".test")) {
                    res.setText("please choose test script file correctly ! ");
                    return;
                }

                RecorderUtils recorder = new RecorderUtils();
                if (record.isSelected()) {
                    recorder.startRecording();
                    cout.setText("Recording started successfully ");
                }

                cout.setText(scripFileName);
                setState(Frame.ICONIFIED);
                Interpreter interpreter = new Interpreter();
                interpreter.readStatement(scripFileName);

                if (recorder.isRecordingOn()) {
                    recorder.stop(scripFileName.substring(scripFileName.lastIndexOf(File.separator) + 1,
                            scripFileName.lastIndexOf(".")));
                }
            } else {
                cout.setText("");
                res.setText("Please accept provided "
                        + "information is correct * ");
            }
        }

        else if (e.getSource() == reset) {
            String def = "";
            cout.setText(def);
            tname.setText("Please choose test script ");
            res.setText(def);
            push.setSelected(false);
            get.setSelected(false);
            term.setSelected(false);
        }
    }
}
