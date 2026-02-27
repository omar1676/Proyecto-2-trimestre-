package competicion;

import clubes.Club;

public class SegundaDivision extends Liga {

    public SegundaDivision(String nombre, Club[] clubes) {
        super(nombre, clubes);
    }

    @Override
    public void generar() {
        super.generar();
    }

    @Override
    public String toString() {
        return "Segunda Division: " + getNombre();
    }
}
