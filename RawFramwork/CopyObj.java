import java.util.LinkedList;

public class CopyObj {
    public static void main(String[] args) {
        String m_str=new String();
        String n_str=new String();
        MObject m_obj=new MObject();
        m_obj.set_str("m_obj_value");
        NObject n_obj=new NObject();   
        n_obj.set_int(99999);     
        m_str=String.format("m_obj=%s, key:%d, value=%s",m_obj.get_name(),m_obj.get_key(),m_obj.get_str());
        n_str=String.format("n_obj=%s, key:%d, value=%d",n_obj.get_name(),n_obj.get_key(),n_obj.get_int());
        System.out.println(m_str);
        System.out.println(n_str);

        System.out.println("--객체 생성전에 추상클래스를 프레임워크에서 사용할 수 있다--BUT Object의 값을 사용할 수는 없다----");
        //-------------------------------------------

        AttrSuper instance_m=(AttrSuper)m_obj.get_instance();
        AttrSuper instance_n=(AttrSuper)n_obj.get_instance();
        m_str=String.format("m_obj=%s, key:%d"/*, value=%s*/,instance_m.get_name(),instance_m.get_key()/*,instance_m.get_str() $$ 추상메소드에서는 접근불가*/);
        n_str=String.format("n_obj=%s, key:%d"/*,value=%d*/,instance_n.get_name(),instance_n.get_key()/*,instance_n.get_int() $$ 추상메소드에서는 접근불가*/);
        System.out.println(m_str);
        System.out.println(n_str);
        
        System.out.println("THEN--객체로 형변환 해서 Object의 값에 접근 한다------");
        //-------------------------------------------
        
        LinkedList list=new LinkedList<>();
        for(int i=0; i<10; i++){
            AttrSuper attr_inst=(AttrSuper)n_obj.get_instance();
            list.addLast(attr_inst);            
        }
        
        for(int i=0; i<10; i++){
            NObject get_obj=(NObject)list.get(i);            
            get_obj.set_int(i);            
        }
        
        for(int i=0; i<10; i++){
            NObject get_obj=(NObject)list.get(i);            
            n_str=String.format("n_obj=%s, key:%d,value=%d",get_obj.get_name(),get_obj.get_key(),get_obj.get_int());                        
            System.out.println(n_str);
        }
        
    }        
}    

