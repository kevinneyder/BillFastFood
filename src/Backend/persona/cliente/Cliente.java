package Backend.persona.cliente;

import Backend.persona.Persona;

public class Cliente extends Persona {
    private int nit;

    public Cliente(String nombre) {
        super(nombre);
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }
}
