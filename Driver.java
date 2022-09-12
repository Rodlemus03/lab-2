import java.util.Scanner;
import java.util.ArrayList;
import java.math.*;
public class Driver{
    
    public static void main(String[] args) {
        System.out.println("BIENVENIDO ");
        int respuesta=-1;
        Scanner teclado=new Scanner(System.in);
        
        ArrayList<Programas> ram=new ArrayList<Programas>();
        ArrayList<String> ramNombres=new ArrayList<String>();
        ArrayList<Programas> cola=new ArrayList<Programas>();
        Memoria memoria=new Memoria("", 0, 0);

        int seleccion=1;
        String tipo="";
        double sizeSeleccion=1,size=4,aux,bloques;
        System.out.println("Ingresa el tipo de memoria que deseas? \n1.SDR \n2.DDR");
        seleccion=teclado.nextInt();
        System.out.println("Ingresa el tamaño de la memoria: \n1-->4GB \n2-->8GB \n3-->12GB \n4-->16GB \n5-->32GB \n6-->64GB ");
        sizeSeleccion=teclado.nextDouble();
        if(sizeSeleccion==1){
            size=4;
        }else if(sizeSeleccion==2){
            size=8;
        }else if(sizeSeleccion==3){
            size=12;
        }else if(sizeSeleccion==4){
            size=16;
        }else if(sizeSeleccion==5){
            size=32;
        }else if(sizeSeleccion==6){
            size=64;
        }else{
            System.out.println("Elegiste una opcion incorrecta, se asignaran 4GB");
        }
        //
        double sizeGlobal=size*1024;
        double limiteGlobal=sizeGlobal;
        double bloqueGlobal=sizeGlobal/64;
        //
        if(seleccion==1){
            tipo="SDR";
        }else{
            tipo="DDR";
        }
        memoria.setTipo(tipo);
        memoria.setSize(size);
        aux=size/64;
        bloques=Math.ceil(aux);
        memoria.setBloques(bloques);



        //Inicializar
        Programas programa1=new Programas("Google chrome", 2070, 8);
        Programas programa2=new Programas("Firefox", 64, 16);
        Programas programa3=new Programas("Zoom", 320, 60);
        Programas programa4=new Programas("Whatsapp", 128, 8);
        Programas programa5=new Programas("Telegram", 128, 8);
        Programas programa6=new Programas("Visual Studio", 320, 60);
        Programas programa7=new Programas("Mail", 32, 15);
        Programas programa8=new Programas("Contactos", 32, 8);
        Programas programa9=new Programas("Word", 1024, 10);
        ram.add(programa1);
        ram.add(programa2);
        ram.add(programa3);
        ram.add(programa4);
        ram.add(programa5);
        ram.add(programa6);
        ram.add(programa7);
        ram.add(programa8);
        ram.add(programa9);
        ramNombres.add("Google Chrome");
        ramNombres.add("Firefox");
        ramNombres.add("Zoom");
        ramNombres.add("Whatsapp");
        ramNombres.add("Telegram");
        ramNombres.add("Visual Studio");
        ramNombres.add("Mail");
        ramNombres.add("Contactos");
        ramNombres.add("Word");
        double suma=2070+64+320+128+128+320+32+32+1024;
        double sumaBloques=8+16+60+8+8+60+15+8+10;
        sizeGlobal-=suma;
        bloqueGlobal-=sumaBloques;

        while(respuesta!=14){
            System.out.println("\n\n1. Abrir programa");
            System.out.println("2. Cerrar programa");
            System.out.println("3. Saber RAM total");
            System.out.println("4. Saber RAM disponible");
            System.out.println("5. Saber RAM en uso");
            System.out.println("6. Programas en ejecucion");
            System.out.println("7. Programas en cola");
            System.out.println("8. Saber espacios que ocupa un programa");
            System.out.println("9. Visualizar ciclos de reloj");
            System.out.println("10. Determinar que programas pueden ingresarse a la cola");
            System.out.println("11. Aumentar o disminuir");
            System.out.println("12. Finalizar programas segun tiempo en ejecucion");
            System.out.println("13. Actualizar");
            System.out.println("\n\nIngresa la opcion que desees");
            respuesta=teclado.nextInt();
            if(respuesta==1){
           
                //Agregar programa
                Programas programa=new Programas("nombre", 0, 0);
                String nombre;
                double espacio,aux2;
                Double bloques2;
                System.out.println("Ingresa el nombre del programa ");
                nombre=teclado.next();
                System.out.println("Cuanto espacio ocupa? ");
                espacio=teclado.nextDouble();

                //Averiguar cuantos bloques 
                aux2=espacio/64;
                bloques2=Math.ceil(aux2);
                if(bloques2>bloqueGlobal && sizeGlobal>espacio){

                
                programa.setNombre(nombre);
                programa.setEspacio(espacio);
                programa.setBloques(bloques2);
                ram.add(programa);
                ramNombres.add(nombre);
                sizeGlobal-=espacio;
                }else{
                    System.out.println("No se puede ingresar el programa, se pondra en cola ");
                    programa.setNombre(nombre);
                    programa.setEspacio(espacio);
                    programa.setBloques(bloques2);
                    cola.add(programa);
                }
                
            }else if(respuesta==2){
                //Cerrar programa
                int pos=0;
                for(int i=0;i<ramNombres.size();i++){
                    System.out.println(i+1+". "+ramNombres.get(i));
                }
                System.out.println("Ingresa el numero del programa que deseas cerrar ");
                pos=teclado.nextInt();
                ram.remove(pos-1);
                ramNombres.remove(pos-1);
            }else if(respuesta==3){
                //Ram total 
                System.out.println("Ram total: "+limiteGlobal);
            }else if(respuesta==4){
                //Ram disponible
                System.out.println("Ram disponible "+sizeGlobal);
            }else if(respuesta==5){
                //Ram en uso
                System.out.println("Ram en uso: "+(limiteGlobal-sizeGlobal));
            }else if(respuesta==6){
                //Programas en ejecucion
                for(int i=0;i<ram.size();i++){
                    System.out.print(i+1+". ");
                    System.out.println(ram.get(i));
                }
                System.out.println("Memoria restante: "+sizeGlobal+" MB");
            }else if(respuesta==7){
                //Programas en cola
                for(int i=0;i<cola.size();i++){
                    System.out.print(i+1+". ");
                    System.out.println(cola.get(i));
                }
            }else if(respuesta==8){
                //Saqber espacios que ocupa un programa
                int posicion=0;
                for(int i=0;i<ram.size();i++){
                    System.out.print(i+1+". ");
                    System.out.println(ram.get(i).getNombre());
                }
                posicion=teclado.nextInt();
                if(posicion>0 && posicion<=ram.size()){
                    System.out.print("Espacio que ocupa "+ram.get(posicion-1).getNombre()+": ");
                    System.out.println(ram.get(posicion-1).getEspacio());
                }
            }else if(respuesta==9){
                //Visualizar ciclos de reloj
                 
            }else if(respuesta==10){
                //Determinar que programas pueden ingresar
                ArrayList<Programas> temp=new ArrayList<Programas>();
                ArrayList<Programas> temp2=new ArrayList<Programas>();
                if(cola.size()>0){
                    for(int i=0;i<cola.size();i++){
                        if(cola.get(i).getBloques()<bloqueGlobal){
                            temp.add(cola.get(i));
                            cola.remove(i);
                        }else{
                            temp2.add(cola.get(i));
                        }
                    }
                    System.out.println("###################### SI SE PUEDEN ######################");
                    for(int k=0;k<temp.size();k++){
                        System.out.print(k+1+". ");
                        System.out.println(temp.get(k));
                    }
                    System.out.println("###################### NO SE PUEDEN ######################");
                    for(int k=0;k<temp2.size();k++){
                        System.out.print(k+1+". ");
                        System.out.println(temp2.get(k));
                    }
                }else{
                    System.out.println("No hay programas en la cola");
                }
            }else if(respuesta==11){
                //Aumentar o disminuir ram
                //4 gb  64 bloques
                //8 gb  128 bloques
                //12 gb 192 bloques
                //16 gb 256 bloques
                //32 gb 512 bloques
                //64 gb 1024 bloques

                double contador=0;

                double bloque1=64;
                double bloque2=128;
                double bloque3=192;
                double bloque4=256;
                double bloque5=512;
                double bloque6=1024;
                if(memoria.getTipo().equalsIgnoreCase("SDR")){
                    if(cola.size()>0){
                        for(int i=0;i<cola.size();i++){
                            contador+=cola.get(i).getBloques();
                        }
                    
                    if(bloque1<contador && contador<bloque2){

                    }else if(bloque2<contador && contador<bloque3){

                    }else if(bloque3<contador && contador<bloque4){
                        
                    }else if(bloque4<contador && contador<bloque5){
                        
                    }else if(bloque5<contador && contador<bloque6){
                        
                    }

                    }else{

                    }
                }else{
                    System.out.println("Por el tipo de memoria, no puede aumentarse ");
                }
            }else if(respuesta==12){
                //Finalizar programas segun tiempo de ejecucion
            }else if(respuesta==13){
                //Actualizar
            }else if(respuesta==14){
                System.out.println("Feliz dia ");
            }else{
                System.out.println("Ingresa un valor correcto ");
            }
        }
    }
}