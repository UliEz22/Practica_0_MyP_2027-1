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

    public void calcularProm(double[] caltemp){
        double suma = 0.0;
        this.calficaciones = caltemp;

        for(int i=0; i < calficaciones.length; i++){
            suma += calficaciones[i];
        }

        this.promedio = Math.round((suma/calficaciones.length)*100.0) / 100.0;
        this.estado = (promedio >= 6.0);
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

    @Override
    public String toString(){
        return "\nESTUDIANTE:     " + nombre + "\n" +
               "CALIFICACIONES: " + Arrays.toString(calficaciones) +
               "\nPROMEDIO:       " + promedio + "\n" +
               "ESTADO:         " + (estado ? "Aprobado" : "Reprobado") + "\n";
    }

    public static void main(String args[]){

        String opcion;
        String nombre;

        System.out.println("-------------PRÁCTICA_0_CALIFICACIONES-------------");
        opcion = getOpcion("Si desea continuar con el programa ingrese 1, de lo contrario ingrese 'salir'. ");

        while(!opcion.equalsIgnoreCase("Salir")){
        switch (opcion) {
            case "1":
                nombre = getString("Ingresa el nombre del estudiante: ");
                Estudiante estudiante = new Estudiante(nombre);

                double caltemp[] = new double[3];

                for(int i = 0; i < caltemp.length; i++){
                    caltemp[i] = getDouble("Ingresa la calificación " + (i + 1) + ": ", 0, 10);
                }
                estudiante.calcularProm(caltemp);


                System.out.println(estudiante);

                break;

            default:
                break;
            }
        opcion = getOpcion("Si desea continuar con el programa ingrese '1', de lo contrario ingrese 'salir'. ");
        }
        System.out.println("Hasta luego:)");
    }
}
