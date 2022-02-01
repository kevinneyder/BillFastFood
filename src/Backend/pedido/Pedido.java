package Backend.pedido;

import Backend.persona.cliente.Cliente;
import Backend.factura.Factura;
import Backend.productos.Producto;

import java.util.ArrayList;

public class Pedido {
    private Factura factura;
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private String estado;

    public void addProducto( Producto producto ){
        productos.add(producto);
    }

    public void deleteProducto(){}


}
