package Backend.productos.bebida;

import Backend.productos.Categoria;
import Backend.productos.Producto;

public class Bebida extends Producto {
    private int litros;
    private String sabor;
    private int gradoAlcohol;
    private boolean importada;
    private Categoria categoria;

    public Bebida(String nombre, int precio,int litros, String sabor, int gradoAlcohol, boolean importada, Categoria categoria) {
        super(nombre, precio);
        this.litros = litros;
        this.sabor = sabor;
        this.gradoAlcohol = gradoAlcohol;
        this.importada = importada;
        this.categoria = categoria;
    }

    public int getLitros() {
        return litros;
    }

    public void setLitros(int litros) {
        this.litros = litros;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public int getGradoAlcohol() {
        return gradoAlcohol;
    }

    public void setGradoAlcohol(int gradoAlcohol) {
        this.gradoAlcohol = gradoAlcohol;
    }

    public boolean isImportada() {
        return importada;
    }

    public void setImportada(boolean importada) {
        this.importada = importada;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
