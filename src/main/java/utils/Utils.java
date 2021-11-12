package utils;

import modelo.Diccionario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {
    public static String nombreArchivo = "diccionario.txt";
    private Diccionario diccionario;
    public static ArrayList<Diccionario> listWords = new ArrayList<>();

    public void addWord (String spanish, String english){
        if (!existWord(spanish,english)){ //Veridicamos esa traduccion ya existe y sino añadimos la traduccion a la lista
            diccionario = new Diccionario(spanish,english);
            listWords.add(diccionario);
            try {//Añadimos la nueva traduccion a nuestro archivo diccionario.txt
                FileWriter writer = new FileWriter(nombreArchivo,true);
                writer.write("\r\n" + spanish + " = "+ english);
                writer.close();
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo de texto");
            }
        }
    }

    public void searchWord(String word){// Recorremos la lista buscando para varidar si existe esa palabra en el diccionario
        for (Diccionario p : listWords){
            if (p.getSpanish().equals(word)) {
                System.out.println("La traduccion es: "+p.getEnglish());
            }
        }
    }

    public void showAllWords(){// Recorremos y mostramos todas las traducciones
        System.out.println("TODAS LAS PALABRAS");
        listWords.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------");
    }

    private boolean existWord(String spanish, String english){//Veridicamos esa traduccion ya existe
        Boolean exist = false;
        for (Diccionario diccionario : listWords){//Recorremos la lista existente
            if (diccionario.getSpanish().equals(spanish) && diccionario.getEnglish().equals(english)){
                exist = true;
            }
        }
        return exist;
    }

}
