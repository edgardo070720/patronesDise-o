package Entity;

public class SudPaquete  extends Paquete {
    public SudPaquete() {
        super();
    }



    @Override
    public Double calcularValor() {
        if (super.getDhl()) {
        return 5000.0*super.getPeso()*0.25;
        }
        return 5000.0*super.getPeso();
    }
}
