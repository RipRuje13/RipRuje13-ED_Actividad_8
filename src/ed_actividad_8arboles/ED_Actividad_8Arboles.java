package ed_actividad_8arboles;

import java.io.*;
import java.util.Scanner;

public class ED_Actividad_8Arboles {

    public static void main(String[] args)throws IOException {
     Scanner sc = new Scanner(System.in);
        arbolBinario arbol = new arbolBinario();
        int res, aux;
        do {
            System.out.println("\nElija la opcion que desea realizar");
            System.out.println("1.Crear árbol (crear un árbol inicial con los datos desde un archivo)");
            System.out.println("2.Inserta un nodo en el árbol");
            System.out.println("3.Calcule la profundidad de un nodo");
            System.out.println("4.Calcule la altura de un nodo");
            System.out.println("5.Calcule el tamaño de un nodo");
            System.out.println("6.Obtener el hermano de un nodo");
            System.out.println("7.Obtener los ancestros (antepasados) de un nodo");
            System.out.println("8.Obtener los descendientes de un nodo");
            System.out.println("9.Recorrido en preorden");
            System.out.println("10.Recorrido en inorden");
            System.out.println("11.Recorrido en postorden");
            System.out.println("12.Borrar un nodo");
            System.out.println("13.Determine si es un árbol binario completo (ABC)");
            System.out.println("14.Salir");          
            res = sc.nextInt();

            try {
                switch (res) {
                    
                    case 1:
                        System.out.println("Crear arbol(1-2)");
                        int op = sc.nextInt();
                        if (op == 1) {
                            arbol.archivo("Arbol1.txt");
                        } else {
                            arbol.archivo("Arbol2.txt");
                        }
                        System.out.println("Arbol \n");
                        arbol.imprimirPreorden();
                        System.out.println("");
                        break;

                    case 2:
                        System.out.println("Ingrese el nodo que desea insertar");
                        aux = sc.nextInt();
                        arbol.agregarNuevo(aux);
                        System.out.println("Se agrego correctamente");
                        arbol.imprimirPreorden();
                        System.out.println("");
                        break;

                    case 3:
                        System.out.println("Ingrese el nodo a buscar");
                        aux = sc.nextInt();
                        arbol.Profundidad(aux);
                        System.out.println("");
                        break;

                    case 4:
                        System.out.println("ingrese el nodo a buscar");
                        aux = sc.nextInt();
                        arbol.Altura(aux);
                        break;

                    case 5:
                        System.out.println("ingrese el nodo");
                        aux = sc.nextInt();
                        arbol.SizeNodo(aux);
                        System.out.println("");
                        break;
                    case 6:
                        System.out.println("ingrese el nodo a buscar");
                        aux = sc.nextInt();
                        arbol.Hermano(aux);
                        System.out.println("");
                        break;

                    case 7:
                        System.out.println("ingrese el nodo");
                        aux = sc.nextInt();
                        arbol.Ancestro(aux);
                        System.out.println("");
                        break;

                    case 8:
                        System.out.println("ingrese el nodo");
                        aux = sc.nextInt();
                        arbol.Descendientes(aux);
                        System.out.println("");
                        break;

                    case 9:
                        System.out.println("Recorrido Preorden");  
                        arbol.imprimirPreorden();
                        System.out.println("");
                        break;

                    case 10:
                        System.out.println("Recorrido Inorden"); 
                        arbol.imprimirInorden();
                        System.out.println("");
                        break;

                    case 11:
                        System.out.println("Recorrido Postorden"); 
                        arbol.imprimirPostorden();
                        System.out.println("");

                        break;

                    case 12:
                        System.out.println("ingrese el nodo");
                        aux = sc.nextInt();
                        arbol.borrarNodo(aux);
                        System.out.println("nodo borrado");
                        arbol.imprimirPreorden();
                        System.out.println("");
                        break;

                    case 13:
                        System.out.println("Arbol ABC");
                        arbol.ABC();
                        break;
                }
            } catch (noEncontrarValor | evaluarNodo | IOException exception) {
                System.out.println("Exepcion:" + exception.getMessage());
            }
        } while (res != 14);
    }
    
}
