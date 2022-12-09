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
        con.add(done2);
        con.add(cancel2);
        this.setSize(340, 100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        SQL sql = new SQL();
        sql.createTable();
        cancel2.addActionListener(e -> {
            WithdrawMoney.this.dispose();
            MenuMain menuMain = new MenuMain();
        });
        done2.addActionListener(e -> {
            //取钱
            double qq = Double.parseDouble(qqInput.getText());
            String balance_2String = String.format("%.2f", qq);
            SQL sql1 = new SQL();
            if(sql1.outMoney(IDnow.getID_now(),qq)){
                JOptionPane.showMessageDialog(null, "取款成功！取款金额为：" + balance_2String , "提示", JOptionPane.INFORMATION_MESSAGE);
                WithdrawMoney.this.dispose();
                MenuMain menuMain = new MenuMain();
            }
            else{
                String balance_3String = String.format("%.2f", sql.getBalance(IDnow.getID_now()));
                JOptionPane.showMessageDialog(null, "取款失败！余额不足，你的余额为：" + balance_3String , "提示", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
