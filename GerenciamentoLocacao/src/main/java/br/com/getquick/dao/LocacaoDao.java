package br.com.getquick.dao;

import java.sql.*;

public class LocacaoDao {

    private static final String INSERT_LOCACAO = "INSERT INTO RESERVA (dataInicio, dataFim, usuarioReserva) VALUES (?,?,?)";

    public boolean emailExiste(String usuario, String dataInicio, String dataFim) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LOCACAO)) {

            preparedStatement.setString(1, dataInicio);
            preparedStatement.setString(2, dataFim);
            preparedStatement.setString(3, usuario);

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

