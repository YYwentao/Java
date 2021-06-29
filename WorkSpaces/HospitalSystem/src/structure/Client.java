package structure;

/**
 * ClassName: Client
 * Description:
 * date: 2021/6/29 17:45
 *
 * @author wt
 * @since JDK 1.8
 */
public class Client {
    public static void main(String[] args) {
        //创建菜单项
        Hospital menu1 = new HospitalLevel("消化内科",3);
        menu1.add(new Doctor("1号消化内科医生",4));
        menu1.add(new Doctor("2号消化内科医生",4));

        Hospital menu2 = new HospitalLevel("心血管科",3);
        menu2.add(new Doctor("1号心血管科医生",4));
        Hospital menu3 = new HospitalLevel("骨科",3);
        menu3.add(new Doctor("1号骨科医生",4));
        Hospital menu4 = new HospitalLevel("神经外科",3);
        menu4.add(new Doctor("1号神经外科",4));
        //创建二级菜单,把三级菜单加到二级菜单中
        Hospital menu5 = new HospitalLevel("内科",2);
        menu5.add(menu1);
        menu5.add(menu2);
        //menu5.print();
        Hospital menu6 = new HospitalLevel("外科",2);
        menu6.add(menu3);
        menu6.add(menu4);
        //创建一级菜单,把二级菜单加到一级菜单中
        Hospital menu = new HospitalLevel("xx医院",1);
        menu.add(menu5);
        menu.add(menu6);
        menu.print();
    }
}
