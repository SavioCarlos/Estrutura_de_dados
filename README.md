# Estrutura de dados

1. **Implementação do Labirinto:**
    - Foi usando uma matriz, onde cada célula pode ser um caminho livre (0), um obstáculo (1), o ponto de partida (S) ou o destino (D).
2. **Exploração com Pilhas (DFS - Busca em Profundidade):**
    - Utilizamos uma pilha para implementar a busca em profundidade (DFS) no labirinto.
    - O código marca o caminho percorrido com 'X' e registra os caminhos explorados.
3. **Algoritmo de Navegação:**
    - O robô sai do ponto de partida e verifica as células vizinhas.
    - Ele avança apenas para células livres (0) e evita obstáculos (1).
    - Ao encontrar o destino, traça o caminho de volta ao ponto de partida, destacando o caminho encontrado.
4. **Desafios Adicionais:**
    - Implementamos funcionalidades para evitar caminhos previamente explorados que não levam ao destino.
    - Priorizamos movimentos para a esquerda, para baixo, para a direita e para cima, respectivamente.
    - Marcamos os caminhos possivelmente sem saída com 'H' para indicar retornos.
5. **Resultado:**
    - O algoritmo foi testado com sucesso em um labirinto de exemplo 7x7.
    - Ele encontrou o caminho até o destino, evitando obstáculos e marcando o caminho percorrido.
