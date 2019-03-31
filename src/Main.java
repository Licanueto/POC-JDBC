import java.sql.*;

public class Main {

    // Nombre del driver JDBC y la URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3307/basket";

    // Credenciales
    static final String USER = "root";
    static final String PASS = "1234";

    public static void main(String[] args){
        Connection conn = null;
        Statement stmt = null;
        try{
            // Registrar el driver
            //Class.forName("com.mysql.jdbc.driver");
            Class.forName(JDBC_DRIVER);

            // Abrir la conección
            System.out.println("Connecting to database..");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // Ejecuta la query
            System.out.println("Creando statement..");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM jugadores";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs.toString());


        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }


}

