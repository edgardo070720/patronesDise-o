package DAL;
import Entity.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GuiaRepository {
    private final String fileName;
    DestinatarioRepository destinatarioRepository;
    RemitenteRepository remitenteRepository;
    PaqueteRepository paqueteRepository;
    public GuiaRepository() {
        this.fileName = "data/GUIAS.txt";
        destinatarioRepository = new DestinatarioRepository();
        remitenteRepository = new RemitenteRepository();
        paqueteRepository = new PaqueteRepository();
    }
    public void guardarGuia(Guia guia) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
        bw.write(guia.toString());
        bw.newLine();
        bw.close();
        destinatarioRepository.guardarDestinatario(guia.getNumEnvio(),guia.getDestinatario());
        remitenteRepository.guardarRemitente(guia.getRemitente(),guia.getNumEnvio());
        paqueteRepository.guardarPaquete(guia.getPaquete(),guia.getNumEnvio());
    }

    public List<Guia> getGuias() throws IOException {
        List<Guia> guias = new ArrayList<Guia>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line=br.readLine()) != null) {
            String[] datos = line.split(",");
            Guia guia = new Guia();
            if(datos.length>0) {
                guia.setNumEnvio(Integer.parseInt(datos[0]));
                guia.setFecha(datos[1]);
                guia.setValorEnvio(Double.parseDouble(datos[2]));
                guia.setEstadoEnvio(datos[3]);
                guia.setDestinatario(destinatarioRepository.recuperarDestinatario(Integer.parseInt(datos[0])));
                guia.setRemitente(remitenteRepository.recuperarRemitente(Integer.parseInt(datos[0])));
                guia.setPaquete(paqueteRepository.recuperarPaquete(Integer.parseInt(datos[0])));
            }
            guias.add(guia);
        }
        br.close();
        return guias;
    }
}
