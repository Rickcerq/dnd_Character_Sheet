import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonagemDAO {
    private Connection conexao;

    public PersonagemDAO() {
        this.conexao = Java.Conexao.GeraConexao();
    }

    public void cadastrarPersonagem(Personagem personagem) {
        String sql = "INSERT INTO Personagem (nome, raça, classe, nivel, antecedente, alinhamento, pontos_exp) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, personagem.getNome());
            pstmt.setString(2, personagem.getRaça().name());
            pstmt.setString(3, personagem.getClasse().name());
            pstmt.setInt(4, personagem.getNivel());
            pstmt.setString(5, personagem.getAntecendente());
            pstmt.setString(6, personagem.getAlinhamento().name());
            pstmt.setInt(7, personagem.getPontosExp());

            pstmt.executeUpdate();
            System.out.println("Personagem cadastrado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar personagem: " + e.getMessage());
        }
    }

    public List<Personagem> listarPersonagens() {
        List<Personagem> personagens = new ArrayList<>();
        String sql = "SELECT * FROM Personagem";

        try (PreparedStatement pstmt = conexao.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Personagem personagem = new Personagem(
                        rs.getString("nome"),
                        Raça.valueOf(rs.getString("raça")),
                        Classe.valueOf(rs.getString("classe")),
                        rs.getString("antecedente"),
                        Alinhamento.valueOf(rs.getString("alinhamento"))
                );
                personagem.setNivel(rs.getInt("nivel"));
                personagem.setPontosExp(rs.getInt("pontos_exp"));
                personagens.add(personagem);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar personagens: " + e.getMessage());
        }

        return personagens;
    }
}
