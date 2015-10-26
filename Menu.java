/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Cliente
 */
public class Menu {

    /*public void mostrarMenu(){
     System.out.println("Bem Vindo ao Eco Test \n Digite 1 para iniciar novo jogo \n Digite 2 para ver as intruções \n Digite 3 para sair");
     }*/
    public void mostraMenu() throws FileNotFoundException {
        System.out.println("Bem Vindo ao Eco Test \n Digite 1 para iniciar novo jogo \n Digite 2 para ver as intruções \n Digite 3 para sair");
        String s;
        try (BufferedReader textoAjuda = new BufferedReader(new FileReader("C:\\Documents and Settings\\gessica\\Desktop\\trab\\src\\trab\\ajuda.txt"))) {
            while ((s = textoAjuda.readLine()) != null) {
                System.out.println(s); //apenas um texte do funcionamento da leitura

            }
        } catch (IOException exc) {
            System.out.println("Erro na abertura do arquivo:  " + exc);

        }
    }

    void Sair() {
        System.out.println("O jogo foi finalizado.");
        System.exit(0);
    }

    void Ajuda() {
        try {
            FileReader arquivoAjuda = new FileReader("C:\\Users\\Arthur\\Desktop\\trab\\src\\trab\\ajuda.txt");
            BufferedReader lerArq = new BufferedReader(arquivoAjuda);
            String linha = lerArq.readLine(); // lê a primeira linha 
            // a variável "linha" recebe o valor "null" quando o processo 
            // de repetição atingir o final do arquivo texto 
            while (linha != null) {
                System.out.printf("%s\n", linha);
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            arquivoAjuda.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo de ajuda: %s.\n", e.getMessage());
        }
    }
}
