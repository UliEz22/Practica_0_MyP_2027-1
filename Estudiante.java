import java.util.Scanner;
import java.util.Arrays;

public class Estudiante {
    public static final Scanner sc = new Scanner(System.in);
    private String nombre;
    private boolean estado;
    private double[] calficaciones;
    private double promedio;
    
    public Estudiante (String nombre){
        this.nombre = nombre;
        this.promedio = 0.0;
        this.estado = false;
    }

    public boolean getEstado(){
        return estado;
    }
    
    public double getPromedio(){
        return promedio;
    }

    public String getNombre(){
        return nombre;
    }   

    public int estaAprobado(){
        return (estado ? 1 : 0);
    }

    public static double getDouble (String mensaje, int min, int max){
        double valor;
        while(true){
            System.out.println(mensaje);
            if(sc.hasNextDouble()){
                valor = sc.nextDouble();
                if(valor < min || valor > max){
                    System.out.println("Ingresa una calificación válida");
                } else {
                    sc.nextLine();
                    return valor;
                }
            } else {
                System.out.println("Ingresa un valor válido");
                sc.next();
            }
            
        }
        
    }

    public static String getOpcion(String mensaje){
        System.out.println(mensaje);
        return sc.nextLine();
    }

    public static String getString(String mensaje){
        String txt;
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$";
        
        while (true) {
            System.out.println(mensaje);
            txt = sc.nextLine();
            if(txt.matches(regex)){
                return txt;
            } else {
                System.out.println("Texto no válido");
            }
        }
    }
}
