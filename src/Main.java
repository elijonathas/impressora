
import com.sun.jna.Library;
import com.sun.jna.Native;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.FileInputStream;

public class Main {

    public interface ImpressoraDLL extends Library {

        ImpressoraDLL INSTANCE = (ImpressoraDLL) Native.load(
                "C:\\Users\\eli_nascimento\\Downloads\\Java-Aluno Graduacao\\Java-Aluno Graduacao\\E1_Impressora01.dll", ImpressoraDLL.class);

        int AbreConexaoImpressora(int tipo, String modelo, String conexao, int param);

        int FechaConexaoImpressora();

        int ImpressaoTexto(String dados, int posicao, int estilo, int tamanho);

        int Corte(int avanco);

        int ImpressaoQRCode(String dados, int tamanho, int nivelCorrecao);

        int ImpressaoCodigoBarras(int tipo, String dados, int altura, int largura, int HRI);

        int AvancaPapel(int linhas);

        int StatusImpressora(int param);

        int AbreGavetaElgin();

        int AbreGaveta(int pino, int ti, int tf);

        int SinalSonoro(int qtd, int tempoInicio, int tempoFim);

        int ModoPagina();

        int LimpaBufferModoPagina();

        int ImprimeModoPagina();

        int ModoPadrao();

        int PosicaoImpressaoHorizontal(int posicao);

        int PosicaoImpressaoVertical(int posicao);

        int ImprimeXMLSAT(String dados, int param);

        int ImprimeXMLCancelamentoSAT(String dados, String assQRCode, int param);
    }

    private static boolean conexaoAberta = false;
    private static int tipo;
    private static String modelo;
    private static String conexao;
    private static int parametro;
    private static final Scanner scanner = new Scanner(System.in);

