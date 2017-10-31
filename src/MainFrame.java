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
    private JMenuItem JMIFont =new JMenuItem("Font");

    private JLabel fontFamily =new JLabel("Family");
    private JLabel fontSyle =new JLabel("Style");
    private JLabel fontSize =new JLabel("Size");

    private JTextField jtf1=new JTextField();
    private JTextField jtf2=new JTextField();

    private JPanel jpanel1 =new JPanel( new GridLayout(2,3,5,5));
    private String [] options={"PIAIN ","BOLD","ITALIC","BOLD+ITALIC"};
    private JComboBox jcbStyle =new JComboBox(options);
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
        jmS.add(JMIFont);
        jmG.add(JMILoto);
        jmF.add(jdp);

        jpanel1.add(fontFamily);
        jpanel1.add(fontSyle);
        jpanel1.add(fontSize);
        jpanel1.add(jtf1);
        jpanel1.add(jcbStyle);
        jpanel1.add(jtf2);

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

      JMIFont.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent actionEvent) {
              int result =JOptionPane.showConfirmDialog(MainFrame.this,jpanel1,"Fontset",JOptionPane.OK_CANCEL_OPTION);
              int fontStyle=0;
              switch (jcbStyle.getSelectedIndex()){
                  case 0:
                      fontStyle=Font.PLAIN ;break;
                  case 1:
                      fontStyle=Font.BOLD ;break;
                  case 2:
                      fontStyle=Font.ITALIC ;break;
                  case 3:
                      fontStyle=Font.BOLD +Font.ITALIC ;break;
              }
              if(result==JOptionPane.OK_CANCEL_OPTION){
              }

          }
      });





    }
}