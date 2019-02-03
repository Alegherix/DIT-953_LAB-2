public class Testing {

    public static void main(String[] args) {
        Car volvo = new Saab95();
        System.out.println(volvo.getCurrentSpeed());
        volvo.gas(1);
        System.out.println(volvo.getCurrentSpeed());
        volvo.gas(0);
        System.out.println(volvo.getCurrentSpeed());
        for (int i = 0; i <=150; i++){
            volvo.gas(1);
        }
        System.out.println(volvo.getCurrentSpeed());

    }

}
