import java.util.ArrayList;
import java.util.Scanner;
//import java.util.Data;
//import java.text.SimpleDateFormat;

class Projeto {  
        private String status;
        private int identificacao;
        private String descricao;
        private Usuarios coordenador; 
        private ArrayList<Usuarios> usuarios_ativos;
        private ArrayList<String> atividades;
        private double valor_bolsa;
        private int periodo_virgencia;
        private Data data_inicio; 
        private Data data_termino;

        private void Get_status(){
            if((this.identificacao==null) && (this.descricao==null) && (this.coordenador)&& (this.usuarios_ativos)&& (this.atividades)&& (this.valor_bolsa)&& (this.periodo_virgencia)&& (this.data_inicio)&& (this.data_termino)){
                this.status = 'Iniciado';
            }
            else{ this.status = 'Em processo de criação'; }
        }

        private int Get_identificacao(){ return this.identificacao; }
        private int Get_descricao(){ return this.descricao; }
        private int Get_coordenador(){ return this.descricao; } 
        private int Get_usuarios_ativos(){ return this.usuarios_ativos; }
        private int Get_atividades(){ return this.atividades; }
        private int Get_valor_bolsa(){ return this.valor_bolsa; }
        private int Get_periodo_virgencia(){ return this.periodo_virgencia; }
        private int Get_data_inicio(){ return this.data_inicio; }
        private int Get_data_termino(){ return this.data_termino; } 
        
        private int ADD_identificacao(int identificacao){  
            this.identificacao = identificacao;}
        private int ADD_descricao(String descricao){       
            this.identificacao = identificacao;}
        private int ADD_coordenador(Usuarios coordenador){ 
            this.coordenador = coordenador;}
        private int ADD_usuarios_ativos(ArrayList<Usuarios> usuarios_ativos){            
            this.usuarios_ativos.add(new Usuarios());}
        private int ADD_atividades(ArrayList<String> atividades){
            this.atividades = atividades;}
        private int ADD_valor_bolsa(double valor_bolsa){            
            this.valor_bolsa = valor_bolsa;}
        private int ADD_periodo_virgencia(int periodo_virgencia){            
            this.periodo_virgencia = periodo_virgencia;}
        private int ADD_data_inicio(Data data_inicio){  
            this.data_inicio = data_inicio; }
        private int ADD_data_termino(Data data_termino){ 
            this.data_termino = data_termino; }

        private int Delete_identificacao(){  
            this.identificacao = identificacao;}
        private int Delete_descricao(){       
            this.identificacao = identificacao;}
        private int Delete_coordenador(){ 
            this.coordenador = coordenador;}
        private int Delete_usuarios_ativos(){            
            this.usuarios_ativos = usuarios_ativos;}
        private int Delete_atividades(){
            this.atividades = atividades;}
        private int Delete_valor_bolsa(){            
            this.valor_bolsa = valor_bolsa;}
        private int Delete_periodo_virgencia(){            
            this.periodo_virgencia = periodo_virgencia;}
        private int Delete_data_inicio(){  
            this.data_inicio = data_inicio; }
        private int Delete_data_termino(){ 
            this.data_termino = data_termino; }
            
        public Projeto(){
            Scanner ler = new Scanner(System.in);
            this.identificacao = ler.nextInt();
            this.descricao = ler.nextString();
            this.coordenador = new Usuarios();
            this.atividades = new atividade();
            this.valor_bolsa = ler.nextDouble();
            this.periodo_virgencia = ler.nextInt();
            this.data_inicio = new Data();
            this.data_termino = new Data();
        }
       public static void main(String args[]) {  
              
       }
    }  

     //  public Projeto(int identificacao, String descricao[], Usuarios coordenador, ArrayList<Usuarios> usuarios_ativos, ArrayList<String> atividades, double valor_bolsa, int periodo_virgencia, Data data_inicio, Data data_termino{
