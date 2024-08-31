package Entity;

public class SudCaja extends Paquete{
    public SudCaja() {
        super();
    }

    @Override
    public Double calcularValor() {
        if (super.getDhl()){
            return ((5000.0*getPeso())+25000)*0.25*getCantidad();
        }
        return (5000.0*getPeso())+25000*getCantidad();
    }
}
