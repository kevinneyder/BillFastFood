package Backend.menu;

import Backend.productos.Producto;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Producto> productos;

    public Menu(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public void addProducto(Producto producto){
       productos.add(producto);
   }

   public void deleteProducto(){}
}
