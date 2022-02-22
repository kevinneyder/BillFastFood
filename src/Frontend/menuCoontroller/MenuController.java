package Frontend.menuCoontroller;

import Backend.productos.Producto;
import Backend.productos.Categoria;
import Backend.productos.comida.alitas.AlitasPollo;
import Backend.productos.comida.alitas.Guarnicion;
import Backend.productos.comida.alitas.Salsa;
import Backend.productos.comida.hamburguesa.Hamburguesa;
import Backend.productos.comida.hamburguesa.TipoCarne;
import Backend.productos.comida.hamburguesa.Topping;
import Backend.productos.comida.pizza.Pizza;
import Backend.productos.comida.pizza.Tamanio;
import Backend.productos.comida.pizza.Tipo;
import Backend.productos.extra.ToppingExtra;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MenuController {
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Producto> productosSeleccionados = new ArrayList<>();


    public MenuController(){
        productos.add(new Hamburguesa("Hamburguesa de carne", 12, TipoCarne.VACUNA, new Topping[]{Topping.JAMON_SERRANO, Topping.BACON}));
        productos.add(new Hamburguesa("Hamburguesa de cerdo", 12, TipoCarne.CERDO, new Topping[]{Topping.JAMON_SERRANO}));
        productos.add(new Hamburguesa("Hamburguesa de ternera", 12, TipoCarne.TERNERA));
        productos.add(new Pizza("Pizza americana", 50, 15, Tamanio.FAMILIAR, Tipo.AMERICANA));
        productos.add(new Pizza("Pizza hawaiana", 80, 15, Tamanio.NORMAL, Tipo.HAWAIANA));
        productos.add(new Pizza("Pizza jamon y queso", 90, 15, Tamanio.INTERMINABLE, Tipo.JAMON_QUESO));
        productos.add(new AlitasPollo("Alitas picantes", 50, 15, Salsa.PICANTE, Guarnicion.PAPAS_FRITAS));
        productos.add(new AlitasPollo("Alitas BBQ", 30, 15, Salsa.BBQ, Guarnicion.YUCA));
        productos.add(new AlitasPollo("Alitas agridulce", 40, 15, Salsa.PICANTE, Guarnicion.ENSALADA));
        productos.add(new ToppingExtra("Papas fritas", 10, "mediano"));
        productos.add(new ToppingExtra("Yuca", 10, "Grande"));
        productos.add(new ToppingExtra("Ensalada", 10, "pequenio"));
    }

    public void printMenu(){
        int index = 0;
        System.out.println("=====================================================================================================");
        System.out.printf("%s%60s%40s%n","*", "!! MENU DEL DIA !!","*");
        System.out.println("=====================================================================================================");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.printf("|%s%88s|%n","CATEGORIAS:","");
        for (Categoria c : Categoria.values()) {
            System.out.printf("|%40s%-59s|\n","", "~~~~ "+ c +" ~~~~");
            printProductoCategoria(index);
            index++;
        }
        System.out.println("=====================================================================================================");
    }

    private void printProductoCategoria(int categoria){
        Scanner sc = new Scanner (System.in);
        boolean b = true;
            AtomicInteger index = new AtomicInteger(0);
            productos.forEach((p) -> {
                index.getAndIncrement();
                if(Categoria.values()[categoria].toString().equals(p.getCategoria().toString())){
                    System.out.printf( "| %-5s%-25s%s%14s\n", index+".-",  p.getNombre() ,".......................................................", p.getPrecio()+" Bs. |");
                }
            });
            System.out.printf("\n");
    }


    public void printSeleccionados() {
        productosSeleccionados.forEach((p) -> {
                System.out.printf( "| %-5s%-25s%s%14s\n", "",  p.getNombre() ,".......................................................", p.getPrecio()+" Bs. |");
        });
    }

    public void seleccionar(){
        int seleccion;
        printMenu();
        System.out.println("Seleccione un producto por favor: ");
            Scanner sc = new Scanner (System.in);
            seleccion = sc.nextInt();;
            if(seleccion != 0){
                productosSeleccionados.add(productos.get(seleccion-1));
            }
    }

    public ArrayList<Producto> menuSeleccionado(){
        return productosSeleccionados;
    }

    private void seleccionarCantidad(){
        Scanner sc = new Scanner (System.in);
        System.out.println("Seleccione la cantidad:");


    }

    public ArrayList<Producto> getProductosSeleccionados() {
        return productosSeleccionados;
    }
}