    private static String capturarEntrada(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    private static String lerArquivoComoString(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        byte[] data = fis.readAllBytes();
        fis.close();
        return new String(data, StandardCharsets.UTF_8);
    }

    public static void configurarConexao() {
        tipo = Integer.parseInt(capturarEntrada("Tipo da conexão: "));
        modelo = capturarEntrada("Modelo: ");
        conexao = capturarEntrada("Conexão: ");
        parametro = Integer.parseInt(capturarEntrada("Parâmetro: "));
        System.out.println("Configuração salva.");
    }

    public static void abrirConexao() {
        if (conexaoAberta) {
            System.out.println("Conexão já aberta.");
            return;
        }
        int retorno = ImpressoraDLL.INSTANCE.AbreConexaoImpressora(tipo, modelo, conexao, parametro);
        if (retorno == 0) {
            conexaoAberta = true;
            System.out.println("Conexão estabelecida.");
        } else {
            System.out.println("Erro ao abrir conexão: " + retorno);
        }
    }

    public static void fecharConexao() {
        if (!conexaoAberta) {
            System.out.println("Nenhuma conexão ativa.");
            return;
        }
        int retorno = ImpressoraDLL.INSTANCE.FechaConexaoImpressora();
        if (retorno == 0) {
            conexaoAberta = false;
            System.out.println("Conexão encerrada.");
        } else {
            System.out.println("Erro ao encerrar: " + retorno);
        }
    }

    public static void imprimeXMLSAT() {
        if (conexaoAberta) {
            String dados = "path=C:\\Users\\eli_nascimento\\Downloads\\Java-Aluno Graduacao\\Java-Aluno Graduacao\\XMLSAT.xml";
            int retorno = ImpressoraDLL.INSTANCE.ImprimeXMLSAT(dados, 0);

            if (retorno == 0) {
                System.out.println("Impressao de xml sat OK");
            } else {
                System.out.println("Erro. Retorno " + retorno);
            }
        } else {
            System.out.println("Abra a conexao primeiro.");

        }
    }

    public static void ImprimeXMLCancelamentoSAT() {
        if (conexaoAberta) {
            String dados = "path=C:\\Users\\eli_nascimento\\Downloads\\Java-Aluno Graduacao\\Java-Aluno Graduacao\\CANC_SAT.xml";
            String assQRCode = "Q5DLkpdRijIRGY6YSSNsTWK1TztHL1vD0V1Jc4spo/CEUqICEb9SFy82ym8EhBRZjbh3btsZhF+sjHqEMR159i4agru9x6KsepK/q0E2e5xlU5cv3m1woYfgHyOkWDNcSdMsS6bBh2Bpq6s89yJ9Q6qh/J8YHi306ce9Tqb/drKvN2XdE5noRSS32TAWuaQEVd7u+TrvXlOQsE3fHR1D5f1saUwQLPSdIv01NF6Ny7jZwjCwv1uNDgGZONJdlTJ6p0ccqnZvuE70aHOI09elpjEO6Cd+orI7XHHrFCwhFhAcbalc+ZfO5b/+vkyAHS6CYVFCDtYR9Hi5qgdk31v23w==\";)";
            int retorno = ImpressoraDLL.INSTANCE.ImprimeXMLCancelamentoSAT(dados, assQRCode, 0);

            if (retorno == 0) {
                System.out.println("Impressao de xml sat OK");
            } else {
                System.out.println("Erro. Retorno " + retorno);


            }
        }
    }



    public static void main(String[] args) {

        while (true) {

            System.out.println("\n============== MENU ==============\n");
            System.out.println("1 - Configurar Conexão");
            System.out.println("2 - Abrir Conexão");
            System.out.println("3 - Impressão Texto");
            System.out.println("4 - Impressão QRCode");
            System.out.println("5 - Impressão Código de Barras");
            System.out.println("6 - Impressão XML SAT");
            System.out.println("7 - Impressão XML Cancelamento SAT");
            System.out.println("8 - Abrir Gaveta Elgin");
            System.out.println("9 - Abrir Gaveta");
            System.out.println("10 - Sinal Sonoro");
            System.out.println("0 - Fechar Conexão e Sair");

            String opcao = capturarEntrada("Opção: ");

            switch (opcao) {

                case "0":
                    fecharConexao();
                    System.out.println("Encerrando.");
                    return;

                case "1":
                    configurarConexao();
                    break;

                case "2":
                    abrirConexao();
                    break;

                case "3":
                    if (!conexaoAberta) { System.out.println("Abra a conexão primeiro."); break; }
                    ImpressoraDLL.INSTANCE.ImpressaoTexto("Teste de impressao", 1, 4, 0);
                    ImpressoraDLL.INSTANCE.AvancaPapel(2);
                    ImpressoraDLL.INSTANCE.Corte(2);
                    break;

                case "4":
                    if (!conexaoAberta) { System.out.println("Abra a conexão."); break; }
                    ImpressoraDLL.INSTANCE.ImpressaoQRCode("Teste de impressao", 6, 4);
                    ImpressoraDLL.INSTANCE.AvancaPapel(2);
                    ImpressoraDLL.INSTANCE.Corte(2);
                    break;

                case "5":
                    if (!conexaoAberta) { System.out.println("Conexão não aberta."); break; }
                    ImpressoraDLL.INSTANCE.ImpressaoCodigoBarras(8, "{A012345678912", 100, 2, 3);
                    ImpressoraDLL.INSTANCE.AvancaPapel(2);
                    ImpressoraDLL.INSTANCE.Corte(2);
                    break;

                case "6":
                    imprimeXMLSAT();
                    ImpressoraDLL.INSTANCE.Corte(5);
                    break;

                case "7":
                    ImprimeXMLCancelamentoSAT();
                    ImpressoraDLL.INSTANCE.Corte(5);
                    break;

                case "8":
                    if (!conexaoAberta) { System.out.println("Abra a conexão."); break; }
                    ImpressoraDLL.INSTANCE.AbreGavetaElgin();
                    break;

                case "9":
                    if (!conexaoAberta) { System.out.println("Conexão necessária."); break; }
                    ImpressoraDLL.INSTANCE.AbreGaveta(1, 5, 10);
                    break;

                case "10":
                    if (!conexaoAberta) { System.out.println("Conexão necessária."); break; }
                    ImpressoraDLL.INSTANCE.SinalSonoro(4, 5, 5);
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}