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
import java.util.Scanner;

/**
 *
 * @author Cliente
 */
public class Quiz {
    public
        //ATRIBUTOS
            Menu menuJogo;      
            Pergunta Questoes[];
            Pontuacao[] Ranking;
            miniGame[] Bonus;   //cada Mini-Game será disparado quando o Jogador fizer 5 acertos, independente de serem consecutivos ou da pontuação atual
            int pontos; //variável utilziada para o controle dos pontos ATUAIS do jogador
            int contaPontos; //variável utilizada para disparar o Mini-Game
            int contaPergunta; //indica em qual índice do vetor de perguntas o jogador está
            int tamRanking; //numero de pontuações registradas atualmente.
            int tamQuiz ;   //quantidade de perguntas do quiz.
            int tamBonus; //quantidade de mini-games que haverão, proporcional ao tamQuiz
            
    Quiz(int quantQuestoes){
       
        menuJogo = new Menu();
        tamQuiz = quantQuestoes;
        tamBonus = quantQuestoes/5;
        Questoes = new Pergunta[quantQuestoes];
        Bonus = new miniGame[tamBonus];
      
            for (int i=0; i < quantQuestoes; i++){          
                Questoes[i] = new Pergunta();
                
            }
            for (int i=0; i<tamBonus; i++){
                Bonus[i] = new miniGame();
            } 
        pontos = 0;
        contaPontos = 0;
        contaPergunta = 0;
        tamRanking = 0;
        Ranking = null;
    }        
         //MÉTODOS
    
            void chamaPergunta(){
                Questoes[contaPergunta].criaPergunta(); //pergunta é exibida na tela
                pedeResposta();
                if (contaPergunta < tamQuiz-1)
                    contaPergunta++;
                else
                    finalizarJogo();
            }
            void finalizarJogo(){
                System.out.println("Deseja salvar sua pontuação?(s/n)");
                char c;
                Scanner save = new Scanner(System.in);
                c = save.next().charAt(0);
                    if (c == 's' || c == 'S')
                    {
                        if(tamRanking == 0){
                            tamRanking++;
                            Ranking = new Pontuacao[tamRanking];
                        }
                        else
                            tamRanking++;
                        System.out.println("Digite seu nome:");
                        Scanner name = new Scanner(System.in);
                        String nomeAluno = name.next();
                        Ranking[tamRanking-1] = new Pontuacao(nomeAluno, pontos);
                       
                        System.out.println("Score salvo com sucesso!");
                        System.exit(0);
                    }
                    if (c == 'n' || c == 'N'){
                        System.out.println("Jogo finalizado.");
                        System.exit(0);
                    }
            }
            void pedeResposta(){
                Scanner respostaAluno = new Scanner(System.in); //aluno entra com a resposta da pergunta, que é armazenada numa String.
                char c = respostaAluno.next().charAt(0);
                if(Questoes[contaPergunta].checarResposta(c)){ //compara a resposta dada com a string respostaCorreta da classe Pergunta.
                    acertaResposta();   //Se a resposta foi correta, chama o acertaResposta().
                }
                else
                    erraResposta();
            }
            void acertaResposta(){
                System.out.println("OH YEEEEAAAAH!!");
                pontos = pontos + 10;
                contaPontos++;
                if ((contaPontos % 5 == 0)){    //Se a pontuação obtida com acertos de PERGUNTAS for multipla de 5 um mini-game será ativado
                    if(Bonus[0].iniciaMiniGame()){
                        pontos = pontos + 5;  //Se a função retornou true (Usuário acertou o mini-game), também são somados pontos
                    }
                }       
            }
            void erraResposta(){    //Jogador perde pontos ao errar, mas a pontuação não pode ser negativa.
                System.out.println("VOCE FRACASSOU NESSA PERGUNTA!!");
                pontos = pontos - 10;
                if (pontos < 0)
                    pontos = 0;
            }
            void mostraScores(){
                for (int i = 0; i < tamRanking; i++){
                    Ranking[i].mostraPontos(); //Imprime na tela o vetor de Pontuacao.
                }
            }
}        
    
            
    //vai ter que ler as questoes de um arquivo e imprimir
    

