import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;


public class MainFrame extends JFrame{
    private Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW=800;
    private int frmH=600;
    private int screenW=dim.width ;
    private int screenH=dim.height ;
    private JMenuBar jmb =new JMenuBar();
    private JMenu jmF = new JMenu("File");
    private JMenu jmSet = new JMenu("Set");
    private JMenu jmG = new JMenu("Game");
    private JMenu jmA = new JMenu("About");
    private JMenuItem JMIExit =new JMenuItem("Exit");
    private JMenuItem JMILoto =new JMenuItem("Loto");






    private JPanel jPanel1 = new JPanel(new GridLayout(2,3,5,5));
    private JMenuItem JMISetFont = new JMenuItem("Set Font");
    private JLabel jlFamilyfont = new JLabel("Family");
    private JLabel jlStylefont = new JLabel("Style");
    private JLabel jlSizefont = new JLabel("Size");
    private JTextField jtxFamilyfont = new JTextField("Time New Romans");
    private JTextField jtxSizefont = new JTextField("24");
    private String options[] ={"PLAIN","BOLD","ITALIC","BOLD+ITALIC"};
    private JComboBox jcombofont = new JComboBox(options);


    //---------------Loto----------------------------------------------------------------
    private JDesktopPane jdp =new JDesktopPane();
    private JInternalFrame jIFLoto =new JInternalFrame();
    private JButton jbtnClose =new JButton("Close");
    private JButton jbtnReamke =new JButton("Rerandom");
    private int data[]=new int[6];
    private JLabel jlLoto[]=new JLabel[6];
    private Random rnd =new Random(System.currentTimeMillis());
    private JPanel jpnLotoNumber =new JPanel(new GridLayout(1,6,3,3));
    private JPanel jpnLotoUse =new JPanel(new GridLayout(1,2,3,3));

    private void GenerateNum(){
        for(int i = 0;i<6;i++){
            jlLoto[i] = new JLabel();
            jlLoto[i].setHorizontalAlignment(SwingConstants.CENTER);
            //讓每格不透明
            jlLoto[i].setOpaque(true);
            jlLoto[i].setBackground(new Color(40,143,255));
            jlLoto[i].setText(Integer.toString(data[i]));
            jpnLotoNumber.add(jlLoto[i]);
        }

    }

    private void Number(){
        for(int i = 0;i <6;i++){
            data[i] = rnd.nextInt(42)+1;
            for(int j = 0;j<i;j++){
                if(data[i]==data[j]){
                    i--;
                    break;
                }
            }
        }
    }
//    --------------------------------------------------------------------
    LoginFrame loginFrame;
    public MainFrame(LoginFrame login){
        loginFrame=login;
        initComp();
    }
    private void initComp(){
        this.setBounds((screenW-frmW)/2,(screenH-frmH)/2,frmW,frmH);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setJMenuBar(jmb);
        jIFLoto.setBounds(0,0,300,150);
        jmb.add(jmF);
        jmb.add(jmSet);
        jmb.add(jmG);
        jmb.add(jmA);
        jmF.add(JMIExit);

        jmG.add(JMILoto);
        jmF.add(jdp);

        jmSet.add(JMISetFont);
        jPanel1.add(jlFamilyfont);
        jPanel1.add(jlStylefont);
        jPanel1.add(jlSizefont);
        jPanel1.add(jtxFamilyfont);
        jPanel1.add(jcombofont);
        jPanel1.add(jtxSizefont);

        jIFLoto.setBounds(0,0,300,200);
        jIFLoto.setLayout(new BorderLayout(3,3));
        jIFLoto.add(jpnLotoNumber,BorderLayout.CENTER);
        jIFLoto.add(jpnLotoUse,BorderLayout.SOUTH);
        Number();
        GenerateNum();
        jpnLotoUse.add(jbtnClose);
        jpnLotoUse.add(jbtnReamke);
        this.setContentPane(jdp);




//--------Loto-----------------

        JMILoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jdp.add(jIFLoto);
                jIFLoto.setVisible(true);
            }
        });


        jbtnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jIFLoto.setVisible(false);
            }
        });

        jbtnReamke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Number();
                for(int i=0;i<6;i++){

                    jlLoto[i].setText(Integer.toString(data[i]));
                }
            }
        });










//   --------------------------捷鍵
        JMIExit.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        JMILoto.setAccelerator(KeyStroke.getKeyStroke('S',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        JMISetFont.setAccelerator(KeyStroke.getKeyStroke('W',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));




        JMIExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });



        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginFrame.setVisible(true);
                dispose();
            }
        });

        JMISetFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(MainFrame.this,
                        jPanel1,"Font setting",
                        JOptionPane.OK_CANCEL_OPTION);
                int fontStyle = 0;
                switch (jcombofont.getSelectedIndex()){
                    case 0:
                        fontStyle = Font.PLAIN;
                        break;
                    case 1:
                        fontStyle = Font.BOLD;
                        break;
                    case 2:
                        fontStyle = Font.ITALIC;
                        break;
                    case 3:
                        fontStyle = Font.BOLD + Font.ITALIC;
                        break;
                }
                if(result == JOptionPane.OK_OPTION){
                    System.out.println("Test Change");
                    UIManager.put("Menu.font",new Font(jtxFamilyfont.getText(),
                            fontStyle,Integer.parseInt(jtxSizefont.getText())));

                }
            }
        });



    }

}