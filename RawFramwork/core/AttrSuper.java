import util.UniqueGenerator;

public abstract class AttrSuper {
    private String name;
    private long key;
    //private UniqueGenerator unique;

    private Object super_value; 
    AttrSuper(){
        key=UniqueGenerator.instance().getUniqueNumber();
        name=get_name();
    }
    public abstract AttrSuper get_instance();
    public abstract String get_name();

    public long get_key(){
        return key;
    }
    protected void set_super_value(Object str){
        super_value=str;
    }

    protected Object get_super_value(){
        return super_value;
    }

    public AttrSuper get_obj(){
            AttrSuper obj=this.get_instance();
        return obj;
    }

}
