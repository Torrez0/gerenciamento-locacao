package br.com.getquick.dao;

import br.com.getquick.model.Usuario;

import java.sql.*;

public class LocacaoDao {

    private static final String INSERT_LOCACAO = "INSERT INTO RESERVA (dataInicio, dataFim, nomeLocavel, usuarioReserva) VALUES (?,?,?,?)";

    public boolean locacao(String nomeLocavel, String dataInicio, String dataFim, String usuario) {

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LOCACAO)) {

            preparedStatement.setString(1, nomeLocavel);
            preparedStatement.setString(2, dataInicio);
            preparedStatement.setString(3, dataFim);
            preparedStatement.setString(4, usuario);

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


}

