class IDnow {


    static private long ID;
    public IDnow(long ID){
        this.ID = ID;
    }
    static public long getID_now(){
        return ID;
    }
    static public String getPhone(){
        SQL sql = new SQL();
        return sql.getPhone(ID);
    }
    static public String getEmail(){
        SQL sql = new SQL();
        return sql.getEmail(ID);
    }
    static public String getAddress(){
        SQL sql = new SQL();
        return sql.getAddress(ID);
    }
    static public String getName(){
        SQL sql = new SQL();
        return sql.getName(ID);
    }
    static public String getType(){
        SQL sql = new SQL();
        return sql.getType(ID);
    }

    static public double getBalance(){
        SQL sql = new SQL();
        return sql.getBalance(ID);
    }

}
