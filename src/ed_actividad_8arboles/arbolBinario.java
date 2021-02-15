package ed_actividad_8arboles;

import java.io.*;
import java.util.Arrays;

public class arbolBinario {
     private Nodo nodoB;

    public arbolBinario() {
    }

    public void archivo(String archivo) throws IOException {
        File f = new File(archivo);
        FileReader rf = new FileReader(f);
        BufferedReader br = new BufferedReader(rf);
        int[] valor= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        limpiar();
        añadir(valor);
    }
    
    private boolean esVacio() {
        return nodoB == null;
    }
    
    public void limpiar(){
        this.nodoB=null;
    }
    
    private Nodo getNodo(int dato) {
        return getNodo(nodoB, dato);
    }

    public void agregarNuevo(int dato) throws evaluarNodo {
        if (esVacio()) {
            nodoB = new Nodo(null, dato);
        } else {
            agregarNuevo(nodoB, dato);
        }
    }
    
    private void agregarNuevo(Nodo nodo, int dato) throws evaluarNodo {
        if (nodo.dato == dato) {
            throw new evaluarNodo();
        }
        if (dato < nodo.dato) {
            if (nodo.izquierda != null) {
                agregarNuevo(nodo.izquierda, dato);
            } else {
                nodo.izquierda = new Nodo(nodo, dato);
            }
        } else {
            if (nodo.derecha != null) {
                agregarNuevo(nodo.derecha, dato);
            } else {
                nodo.derecha = new Nodo(nodo, dato);
            }
        }
    }

    public void añadir(int... valores) {
        for (int valor : valores) {
            try {
                agregarNuevo(valor);
            } catch (evaluarNodo evaluarNodo) {
                System.out.println("Se omitió el " + valor + " por que ya existe en el árbol.");
            }
        }
    }
    
    public void Altura(int dato) throws noEncontrarValor {
        Nodo nodo = getNodo(dato);
        if (nodo != null) {
            System.out.println("La altura es:" + getAltura(nodo));
        } else {
            throw new noEncontrarValor();
        }
    }

    private int getAltura(Nodo nodo) {
        if (nodo.Hoja()) {
            return 0;
        } else {
            int alturaI = 0;
            int alturaD = 0;
            if (nodo.izquierda != null) {
                alturaI = 1 + getAltura(nodo.izquierda);
            }
            if (nodo.derecha != null) {
                alturaD = 1 + getAltura(nodo.derecha);
            }
            return Integer.max(alturaI, alturaD);
        }
    }

    public void Profundidad(int dato) throws noEncontrarValor {
        Nodo nodo = getNodo(dato);
        if (nodo != null) {
            System.out.println("La profundidad es:" + getProfundidad(nodo, dato));
        } else {
            throw new noEncontrarValor();
        }
    }
     
    private int getProfundidad(Nodo nodo, int dato) {
        if (nodo.dato == dato) {
            return 0;
        } else if (dato < nodo.dato) {
            return 1 + getProfundidad(nodo.izquierda, dato);
        } else {
            return 1 + getProfundidad(nodo.derecha, dato);
        }
    }
     
    public void Hermano(int dato) throws noEncontrarValor {
        Nodo nodo = getNodo(dato);
        if (nodo != null) {
            if (nodo.Raiz() || nodo.parentesco.otroHijo(nodo) == null) {
                System.out.println("No tengo hermanos");
            } else {
                System.out.println("Mi hermano es:" + nodo.parentesco.otroHijo(nodo).dato);
            }
        } else {
            throw new noEncontrarValor();
        }
    }
       
    private Nodo getMinimo(Nodo nodo) {
        if (nodo == null) {
            return null;
        } else if (nodo.izquierda != null) {
            return getMinimo(nodo.izquierda);
        } else {
            return nodo;
        }
    }

    public void borrarNodo(int dato) throws noEncontrarValor {
        Nodo nodo = getNodo(dato);
        if (nodo != null) {
            borrar(nodo);
        }else{
            throw new noEncontrarValor();
        }
    }
    
