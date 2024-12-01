import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TryWithResource{
    public static void main(String[] args){
        InputStreamReader in = new InputStreamReader(System.in);
        try (BufferedReader bf = new BufferedReader(in)){
            System.out.print("Enter you string: ");
            String input = bf.readLine();
            System.out.println(input);
        }
        catch( IOException io){
            System.out.println("Exception caught : " + io);
        }       
    }
}