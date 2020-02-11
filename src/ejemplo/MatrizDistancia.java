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
    public Point[] document;

    public void Matriz(int ciudadx, int ciudady, int paquetes, ArrayList<Encomienda> enco) {
        matrizC = new int[paquetes + 1][paquetes + 1];
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
                dibujo[i][j] = "{■";
                for (int e = 0; e < enco.size(); e++) {
                    if (i == enco.get(e).getX() && j == enco.get(e).getY()) {
                        if ("■".equals(dibujo[i][j])) {
                            dibujo[i][j] = "{";
                        }
                        dibujo[i][j] += String.valueOf(e) + ",";
                    }
                }
                dibujo[i][j] += "}";
            }
        }

        dibujo[uox][uoy] += "O";

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(" " + dibujo[i][j]);
            }
            System.out.println("");
        }

    }

    /* // MÉTODO PARA RECORRER EL ARREGLO DE LAS ENTREGAS
    public static String camino(int matriz_distancias[][], int paquetes) {
    
    boolean[] entregas_realizadas = new boolean[paquetes]; //Almacena el estado de las entregas
    int distancia;
    int entrega;
    
    for (int i = 0; i< entregas_realizadas.length;) {
    distancia = distancia_entrega_cercana(entrega, matriz_distancias);
    total = total + distancia;
    camino = camino + "->" + entrega + "[" + distancia + "] ";
    }
    
    imprimirMatrizDistancias(matriz_distancias);
    
    System.out.println (
    
    "Camino: " + camino);
    System.out.println (
    "El tiempo en realizar las (" + entregas + ") entregas fue: " + total);
    return camino ;
    }
    // MÉTODO PARA DETERMINAR LA ULTIMA DISTANCIA MINIMA A CADA ENTREGA
    public static int distancia_entrega_cercana(int pos, int matriz_distancias[][]) {
    for (int j = 0; j < matriz_distancias.length; j++) {
    if (pos != j) {
    if (matriz_distancias[pos][j] != -1) {
    entrega_cercana = matriz_distancias[pos][j];
    break;
    }
    }
    }
    for (int j = 0; j <= matriz_distancias.length - 1; j++) {
    if (pos != j && matriz_distancias[pos][j] != -1) {
    if (matriz_distancias[pos][j] != -1) {
    if (entrega_cercana < matriz_distancias[pos][j]) {
    entrega_cercana = entrega_cercana;
    } else {
    entrega_cercana = matriz_distancias[pos][j];
    entrega = j;
    }
    }
    }
    }
    matriz_distancias[pos][entrega] = -1; //Pone -1 en las entregas que ya se hicieron
    matriz_distancias[entrega][pos] = -1; //Pone -1 en las entregas que ya se hicieron
    contador++;
    entregas_realizadas[entrega - 1] = true; //Cambia el estado de cada entrega realizada
    int pos2;
    for (pos = 0, pos2 = 1; pos < entregas_realizadas.length; pos++, pos2++) {
    System.out.println("La entrega: " + pos2 + " esta en: " + entregas_realizadas[pos]);
    }
    System.out.println(); //Salto de linea entre cada ciclo de entregas
    return entrega_cercana;
    }*/
    public int[][] getMatrizC() {
        return matrizC;
    }

}
