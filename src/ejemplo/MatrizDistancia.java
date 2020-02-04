/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Rubio
 */
public class MatrizDistancia {

    int[][] matrizC;
    int[] oficina;
    HashMap<String, Sitio> sitios;
    private Point[] document;

    public void Matriz(int ciudadx, int ciudady, int paquetes, ArrayList<Encomienda> enco) {
        matrizC = new int[paquetes][paquetes];
        Encomienda en, en1;
        int d, x, y;
        for (int i = 0; i < matrizC.length; i++) {
            //en = new Encomienda();
            en = enco.get(i);
            for (int j = 0; j < matrizC.length; j++) {
                //en1 = new Encomienda();
                en1 = enco.get(j);
                x = Math.abs(en.getX() - en1.getX());
                y = Math.abs(en.getY() - en1.getY());
                d = x + y;
                matrizC[i][j] = d;
            }
        }

        for (int[] matrizC1 : matrizC) {
            for (int j = 0; j < matrizC.length; j++) {
                System.out.print(" " + matrizC1[j]);
            }
            System.out.println("");
        }

    }

    public void DibujoMatriz(int ciudadx, int ciudady, ArrayList<Encomienda> enco, int[] oficina) {

        int x = ciudadx;
        int y = ciudady;

        this.sitios = new HashMap<>();

        System.out.println(x + " X " + y + " kklklklkCiudada ");
        int uox = oficina[0]; // Ubicación oficina X
        int uoy = oficina[1]; // Ubicación oficina Y

        System.out.println(uox + " Ubicacón ofinica x");
        System.out.println(uoy + " Ubicacón ofinica y");

        String[][] dibujo = new String[x][y];

        dibujo[uox][uoy] = "O";

        //Ciclo para llenar la ciudad - matriz
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                dibujo[i][j] = "■";
                for (int e = 0; e < enco.size(); e++) {
                    if (i == enco.get(e).getX() && j == enco.get(e).getY()) {
                        dibujo[i][j] = String.valueOf(e);
                        String key = x + "," + y;
                        if (oficina[0] == i && oficina[1] == j) {
                            sitios.get(key).add((short)i);
                        } else {
                            this.document[i] = new Point(x, y);

                            //si ya fue registrado ese punto se añade a la lista
                            if (sitios.containsKey(key)) {
                                sitios.get(key).add((short)i);
                            } else {
                                //sino se crea un nuevo lugar y se añade al hashmap
                                Point point = new Point(x, y);
                                Sitio place = new Sitio((short) (sitios.size() + 1), point, (short)i);
                                sitios.put(key, place);
                            }
                        }
                    }
                }
            }}

            dibujo[uox][uoy] = "O";

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    System.out.print(" " + dibujo[i][j]);
                }
                System.out.println("");
            }

        }

    

    

    

    public int[][] getMatrizC() {
        return matrizC;
    }

}
