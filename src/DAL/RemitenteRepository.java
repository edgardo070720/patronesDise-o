package DAL;

import Entity.Remitente;

import java.io.*;

public class RemitenteRepository {
    private final  String fileName;
    public RemitenteRepository() {
        this.fileName = "data/remitentes.txt";
    }
    public void  guardarRemitente(Remitente remitente,int numEnvio) throws IOException {
        BufferedWriter bw= new BufferedWriter(new FileWriter(fileName,true));
        bw.write(remitente.toString()+","+numEnvio);
        bw.newLine();
        bw.close();
    }
    public Remitente recuperarRemitente(int id) throws IOException {
        BufferedReader br= new BufferedReader(new FileReader(fileName));
        String line;
        Remitente remitente = new Remitente();
        while((line=br.readLine())!=null){
            String[] datos = line.split(",");
            if(datos.length>0&&datos[4].equals(String.valueOf(id))){
                remitente.setId(datos[0]);
                remitente.setNombre(datos[1]);
                remitente.setDepartamento(datos[2]);
                remitente.setTelefono(datos[3]);
            }
        }
        br.close();
        return remitente;
    }

}
