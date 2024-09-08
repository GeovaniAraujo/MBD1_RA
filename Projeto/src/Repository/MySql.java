package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class MySql {
    private static Connection connection;

    public static Connection getConnection(){
        try{                                                                //Tenta executar mesmo com a possibilidade de erro
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/game",
                            "root",
                            ""
            );
            return connection;
        } catch (SQLException e){                                           //Caso tenha uma exeção
            System.out.println("Erro ao tentar conectar com o banco.");
        }catch (ClassNotFoundException e) {
            System.out.println("Erro ao tentar importar o driver MySql.");
        }
        return null;
    }
}
