import javax.swing.*;

public class LoginInspection extends JFrame {
    public boolean handler(String id, String password) {
        if(id.equals("Mary") && password.equals("123")){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean login(String id, String password) {
        return handler(id, password);
    }

}
