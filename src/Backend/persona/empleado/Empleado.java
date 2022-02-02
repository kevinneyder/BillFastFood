package Backend.persona.empleado;

import Backend.persona.Persona;

public class Empleado extends Persona {
    private int salario;
    private RolEmpleado rol;
    private int horaIngreso;
    private int horaSalida;

    public Empleado(String nombre, RolEmpleado rol,int salario) {
        super(nombre);
        this.salario = salario;
        this.rol = rol;
    }

    public RolEmpleado getRol() {
        return rol;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(int horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }
}
