package structure;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Hospital
 * Description:     医院结构层次(菜单类)
 * date: 2021/6/29 15:21
 */
public class HospitalLevel extends Hospital{

    //菜单里面可以有子菜单和子菜单项
    private List<Hospital> hospitals = new ArrayList<>();

    //构造方法
    public HospitalLevel(String name, int level) {
        this.name = name;
        this.level = level;
    };

    @Override
    public void add(Hospital hospital) {
        hospitals.add(hospital);
    }

    @Override
    public void remove(Hospital hospital) {
        hospitals.remove(hospital);
    }

    @Override
    public Hospital getChild(int index) {
        return hospitals.get(index);
    }

    @Override
    public void print() {
        //打印菜单项名称
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(name);
        //打印子菜单或子菜单项名称
        for (Hospital hospital : hospitals) {
            hospital.print();
        }
    }
}
