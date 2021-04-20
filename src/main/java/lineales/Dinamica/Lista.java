package lineales.Dinamica;
/**
 *
 * @author Mauro Fierro
 */
public class Lista {
    private Nodo cabecera;
    private int longitud=0;
    public Lista(){
        cabecera=null;
    }    
    public boolean insertar(Object nuevoElem, int pos){
        // inserta el elemento nuevo en la posicion pos
        // detecta y reporta error posicion invalida
        boolean exito=true;
        if(pos<1 || pos>this.longitud()+1){
            exito=false;            
        }else{
            if(pos==1){ // crea un nuevo nodo y se enlaza en la cabecera
                this.cabecera=new Nodo(nuevoElem, this.cabecera);
            }else { // avanza hasta el elemento en la posicion pos-1
                Nodo aux=this.cabecera;
                int i=1;
                while(i<pos-1){ // Me ubico un lugar antes de la posicion en la que se quiere insertar
                    aux=aux.getEnlace();
                    i++;
                }
                // Crea el nodo y lo enlaza
                Nodo nuevo= new Nodo(nuevoElem,aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }
        this.longitud++;
        // nunca hay error de lista llena, entonces devuelve true
        return exito;
    }
    public boolean eliminar(int pos){
        boolean exito=true;
        // Voy a poder eliminar un elemento siempre y cuando, la lista no este vacia y que la posicion respete los limites de la misma
        if(!esVacia() && (1<=pos && pos<longitud())){
            if(pos==1){
                this.cabecera=this.cabecera.getEnlace();
            }else{
                Nodo aux=this.cabecera;
                int i=2;
                while(i<pos){
                    
                    if(i<pos)
                        aux=aux.getEnlace(); 
                    i++;
                    if(i==pos){
                        Nodo aux1=aux.getEnlace();           
                        aux.setEnlace(aux1.getEnlace());
                    }
                }
                
            }
        this.longitud--;
        }else
            exito=false;
        return exito;
    }
    public Object recuperar(int pos){
        Object recuperarElemento=null;
        if(pos>=1 && pos<this.longitud+1){
            if(pos==1){ // Si la posicion es 1, entonces devuelvo la primera posicion de la lista
                recuperarElemento=this.cabecera.getElem();
            }else{ // Busco el elemento dentro de la lista
                int i=2;
                Nodo aux=this.cabecera; // Me posiciono dentro de la cabecera
                while(i<=pos){
                    aux=aux.getEnlace();
                    if(i==pos){ //
                        recuperarElemento=aux.getElem();
                    }
                    i++;
                }
            }
        }
        return recuperarElemento;
    }
    public int localizar(Object localizarElemento){
        int pos=-1,i=1;
        boolean fin=false;
        if(!esVacia()){ // Devuelve -1 sino encuentra el elemento buscado o si la lista esta vacia, ya que no habra ningun elemento que buscar
            Nodo aux=this.cabecera; // Me posiciono en la cabecera para empezar a buscar desde la Posicion 1
            while(i<this.longitud+1 && fin==false){ // Recorro los nodos hasta llegar al final de la lista o hasta encontrar la 1er Ocurrencia. 
                if(aux.getElem()==localizarElemento){ // Si encontro el elemento. Pos guarda la posicion dentro de la Lista
                    pos=i;
                    fin=true;
                }else{  // Sino encontro el elemento, me muevo al siguiente Nodo y Aumento i
                    aux=aux.getEnlace();
                    i++;                // La variable i lleva la cuenta de las posiciones
                }
            }
        }
            
        return pos;
    }
    public int longitud(){        
        return this.longitud;
    }
    public boolean esVacia(){
        boolean fin=false;
        
        return fin;
    }
    public void vaciar(){
        
    }
    public Lista clone(){
        Lista listaClon=new Lista();
        
        return listaClon;
    }
    // Metodo utilizado durante el Testing para poder visualizar la lista
     public String toString(){
        String s="[";
        if(!esVacia()){
        Nodo nodoAux=this.cabecera;        
           while(nodoAux!=null){
               s+=nodoAux.getElem().toString();
               nodoAux=nodoAux.getEnlace();
               if(nodoAux!=null){
                   s+=",";
               }
           }
        }
        return s+"]";
    }
    
}
