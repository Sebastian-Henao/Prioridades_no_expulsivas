package libproceso;

// Clase que representa las funciones de la biblioteca dinamica JNI

public class JavaProceso {
    public native String algoritmo_Prioridades(String json);

    public JavaProceso(){
        try{
            System.loadLibrary("Proceso");
            System.out.println("Biblioteca cargada exitosamente!");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Carga de la biblioteca fallida: " + e.getMessage());
        }
    }
}
