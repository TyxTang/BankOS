import javax.swing.*;

public class LoginInspection extends JFrame {
    public boolean match(long id, String password) {
        SQL sql = new SQL();
        if(sql.match(id, password)){
            System.out.println("登录成功");
            return true;
        }
        else{
            System.out.println("登录失败");
            return false;
        }
    }

}
