import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String resultadoCSV = "C:/Users/PC/Desktop/resultados.csv";
        String pronosticoCSV = "C:/Users/PC/Desktop/pronostico.csv";

        String[][] resultadoLista = new String[10][];
        String[][] pronosticoLista = new String[10][];

        leerArchivo(resultadoCSV,resultadoLista );
        leerArchivo(pronosticoCSV,pronosticoLista );

        Partido[] listaPartidos = creaPartidos(resultadoLista);
        Pronostico[] listaPronostico = creaPronostico(pronosticoLista, listaPartidos);

    }

    public static Partido[] creaPartidos(String[][] resultados){
        Partido[] listaAux = new Partido[10];

        for (int i = 0; i < resultados.length; i++) {
            if(resultados[i] != null){
                String[] prePartido = resultados[i];

                String nombreEquipo1 = prePartido[0];
                String nombreEquipo2 = prePartido[3];

                Equipo equipoAux1 = new Equipo(nombreEquipo1);
                Equipo equipoAux2 = new Equipo(nombreEquipo2);

                int golesE1 = Integer.parseInt(prePartido[1]);
                int golesE2 = Integer.parseInt(prePartido[2]);

                Partido p = new Partido(equipoAux1, equipoAux2, golesE1, golesE2);
                listaAux[i] = p;
            }
        }
        return listaAux;
    }

    public static Pronostico[] creaPronostico(String[][] pronosticos, Partido[] partidos){
        Pronostico[] listaAux = new Pronostico[10];

        for (int i = 0; i < pronosticos.length; i++) {
            if(pronosticos[i] != null) {
                String[] prePronostico = pronosticos[i];
                String nombre;

                if (prePronostico[1].equals("x")) {
                    nombre = prePronostico[0];
                } else if (prePronostico[3].equals("x")) {
                    nombre = prePronostico[4];
                } else {
                    nombre = "";
                }

                Partido partidoAux = partidos[i];
                Equipo equipoAux = new Equipo(nombre);
                Pronostico p = new Pronostico(partidoAux, equipoAux);
                listaAux[i] = p;
            }
        }
        return listaAux;
    }

    public static void leerArchivo(String path, String[][] data){
        BufferedReader br = null;
        String linea = "";

        try {
            br = new BufferedReader(new FileReader(path));
            int posicion = 0;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                data[posicion] = datos;
                posicion++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}