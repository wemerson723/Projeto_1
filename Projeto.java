import java.util.ArrayList;
import java.util.Scanner;

class Projeto {  
        private String status;
        private int identificacao;
        private String descricao;
        private Usuarios cordenador; 
        private ArrayList<Usuarios> usuarios_ativos;
        private ArrayList<Atividade> atividades;
        private double valor_bolsa;
        private int periodo_vigencia;
        private Data data_inicio; 
        private Data data_termino;



        public String               Get_status(){               return status;                 }
        public int                  Get_identificacao(){        return identificacao;          }
        public String               Get_descricao(){            return descricao;              }
        public Usuarios             Get_cordenador(){           return cordenador;             } 
        public ArrayList<Usuarios>  Get_usuarios_ativos(){      return usuarios_ativos;        }
        public Atividade            Get_atividade(int index){   return atividades.get(index);  }
        public ArrayList<Atividade> Get_atividades(){           return atividades;             }
        public double               Get_valor_bolsa(){          return valor_bolsa;            }
        public int                  Get_periodo_vigencia(){    return periodo_vigencia;        }
        public Data                 Get_data_inicio(){          return data_inicio;            }
        public Data                 Get_data_termino(){         return data_termino;           } 



        public void Edit                  (String status) {                       this.status = status;                      }
        public void Edit                  (int identificacao){                    this.identificacao = identificacao;        }
        public void Edit_descricao        (String descricao){                     this.descricao = descricao;                }
        public void Edit                  (Usuarios cordenador){                  this.cordenador = cordenador;              }
        public void Edit                  (ArrayList<Usuarios> usuarios_ativos){  this.usuarios_ativos.add(new Usuarios());  }
        public void Edit_valor_bolsa      (double valor_bolsa){                   this.valor_bolsa = valor_bolsa;            }
        public void Edit_periodo_vigencia (int periodo_vigencia){                  this.periodo_vigencia = periodo_vigencia; }
        public void Edit_data_inicio      (){                                     this.data_inicio.Edit();                   }
        public void Edit_data_termino     (){                                     this.data_termino.Edit();                  }



        //public void Delete_identificacao(){     this.identificacao = 0;                          }
        public void Delete_descricao(){         this.descricao = "";                             }
        public void Delete_cordenador(){        this.cordenador = new Usuarios();                }
        public void Delete_usuarios_ativos(){   this.usuarios_ativos = new ArrayList<Usuarios>();}
        public void Delete_atividades(){        this.atividades = new ArrayList<Atividade>();    }
        public void Delete_valor_bolsa(){       this.valor_bolsa = 0;                            }
        public void Delete_periodo_vigencia(){ this.periodo_vigencia = 0;                        }
        public void Delete_data_inicio(){       this.data_inicio = new Data();                   }
        public void Delete_data_termino(){      this.data_termino = new Data();                  }


        public int Check_Usuario(String nome){
            for (int i = 0; i < this.usuarios_ativos.size(); i++){
                if(this.usuarios_ativos.get(i).Get_nome() == nome){
                    return i;
                }
            }
            return -1;
        }
        public void ADD_atividade   ()         {     this.atividades.add(new Atividade()) ;    }
        public void Rem_atividade   (int index){     this.atividades.remove(index) ;           }

        public void consulta(){

            System.out.println("Status: "+this.status+".\n");
            System.out.println("Identificação: "+this.identificacao+".\n");
            System.out.println("Descrição: "+this.descricao+".\n");
            System.out.println("Cordenador: "+this.cordenador.Get_nome()+".\n");
            System.out.println("Usuários ativos:\n");
            for (int i = 0; i < this.usuarios_ativos.size(); i++) { this.usuarios_ativos.get(i).consulta(); }
            System.out.println("Atividades:\n");
            for (int i = 0; i < this.atividades.size(); i++) {
                this.atividades.get(i).consulta();
            }
            System.out.println("Bolsa: "+this.valor_bolsa+" Reais.\n");
            System.out.println("Período de vigência: "+this.periodo_vigencia+" Dias.\n");
            System.out.println("Data de início: ");
            this.data_inicio.consulta();
            System.out.println("Data de termino: ");
            this.data_termino.consulta();
        }
        
