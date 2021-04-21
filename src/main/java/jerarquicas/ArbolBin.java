package jerarquicas;
import lineales.Dinamica.Lista;

/**
 *
 * @author Mauro Fierro
 */
public class ArbolBin {
   private nodoArbol raiz;
   
   // Constructor vacio
   public ArbolBin () {
       raiz=null;
   }
    public boolean insertar (Object elemNuevo, Object elemPadre, char lugar){
    // Inserta elemNuevo como hijo del primer nodo encontrado en preOrden
    // Igual al elemPAdre, como hijo izquierdo I o derecho D, segun lo indique el parametro Lugar
        boolean exito=true;
        
        if(this.raiz==null){    // Si el arbol esta vacio, ponemos el elemNuevo en la raiz
            this.raiz=new nodoArbol(elemNuevo , null , null );
        }else{
            // si no esta vacio, se busca al padre
            nodoArbol nodoPadre=obtenerNodo(this.raiz, elemPadre);
            if( nodoPadre!=null ){
                if( ( lugar=='I' || lugar=='i' ) && nodoPadre.getIzquierdo()==null ){
                    // si el padre existe y no tiene hijos Izquierdos, se lo agrega
                    nodoPadre.setIzquierdo(new nodoArbol(elemNuevo, null , null ));
                }else{
                    if( ( lugar=='D' || lugar=='d') && nodoPadre.getDerecho()==null ){
                        // si el padre existe y no tiene hijos Derecho se lo agrega
                        nodoPadre.setDerecho(new nodoArbol(elemNuevo , null , null ));
                    }else{
                        // si el padre no existe o ya tiene ese hijo, da error
                        exito=false;
                    }                
                }
            }else{
                    exito=false;
            }        
        }
        return exito;
    }
    
    // Operaciones Básicas del TDA Arbol Binario
    public boolean esVacio(){
        return this.raiz==null;
    }
    public Object padre(Object elem){
        
        return elem;
    }
    public int altura(){
        
        return 0;
    }
    public int nivel (Object elem){
        
        return 0;
    }
    public void vaciar(){
        this.raiz=null;
    }
    public ArbolBin clone(){
        ArbolBin copiaRaiz=new ArbolBin();
        
        return copiaRaiz;
    }
    public String toString(){
        String s="[";
        
        return s+"]";
    }
    public Lista listarPreOrden(){
        Lista listaPre=new Lista();
        listarPreOrdenAux(this.raiz, listaPre);
        return listaPre;
    }
    public Lista listarPosOrden(){
        Lista listaPos=new Lista();
        
        return listaPos;
    }
    public Lista listarInOrden(){
        Lista listaIn=new Lista();
        
        return listaIn;
    }
    public Lista listarPorNiveles(){
         Lista listaNivel=new Lista();
         
         return listaNivel;
     }
    
     // Otras operaciones propias del Arbol Binario
     
    private nodoArbol obtenerNodo(nodoArbol n , Object buscado){
        nodoArbol resultado=null;
        if(n!=null){
            if(n.getElem().equals(buscado)){
                // si el buscado es n, lo devuelve
                resultado=n;
            }else{
                // no es el buscad. Busca primero en H. Izquierdo
                resultado=obtenerNodo( n.getIzquierdo() , buscado );
                // si  no lo encuentra en el H. Izquierdo, busca en el H. Derecho
                resultado=obtenerNodo( n.getDerecho() , buscado );
                if(resultado==null)
                    resultado=obtenerNodo(n.getDerecho() , buscado );
            }
        }
        return resultado;
    }    
     
     
    private void listarPreOrdenAux(nodoArbol nodo, Lista lis){ 
    // Método recursivo porque su parametro es de tipo nodoArbol
     if(nodo!=null){
         // visita el elemento en el nodo
         lis.insertar( nodo.getElem() ,  lis.longitud()+1 );

         // recorre a sus hijos en preOrden
         listarPreOrdenAux( nodo.getIzquierdo() , lis );
         listarPreOrdenAux(nodo.getDerecho() , lis );
     }
 }
}
