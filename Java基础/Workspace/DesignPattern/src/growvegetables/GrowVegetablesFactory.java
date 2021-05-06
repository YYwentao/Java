package growvegetables;
//抽象种植工厂
public interface GrowVegetablesFactory {
    //种植根类
    Root root();
    //种植茎类
    Celery celery();
}
