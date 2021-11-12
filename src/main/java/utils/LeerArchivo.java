package utils;

import modelo.Diccionario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivo {

    private String traducccion = "";
    private Diccionario diccionario;

    public void leerDiccionario() throws FileNotFoundException {
        FileReader leerArchivo = new FileReader(Utils.nombreArchivo);
        BufferedReader leer = new BufferedReader(leerArchivo);

        //Leemos nuestro diccionario
        while (traducccion != null) {
            try {
                traducccion = leer.readLine();
                if (traducccion == null) {
                    break;
                }else{
                    if (!traducccion.isBlank()){//Verificamos si existe palabras en el diccionario y si existe la añadiomos a una lista estatica
                        String[] words = traducccion.split("=");
                        diccionario = new Diccionario(words[0].trim(),words[1].trim());
                        Utils.listWords.add(diccionario);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
