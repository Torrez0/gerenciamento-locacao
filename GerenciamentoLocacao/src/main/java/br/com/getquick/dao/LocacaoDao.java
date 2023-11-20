package br.com.getquick.dao;

import br.com.getquick.model.Locacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocacaoDao {

    private static final String INSERT_LOCACAO = "INSERT INTO RESERVA (DT_INICIO, DT_FIM, NOME_LOCAVEL, USUARIO) VALUES (?,?,?,?)";

    public void fazerLocacao(Locacao locacao) {

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")) {
            System.out.println("Sucesso na conexão com o banco de dados");

            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LOCACAO)) {
                preparedStatement.setString(1, locacao.getDataLocacaoIni());
                preparedStatement.setString(2, locacao.getDataLocacaoFim());
                preparedStatement.setString(3, locacao.getNomeQuadra());
                preparedStatement.setString(4, locacao.getUsuario());
                preparedStatement.executeUpdate();

                System.out.println("Locacao feita com sucesso");
            }
        } catch (SQLException e) {
            System.out.println("Falha na conexão com o banco de dados: " + e.getMessage());
        }

    }

    public int idLocavel() {
        //Essa classe precisa pegar o id da quadra selecionada para fazer uma consulta no banco;

        return 1; //RETORNA O ID DA QUADRA
    }

    public List<Locacao> listarLocacoes(String usuario) {
        String listarLocacao = "SELECT * FROM RESERVA WHERE USUARIO = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")) {
            System.out.println("success in database connection");

            try (PreparedStatement preparedStatement = connection.prepareStatement(listarLocacao)) {
                preparedStatement.setString(1, usuario);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    List<Locacao> locacoes = new ArrayList<>();

                    while (resultSet.next()) {
                        String idLocacao = resultSet.getString("ID_RESERVA");
                        String nomeLocavel = resultSet.getString("NOME_LOCAVEL");
                        String dataLocacaoIni = resultSet.getString("DT_INICIO");
                        String dataLocacaoFim = resultSet.getString("DT_FIM");
                        String usuarioReserva = resultSet.getString("USUARIO");

                        Locacao locacao = new Locacao(idLocacao, nomeLocavel, dataLocacaoIni, dataLocacaoFim, usuarioReserva, "");
                        locacoes.add(locacao);
                    }

                    System.out.println("success in select * car");

                    return locacoes;
                }
            }
        } catch (SQLException e) {
            System.out.println("fail in database connection: " + e.getMessage());
            return Collections.emptyList();
        }


    }


    public void deleteLocacao(String idLocacao) {

        String SQL = "DELETE RESERVA WHERE ID = ?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, idLocacao);
            preparedStatement.execute();

            System.out.println("success on delete car with id: " + idLocacao);

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }

    }

    public List<Locacao> listarLocacoesRelatorio() {
        String listarLocacao = "SELECT ID_RESERVA,  NOME_LOCAVEL, FORMATDATETIME(DT_INICIO, 'dd/MM/YYYY HH:mm') AS \"DATA INÍCIO\", FORMATDATETIME(DT_FIM, 'dd/MM/YYYY HH:mm') AS \"DATA FIM\", USUARIO FROM RESERVA";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")) {
            System.out.println("success in database connection");

            try (PreparedStatement preparedStatement = connection.prepareStatement(listarLocacao)) {

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    List<Locacao> locacoesAdmin = new ArrayList<>();

                    while (resultSet.next()) {
                        String idLocacao = resultSet.getString("ID_RESERVA");
                        String nomeLocavel = resultSet.getString("NOME_LOCAVEL");
                        String dataLocacaoIni = resultSet.getString("DATA INÍCIO");
                        String dataLocacaoFim = resultSet.getString("DATA FIM");
                        String usuarioReserva = resultSet.getString("USUARIO");

                        Locacao locacao = new Locacao(idLocacao, nomeLocavel, dataLocacaoIni, dataLocacaoFim, usuarioReserva, "");
                        locacoesAdmin.add(locacao);
                    }

                    //System.out.println("success in select * car");

                    return locacoesAdmin;
                }
            }
        } catch (SQLException e) {
            System.out.println("fail in database connection: " + e.getMessage());
            return Collections.emptyList();
        }

    }

    public boolean updateLocacao(int idLocacao){

        String UPDATE_LOCACAO = "UPDATE RESERVA SET NOME_LOCAVEL = ?, DT_INICIO = ?, DT_FIM = ? WHERE ID_RESERVA = ?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LOCACAO);
            //Aqui precisa colocar as alterações realizadas\\
            preparedStatement.setInt(4, idLocacao);
            preparedStatement.execute();

            System.out.println("success on alter locacao with id: " + idLocacao);

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }

        return true;
    }

}

