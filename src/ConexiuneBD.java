import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexiuneBD {
    public Connection connect() {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProiectPAO", "postgres", "admin");
            if(con == null)
                System.out.println("Conexiune esuata!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return con;
    }
    public void creeazaTabelCarti() {
        Connection con = connect();
        String createTableSQL = "CREATE TABLE IF NOT EXISTS CARTI (titlu VARCHAR(200), an_publicare INTEGER, nume_autor VARCHAR(200), zile_ramase INTEGER, disponibil BOOLEAN, gen_literar VARCHAR(200), editura VARCHAR(200), idCarte INTEGER, descriere VARCHAR(200))";
        try (PreparedStatement pstmt = con.prepareStatement(createTableSQL)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
        public void adaugaCarte(Carte c) {
            Connection con = connect();
            String insertTableSQL = "INSERT INTO CARTI (titlu, an_publicare, nume_autor, zile_ramase, disponibil, gen_literar, editura, idCarte, descriere) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(insertTableSQL)) {
                pstmt.setString(1, c.getTitlu());
                pstmt.setInt(2, c.getAn_publicare());
                pstmt.setString(3, c.getNume_autor());
                pstmt.setInt(4, c.getZile_ramase());
                pstmt.setBoolean(5, c.getDisponibil());
                pstmt.setString(6, c.getGen_literar());
                pstmt.setString(7, c.getEditura());
                pstmt.setInt(8, c.getIdCarte());
                pstmt.setString(9, c.getDescriere());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        public void afiseazaCartiDisponibile() {
            Connection con = connect();
            String selectSQL = "SELECT * FROM CARTI WHERE disponibil = true";
            try (PreparedStatement pstmt = con.prepareStatement(selectSQL)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    String titlu = rs.getString("titlu");
                    Integer an_publicare = rs.getInt("an_publicare");
                    String nume_autor = rs.getString("nume_autor");
                    Integer zile_ramase = rs.getInt("zile_ramase");
                    Boolean disponibil = rs.getBoolean("disponibil");
                    String gen_literar = rs.getString("gen_literar");
                    String editura = rs.getString("editura");
                    Integer idCarte = rs.getInt("idCarte");
                    String descriere = rs.getString("descriere");
                    System.out.println("Titlu: " + titlu + " An publicare: " + an_publicare + " Nume autor: " + nume_autor + " Zile ramase: " + zile_ramase + " Disponibil: " + disponibil + " Gen literar: " + gen_literar + " Editura: " + editura + " Id carte: " + idCarte + " Descriere: " + descriere);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        public void modificaCarte(Carte c) {
            Connection con = connect();
            String updateTableSQL = "UPDATE CARTI SET titlu = ?, an_publicare = ?, nume_autor = ?, zile_ramase = ?, disponibil = ?, gen_literar = ?, editura = ?, idCarte = ?, descriere = ? WHERE idCarte = ?";
            try (PreparedStatement pstmt = con.prepareStatement(updateTableSQL)) {
                pstmt.setString(1, c.getTitlu());
                pstmt.setInt(2, c.getAn_publicare());
                pstmt.setString(3, c.getNume_autor());
                pstmt.setInt(4, c.getZile_ramase());
                pstmt.setBoolean(5, c.getDisponibil());
                pstmt.setString(6, c.getGen_literar());
                pstmt.setString(7, c.getEditura());
                pstmt.setInt(8, c.getIdCarte());
                pstmt.setString(9, c.getDescriere());
                pstmt.setInt(10, c.getIdCarte());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
}
