/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Pila {

    private int contNodo = 0;
    private Nodo cabeza;
    
    public int getContNodo() {
        return contNodo;
    }

    public Nodo getCabeza() {
        return cabeza;
    }
    
    public void Push(Nodo n){
        contNodo ++;
        if(cabeza == null){
            cabeza = n;
        }else{
            n.setAbajo(cabeza);
            cabeza.setArriba(n);    
            cabeza = n;
        }
    }
    
     public void Pop (){
        if(contNodo > 0){
            contNodo --; 
            cabeza = cabeza.getAbajo();
        }
    }
     
    public String Peek(){
        return cabeza.getDato();
    }
        
}
