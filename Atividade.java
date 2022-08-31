import java.util.ArrayList;
import java.util.Scanner;

class Atividade{

    int identificacao;
    String descricao;
    Data data_inicio;
    Data data_termino;
    Usuarios responsavel;
    ArrayList<Usuarios> usuarios_ativos;
    ArrayList<String> tarefas;

    private int Get_identificacao(){ return this.identificacao; }
    private int Get_descricao(){ return this.descricao; }
    private int Get_data_inicio(){ return this.data_inicio; } 
    private int Get_data_termino(){ return this.data_termino; }
    private int Get_responsavel(){ return this.responsavel; }
    private int Get_usuarios_ativos(){ return this.usuarios_ativos; }
    private int Get_tarefas(){ return this.tarefas; }

    private void ADD_identificacao(int identificacao){ this.identificacao = identificacao; }
    private void ADD_descricao(String descricao){ this.descricao = descricao; }
    private void ADD_data_inicio(Data data_inicio){ this.data_inicio = data_inicio; } 
    private void ADD_data_termino(Data data_termino){ this.data_termino = data_termino; }
    private void ADD_responsavel(Usuarios responsavel){ this.responsavel = responsavel; }
    private void ADD_usuarios_ativos(ArrayList<Usuarios> usuarios_ativos){ this.usuarios_ativos = usuarios_ativos; }
    private void ADD_tarefas(ArrayList<String> tarefas){ this.tarefas = tarefas; }

    private void Delete_identificacao(int identificacao){ this.identificacao = null; }
    private void Delete_descricao(String descricao){ this.descricao = null; }
    private void Delete_data_inicio(Data data_inicio){ this.data_inicio = null; } 
    private void Delete_data_termino(Data data_termino){ this.data_termino = null; }
    private void Delete_responsavel(Usuarios responsavel){ this.responsavel = null; }
    private void Delete_usuarios_ativos(ArrayList<Usuarios> usuarios_ativos){ this.usuarios_ativos = null; }
    private void Delete_tarefas(ArrayList<String> tarefas){ this.tarefas = null; }

    public Atividade(){
        Scanner ler = new Scanner(System.in);
        this.identificacao = ler.nextInt();
        this.descricao = ler.nextString();
        this.data_inicio = new Data();
        this.data_termino = new Data();
        this.responsavel = new Usuarios();
        this.tarefas = new ArrayList<String>();
    }
    public static void main(String args[]){

    } 
}

//    public Atividade(int identificacao, ArrayList<String> descricao, Data data_inicio, Data data_termino, Usuarios responsavel, ArrayList<Usuarios> usuarios_ativos, ArrayList<String> tarefas){
