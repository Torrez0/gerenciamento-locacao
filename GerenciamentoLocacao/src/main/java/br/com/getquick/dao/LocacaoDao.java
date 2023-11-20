package br.com.getquick.dao;

import br.com.getquick.model.Locacao;
import br.com.getquick.model.Usuario;

import java.sql.*;

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

    public int idLocavel(){
        //Essa classe precisa pegar o id da quadra selecionada para fazer uma consulta no banco;

        return 1; //RETORNA O ID DA QUADRA
    }


}

