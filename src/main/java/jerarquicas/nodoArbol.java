package jerarquicas;

/**
 *
 * @author Mauro Fierro
 */
class nodoArbol {
    private Object elem;
    private nodoArbol izquierdo;
    private nodoArbol derecho;    

    // Constructor
    public nodoArbol(Object nuevoElem, nodoArbol izq, nodoArbol der){
        this.elem=nuevoElem;
        this.izquierdo=izq;
        this.derecho=der;
    }
    
    // Observadoras
    public Object getElem(){
        return this.elem;
    }    
    public nodoArbol getIzquierdo(){
        return this.izquierdo;
    }    
    public nodoArbol getDerecho(){
        return this.derecho;
    }
    
    // Modificadores
    public void setElem(Object nuevoElem){
        this.elem=nuevoElem;
    }
    public void setIzquierdo(nodoArbol izq){
        this.izquierdo=izq;
    }
    public void setDerecho(nodoArbol der){
        this.derecho=der;
    }
}
