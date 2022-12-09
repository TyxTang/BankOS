import javax.swing.*;
import java.awt.*;

public class WithdrawMoney extends JFrame {
    private JLabel cq2;
    private JButton cancel2,done2;
    private JTextField qqInput;
    public WithdrawMoney(){
        super("取钱");
        Container con = this.getContentPane();
        con.setLayout(new FlowLayout());
        cq2=new JLabel("取出金额：");
        qqInput = new JTextField(20);
        cancel2=new JButton("取消");
        done2=new JButton("确定");
        con.add(cq2);
        con.add(qqInput);
        con.add(cancel2);
        con.add(done2);
        this.setSize(340, 100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        SQL sql = new SQL();
        sql.createTable();
        cancel2.addActionListener(e -> {
            MenuMain me =new MenuMain();
        });
        done2.addActionListener(e -> {
            MenuMain me =new MenuMain();
        });
    }
}
