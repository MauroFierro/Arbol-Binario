package lineales.Estatica;
public class Cola {
    private Object [] arreglo;
    private int frente;
    private int fin;
    private static final int tamanio=10;
    
    public Cola(){
        this.arreglo=new Object[this.tamanio];
        this.frente=0;
        this.fin=0;
    }
    
    /* Coloca un elemento al final de la cola. Devuelve verdadero si el elemento se pudo agregar en la estructura
y falso en caso contrario. */
    public boolean poner(Object entrada){
        boolean estado=true;
        if((this.fin+1)%tamanio==this.frente){
            estado=false;
        }else{
            this.arreglo[this.fin]=entrada;
            this.fin=(this.fin+1)%tamanio;      
        }        
        return estado;
    }
    // Saca un elemento de la cola a no ser que este vacía
    public boolean sacar(){
        boolean exito=true;
        // Reporta error si la cola esta vacía
        if(this.esVacia())
            exito=false;
        /* Cuando quita un elemento, lo hace en la posicion frente que es el primer elemento de la cola 
            Asigna null en la posicion frente y luego corre de posicion a frente */
        else{ 
            this.arreglo[this.frente]=null;
            this.frente=(this.frente+1)%this.tamanio;
        }
        return exito;
    }
    
   
    // Devuelve el elemento que esta en el frente de la cola
    public Object obtenerFrente(){
        Object elem=null;
        if(!esVacia())
            elem=this.arreglo[frente];
        return elem;
    }
    
    // Devuelve True si la cola no tiene elementos y falso en caso contrario
    public boolean esVacia(){
        return this.frente==this.fin;
    }
    
    // Se encarga de Vaciar la Cola 5
   public void vaciar(){
       while(this.frente!=this.fin){
           this.arreglo[this.frente]=null;
           this.frente++;
       }
    }    
   // Se encarga de clonar una Cola
   public Cola clone(){ 
       //Creo una nueva Cola para almacenar la copia
       Cola arregloCola=new Cola();
       arregloCola.frente=this.frente;
       arregloCola.fin=this.fin;
       //uso variables auxiliares para recorrer el arreglo original y la copia
       int frenteAux=this.frente, finAux=this.fin;
       while(frenteAux!=finAux){
           arregloCola.arreglo[frenteAux]=this.arreglo[frenteAux];           
           frenteAux++;
           if(frenteAux+1==this.tamanio)
               frenteAux=(this.frente+1)%this.tamanio;
       }
       return arregloCola;
    }
   // Solo se utiliza este metodo durante el testeo del programa, una vez finalizado debe ponerse Privado.
   public String toString(){
        int frenteAux=this.frente, finAux=this.fin;
        String valor="[";
        if(!esVacia()){
            while(frenteAux!=finAux){
                valor=valor+this.arreglo[frenteAux];
                frenteAux=(frenteAux+1)%tamanio;
                if(frenteAux!=finAux)
                    valor=valor+",";
            }
        }
        return valor+"]";
    }
}

