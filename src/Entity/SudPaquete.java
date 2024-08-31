package Entity;

public class SudPaquete  extends Paquete {
    public SudPaquete() {
        super();
    }



    @Override
    public Double calcularValor() {
        if (super.getDhl()) {
        return 5000.0*getPeso()*0.25*getCantidad();
        }
        return 5000.0*getPeso()*getCantidad();
    }
}
