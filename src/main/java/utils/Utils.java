package utils;

import modelo.Diccionario;

import java.util.ArrayList;

public class Utils {

    private Diccionario diccionario;
    public ArrayList<Diccionario> listWords = new ArrayList<>();

    public void addWord (String spanish, String english){
        diccionario = new Diccionario(spanish,english);
        listWords.add(diccionario);
    }

    public void searchWord(String word){
        listWords.forEach(p -> {
            if (p.getSpanish().equals(word.toLowerCase())) {
                System.out.println("La traduccion es: "+p.getEnglish());
            }else{
                System.out.println("No existe traduccion");
            }
        });
    }

    public void showAllWords(){
        System.out.println("TODAS LAS PALABRAS");
        listWords.forEach(System.out::println);
    }

}
