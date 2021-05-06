package simplevagetables;


public interface RootFactory {
    public static Root makeRoot(String root){
        if (root.equals("Carrot")){
            return new Carrot();
        }else if (root.equals("Potato")){
            return new Potato();
        }else if (root.equals("Radish")){
            return new Radish();
        }else if (root.equals("Turnip")){
            return new Turnip();
        }
        return null;
    }
}

