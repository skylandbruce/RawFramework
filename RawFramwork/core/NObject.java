public class NObject extends AttrSuper{
    NObject(){
        super();        
    }

    /** -------------------------------------
     * AttrSuper 에서 abstract method 로 설정되어 정의 필수
     */
    public String get_name(){
        return "name:N";
    }
    
    public AttrSuper get_instance(){
        AttrSuper nucleus=(AttrSuper)new NObject();
        return nucleus;
    }
    //------------------------------------
    public void set_int(Integer num ){
		set_super_value(num);
	}
    
    public int get_int(){
		return (int)get_super_value();
	}	
}
