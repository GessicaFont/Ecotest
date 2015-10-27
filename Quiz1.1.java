package trab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Quiz {

    //ATRIBUTOS
    Pergunta Questoes[];
    Pontuacao[] Ranking;
    miniGame[] Bonus;   
//cada Mini-Game será disparado quando o Jogador fizer 5 acertos, independente de serem consecutivos ou da pontuação atual
    int pontos; //variável utilziada para o controle dos pontos ATUAIS do jogador
    int contaPontos; //variável utilizada para disparar o Mini-Game
    int contaPergunta; //indica em qual índice do vetor de perguntas o jogador está
    int tamRanking; //numero de pontuações registradas atualmente.
    int tamQuiz;   //quantidade de perguntas do quiz.
    int tamBonus; //quantidade de mini-games que haverão, proporcional ao tamQuiz

    Quiz(int quantQuestoes) {

        tamQuiz = quantQuestoes;
        tamBonus = quantQuestoes / 5;
        Questoes = new Pergunta[quantQuestoes];
        Bonus = new miniGame[tamBonus];

        for (int i = 0; i < quantQuestoes; i++) {
            Questoes[i] = new Pergunta();

        }
        for (int i = 0; i < tamBonus; i++) {
            Bonus[i] = new miniGame();
        }
        pontos = 0;
        contaPontos = 0;
        contaPergunta = 0;
        tamRanking = 0;
        Ranking = null;
    }

    //MÉTODOS
    
   
    void chamaPergunta() {  //é chamada quando o usuário escolhe iniciar o jogo, do Menu.
        String alt;    //alt será utilizado para ser passado como parâmetro para o método criapergunta(String x), de Pergunta.
        for (int i = 1; i <= tamQuiz; i++) {                               
        // a cada iteração alt receberá uma String que corresponde à conversão de um inteiro,
            alt = Integer.toString(i);  // ou seja, "1","2","3",...
            Questoes[contaPergunta].criaPergunta(alt); //criaPergunta é chamado "tamQuiz" vezes
            pedeResposta();
            if (contaPergunta < tamQuiz - 1) {
                contaPergunta++;
            } else {
                System.out.println("Fim do Quiz.");
                finalizarJogo();
            }
        }
    }

    void finalizarJogo() {
        System.out.println("Deseja salvar sua pontuação?(s/n)");
        char c;
        Scanner save = new Scanner(System.in);
        c = save.next().charAt(0);
        if (c == 's' || c == 'S') {
            if (tamRanking == 0) {
                tamRanking++;
                Ranking = new Pontuacao[tamRanking];
            } else {
                tamRanking++;
            }
            System.out.println("Digite seu nome:");
            Scanner name = new Scanner(System.in);
            String nomeAluno = name.next();
            Ranking[tamRanking - 1] = new Pontuacao(nomeAluno, pontos);
            System.out.printf("Score de %d salvo com sucesso, %s!\n", pontos, nomeAluno);
            System.exit(0);
        }
        if (c == 'n' || c == 'N') {
            System.out.println("Jogo finalizado.");
            System.exit(0);
        } else {
            System.out.println("Opção incorreta.");
            finalizarJogo();
        }
    }

    void pedeResposta() {
        Scanner respostaAluno = new Scanner(System.in); //aluno entra com a resposta da pergunta, que é armazenada numa String.
        char c = respostaAluno.next().charAt(0);        //essa String é convertida para char para que a entrada seja validada
            if (c < 'a' || c > 'd') {
                System.out.println("Resposta inválida.");
                pedeResposta();
            }
            else{
                System.out.println("Resposta escolhida: letra " + c);
                if (Questoes[contaPergunta].checarResposta(c) == true) {
                    //compara a resposta dada com a string respostaCorreta da classe Pergunta.
                    acertaResposta();   //Se a resposta foi correta, chama o acertaResposta().
                } else {
                    erraResposta();
                }
            }
    }

    void acertaResposta() {
        System.out.println("OH YEEEEAAAAH!!\n");
        pontos = pontos + 10;
        contaPontos++; 
//O mini-game depende da quantidade de acertos e não da quantidade de pontos. contaPontos é a quantidade de acertos  
        
        if ((contaPontos % 5 == 0)) {    //Se contaPontos for multipla de 5, um mini-game será ativado
            if (Bonus[contaPontos / 5].iniciaMiniGame()) { 
            //(contaPontos/5) assumirá os valores 1,2,3,... dentro do "if" anterior(mod).
                pontos = pontos + 5;  //Se a função retornou true (Usuário acertou o mini-game), também são somados pontos
            }
        }
    }

    void erraResposta() {    //Jogador perde pontos ao errar.
        System.out.println("RESPOSTA ERRADA!!\n");
        pontos = pontos - 10;
        if (pontos < 0) { //não há pontuação negativa.
            pontos = 0;
        }
    }

    void mostraScores() {
        for (int i = 0; i < tamRanking; i++) {
            Ranking[i].mostraPontos(); //Imprime na tela o vetor de Pontuacao. Não está sendo utilizado no protótipo
        }
    }
}
