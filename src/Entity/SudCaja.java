package Entity;

public class SudCaja extends Paquete{
    public SudCaja() {
        super();
    }

    @Override
    public Double calcularValor() {
        if (super.getDhl()){
            return ((5000.0*super.getPeso())+25000)*0.25;
        }
        return (5000.0*super.getPeso())+25000;
    }
}
