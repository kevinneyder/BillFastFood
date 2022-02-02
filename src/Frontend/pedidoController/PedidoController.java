package Frontend.pedidoController;

import Backend.cliente.Cliente;
import Backend.pedido.DetallePedido;
import Backend.productos.Producto;
import Frontend.menuCoontroller.MenuController;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class PedidoController {
    private ArrayList<Producto> productos;
    private Cliente cliente = new Cliente();
    private MenuController menu = new MenuController();
    private ArrayList<DetallePedido> detallePedidos = new ArrayList<>();

    public PedidoController() {
        productos = menu.getProductosSeleccionados();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addProducto(Producto producto){
        productos.add(producto);
    }

    public void printMenu(){
        menu.printMenu();
        System.out.println("Bienvenido a Bill Fast Food...!!!");
        menuOpciones();
    }

    public void menuOpciones(){
        boolean b = true;
        int seleccion;
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Ver Menu");
        System.out.println("2. Realizar Pedido");
        System.out.println("3. Ver Detalle Pedidos");
        System.out.println("4. Imprimir factura");
        System.out.println("0. Salir");
        seleccion = sc.nextInt();
            switch (seleccion){
                case 0:
                    System.out.println("Gracias por visitarnos, vuelva pronto");
                    break;
                case 1:
                    verMenu();
                    break;
                case 2:
                    realizarPedido();
                    break;
                case 3:
                    printDetalle();
                    menuOpciones();
                    break;
                case 4:
                    printFactura();
                    break;
                default:
                    System.out.println("Opcion no valida");

            }
    }

    private void verMenu() {
        menu.printMenu();
        menuOpciones();
    }

    private void realizarPedido() {
//        System.out.println("Seleccione un producto por favor: ");
        menu.seleccionar();
        seleccionarCantidad();
    }

    private void seleccionarCantidad(){
        Scanner sc = new Scanner (System.in);
        System.out.println("Seleccione la cantidad:");
        detallePedidos.add(new DetallePedido(sc.nextInt(), productos.get(productos.size()-1)));
        menuOpciones();
    }

    public void printSeleccionados() {
        AtomicInteger index = new AtomicInteger(0);
        productos.forEach((p) -> {
            index.getAndIncrement();
            System.out.printf( "| %-5s%-25s%s%14s\n", index+".-",  p.getNombre() ,".".repeat(55), p.getPrecio()+" Bs. |");
        });
    }

    private void printDetalle() {
        AtomicInteger index = new AtomicInteger(0);
        System.out.println("-".repeat(84));
        System.out.printf("|%-20s|%-40s|%-20s|\n", "CANTIDAD", "DESCRIPCION", "PRECIO");
        System.out.println("-".repeat(84));
        detallePedidos.forEach((p) -> {
            index.getAndIncrement();
            System.out.printf( "|%-20s|%-40s|%-20s|\n", p.getCantidad()+"  ",  p.getProducto().getNombre() , p.getProducto().getPrecio()*p.getCantidad()+" Bs.");
        });
        System.out.println("-".repeat(84)+"");
    }

    private void printFactura(){
        if (detallePedidos.size() != 0){
            Scanner sc = new Scanner (System.in);
            System.out.println("Imgrese su nombre por favor");
            cliente.setNombre(sc.nextLine());
            System.out.println("Imgrese su NIT por favor");
            cliente.setNit(sc.nextInt());
        }else {
            System.out.println("Realice un pedido primero!\n");
            menuOpciones();
        }
        System.out.printf("%-20s%-40s%-20s\n", "NOMBRE:  "+cliente.getNombre()+"        ", "NIT:  "+cliente.getNit(),"  ");
        printDetalle();
        System.out.printf("|%-20s|%-40s|%-20s|\n", "TOTAL COMPRA", "", getTotalPedido()+"Bs");
        System.out.println("-".repeat(84));


    }

    private double getTotalPedido(){
        double total = detallePedidos.stream().mapToDouble(p -> (p.getCantidad() * p.getProducto().getPrecio())).sum();
        return total;
    }

}
