package Entity;

public class SudSobre extends Paquete {
    public SudSobre() {
        super();
    }



    @Override
    public Double calcularValor(){
        if(super.getDhl()){
            return 15000.0*0.25*getCantidad();
        }
        return 15000.0*getCantidad();
    }

}
