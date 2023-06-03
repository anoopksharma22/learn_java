import com.phone.Apple;
import com.phone.Phone;

public class App {
    public static void main(String[] args) throws Exception {
        Phone phone1 = new Apple();        
        System.out.println("Name: " + phone1.name());
        System.out.println("Name: " + phone1.manufacturer());
        System.out.println("Name: " + phone1.memory());
    }
}
