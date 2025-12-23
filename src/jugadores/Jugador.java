package jugadores;

public class Jugador {

    private int dorsal;
    private String nombre;
    private int edad;
    private String posicion;
    private double valorMercado;
    private int valoracion;


    public Jugador(int dorsal, String nombre, int edad, String posicion,
                   double valorMercado, int valoracion) {

        this.dorsal = dorsal;
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
        this.valorMercado = valorMercado;
        this.valoracion = valoracion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public String getPosicion() {
        return posicion;
    }
    public double getValorMercado() {
        return valorMercado;
    }
    public int getValoracion() {
        return valoracion;
    }
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    public void setValorMercado(double valorMercado) {
        this.valorMercado = valorMercado;
    }
    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
    @Override
    public String toString() {
        return "Jugador{" + "dorsal=" + dorsal + ", nombre=" + nombre + ", edad=" + edad + ", posicion=" + posicion + ", valorMercado=" + valorMercado + ", valoracion=" + valoracion + '}';
    }
}


