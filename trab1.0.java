/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trab;

/**
 *
 * @author Cliente
 */
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Trab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
      int opcao;
      Quiz Ecotest = new Quiz(5);
      Ecotest.menuJogo.mostraMenu();
      Scanner entrada = new Scanner (System.in);
      opcao = entrada.nextInt();
      if (opcao==1){
          System.out.println("Teste opção 1");
          while(true){
            Ecotest.chamaPergunta();
          }
      }
      else if (opcao==2){
          System.out.println("Teste opção 2");
          Ecotest.menuJogo.Ajuda();
          Scanner voltar = new Scanner (System.in);
          opcao=voltar.nextInt();
      }
      else if (opcao ==3){
          System.out.println("Teste opção 3");
          Ecotest.menuJogo.Sair();
      }
      else {
      System.out.println("Opção inválida");
      }
    }
    
}
