package competicion;

public abstract class Competicion {

    private String nombre;
    private boolean generada;
    private boolean terminada;

    public Competicion(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            this.nombre = "Competición";
        } else {
            this.nombre = nombre.trim();
        }
        this.generada = false;
        this.terminada = false;
    }


    public abstract void generar();

    public abstract boolean simularRonda(boolean verEnDirecto);

    public abstract void mostrarUltimosResultados();

    public abstract boolean haTerminado();


    public String getNombre() {
        return nombre;
    }

    public boolean isGenerada() {
        return generada;
    }

    protected void setGenerada(boolean generada) {
        this.generada = generada;
    }

    public boolean isTerminada() {
        return terminada;
    }

    protected void setTerminada(boolean terminada) {
        this.terminada = terminada;
    }

    public static boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }


    public void mostrarEstado() {
        System.out.println("\n==============================");
        System.out.println("COMPETICIÓN: " + nombre);
        System.out.println("Generada: " + generada);
        System.out.println("Terminada: " + terminada);
        System.out.println("==============================\n");
    }

    @Override
    public String toString() {
        return "Competicion{" +
                "nombre='" + nombre + '\'' +
                ", generada=" + generada +
                ", terminada=" + terminada +
                '}';
    }
}