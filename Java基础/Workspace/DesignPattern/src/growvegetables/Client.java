package growvegetables;

public class Client {
    public static void main(String[] args) {
        TransgenosisRoot transgenosisRoot = new TransgenosisRoot();
        transgenosisRoot.seed();
        transgenosisRoot.grow();
        transgenosisRoot.fruit();
        TransgenosisCelery transgenosisCelery = new TransgenosisCelery();
        transgenosisCelery.seed();
        transgenosisCelery.grow();
        transgenosisCelery.fruit();
        System.out.println();
        NgMoRoot ngMoRoot = new NgMoRoot();
        ngMoRoot.seed();
        ngMoRoot.grow();
        ngMoRoot.fruit();
    }
}
