import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame{
    private  JLabel jlID= new JLabel("ID:");
    private  JLabel jlPW= new JLabel("Password:");
    private  JTextField jfID= new JTextField();
    private JPasswordField jpfPW =new JPasswordField();
    private JButton jbExit =new JButton("Exit");
    private JButton jbLogin =new JButton("Login");

    private Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW=300;
    private int frmH=150;
    private int screenW=dim.width ;
    private int screenH=dim.height ;




    public LoginFrame(){
        initComp();
    }
    private  void initComp(){
        this.setBounds((screenW-frmW)/2,(screenH-frmH)/2,frmW,frmH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container cp;
        cp=this.getContentPane();
        cp.setLayout(new GridLayout(3,2,2,2));
        jbExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jbLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jfID.getText().equals("h304")&& new String(jpfPW.getPassword()).equals("23323456")){
                    MainFrame mf =new MainFrame(LoginFrame.this);
                    mf.setVisible(true);
                    LoginFrame.this.setVisible(false);
                    dispose();
                }else {
                    JOptionPane.showMessageDialog(LoginFrame.this,"Error"+"\nID : "+jfID.getText()+"\nPassword : "+new String(jpfPW.getPassword()));



                }
            }
        });
        jlID.setHorizontalAlignment(JLabel.RIGHT);
        jlPW.setHorizontalAlignment(JLabel.RIGHT);
        cp.add(jlID);
        cp.add(jfID);
        cp.add(jlPW);
        cp.add(jpfPW);
        cp.add(jbExit);
        cp.add(jbLogin);

    }

}