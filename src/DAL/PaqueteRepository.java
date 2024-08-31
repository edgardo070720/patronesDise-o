package DAL;

import Entity.Paquete;
import Entity.SudCaja;
import Entity.SudPaquete;
import Entity.SudSobre;

import java.io.*;

public class PaqueteRepository {
    private final String fileName;
    public PaqueteRepository() {
        this.fileName = "data/paquete.txt";
    }
    public void guardarPaquete(Paquete paquete,int numEnvio,boolean fileAppend) throws IOException {
        BufferedWriter bw= new BufferedWriter(new FileWriter(fileName,fileAppend));
        bw.write(paquete.toString()+","+numEnvio);
        bw.newLine();
        bw.close();
    }
    public Paquete recuperarPaquete(int numEnvio) throws IOException {
        Paquete paquete=null;
        BufferedReader br= new BufferedReader(new FileReader(fileName));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            if(datos.length>0&&datos[5].equals(String.valueOf(numEnvio))) {
                paquete=definirInstancia(Integer.parseInt(datos[4]));
                paquete.setIdPaquete(datos[0]);
                paquete.setCantidad(Integer.parseInt(datos[1]));
                paquete.setPeso(Float.parseFloat(datos[2]));
                paquete.setDhl(Boolean.valueOf(datos[3]));
                paquete.setTipoPaquete(Integer.parseInt(datos[4]));
            }
        }
        br.close();
        return paquete;
    }

    private Paquete definirInstancia(int tipoPaquete) {

        switch (tipoPaquete) {
            case 1:return new SudPaquete();
            case 2:return new SudCaja();
            case 3:return new SudSobre();
        }
        return null;
    }
}
