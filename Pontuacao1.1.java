package trab;


public class Pontuacao {

    protected String nome; // Nome do Aluno.
    int pontosFinais; // Pontuação que o aluno tinha ao fechar/terminar o jogo.

    Pontuacao() {
        nome = "";
        pontosFinais = 0;
    }

    Pontuacao(String nomeAluno, int pontosAluno) {
        nome = nomeAluno;
        pontosFinais = pontosAluno;
    }

    void mostraPontos() {
        System.out.println("Aluno %s: %d pontos " + nome + pontosFinais);
    }

    void salvaPontuacao() {
        //armazenamento da pontuação num arquivo txt
    }

}
