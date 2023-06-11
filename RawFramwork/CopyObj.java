import java.util.ArrayList;

public class CopyObj {
    public static void main(String[] args) {
        // MObject 와 NObject 의 Instance Data 확인용 String 생성
        String m_str=new String();
        String n_str=new String();

        // MObject 와 NObject 의 Instance 생성
        MObject m_obj=new MObject();
        m_obj.set_str("m_obj_value");
        NObject n_obj=new NObject();   
        n_obj.set_int(99999);     
        m_str=String.format("m_obj=%s, key:%d, value=%s",m_obj.get_name(),m_obj.get_key(),m_obj.get_str());
        n_str=String.format("n_obj=%s, key:%d, value=%d",n_obj.get_name(),n_obj.get_key(),n_obj.get_int());
        System.out.println(m_str);
        System.out.println(n_str);

        System.out.println("--부모 Object를 통해서도 Instance 자료 접근이 가능--BUT 자식 Object의 자료영역은 접근 불가!----");
        //-------------------------------------------
        AttrSuper m_super=m_obj;
        AttrSuper n_super=n_obj;
        m_str=String.format("m_obj=%s, key:%d"/*, value=%s*/,m_super.get_name(),m_super.get_key()/*,instance_m.get_str() $$ 추상메소드에서는 접근불가*/);
        n_str=String.format("n_obj=%s, key:%d"/*,value=%d*/,n_super.get_name(),n_super.get_key()/*,instance_n.get_int() $$ 추상메소드에서는 접근불가*/);
        System.out.println(m_str);
        System.out.println(n_str);
        
        System.out.println("SO--부모 Object로 Framework를 construct하고");
        System.out.println("THEN, 진행중인 Project에 맞게 business Object를 customizing 함으로써 프로젝트를 완성------");
        //-------------------------------------------
        // 부모 Object를 통해, 필요한 개수의 Instance를 생성해서 list에 보관, 관리 하도록 해서, framwork를 construct 한다
        int size_factoring=10;
        ArrayList<AttrSuper> list=new ArrayList<>();
        for(int i=0; i<size_factoring; i++){
            AttrSuper n_obj_super=(AttrSuper)n_obj.get_instance();
            list.add(n_obj_super);            
        }
        
        // 추상적이었던 부모 Object를 진행중인 Project에 적합하게 NObject 형 business Object 로 구체화해서 Project 완성 
        for(int i=0; i<10; i++){
            NObject n_biz_obj=(NObject)list.get(i);            
            n_biz_obj.set_int(i);            
        }
        
        // 구체화된 NObject형 n_biz_obj Object의 Instance 들의 data를 확인해 본다
        list.forEach((n_obj_super)->{
            NObject n_biz_obj=(NObject)n_obj_super;            
            String n_str_conv=String.format("n_obj=%s, key:%d,value=%d",
                n_biz_obj.get_name(),n_biz_obj.get_key(),n_biz_obj.get_int());                        
            System.out.println(n_str_conv);
        });
        
    }        
}    

