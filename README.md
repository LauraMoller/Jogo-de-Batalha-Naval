Batalha Naval



Introdução

Este é um jogo de Batalha Naval simples implementado em Java. O objetivo do jogo é encontrar e afundar todos os navios escondidos no tabuleiro antes de esgotar suas tentativas. O tabuleiro é uma matriz 8x8, onde 10 navios são colocados aleatoriamente.



Como Jogar

Executar o Programa:
Para iniciar o jogo, compile e execute a classe BatalhaNaval. Você pode usar um ambiente de desenvolvimento integrado (IDE) como Eclipse ou IntelliJ, ou compilar e executar o código a partir da linha de comando.



Instruções do Jogo:

-O jogo começa com um tabuleiro de 8x8, inicialmente preenchido com água (~).
-Dez navios (N) estão escondidos no tabuleiro, mas suas posições não são reveladas ao jogador.
-O jogador tem até 30 tentativas para encontrar todos os 10 navios.
-Em cada turno, o jogador insere as coordenadas da linha e coluna onde deseja atacar.
-Se o ataque acertar um navio, a posição no tabuleiro será marcada com um X.
-Se o ataque errar, a posição será marcada com um O.



Estrutura do Código

-BatalhaNaval: Classe principal que contém a lógica do jogo.
-popularMar: Método que inicializa o tabuleiro com água.
-popularEscondido: Método que posiciona aleatoriamente os navios no tabuleiro.
-ImprimirMar: Método que imprime o estado atual do tabuleiro para o jogador.
-Jogadas: Método que controla o fluxo das jogadas do jogador.
-mensagemAcertouErrou: Método que verifica se o jogador acertou ou errou um navio.
-mensagemVitoriaDerrota: Método que imprime o resultado final do jogo.
-verificarLinhaColuna: Método que verifica a validade das coordenadas inseridas pelo jogador.