        public int Check_atividade(int id){
            for (int i = 0; i < atividades.size(); i++){
                if(atividades.get(i).Get_identificacao() == id){
                    return i;
                }
            }
            return -1;
        }

        public void Editar_projeto(){
            Scanner ler = new Scanner(System.in);
    
            System.out.println("Digite a Opção:\n1: Alterar status.\n2: Editar identificação.\n3: Editar descrição.\n4: Editar coordenador.\n5: Editar atividades.\n6: Editar valor da bolsa.\n7: Editar periodo de vigência.\n8: Editar data de início.\n9: Editar data de termino.\n");            
                
            switch (ler.nextInt()) {
                case 1:
                    if (this.status == "Em processo de criação") {
                        this.status = "Iniciado";
                        System.out.println("O Projeto está agora iniciado.\n");
                    }
                    else if (this.status == "Iniciado"){
                        this.status = "em andamento";
                        System.out.println("O Projeto está agora em andamento.");
                    }
                    else if (this.status == "em andamento"){
                        this.status = "Concluído";
                        System.out.println("O Projeto está agora concluído.");
                    }
                    else if (this.status == "Concluído"){
                        System.out.println("O projeto já foi concluído.\n");
                    }
                    else { System.out.println("ERRO: Anomalia no Status\n"); }
                break;        
                case 2:
                    System.out.println("Digite a nova identificação do Projeto:\n");
                    this.identificacao = ler.nextInt();
                break;
                case 3:
                    System.out.println("Digite a nova descrição do Projeto:\n");
                    this.descricao = ler.nextLine();
                break;
                case 4:
                    System.out.println("Digite o nome do novo cordenador do projeto:\n");
                    int _id_ =  Check_Usuario(ler.nextLine());
                    if (_id_ != -1){
                        if((this.usuarios_ativos.get(_id_).Get_cargo() == "professor") || this.usuarios_ativos.get(_id_).Get_cargo() == "pesquisador"){
                            this.cordenador = this.usuarios_ativos.get(_id_);
                        }
                        else { System.out.println("ERRO: Esse usuário não tem poder para ser um cordenador.\n"); }
                    }
                    else{ System.out.println("ERRO: Esse usuário não está no projeto.\n"); }
                break;
                case 5:
                    System.out.println("Digite a identificação da atividade\n");
                    int id_0 = Check_atividade(ler.nextInt());
                    if (id_0 != -1) { this.atividades.get(id_0).editar_atividade(this.usuarios_ativos); }
                    else{ System.out.println("ERRO: Atividade não encontrada.");  }
                break;
                case 6:
                    System.out.println("Digite o novo valor da bolsa.\n");
                    this.valor_bolsa = ler.nextDouble(); 
                break;
                case 7:        
                    System.out.println("Digite o novo período vigência.\n");
                    this.periodo_vigencia = ler.nextInt();
                break;
                case 8:
                    System.out.println("Digite os dados da nova Data de ínicio.");
                    this.data_inicio.Edit();
                break;
                case 9:
                    System.out.println("Digite os dados da nova Data de termino.");
                    this.data_termino.Edit();
                default:
                    System.out.println("ERRO: Opção inválida.");
                break;
            }  
        }
        public boolean Check(){
            if((this.status == "Em processo de criação.") && 
               //(this.identificacao != -1)     &&
               (this.descricao != "null")     &&
               (this.atividades.size() != 0)  &&
               (this.valor_bolsa != -1)       &&
               (this.periodo_vigencia != -1) &&
               (this.data_inicio.check())     &&
               (this.data_termino.check()) ){
                return false;
            }
            return true;
        }            
        public Projeto(Usuarios cordenador){
            Scanner ler = new Scanner(System.in);

            this.status = "Em processo de criação.";
            System.out.println("Digite uma identificação para o projeto.");
            this.identificacao = ler.nextInt();
            this.descricao = "null";
            this.cordenador = cordenador;
            this.atividades = new ArrayList<Atividade>();
            this.valor_bolsa = -1;
            this.periodo_vigencia = -1;
            this.data_inicio = new Data();
            this.data_termino = new Data();
        }
    }  
