package br.com.getquick.dao;

import br.com.getquick.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    private static final String INSERT_SQL = "INSERT INTO PESSOA_LOGIN (NOME,EMAIL,GENERO,CELULAR,USUARIO,SENHA) VALUES (?,?,?,?,?,?)";
    private static final String SELECT_SQL = "SELECT * FROM PESSOA_LOGIN WHERE EMAIL = ? AND SENHA = ?";
    private static final String SELECT_ADMIN_SQL = "SELECT * FROM PESSOA_LOGIN WHERE EMAIL = ? AND SENHA = ? AND ADMINISTRADOR = 'Y'";
    private static final String EMAIL_CHECK_SQL = "SELECT COUNT(*) FROM PESSOA_LOGIN WHERE EMAIL = ?";
    private static final String USUARIO_CHECK_SQL = "SELECT COUNT(*) FROM PESSOA_LOGIN WHERE USUARIO = ?";
    private static final String CELULAR_CHECK_SQL = "SELECT COUNT(*) FROM PESSOA_LOGIN WHERE CELULAR = ?";
    private static final String AGENDAR_LOCACAO = "INSERT INTO RESERVA (DT_INICIO, DT_FIM) VALUES (?, ?) ";
    private static final String RELATORIO_LOCACAO = "SELECT * FROM RESERVA WHERE DT_INICIO LIKE '%?%'";

    private static final String USUARIO = "SELECT USUARIO FROM PESSOA_LOGIN WHERE EMAIL = ? AND SENHA = ?";

    public boolean emailExiste(String email) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
             PreparedStatement preparedStatement = connection.prepareStatement(EMAIL_CHECK_SQL)) {

            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return false;
    }

    public boolean usuarioExiste(String usuario) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
             PreparedStatement preparedStatement = connection.prepareStatement(USUARIO_CHECK_SQL)) {

            preparedStatement.setString(1, usuario);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return false;
    }

    public boolean celularExiste(String celular) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
             PreparedStatement preparedStatement = connection.prepareStatement(CELULAR_CHECK_SQL)) {

            preparedStatement.setString(1, celular);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return false;
    }

    public void criarUsuario(Usuario usuario) {
        if (emailExiste(usuario.getEmail())) {
            System.out.println("E-mail já está em uso. Não é possível cadastrar.");
            return;
        }

        if (usuarioExiste(usuario.getUsuario())) {
            System.out.println("Nome de usuário já está em uso. Não é possível cadastrar.");
            return;
        }

        if (celularExiste(usuario.getCelular())) {
            System.out.println("Número de celular já está em uso. Não é possível cadastrar.");
            return;
        }

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")) {
            System.out.println("Sucesso na conexão com o banco de dados");

            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
                preparedStatement.setString(1, usuario.getNome());
                preparedStatement.setString(2, usuario.getEmail());
                preparedStatement.setString(3, usuario.getGenero());
                preparedStatement.setString(4, usuario.getCelular());
                preparedStatement.setString(5, usuario.getUsuario());
                preparedStatement.setString(6, usuario.getSenha());
                preparedStatement.executeUpdate();

                System.out.println("Cadastro de usuário feito com sucesso");
            }
        } catch (SQLException e) {
            System.out.println("Falha na conexão com o banco de dados: " + e.getMessage());
        }
    }

    public boolean verificarCredenciais(Usuario usuario) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SQL)) {
                preparedStatement.setString(1, usuario.getEmail());
                preparedStatement.setString(2, usuario.getSenha());

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return verificaPrivilegioAdministrador(connection, usuario.getEmail(), usuario.getSenha());
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return false;
    }

    public String retornaUsuario(Usuario usuario){

        String usuario1 = "null";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(USUARIO)) {
                preparedStatement.setString(1, usuario.getEmail());
                preparedStatement.setString(2, usuario.getSenha());

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        usuario1 = String.valueOf(resultSet.next());
                        System.out.println(usuario1);
                        return usuario1;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return usuario1;
    }


    private boolean verificaPrivilegioAdministrador(Connection connection, String email, String senha) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADMIN_SQL)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("Usuário é administrador");
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println("Usuário é regular");
        return true;
    }

    private boolean realizarLocaco(Connection connection, String dtInicio, String dtFim){

        try (PreparedStatement preparedStatement = connection.prepareStatement(AGENDAR_LOCACAO)) {

            preparedStatement.setString(1, dtInicio);

            preparedStatement.setString(2, dtFim);


                    if(dtInicio == "" || dtFim == ""){

                            System.out.println("Data inici ou Data fim da locação não foi informada");
                        }




        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("Locação realizada com sucesso");

        return true;

    }

    private List<String> visualizarLocacoes(Connection connection, String dataLoc){

        try (PreparedStatement preparedStatement = connection.prepareStatement(RELATORIO_LOCACAO)) {

            preparedStatement.setString(1, dataLoc); //Parametro recebera o dia que o ADMINISTRADOR queira filtrar as locações

            if(dataLoc == ""){
                    System.out.println("Sem data informada");
                }




        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("Lista de relatório");

        List<String> listaReservas = new ArrayList<String>();

        listaReservas.add(RELATORIO_LOCACAO);

        System.out.println(listaReservas);

        //Precisa retornar uma lista


        return listaReservas;


    }


}
