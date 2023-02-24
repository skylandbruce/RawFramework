public class MObject extends AttrSuper{
    MObject(){
        super();        
    }

    public String get_name(){
        return "name:M";
    }
    
    public AttrSuper get_instance(){
        AttrSuper nucleus=(AttrSuper)new MObject();
        return nucleus;
    }

    public void set_str(String str){
		set_super_value(str);
	}
    
    public String get_str(){
		return (String)get_super_value();
	}	
}
