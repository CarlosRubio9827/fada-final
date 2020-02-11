/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Carlos Rubio
 */
public class Ejemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<String> data = new ArrayList<>();

        JFileChooser jFileChooser1 = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("FADA FILES", "fada");
        jFileChooser1.setFileFilter(filter);
        try {
            //jFileChooser1.setCurrentDirectory(new File("..\\fadaProyecto\\Test"));
            jFileChooser1.showOpenDialog(jFileChooser1);

            String patch = jFileChooser1.getSelectedFile().getAbsolutePath();
            BufferedReader br = new BufferedReader(new FileReader(patch));

            String cadena;

            while ((cadena = br.readLine()) != null) {
                data.add(cadena);
            }
        } catch (HeadlessException | IOException e) {
            System.out.println("er" + e);
        }

        try {
            //Primer Linea
            String[] primerLinea = data.get(0).split(",");
            int ciudadx = Integer.parseInt(primerLinea[0]);
            int ciudady = Integer.parseInt(primerLinea[1]);
            System.out.println("Tamaño de la ciudad "+ciudadx+" X " +ciudady);
            int timerecorrer = Integer.parseInt(primerLinea[2]);
            //Segunda Linea
            String[] segundaLinea = data.get(1).split(",");
            int paquetes = Integer.parseInt(segundaLinea[0]);
            int tiempomensajero = Integer.parseInt(segundaLinea[1]);
            //Tercer Linea                 
            String[] terceraLinea = data.get(2).split(",");
            int ubicacionOficinax = Integer.parseInt(terceraLinea[0]);
            int ubicacionOficinay = Integer.parseInt(terceraLinea[1]);
            int[] ofi = {ubicacionOficinax, ubicacionOficinay};
            //Ubicación oficinas
            System.out.println("Oficina: " + ubicacionOficinax + "," + ubicacionOficinay + "\n"
                    + "Paquetes = " + paquetes);

            //Encomiendas
            ArrayList<Encomienda> enco = new ArrayList<>();
            for (int j = 2; j < data.size(); j++) {
                String[] lineasSiguientes = data.get(j).split(",");
                int ubicacionx = Integer.parseInt(lineasSiguientes[0]);
                int ubicaciony = Integer.parseInt(lineasSiguientes[1]);
                Encomienda e = new Encomienda(j - 2, ubicacionx, ubicaciony);
                enco.add(e);
                System.out.println("encomineda " + (j - 2) + " - " + "(" + data.get(j) + ")");
            }
            
            //=========================================
           
        
            //=========================================
            
            
            System.out.println("========================= Encomiendas Con su index y ubicación =========================");
            for (int i = 1; i < enco.size(); i++) {

                System.out.println("Index " + enco.get(i).getIndex() + " => "
                        + enco.get(i).getX() + ", " + enco.get(i).getY());

            }
            
            //Matriz de distancia
            System.out.println("Matriz distancia = ");
            MatrizDistancia md1 = new MatrizDistancia();
            md1.Matriz(ciudadx, ciudady, paquetes, enco);
            System.out.println("\nCiudad\n");
            //Dibujo de ciudad
            md1.DibujoMatriz(ciudadx, ciudady, enco, ofi);

        } catch (NumberFormatException e) {
            System.out.println("er" + e);

        }

    }
}
