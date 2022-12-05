import javax.swing.*;
import java.awt.*;

public class RegisterUI extends JFrame {
    public RegisterUI(){
        super("注册");
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        JLabel Title = new JLabel("银行账户注册");
        Title.setFont(new Font("黑体", Font.PLAIN, 34));
        Title.setHorizontalAlignment(0);
        JLabel id = new JLabel("银行卡号：");
        id.setHorizontalAlignment(0);
        JTextField idInput = new JTextField(20);
        JLabel password = new JLabel("密码");
        JLabel password2 = new JLabel("确认密码");
        JLabel name = new JLabel("姓名");
        JLabel phone = new JLabel("电话号码");
        JLabel email = new JLabel("邮箱");
        JLabel address = new JLabel("地址");
        JLabel type = new JLabel("账户类型");
        JTextField idText = new JTextField(20);
        idText.setEditable(false);
        JPasswordField passwordText = new JPasswordField(20);
        JPasswordField password2Text = new JPasswordField(20);
        JTextField nameText = new JTextField(20);
        JTextField phoneText = new JTextField(20);
        JTextField emailText = new JTextField(20);
        JTextField addressText = new JTextField(20);
        JTextField typeText = new JTextField(20);
        JButton register = new JButton("注册");
        JButton cancel = new JButton("取消");
        //调用IDCreate类生成银行卡号
        IDCreate idCreate = new IDCreate();
        idText.setText(idCreate.getID());
        JPanel Titlepan = new JPanel();
        Titlepan.add(Title);
        c.add(Titlepan);
        c.add(id);
        c.add(idText);
        c.add(password);
        c.add(passwordText);
        c.add(password2);
        c.add(password2Text);
        c.add(name);
        c.add(nameText);
        c.add(phone);
        c.add(phoneText);
        c.add(email);
        c.add(emailText);
        c.add(address);
        c.add(addressText);
        c.add(type);
        c.add(typeText);
        c.add(register);
        c.add(cancel);
        this.setSize(260, 560);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}
