public class Memoria{
    private String tipo;
    private double size;
    private double bloques;
    public Memoria(String tipo, double size, double bloques){
        this.tipo=tipo;
        this.size=size;
        this.bloques=bloques;
    }
    //Gets
    public String getTipo(){return this.tipo;}
    public double getSize(){return this.size;}
    public double getBloques(){return this.bloques;}
    //Sets
    public void setTipo(String tipo){this.tipo=tipo;}
    public void setSize(double size){this.size=size;}
    public void setBloques(double bloques){this.bloques=bloques;}
    //ToString
    public String toString(){
        String cadena="";
        cadena+="Tipo: "+this.tipo+"----";
        cadena+="Size: "+this.size+"----";
        cadena+="Bloques: "+this.bloques;
        return cadena;
    }
}