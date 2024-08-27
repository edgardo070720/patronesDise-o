package BLL;
import DAL.*;
import Entity.*;
public class GuiaService {
    private GuiaRepository repo;
    public GuiaService() {
        repo = new GuiaRepository();
    }
    public  String addGuia(Guia guia) {
        try {
            repo.guardarGuia(guia);
            return "se guardaron los datos de la guia satisfactoriamente";
        }catch (Exception e) {
            return e.getMessage();
        }
    }
    public GuiaListResponse getListGuia() {
        GuiaListResponse response = new GuiaListResponse();
        try {
            response.setGuias(repo.getGuias());
            response.setMessage("");
        }catch (Exception e) {
            response.setMessage(e.getMessage());
        }
        return response;
    }

}


