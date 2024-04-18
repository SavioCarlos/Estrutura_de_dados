import java.util.*;

public class Labirinto {
    private char[][] labirinto;
    private int linhas;
    private int colunas;
    private int[] inicio;
    private int[] destino;
    private Stack<int[]> pilhaCaminho;

    public Labirinto(char[][] labirinto) {
        this.labirinto = labirinto;
        this.linhas = labirinto.length;
        this.colunas = labirinto[0].length;
        this.inicio = encontrarPosicao('S');
        this.destino = encontrarPosicao('D');
        this.pilhaCaminho = new Stack<>();
    }

    private int[] encontrarPosicao(char symbol) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (labirinto[i][j] == symbol) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    private boolean posicaoValida(int linha, int coluna) {
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas && labirinto[linha][coluna] != '1';
    }

    private boolean explorar() {
        int linhaAtual = inicio[0];
        int colunaAtual = inicio[1];
        while (true) {
            labirinto[linhaAtual][colunaAtual] = 'X'; // Marcando a posicao atual
            imprimeLabirinto();

            if (linhaAtual == destino[0] && colunaAtual == destino[1]) {
                System.out.println("Final do labirinto");
                return true; // Encontrou o final
            }

            int[] proximaPosicao = proximaPosicao(linhaAtual, colunaAtual);
            if (proximaPosicao != null) {
                pilhaCaminho.push(new int[] { linhaAtual, colunaAtual });
                linhaAtual = proximaPosicao[0];
                colunaAtual = proximaPosicao[1];
            } else if (!pilhaCaminho.isEmpty()) {
                int[] posicaoAnterior = pilhaCaminho.pop();
                labirinto[linhaAtual][colunaAtual] = 'H'; // Marcando o caminho de volta
                linhaAtual = posicaoAnterior[0];
                colunaAtual = posicaoAnterior[1];
            } else {
                System.out.println("Labirinto sem solução");
                return false; // Não a caminho ate o destino (Se tudo der errado)
            }
        }
    }

    private int[] proximaPosicao(int linha, int coluna) {
        int[][] direcoes = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } }; // Esquerda, Baixo, Direita, Cima
        List<int[]> proximasPosicoes = new ArrayList<>();

        for (int[] direcao : direcoes) {
            int novaLinha = linha + direcao[0];
            int novaColuna = coluna + direcao[1];
            if (posicaoValida(novaLinha, novaColuna) && labirinto[novaLinha][novaColuna] != 'X') {
                proximasPosicoes.add(new int[] { novaLinha, novaColuna });
            }
        }

        if (proximasPosicoes.size() == 1) {
            return proximasPosicoes.get(0); // A apenas uma opção, seguir por ela
        }

        // Verifica a prioridade de direção: esquerda > baixo > direita > cima >
        // esquerda
        int[] prioridades = { 0, 1, 2, 3, 0 }; // indice do array direcoes
        for (int prioridade : prioridades) {
            for (int[] proximaPosicao : proximasPosicoes) {
                if (direcoes[prioridade][0] == proximaPosicao[0] - linha
                        && direcoes[prioridade][1] == proximaPosicao[1] - coluna) {
                    return proximaPosicao;
                }
            }
        }
        return null;
    }

    public void resolveLabirinto() {
        System.out.println("Labirinto inicial:");
        imprimeLabirinto();
        System.out.println("Explorando o labirinto:");
        explorar();
    }

    private void imprimeLabirinto() {
        for (char[] linha : labirinto) {
            System.out.println(Arrays.toString(linha));
        }
        System.out.println();
    }
}