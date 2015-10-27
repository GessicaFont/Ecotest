package trab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Menu {

    Quiz Ecotest;

    Menu(){
        Ecotest = new Quiz(5);
    }

    void mostraMenu() throws FileNotFoundException {
        int opcao;
        
        while(true){
            System.out.println("Bem Vindo ao Eco Test \n Digite 1 para iniciar novo jogo \n Digite 2 para ver as intruções \n Digite 3 para sair");
               
            Scanner entrada = new Scanner(System.in);
            opcao = entrada.nextInt();

            if(opcao < 1 || opcao > 3){
                System.out.println("Opção inválida.");
            }
            else{
                if (opcao == 1) { 
                        Ecotest.chamaPergunta();  //inicia o jogo
                    
                } else if (opcao == 2) { 
                    Ajuda();
                    while(true){ //loop que só acaba quando o usuário escolher sair da tela de Ajuda.
                        System.out.println("Digite s para voltar ao menu.");
                        Scanner voltar = new Scanner(System.in);
                        char volta = voltar.next().charAt(0); //converte a String capturada com Scanner para um char
                        if (volta == 's'){
                            mostraMenu(); //se o usuário entrou com "s", o menu é exibido novamente
                            break;
                        }
                    }
                } else if (opcao == 3) {
                    Sair();
                }
            }
        }
      
    }

    void Sair() { // Sair() do Menu não aciona o salvamento de dados.
        System.out.println("O jogo foi finalizado.");
        System.exit(0);
    }

    void Ajuda() {
        try {
            FileReader arquivoAjuda = new FileReader("E:\\PCS\\trab\\src\\trab\\ajuda.txt");
            BufferedReader lerArq = new BufferedReader(arquivoAjuda);
            String linha = lerArq.readLine(); // lê a primeira linha do arquivo de Ajuda
                
                // a variável "linha" recebe o valor "null" quando a iteração chegar ao final do arquivo txt
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
