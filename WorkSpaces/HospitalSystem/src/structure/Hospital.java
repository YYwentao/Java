package structure;

/**
 * ClassName: Hospital
 * Description:
 * date: 2021/6/29 15:11

 */
public abstract class Hospital {
    //医生的名称
    protected String name;
    //层级
    protected int level;

    //添加子菜单
    public void add(Hospital hospital) {
        //默认实现
        throw new UnsupportedOperationException();
    }

    //移除子菜单
    public void remove(Hospital hospital) {
        //默认实现
        throw new UnsupportedOperationException();
    }

    //获取指定的子菜单
    public  Hospital getChild(int index) {
        throw new UnsupportedOperationException();
    }

    //获取菜单或菜单项的名称
    public String getName() {
        return name;
    }

    //print方法打印菜单名称的方法(包含子菜单和菜单项)
    public abstract void print();
}
