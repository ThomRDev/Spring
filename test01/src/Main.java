import app.Program;

public class Main {
    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            System.out.println("Hola mundo");
            Program pr = new Program(i);
            System.out.println(pr.getTime());
        }
    }
}