import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

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
        typeText.setText("储蓄卡");
        typeText.setEditable(false);
        JButton register = new JButton("注册");
        JButton cancel = new JButton("取消");
        //调用IDCreate类生成银行卡号
        IDCreate idCreate = new IDCreate();
        idText.setText(String.valueOf(idCreate.getID()));
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
        //点击取消按钮，返回登录界面
        cancel.addActionListener(e -> {
            this.dispose();
            new LoginUI();
        });
        //点击注册按钮，连接数据库通过insertData方法将数据插入数据库，返回登录界面
        SQL sql = new SQL();
        sql.createTable();
        register.addActionListener(e -> {
            //id类型为long
            long id1 = Long.parseLong(idText.getText());
            //password类型为String
            String password1 = String.valueOf(passwordText.getPassword());
            String password3 = String.valueOf(password2Text.getPassword());
            String name1 = nameText.getText();
            String phone1 = phoneText.getText();
            String email1 = emailText.getText();
            String address1 = addressText.getText();
            String type1 = typeText.getText();
            if (password1.equals(password3)) {
                sql.insertData(id1, password1, name1, phone1, email1, address1, type1, 0);
                this.dispose();
                JOptionPane.showMessageDialog(null, "注册成功！您的银行卡号为：" + id1 + "（已复制到剪贴板）", "提示", JOptionPane.INFORMATION_MESSAGE);
                StringSelection stringSelection = new StringSelection(String.valueOf(id1));  //弹出注册成功提示框并展示银行卡号，将银行卡号复制到剪贴板
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
                new LoginUI();
            } else {
                JOptionPane.showMessageDialog(null, "两次密码不一致", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