    private void borrar(Nodo nodo) {
        if (nodo.Hoja()) {
            remplazar(nodo, null);
        } else if (nodo.esCompleto()) {
            Nodo minimo = getMinimo(nodo.derecha);
            nodo.dato = minimo.dato;
            borrar(minimo);
        } else if (nodo.derecha != null) {
            remplazar(nodo, nodo.derecha);
        } else {
            remplazar(nodo, nodo.izquierda);
        }
    }
    
    private void remplazar(Nodo nodo, Nodo newNodo) {
        if (!nodo.Raiz()) {
            if (nodo.dato == nodo.parentesco.izquierda.dato) {
                nodo.parentesco.izquierda = newNodo;
            } else if (nodo.dato == nodo.parentesco.derecha.dato) {
                nodo.parentesco.derecha = newNodo;
            }
        }
        if (newNodo != null) {
            newNodo.parentesco = nodo.parentesco;
        }
    }
    
    public void SizeNodo(int dato) throws noEncontrarValor {
        Nodo nodo = getNodo(dato);
        if (nodo != null) {
            System.out.println("El tamaño es:" + getSizeNodo(nodo));
        } else {
            throw new noEncontrarValor();
        }
    }
   
    private int getSizeNodo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        } else {
            return getSizeNodo(nodo.izquierda) + getSizeNodo(nodo.derecha) + 1;
        }
    }

    private void Preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + "\t");
            Preorden(nodo.izquierda);
            Preorden(nodo.derecha);
        }
    }
    
    public void imprimirPreorden() {
        Preorden(nodoB);
        System.out.println("");
    }    
      
    private void Inorden(Nodo nodo) {
        if (nodo != null) {
            Inorden(nodo.izquierda);
            System.out.print(nodo.dato + "\t");
            Inorden(nodo.derecha);
        }
    }
    
     public void imprimirInorden() {
        Inorden(nodoB);
        System.out.println("");
    }
     
    private void Postorden(Nodo nodo) {
        if (nodo != null) {
            Postorden(nodo.izquierda);
            Postorden(nodo.derecha);
            System.out.print(nodo.dato + "\t");
        }
    }

    public void imprimirPostorden() {
        Postorden(nodoB);
        System.out.println("");
    }
   
    public void Descendientes(int dato) throws noEncontrarValor {
        Nodo nodo = getNodo(dato);
        if (nodo != null) {
            if (nodo.Hoja()) {
                System.out.println("No tendo descendientes");
            } else {
                Preorden(nodo);
                }
        } else {
            throw new noEncontrarValor();
        }
    }
    
    public void Ancestro(int dato) throws noEncontrarValor {
        Nodo nodo = getNodo(dato);
        if (nodo != null) {
            System.out.println("Ancestros");
            getAncestros(nodo);
            System.out.println("");
        } else {
            throw new noEncontrarValor();
        }
    }
    
    private void getAncestros(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato);
            if (nodo.parentesco != null) {
                System.out.print("<-");
                getAncestros(nodo.parentesco);
            } else if (nodo != nodoB) {
                System.out.println("No tengo ancestros");
            }
        }
    }
          
    private Nodo getNodo(Nodo nodo, int dato) {       
        if (nodo == null) {
            return null;
        } else {
            if (nodo.dato == dato) {
                return nodo;
            } else if (dato < nodo.dato) {
                     
                return getNodo(nodo.izquierda, dato);
            } else {                   
              return getNodo(nodo.derecha, dato);
            }
        }
    }
    
    public void ABC(Nodo nodo){
        int con=0;
        if(nodo != null){
            if(nodo.esCompleto()== true){
               con++;
            }
        }
        if(con == getSizeNodo(nodoB)){
            System.out.println("El arbol es completo");
        }else{
            System.out.println("El arbol no es completo");
        }
    } 
    
    public void ABC(){
        ABC(nodoB);        
        System.out.println("");
    } 
}
