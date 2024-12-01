import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TryWithResource{
    public static void main(String[] args){
        // InputStreamReader in = new InputStreamReader(System.in);
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
            System.out.print("Enter you string: ");
            String input = bf.readLine();
            System.out.println(input);
        }
        catch( IOException io){
            System.out.println("Exception caught : " + io);
        }       
    }
}


/*
 
 
  
 */