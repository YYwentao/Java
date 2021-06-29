package structure;

/**
 * ClassName: Doctor
 * Description: 子菜单项
 * date: 2021/6/29 17:42
 */
public class Doctor extends Hospital {

    public Doctor(String name,int level) {
        this.name = name;
        this.level = level;
    }

    public void print() {
        //打印菜单项的名称
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(name);
    }

}
