Manual de Instruções: Controlador de Impressora (Java/JNA) 🖨️ Este programa funciona como um controle remoto para a sua impressora (fiscal ou não fiscal), permitindo o envio de comandos como "Imprimir Texto", "Abrir Gaveta" ou "Cortar Papel".

Para usar, basta ligar o programa e digitar o número da ação desejada no menu principal.

📦 Preparação Inicial: Configuração e IntelliJ Se você baixou um arquivo ZIP, todos os arquivos necessários (código, DLL da impressora e bibliotecas) já estão juntos.
Passo 1: Extrair a Pasta (Descompactar) Localize o arquivo ZIP baixado (ex: Java-Aluno Graduacao.zip).

Clique com o botão direito e selecione a opção "Extrair Tudo..." ou "Extract All...".

Escolha um local fácil (como Área de Trabalho ou Documentos) e clique em "Extrair". Uma pasta (ex: Java-Aluno Graduacao) será criada.

Passo 2: Ajuste OBRIGATÓRIO do Caminho da DLL 🛠️ O programa depende do arquivo E1_Impressora01.dll estar em um local exato. O caminho atual está configurado para outra máquina, então você deve alterá-lo.

⚠️ IMPORTANTE (Ajuste Crítico): Se você não mudar o caminho, o programa NÃO VAI FUNCIONAR e dará erro ao tentar abrir a conexão.

Como Pegar e Colar o Novo Caminho Encontre o Novo Caminho:

Vá até a pasta onde você extraiu o arquivo E1_Impressora01.dll.

Clique na barra de endereço (a barra superior do Windows Explorer, ex: Este Computador > Documentos > MinhaPasta).

Clique com o botão direito e selecione "Copiar Endereço como Texto". (Ex: C:\Users\SeuNome\Downloads\MinhaPasta).

Edite o Código no IntelliJ:

Abra o arquivo Main.java no IntelliJ.

Procure a linha que contém o caminho antigo da DLL (ela estará dentro de uma das primeiras classes):

Java

"C:\Users\eli_nascimento\Downloads\Java-Aluno Graduacao\Java-Aluno Graduacao\E1_Impressora01.dll" Substitua o caminho entre as aspas ("...") pelo caminho que você copiou, aplicando a regra do Java:

A Regra da Barra Dupla (\): O Java exige que você use duas barras invertidas (\) para cada uma que o Windows usa ().

Seu caminho copiado: C:\Users\SeuNome\MinhaPasta\E1_Impressora01.dll

Como deve ficar no código: "C:\Users\SeuNome\MinhaPasta\E1_Impressora01.dll"

Finalize: Cole o novo caminho ajustado no lugar do antigo. Salve o arquivo (File > Save All) antes de executar.

💻 Abrindo e Executando o Projeto Com os arquivos prontos e o caminho ajustado, vamos rodar o programa.
Passo 3: Abrir o Projeto no IntelliJ Abra o programa IntelliJ IDEA.

Na tela inicial, clique em "Open" (Abrir).

Navegue até a pasta que você extraiu (ex: Java-Aluno Graduacao).

Clique na pasta e depois no botão "Open" (Abrir).

Se perguntado, clique em "Trust Project" (Confiar no Projeto).

Passo 4: Executar o Programa Principal (Main) ▶️ No lado esquerdo, encontre a pasta src e clique duas vezes no arquivo Main.java.

Procure a pequena seta verde de "Play" ao lado da linha que diz public static void main(String[] args) {.

Clique na seta verde e selecione "Run 'Main'" (Executar 'Main').

O menu aparecerá na parte de baixo da tela, na aba "Run" (Executar), e o programa estará pronto para uso.

🎯 Usando o Menu: Conexão e Comandos Siga sempre esta ordem: Configurar > Abrir > Usar Comandos > Fechar.
Passo 1: Configurar a Impressora (Opção 1) ⚙️ Digite 1 e aperte Enter.

O programa fará 4 perguntas: Tipo da conexão, Modelo, Conexão e Parâmetro. Digite as respostas corretas do seu equipamento.

Passo 2: Abrir a Conexão (Opção 2) ✅ Digite 2 e aperte Enter.

Se as informações estiverem certas e a impressora ligada, a mensagem "Conexão estabelecida" vai aparecer.

Atenção ao Erro: Se aparecer o erro -99999, verifique imediatamente se a impressora está ligada e conectada corretamente.

Comandos de Ação (Opções 3 a 10) Com a conexão aberta, você pode usar qualquer uma dessas ações:

Opção 3 (Impressão Texto): Imprime um texto de teste.

Opção 4 (Impressão QRCode): Imprime um Código QR de teste.

Opção 5 (Impressão Código de Barras): Imprime um Código de Barras de teste.

Opção 6 (Impressão XML SAT): Imprime um Cupom Fiscal Eletrônico.

Opção 7 (Impressão XML Cancelamento SAT): Imprime o comprovante de cancelamento.

Opção 8 (Abrir Gaveta Elgin): Abre a gaveta de dinheiro (método Elgin).

Opção 9 (Abrir Gaveta): Abre a gaveta de dinheiro (método genérico).

Opção 10 (Sinal Sonoro): Faz a impressora emitir bipes.

🛑 Desligar e Sair Passo 3: Fechar a Conexão e Sair (Opção 0) Digite 0 e aperte Enter.
O programa vai fechar a comunicação ("Conexão encerrada") e finalizar.

Regra de Ouro: Sempre use a Opção 0 para fechar. Isso libera a impressora para ser usada por outros programas.
