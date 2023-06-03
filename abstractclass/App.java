import com.abstractclass.Printer;

class MainApp{
    public static void main(String args[]) {
        Printer p1 = new MyPrinter();
        p1.printdoc("Hello my name is Anoop");
        p1.printertype();
        p1.info();
    }
}
