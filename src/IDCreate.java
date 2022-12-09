public class IDCreate {
    //随机生成int类型ID
public static long createID() {
        long id = (long) (Math.random() * 1000000000000000000L);
        return id;
    }
    //getID
public static long getID() {
    SQL sql = new SQL();
        if(!sql.checkID(createID())){
            return createID();
        }
        else{
            return getID();
        }
    }



}
