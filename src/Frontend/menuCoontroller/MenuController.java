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

    public void printCategoria(){
        Scanner sc = new Scanner (System.in);
            System.out.println("===============================================");
            System.out.println("|    Seleccione una categoria por favor       |");
            System.out.println("===============================================");
            System.out.println("|CATEGORIAS:                                  |");
            System.out.println("|           1.-" + Categoria.HAMBURGUESAS+"                   |");
            System.out.println("|           2.-" + Categoria.PIZZAS+"                         |");
            System.out.println("|           3.-" + Categoria.ALITAS+"                         |");
            System.out.println("|           4.-" + Categoria.TOPPING_EXTRAS+"                 |");
            System.out.println("===============================================");
            printProductoCategoria(sc.nextInt()-1);
    }

    private void printProductoCategoria(int categoria){
        Scanner sc = new Scanner (System.in);
        ArrayList<Producto> aux = new ArrayList<>();
        int i;
        boolean b = true;
        do {
            System.out.println("Elija una opcion o pulse 0 para salir");
            AtomicInteger index = new AtomicInteger(1);
            System.out.println("===============================================");
            System.out.println("|      Seleccione un producto por favor       |");
            System.out.println("===============================================");
            System.out.println(""+Categoria.values()[categoria]+":");
            productos.forEach((p) -> {
                if(Categoria.values()[categoria].toString().equals(p.getCategoria().toString())){
                    aux.add(p);
                    System.out.println((index.getAndIncrement()) +".-"+  p.getNombre() +"............"+ p.getPrecio()+"Bs.");
                }
            });
            System.out.println("===============================================");
            i=sc.nextInt();
            if (i == 0){
                b = false;
//                productosSeleccionados.add(aux.get(0));
            }else {
                productosSeleccionados.add(aux.get(i-1));
            }
        }while (b);
        printSeleccionados();
    }

    public void printSeleccionados() {
        AtomicInteger i = new AtomicInteger(1);
        productosSeleccionados.forEach((p) -> {
            System.out.println((i.getAndIncrement()) +".-"+  p.getNombre() +"............"+ p.getPrecio()+"Bs.");
        });
    }

    public ArrayList<Producto> menuSeleccionado(){
        return productosSeleccionados;
    }

}

