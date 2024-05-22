
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PersonagemDAO personagemDAO = new PersonagemDAO();

        while (true) {
            System.out.println("1. Cadastrar personagem");
            System.out.println("2. Listar personagens");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Raça (Anão, Elfo, Meio_Elfo, Halfling, Humano, Draconato, Gnomo, Meio_Orc, Tiefling): ");
                    Raça raça = Raça.valueOf(scanner.nextLine());

                    System.out.print("Classe (Bárbaro, Bardo, Clérigo, Druida, Bruxo, Feiticeiro, Guardião, Guerreiro, Ladino, Mago, Monge): ");
                    Classe classe = Classe.valueOf(scanner.nextLine());

                    System.out.print("Antecedente: ");
                    String antecedente = scanner.nextLine();

                    System.out.print("Alinhamento (Ordeiro_Bom, Neutro_Bom, Caótico_Bom, Ordeiro_Neutro, Neutro, Caótico_Neutro, Ordeiro_Mau, Neutro_Mau, Caótico_Mau): ");
                    Alinhamento alinhamento = Alinhamento.valueOf(scanner.nextLine());

                    Personagem personagem = new Personagem(nome, raça, classe, antecedente, alinhamento);
                    personagemDAO.cadastrarPersonagem(personagem);
                    break;

                case 2:
                    List<Personagem> personagens = personagemDAO.listarPersonagens();
                    for (Personagem p : personagens) {
                        System.out.println("Nome: " + p.getNome());
                        System.out.println("Raça: " + p.getRaça());
                        System.out.println("Classe: " + p.getClasse());
                        System.out.println("Nível: " + p.getNivel());
                        System.out.println("Antecedente: " + p.getAntecendente());
                        System.out.println("Alinhamento: " + p.getAlinhamento());
                        System.out.println("Pontos de Experiência: " + p.getPontosExp());
                        System.out.println("--------------------------");
                    }
                    break;

                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
