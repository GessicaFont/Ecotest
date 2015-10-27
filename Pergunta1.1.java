package trab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Pergunta {

    public char respostaCorreta;

    Pergunta() {
        respostaCorreta = ' ';
    }


    void criaPergunta(String numPergunta) { 
    //numPergunta é a String correspondente a um inteiro gerada em chamaPergunta, da classe Quiz
        try {       
            String perg = "E:\\PCS\\trab\\src\\trab\\pergunta0.txt";
            //o arquivo pergunta0.txt não existe, mas a String serve para fazer o procedimento de substituição de caracter.
            char numPerg = numPergunta.charAt(0);   //conversão para char   
            perg = perg.replace('0', numPerg); 
            //com esta substuição, a String que representa o caminho para o arquivo txt passa a ser válida,
            //pois pergunta1.txt, pergunta2.txt,.... existem.
       
            FileReader arq = new FileReader(perg);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine(); // lê a primeira linha 
            respostaCorreta = linha.charAt(0); 
            //a resposta de cada pergunta está localizada na primeira linha de cada arquivo txt.
        
            linha = lerArq.readLine();
            
            while (linha != null) {  // a variável "linha" recebe o valor "null" quando o processo 
                                       // de repetição atingir o final do arquivo txt
                System.out.printf("%s\n", linha);
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            arq.close();                                                              
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());  
        }  
    }

    boolean checarResposta(char respostaAluno) {
        if (respostaAluno == respostaCorreta) {
            return true;
        } else {
            return false;
        }
    }
}
