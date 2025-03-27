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
