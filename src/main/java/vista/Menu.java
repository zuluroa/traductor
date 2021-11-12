package vista;

import utils.LeerArchivo;
import utils.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {

    private int opcion = 0;
    private String spanish = "", english = "";

    //Metodo de inicio
    public void iniciar() {
        Scanner sc;
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader leerTexto = new BufferedReader(inputStreamReader);

        //Hacemos este constructor, porque aqui tenemos las operaciones de las opciones del menu
        Utils utils = new Utils();

        //Verificamos si existe palabras en el diccionario
        LeerArchivo archivo = new LeerArchivo();
        try {
            archivo.leerDiccionario();
        } catch (FileNotFoundException e) {
            System.out.println("Error al cargar la clase");
        }

        boolean exit = true;

        try{
            do{// Mostramos el menu al usuario
                System.out.println("Bienvenido al traductor Java");
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("1. Añadir palabras\n"+ "2. Buscar palabras\n"+ "3. Leer todo el diccionario\n"+ "4. " + "Salir\n");
                sc = new Scanner(System.in);
                opcion = sc.nextInt();
                if(opcion == 1){
                    System.out.println("Añada una palabra en español y su traducción");
                    spanish = leerTexto.readLine();
                    english = leerTexto.readLine();
                    utils.addWord(spanish.toLowerCase(),english.toLowerCase());
                }else if(opcion == 2){
                    System.out.println("Ingrese una palabra para su búsqueda");
                    spanish = leerTexto.readLine();
                    utils.searchWord(spanish.toLowerCase());
                }else if(opcion == 3){
                    utils.showAllWords();
                }else if(opcion == 4){
                    exit = false;
                }else{
                    System.out.println("Ingresa una opcion correcta");
                }
            } while (exit);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
