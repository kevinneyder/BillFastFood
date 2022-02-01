package Frontend.pedidoController;

import Backend.cliente.Cliente;
import Backend.productos.Producto;

import java.util.ArrayList;

public class PedidoController {
    private ArrayList<Producto> productos = new ArrayList<>();
    private Cliente cliente;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addProducto(Producto producto){
        productos.add(producto);
    }

    public void printDetalle(){

    }

}
