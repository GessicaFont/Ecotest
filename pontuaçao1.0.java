/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab;


public class Pontuacao {
        protected    
            String nome; // Nome do Aluno.
            int pontosFinais; // Pontuação que o aluno tinha ao fechar/terminar o jogo.
            
            Pontuacao(){
                nome = "";
                pontosFinais = 0;
            }
            Pontuacao(String nomeAluno, int pontosAluno){
                nome = nomeAluno;
                pontosFinais = pontosAluno;
            }
            void mostraPontos(){
                System.out.println("Aluno %s: %d pontos " + nome + pontosFinais);
            }
            void salvaPontuacao(){
                //armazenamento da pontuação num arquivo txt
            }
 
}



