public class IDCreate {
    //随机生成ID
    public static String createID() {
        String id = "";
        for (int i = 0; i < 18; i++) {
            id += (int) (Math.random() * 10);
        }
        return id;
    }
    static String getID() {
        String id = createID();
        while (true) {
            if (id.charAt(0) != '0') {
                break;
            }
            id = createID();
        }
        return id;
    }

}
