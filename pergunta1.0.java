/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Pergunta {
    
    public char respostaCorreta;
   
    
    Pergunta(){
        respostaCorreta = ' ';
    }
    Pergunta(char resp){
        respostaCorreta = resp;
    }
    
    void criaPergunta(){                
                                //TIREI DAQUI http://www.devmedia.com.br/lendo-dados-de-txt-com-java/23221
        try { 
        FileReader arq = new FileReader("C:\\Documents and Settings\\gessica\\Desktop\\trab\\src\\trab\\perguntas.txt"); 
        BufferedReader lerArq = new BufferedReader(arq); 
        String linha = lerArq.readLine(); // lê a primeira linha 
        respostaCorreta = linha.charAt(1);
        linha = lerArq.readLine();
// a variável "linha" recebe o valor "null" quando o processo 
// de repetição atingir o final do arquivo texto 
            while (linha != null) { 
                System.out.printf("%s\n", linha); 
                linha = lerArq.readLine(); // lê da segunda até a última linha
            } 
            arq.close(); 
        } 
        catch (IOException e) { 
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage()); 
        } 
    }
    boolean checarResposta(char respostaAluno){
        if (respostaAluno == respostaCorreta)
            return true;
        else
            return false;
    }
}
