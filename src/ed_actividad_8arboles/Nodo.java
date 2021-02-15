
package ed_actividad_8arboles;

public class Nodo {    
    int dato;
    Nodo izquierda;
    Nodo derecha;
    Nodo parentesco;
    
    Nodo(Nodo parentesco,int dato){
        this.dato=dato;
        this.izquierda=null;
        this.derecha=null;
        this.parentesco=parentesco;
    }
    
     public boolean Raiz(){
        return parentesco==null;
    }
     
    public Nodo otroHijo(Nodo nodo){
        if(nodo==izquierda){
            return derecha;
        }else{
            return izquierda;
        }
    }
    
    public boolean Hoja(){
        return izquierda== null && derecha==null;
    }
    
    public  boolean esCompleto(){
        return  izquierda!=null && derecha!=null;
    }
}
