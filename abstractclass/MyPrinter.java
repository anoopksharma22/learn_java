import com.abstractclass.Printer;

public class MyPrinter extends Printer{
    
    @Override
    public void printdoc(String doc){
        System.out.println(doc);
    }
    
    @Override
    public void printertype(){
        System.out.println("Laser printer");
    }
}
