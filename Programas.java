public class Programas {
    private String nombre;
    private double espacio;
    private double bloques;

    public Programas(String nombre, int espacio, int bloques){
        this.nombre=nombre;
        this.espacio=espacio;
        this.bloques=bloques;
    }
    //gets
    public String getNombre(){return this.nombre;}
    public double getEspacio(){return this.espacio;}
    public double getBloques(){return this.bloques;}
    //Sets
    public void setNombre(String nombre){this.nombre=nombre;}
    public void setEspacio(Double espacio){this.espacio=espacio;}
    public void setBloques(Double bloques){this.bloques=bloques;}
    //ToString
    public String toString(){
        String cadena="";
        cadena+="Nombre: "+this.nombre+"-----";
        cadena+="Espacio que ocupa: "+this.espacio+"-----";
        cadena+="Bloques que ocupa: "+this.bloques;
        return cadena;
    }
}
