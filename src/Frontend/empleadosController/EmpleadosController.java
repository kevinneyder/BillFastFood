package Frontend.empleadosController;

import Backend.persona.empleado.Empleado;
import Backend.persona.empleado.RolEmpleado;

import java.util.ArrayList;

public class EmpleadosController {
    private ArrayList<Empleado> empleados= new ArrayList<>();

    public EmpleadosController() {
        empleados.add(new Empleado("Lucas Vargas" , RolEmpleado.JEFE_COCINA, 4000));
        empleados.add(new Empleado("Pedro Alberto", RolEmpleado.AYUDANTE, 3500));
        empleados.add(new Empleado("Erik Anzaldo", RolEmpleado.AYUDANTE, 3000));
        empleados.add(new Empleado("Lucas Vasquez", RolEmpleado.AYUDANTE, 2400));
        empleados.add(new Empleado("Marcelo Castro", RolEmpleado.CAJERO, 3200));
        empleados.add(new Empleado("Nelson Flores", RolEmpleado.CAJERO, 4200));
        empleados.add(new Empleado("Danilo Jimenez", RolEmpleado.MESERO, 1900));
        empleados.add(new Empleado("Alex Zapata", RolEmpleado.MESERO, 2000));
        empleados.add(new Empleado("Juan Carlos", RolEmpleado.MESERO, 2800));
    }

    public void printSalarios(){
        System.out.println("-".repeat(84));
        System.out.printf("|%-30s|%-30s|%-20s|\n", "NOMBRE", "CARGO", "SALARIO");
        System.out.println("-".repeat(84));
        empleados.forEach((e) -> {
            System.out.printf( "|%-30s|%-30s|%-20s|\n", e.getNombre()+"  ",  e.getRol().toString().toLowerCase() , e.getSalario()+" Bs.");
        });
        System.out.println("-".repeat(84));
        System.out.printf("|%-30s|%-30s|%-20s|\n", "TOTAL SUELDOS", "", getTotalSueldos()+"Bs");
        System.out.println("-".repeat(84)+"\n");

    }

    private int getTotalSueldos() {
        int total = empleados.stream().mapToInt(Empleado::getSalario).sum();
        return total;
    }
}
