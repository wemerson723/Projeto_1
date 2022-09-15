import java.util.ArrayList;
import java.util.Scanner;

class Usuarios{

    private String cargo;
    private String nome;
    private String senha;
    private String descricao_chave;
    private String chave;

    public String Get_cargo(){ return cargo; }
    public String Get_nome (){ return nome;  }

    public void Delete_cargo(){ this.cargo = "null"; }
    public void Delete_nome (){ this.cargo = "null"; }

    public void Edit_cargo(String cargo){ this.cargo = cargo; }
    public void Edit_nome (String nome) { this.cargo = nome;  }

    public void recuperar(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Descrição de palavra Chave: "+this.descricao_chave+"\nDigite a chave.");
        String chave = ler.nextLine();
        if (chave.intern() == this.chave.intern()) {
            System.out.println(this.senha);
        }
        else{
            System.out.println("ERRO: Chava errada.");
        }
    }

    public boolean login(String senha){
        if (senha.intern() == this.senha.intern()) {
            return true;
        }
        else{
            return false;
        }
    }

    public Usuarios(){
        Scanner ler = new Scanner(System.in);

        System.out.println("Digite o Cargo do Usuário:");
        this.cargo = ler.nextLine();

        System.out.println("Digite o nome do Usuário:");
        this.nome = ler.nextLine();

        boolean aux = true;
        while (aux) {
            System.out.println("Digite sua senha:");
            String senha = ler.nextLine();

            System.out.println("Digite confirme sua senha:");
            if (senha.intern() != ler.nextLine().intern()) {
                System.out.println("ERRO: Tente novamente.");
            }
            else{
                aux = false;
            }
        }
        System.out.println("Digite uma descrição de palavra Chave:");
        this.descricao_chave = ler.nextLine();
        System.out.println("Digite uma palavra Chave:");
        this.chave = ler.nextLine();
    }  
}
