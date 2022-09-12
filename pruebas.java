import java.util.ArrayList;
public class pruebas {
    public static void main(String[] args) {
        ArrayList<String> cars=new ArrayList<String>();
        cars.add("adasdasd");
        cars.add("adasdasd");
        cars.add("adasdasd");
        cars.add("adasdasd");
        cars.add("adasdasd");
        cars.add("adasdasd");
        System.out.println(cars);
        cars.add("xxx");
        System.out.println(cars.indexOf("xxx"));
        for(int i=0;i<cars.size();i++){
            System.out.println(cars.get(i));
        }
    }
}
