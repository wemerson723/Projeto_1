import java.util.ArrayList;
//import java.util.Data;
//import java.text.SimpleDateFormat;

class Projetos {  

    ArrayList<Projeto> Projetos;

        private Get_projeto(int index){
            return this.Projetos.get(index);
        }
        private ADD_projeto(){
            this.Projetos.add(new Projeto());
        }
        public Projetos(){
            this.Projetos = new ArrayList<Projeto>;
            
        }
       public static void main(String args[]) {  
       }
    }  

     //  public Projeto(int identificação, String descrição[], Usuarios coordenador, ArrayList<Usuarios> usuarios_ativos, ArrayList<String> atividades, double valor_bolsa, int periodo_virgencia, Data data_inicio, Data data_termino{
