# Simulador

Esse simulador envolve conceitos de estrutura de dados e gerenciamento de eventos. Podemos dividir o projeto em etapas:

1. Estruturas de Dados Necessárias
Como você não pode usar listas e filas prontas do Java, será necessário implementar:

Lista Encadeada (para armazenar os caminhões e suas cargas)

Fila (para gerenciar a fila de espera dos caminhões pequenos nas estações)

Pilha (caso seja útil para registros ou logs)

2. Classes Principais
Zona: Representa uma das cinco zonas da cidade.

Atributos: Nome, intervalo de geração de lixo.

Método: gerarLixo().

CaminhaoPequeno: Caminhões de 2, 4, 8 e 10 toneladas.

Atributos: Capacidade, carga atual, zona de coleta, tempo de viagem.

Métodos: coletarLixo(), viajarParaEstacao().

CaminhaoGrande: Caminhões de 20 toneladas que transportam o lixo ao aterro.

Atributos: Capacidade, carga atual, tempo de espera.

Métodos: carregarLixo(), descarregarNoAterro().

EstacaoTransferencia: Local onde os caminhões pequenos descarregam o lixo nos caminhões grandes.

Atributos: Fila de caminhões pequenos, lista de caminhões grandes.

Métodos: receberCaminhaoPequeno(), transferirParaCaminhaoGrande(), gerenciarEspera().

Simulador: Classe principal que gerencia a simulação.

Atributos: Lista de zonas, caminhões e estações.

Métodos: iniciarSimulacao(), registrarEstatisticas().

3. Desenvolvimento
Criar estruturas de dados personalizadas (Listas, Filas e Pilhas).

Implementar as classes conforme a lógica de funcionamento.

Criar um método de simulação que executa eventos ao longo do tempo.

Gerar logs e estatísticas.

Posso começar criando as classes principais para você?


---------------------------------------------


📌 Semana 1 – Fundamentos de Estruturas de Dados e Modelagem
🗓️ Dia 1-2: Revisão de Estruturas de Dados
🔹 O que estudar:

Listas, Filas e Pilhas (implementação manual em Java).
Conceitos de TADs (Tipos Abstratos de Dados).
Complexidade de algoritmos (tempo e espaço).
📚 Material de estudo:

Livro: Estruturas de Dados e Algoritmos com Java – Roberto Tamassia, Michael Goodrich.
PDF: Apostila de Estruturas de Dados – Instituto de Computação USP.
Curso online: Curso de Estruturas de Dados em Java (YouTube).
🗓️ Dia 3-4: Modelagem da Simulação
🔹 O que estudar:

Técnicas de modelagem para simulações baseadas em eventos.
Abstração do problema: representação das zonas, caminhões e processos em classes e métodos.
📚 Material de estudo:

Livro: Simulação: Teoria e Aplicações – Geoffrey Gordon.
PDF: Modelagem e Simulação de Sistemas Discretos – Universidade Federal de São Carlos.
📌 Semana 2 – Implementação das Estruturas de Dados
🗓️ Dia 5-6: Implementação de Listas e Filas
🔹 O que fazer:

Criar classes para listas e filas sem usar ArrayList ou LinkedList.
Testar com inserções, remoções e percursos.
📚 Material de estudo:

Livro: Java Structures – Duane Bailey.
Curso online: Estruturas de Dados em Java (Alura).
🗓️ Dia 7: Testes e Ajustes
🔹 O que fazer:

Criar testes unitários para validar suas listas e filas.
Ajustar qualquer problema encontrado.
📌 Semana 3 – Implementação do Sistema de Simulação
🗓️ Dia 8-9: Criando Classes Principais
🔹 O que fazer:

Implementar a classe Cidade com as 5 zonas.
Criar a classe Caminhão (pequeno e grande) e seus métodos.
Implementar uma fila de espera para os caminhões nas estações de transferência.
🗓️ Dia 10-11: Lógica da Simulação
🔹 O que fazer:

Criar métodos para gerenciar a movimentação dos caminhões.
Implementar regras de tempo de espera e capacidade máxima.
📚 Material de estudo:

Livro: Design Patterns em Java – Eric Freeman, Elisabeth Freeman.
Curso online: Simulação baseada em eventos discretos (Udemy).
📌 Semana 4 – Testes, Estatísticas e Documentação
🗓️ Dia 12-13: Analisando Resultados
🔹 O que fazer:

Criar logs de execução mostrando tempos de espera e número de caminhões necessários.
Implementar métodos para coletar estatísticas.
🗓️ Dia 14: Finalização e Relatório
🔹 O que fazer:

Criar gráficos com os dados obtidos.
Documentar todo o código e escrever o relatório.
📚 Ferramentas úteis:

Apache POI para gerar relatórios em Excel.
Matplotlib (Python) para gerar gráficos estatísticos.
