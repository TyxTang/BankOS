public class IDCreate {
    //随机生成int类型ID
public static int createID() {
        int id = (int) (Math.random() * 1000000000000000000L);
        return id;
    }
    //getID
public static int getID() {
        int id = createID();
        return id;
    }

    //从数据库中读取ID，判断是否重复


}
