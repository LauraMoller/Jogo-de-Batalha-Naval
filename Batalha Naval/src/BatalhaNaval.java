import java.util.Random;
import java.util.Scanner;

public class BatalhaNaval {
    public BatalhaNaval(){

        int tentativas = 0, encontrou = 0;
        char mar [][] = new char[8][8];
        char escondido [][] = new char [8][8];
        popularMar(mar, escondido);      
        System.out.println("Vamos começar o jogo!");
        popularEscondido(escondido);     
        ImprimirMar(mar);     
        Jogadas(escondido, mar, encontrou, tentativas);
    }

    //Método sem retorno (void) popula/preenche as matrizes mar e escondido contidas no parâmetro, com a água do mar (~). A matriz mar servirá de tabuleiro e a matriz 
    //escondido irá conter a localização dos navios e não será apresentada para o usuário
    private void popularMar(char mar [][], char escondido[][]){
        for(int linhas = 0; linhas < mar.length; linhas++){
            for (int colunas = 0; colunas < mar[linhas].length; colunas++){
                escondido[linhas][colunas] = '~';
                mar [linhas][colunas] = '~'; 
            }
        }
    }

    /*Método sem retorno (void) que substituí na matriz escondido contida no parametro 10 dos espaços preenchidos com água (~) por navios(N), utilizando a classe random 
    para popular de maneira aleatória com a condição de não sobrepor os navios.*/
    private void popularEscondido (char escondido [][]){
        Random aleatorio = new Random();
        int qntDeNavios = 0;
        do{
            int linha = aleatorio.nextInt(8);
            int coluna = aleatorio.nextInt(8);

            if (escondido[linha][coluna] == '~') {
                escondido[linha][coluna] = 'N';
                qntDeNavios++;
            }
        }while(qntDeNavios < 10);
    }

    //Método sem retorno(void), que lê no parâmetro a matriz mar e a imprime no início do jogo e a cada jogada, ou seja, esse método lê e imprime
    //o tabuleiro para o jogador juntamente com o indicador de linhas e colunas para facilitar a visualização e o entendimento do usuário.
    private void ImprimirMar(char mar [][]){
        System.out.print("  ");
        for(int colunas = 0; colunas < mar.length; colunas++){
            System.out.print(colunas + " ");
        }
        System.out.println();

        for(int linhas = 0; linhas < mar.length; linhas++){
            System.out.print(linhas + " ");
            for (int colunas = 0; colunas < mar[linhas].length; colunas++){
                System.out.print(mar[linhas][colunas] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /*Método sem retorno (void), que é responsável por fazer o controle das jogadas realizadas pelo usuário. Esse método lê no parâmetro as variáveis matriz escondio 
    (que armazena os navios), matriz mar(que armazena o mar(~) e o resultado das jogadas realizadas(O/X)), encontrou(variavel que soma um se encontrou algum navio) e 
    tentativas(que soma um a cada jogada feita), onde chama o método verificarLinhaColuna e faz a verificação da linha e coluna inserido pelo usuário, em sequência chama
    o método mensagemAcertouErrou que faz a verificação se foi encontrado ou não o navio, ao final se soma um na variável tentativas, depois chama o método imprimirMar 
    para ser visualizado pelo usuário a atualização do tabuleiro e, em seguida se chama o método mensagemVitoriaDerrota para saber a resposta do final do jogo.*/

    private void Jogadas (char escondido[][], char mar[][], int encontrou, int tentativas){
        Scanner entrada = new Scanner (System.in);
        boolean verificar = false;
        int linhaDaJogada, colunaDaJogada;

        do{
            do{
                System.out.println("Insira a linha: ");
                linhaDaJogada = entrada.nextInt();
                System.out.println("Insira a coluna: ");
                colunaDaJogada = entrada.nextInt();

                verificar = verificarLinhaColuna(linhaDaJogada,colunaDaJogada, mar);
                
            }while(verificar);

            encontrou = mensagemAcertouErrou(escondido,mar,linhaDaJogada, colunaDaJogada, encontrou);
            tentativas++;
            ImprimirMar(mar);          

        }while(tentativas < 30 && encontrou < 10);

        mensagemVitoriaDerrota(tentativas, encontrou);
        entrada.close();
    }

    /*Esse método com retorno(int) que é responsável por ler no parâmetro as variáveis linhaDaJogada (linha informada pelo jogador) e colunaDaJogada(coluna informada pelo
    jogador) para verificar se a pessoa acertou ou errou a posição do navio na matriz escondido(contém onde esta os navios) e modificando a matriz mar(tabuleiro) para o 
    caractere 'X'(acertou) ou 'O'(errou), imprindo para o usuário o resultado da jogada, caso tenha acertado a jogada soma-se um na variável encontrou. Após as 
    verificações retorna a quantidade de navios encontrados pelo usuário até o momento, por meio da variável encontrou para o método Jogadas.*/
    private int mensagemAcertouErrou(char [][]escondido, char [][]mar, int linhaDaJogada, int colunaDaJogada, int encontrou){
        if(escondido[linhaDaJogada][colunaDaJogada] == 'N'){
            System.out.println("Você acertou!");
            mar[linhaDaJogada][colunaDaJogada] = 'X';
            encontrou++;
        }else{
            System.out.println("Você errou :(");
            mar[linhaDaJogada][colunaDaJogada] = 'O';
        }
        return encontrou;
    }

    /*Esse é um método sem retorno(void) que é responsável por ler no parâmetro as variáveis tentativas (váriavel que contabiliza a quantidade de jogadas feitas pelo 
    usuário) e encontrou (variável que contabiliza a quantidade de navios encontrados pelo usuário na partida), imprimir que acabou o jogo e validar se o jogador 
    ganhou (encontrou os 10 navios sem ultrapassar o limite de tentaivas) ou perdeu (não encontrou os 10 navios antes de atingir o limite de tentativas), imprimindo as 
    respectivas mensagens*/
    private void mensagemVitoriaDerrota(int tentativas, int encontrou){
        System.out.println("Fim de jogo");
        if(encontrou == 10 && tentativas <=30){
            System.out.println("Resuntado: Vitória");
        }else{
            System.out.println("Resultado: Derrota");
        }
    }

    /*Esse é um método com retorno booleano, ou seja, uma variável de verdadeiro ou falso, que lê no parâmetro as variáveis de linhaDaJogada (linha informada pelo jogador),
    colunaDaJogada (coluna informada pelo jogador) e a matriz mar(tabuleiro). É responsável por verificar se a coluna e a linha que foram inseridos pelo usuário são 
    validas seguindo as regras do jogo (linha e coluna de 0 a 7 e sem repetir as jogadas que já foram feitas na partida) e retornando para o método Jogadas a resposta 
    true(jogada inválida) ou false(jogada válida)*/
    private boolean verificarLinhaColuna(int linhaDaJogada, int colunaDaJogada, char mar[][]){
        boolean verificar = false;
        if((linhaDaJogada<0||linhaDaJogada>7)||(colunaDaJogada<0 ||colunaDaJogada>7)){
            System.out.println("Jogada Inválida");
            verificar = true;
        }else if(mar[linhaDaJogada][colunaDaJogada] == 'X' || mar[linhaDaJogada][colunaDaJogada] == 'O'){
            verificar = true;
            System.out.println("Você já fez essa jogada, tente novamente!");
        }
        return verificar;
    }

    public static void main(String[] args) {
        new BatalhaNaval();
    }
}