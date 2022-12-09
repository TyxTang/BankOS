import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {
    private JLabel Title;
    private JLabel id;
    private JTextField idInput;
    private JLabel password;
    private JPasswordField passwordInput;
    private String passwordString;
    private JLabel ok_null_Text;
    private JButton ok;
    private JButton register;
    public LoginUI(){
        super("登录");
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        Title = new JLabel("银行管理系统");
        Title.setFont(new Font("黑体", Font.PLAIN, 40));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        id = new JLabel("银行卡号：");
        id.setHorizontalAlignment(SwingConstants.CENTER);
        idInput = new JTextField(20);
        password = new JLabel("网银密码：");
        password.setHorizontalAlignment(SwingConstants.CENTER);
        passwordInput = new JPasswordField(20);
        ok_null_Text = new JLabel(" ");
        ok_null_Text.setHorizontalAlignment(SwingConstants.CENTER);
        ok = new JButton("登录");
        ok.setHorizontalAlignment(SwingConstants.CENTER);
        register = new JButton("注册");
        register.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel Titlepan = new JPanel();
        Titlepan.add(Title);
        c.add(Titlepan);
        JPanel idPan = new JPanel();
        idPan.add(id);
        idPan.add(idInput);
        c.add(idPan);
        JPanel passwordPan = new JPanel();
        passwordPan.add(password);
        passwordPan.add(passwordInput);
        c.add(passwordPan);
        //passwordString = new String(passwordInput.getPassword());
        JPanel okPan = new JPanel();
        okPan.add(ok_null_Text);
        okPan.add(ok);
        ok.addActionListener(new handler());
        c.add(okPan);
        JPanel registerPan = new JPanel();
        registerPan.add(register);
        register.addActionListener(new reg());
        c.add(registerPan);
        this.setSize(340, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public String getId(){
        return idInput.getText();
    }
    public String getPassword(){
        String passwordString = new String(passwordInput.getPassword());
        return passwordString;
    }

    class reg implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new RegisterUI();
        }
    }
    class handler implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            LoginInspection login = new LoginInspection();
            if(login.match(Long.parseLong(getId()), getPassword())){
                new MenuMain();
                dispose();
            }
            else{
                ok_null_Text.setText("登录失败");
            }
        }
    }
}

