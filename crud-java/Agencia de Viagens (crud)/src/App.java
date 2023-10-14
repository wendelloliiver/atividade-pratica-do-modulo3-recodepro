import java.util.Locale;

import views.Cliente;
import views.ClienteDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class App {

    public static Connection criarConexao() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/agencia_de_viagens";
        String usuario = "root";
        String senha = "12345678";
        Connection conexao = DriverManager.getConnection(url, usuario, senha);

        return conexao;
    }

    public static void fecharConexao(Connection conexao) throws SQLException {
        conexao.close();
    }

    public static void inserirCliente(Cliente cliente) throws SQLException {
        Connection conexao = criarConexao();

        String sql = "INSERT INTO cliente (nome, email, telefone) VALUES (?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getEmail());
        ps.setString(3, cliente.getTelefone());
        ps.executeUpdate();

        fecharConexao(conexao);
    }

    public static void alterarCliente(Cliente cliente) throws SQLException {
        Connection conexao = criarConexao();

        String sql = "UPDATE cliente SET nome = ?, email = ?, telefone = ? WHERE id = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getEmail());
        ps.setString(3, cliente.getTelefone());
        ps.setInt(4, cliente.getId());
        ps.executeUpdate();

        fecharConexao(conexao);
    }

    public static void excluirCliente(Cliente cliente) throws SQLException {
        Connection conexao = criarConexao();

        String sql = "DELETE FROM cliente WHERE id = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, cliente.getId());
        ps.executeUpdate();

        fecharConexao(conexao);
    }

    public static void listarClientes() throws SQLException {
        Connection conexao = criarConexao();

        String sql = "SELECT * FROM cliente";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String telefone = rs.getString("telefone");

            Cliente cliente = new Cliente(id, nome, email, telefone);
            System.out.println(cliente);
        }

        fecharConexao(conexao);
    }

    public static void imprimirMenu() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Menu");
        System.out.println("-----------------------------------------------------------");
        System.out.println("1 - Inserir");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Listar");
        System.out.println("5 - Sair");
        System.out.println("-----------------------------------------------------------");
    }

    public static int lerOpcao() {
        System.out.print("Digite a opção desejada: ");
        int opcao = Integer.parseInt(System.console().readLine());

        return opcao;
    }

    public static Cliente lerCliente() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Dados do cliente");
        System.out.println("-----------------------------------------------------------");

        System.out.println("Digite o id do cliente: ");
        int id = Integer.parseInt(System.console().readLine());

        System.out.print("Digite o nome do cliente: ");
        String nome = System.console().readLine();

        System.out.print("Digite o email do cliente: ");
        String email = System.console().readLine();

        System.out.print("Digite o telefone do cliente: ");
        String telefone = System.console().readLine();

        Cliente cliente = new Cliente(id, nome, email, telefone);

        return cliente;
    }

    public static void imprimirCliente(Cliente cliente) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Dados do cliente");
        System.out.println("-----------------------------------------------------------");

        System.out.println("Id: " + cliente.getId());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Telefone: " + cliente.getTelefone());
    }

    public static void imprimirCabecalho() {
        System.out.println("-----------------------------------------------------------");
        System.out.println(
                "Programa iniciado: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println("------------------- Agencia de viagens --------------------");
    }

    public static void imprimirRodape() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Programa finalizado: "
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println("-----------------------------------------------------------");
    }

    public static void imprimirErro(String mensagem) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Erro: " + mensagem);
        System.out.println("-----------------------------------------------------------");
    }

    public static void imprimirSucesso(String mensagem) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Sucesso: " + mensagem);
        System.out.println("-----------------------------------------------------------");
    }

    public static void imprimirConfirmacao(String mensagem) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Confirmação: " + mensagem);
        System.out.println("-----------------------------------------------------------");
    }

    public static void imprimirDespedida() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Obrigado por utilizar o programa!");
        System.out.println("-----------------------------------------------------------");
    }

    public static void imprimirBoasVindas() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Bem vindo ao programa!");
        System.out.println("-----------------------------------------------------------");
    }

    public static void imprimirOpcaoInvalida() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Opção inválida!");
        System.out.println("-----------------------------------------------------------");
    }

    public static void menu() throws SQLException {
        int opcao = 0;

        do {
            imprimirMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    Cliente cliente = lerCliente();
                    inserirCliente(cliente);
                    imprimirSucesso("Cliente inserido com sucesso!");
                    break;
                case 2:
                    cliente = lerCliente();
                    alterarCliente(cliente);
                    imprimirSucesso("Cliente alterado com sucesso!");
                    break;
                case 3:
                    cliente = lerCliente();
                    excluirCliente(cliente);
                    imprimirSucesso("Cliente excluído com sucesso!");
                    break;
                case 4:
                    listarClientes();
                    break;
                case 5:
                    imprimirDespedida();
                    break;
                default:
                    imprimirOpcaoInvalida();
                    break;
            }
        } while (opcao != 5);
    }

    public static void main(String[] args) throws Exception {
        LocalDateTime dataHora = LocalDateTime.now();
        Locale.setDefault(new Locale("pt", "BR"));

        System.out.println("-----------------------------------------------------------");
        System.out.println(
                "Programa iniciado: " + dataHora.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println("------------------- Agencia de viagens --------------------");

        try (ClienteDAO clienteDAO = new ClienteDAO()) {
            Cliente cliente = clienteDAO.buscarClientePorId(1);
            System.out.println(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
