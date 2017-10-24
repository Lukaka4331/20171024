import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame{
    private Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW=800;
    private int frmH=600;
    private int screenW=dim.width ;
    private int screenH=dim.height ;
    private JMenuBar jmb =new JMenuBar();
    private JMenu jmF = new JMenu("File");
    private JMenu jmS = new JMenu("Set");
    private JMenu jmG = new JMenu("Game");
    private JMenu jmA = new JMenu("About");
    private JMenuItem JMIExit =new JMenuItem("Exit");
    private JMenuItem JMILoto =new JMenuItem("Loto");
    private JDesktopPane jdp =new JDesktopPane();
    private JInternalFrame jil =new JInternalFrame();
    LoginFrame loginFrame;
    public MainFrame(LoginFrame login){
        loginFrame=login;
        initComp();
    }
    private void initComp(){
        this.setBounds((screenW-frmW)/2,(screenH-frmH)/2,frmW,frmH);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setJMenuBar(jmb);
        jil.setBounds(0,0,300,150);
        jmb.add(jmF);
        jmb.add(jmS);
        jmb.add(jmG);
        jmb.add(jmA);
        jmF.add(JMIExit);
        jmG.add(JMILoto);
        jmF.add(jdp);
        this.setContentPane(jdp);
        JMILoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jdp.add(jil);
                jil.setVisible(true);
            }
        });
        JMIExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        JMIExit.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginFrame.setVisible(true);
                dispose();
            }
        });


    }
}