package SportClass;

import java.time.LocalDate;

public class Evento {

       private LocalDate fecha;
       private String deporte;
       private String nombre;

        public Evento(LocalDate fecha, String deporte, String nombre) {
            this.fecha = fecha;
            this.deporte = deporte;
            this.nombre = nombre;

        }

        public  LocalDate getFecha() {
            return fecha;
        }
        public String getDeporte() {
            return deporte;
        }
        public String getNombre() {
            return nombre;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }
        public void setDeporte(String deporte) {
            this.deporte = deporte;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        @Override
        public String toString() {
            return fecha + " - " + deporte + " - " + nombre;
        }
}

