/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorArchivos;

import ContextoProblema.Celular;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author licho
 */
public class Gestor {
    ArrayList<Celular> celulares;
    String[] texto;
    String[] datos;
    
    public Gestor(){
        copiarTexto("celulares.csv");
        crearCelulares();
        System.out.println("Orden normal: \n");
        mostrarCelulares();
        System.out.println("Orden por modelos alfabeticamente: \n");
        insertationSortModelo();
        mostrarCelulares();
        System.out.println("Orden por tamño de pantalla: \n");
        insertationSortPantalla();
        mostrarCelulares();
        
    }
        
    /*
    Separa las lineas del texto
    @param ruta del archivo
    */
    
    public  void copiarTexto(String ruta) {
        try{          
            texto = new String[10];
            File file = new File (ruta);
            if (file.exists()){
                FileReader fl = new FileReader(ruta);
                BufferedReader br = new BufferedReader(fl);  
                while(br.readLine() != null){
                    for(int i = 0; i < 10; i++){
                        texto[i] = br.readLine();
                    }
                }
                
            }else{
            }
        }catch(IOException e){
            
        }
    }
    
    /*
    Obtiene los datos necesarios para crear un objeto de tipo celular y los almacena en un arreglo
    @param numero de la linea del arhivo csv
    @retrun void
    */
    
    public void obtenerDatos(int linea){
        this.datos=this.texto[linea].split(";");
    }
    
    /*
    Añade un celular al arrayslist de celulares
    @param un bojeto de tipo Celular
    @return void
    */
    
    public void addCelular(Celular celular){
        celulares.add(celular);
    }
    
    /*
    Crea los celulares 
    @return void
    */
    
    public void crearCelulares(){
        celulares = new ArrayList();
        for(int i=0;i<10;i++){
            obtenerDatos(i);
            addCelular(new Celular(datos[0],Double.parseDouble(datos[1])));            
        }
    }
    
    /*
    Muestra los atribuos de todos los celulares
    @return void
    */
    
    public void mostrarCelulares(){
        for(int i=0;i<celulares.size();i++){
            System.out.println(celulares.get(i).toString()+"\n");
            System.out.println("---------------------\n");
        }
    }
    
    public void selectionSortModelo(){
        for(int i=0;i<celulares.size();i++){
            int cont=i;
            Celular celular=celulares.get(i);
            for(int j=i+1;j<celulares.size();j++){
                if(celulares.get(j).getModelo().compareTo(celular.getModelo())<=0) {
                    celular=celulares.get(j);
                    cont=j;
                }
            }
            celulares.remove(cont);
            celulares.add(i,celular);
        }
    }
    
    public void insertationSortModelo(){
        int fin,contador;
        for(int i=1;i<celulares.size();i++){
            fin=0;
            contador=i-1;
            Celular celular=celulares.get(i);
            while(contador>-1 && fin==0){
                if(celulares.get(contador).getModelo().compareTo(celular.getModelo())<=0) {
                    celulares.remove(i);
                    celulares.add(contador+1, celular);
                    fin=1;
                }else if(contador==0){
                    celulares.remove(i);
                    celulares.add(0, celular);
                }
                contador--;
            }
        }
    }
    
    public void selectionSortPantalla(){
        for(int i=0;i<celulares.size();i++){
            int cont=i;
            Celular celular=celulares.get(i);
            for(int j=i+1;j<celulares.size();j++){
                if(celulares.get(j).getPantalla()<celular.getPantalla()) {
                    celular=celulares.get(j);
                    cont=j;
                }                   
            }
            celulares.remove(cont);
            celulares.add(i,celular);
        }
    }
    
    public void insertationSortPantalla(){
        for(int i=1;i<celulares.size();i++){
            int fin=0;
            int contador=i-1;
            Celular celular=celulares.get(i);
            while(contador>-1 && fin==0){
                if(celulares.get(contador).getPantalla()<celular.getPantalla()) {
                    celulares.remove(i);
                    celulares.add(contador+1, celular);
                    fin=1;
                }else if(contador==0){
                    celulares.remove(i);
                    celulares.add(0, celular);
                }
                contador--;
            }
        }
    }
    
    
    
    
}
