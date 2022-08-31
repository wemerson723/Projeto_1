import java.util.ArrayList;
import java.util.Scanner;

class Usuarios{

    ArrayList<String> cargo;

    private int Get_cargo(){ return this.cargo; }

    private void Delete_cargo(){ this.cargo = null; }

    private void ADD_cargo(ArrayList<String> cargo){ this.cargo = cargo; }

    public Usuarios(){
        Scanner ler = new Scanner(System.in);
        this.cargo = ler.nextString();
    }
    public static void main(String args[]){

    }   
}

//      usuários: alunos de
//      graduação, mestrado e doutorado, professores, pesquisadores, profissionais
//      (desenvolvedor, testador e analista) e técnico.