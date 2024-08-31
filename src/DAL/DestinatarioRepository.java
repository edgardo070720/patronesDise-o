package DAL;

import Entity.Destinatario;

import java.io.*;

public class DestinatarioRepository {
    private final String filename;
    public DestinatarioRepository() {
        this.filename = "data/destinatarios.txt";
    }
    public void guardarDestinatario(int numEnvio,Destinatario destinatario,boolean fileAppend) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename,fileAppend));
        bw.write(destinatario.toString()+","+numEnvio);
        bw.newLine();
        bw.close();
    }
    public Destinatario recuperarDestinatario(int numEnvio) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        Destinatario destinatario = new Destinatario();
        String linea;
        while ((linea=br.readLine())!= null) {
            String[] datos = linea.split(",");
            if (datos.length>0 && datos[9].equals(String.valueOf(numEnvio))) {
                    destinatario.setId(datos[0]);
                    destinatario.setCompania(datos[1]);
                    destinatario.setContacto(datos[2]);
                    destinatario.setCalle(datos[3]);
                    destinatario.setCol(datos[4]);
                    destinatario.setCiudad(datos[5]);
                    destinatario.setEstado(datos[6]);
                    destinatario.setPais(datos[7]);
                    destinatario.setCodigoPostal(datos[8]);
            }
        }
        br.close();
        return destinatario;
    }
}
