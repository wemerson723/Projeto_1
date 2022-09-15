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
        public int                  Get_periodo_vigencia(){    return periodo_vigencia;      }
        public Data                 Get_data_inicio(){          return data_inicio;            }
        public Data                 Get_data_termino(){         return data_termino;           } 



        public void Edit_status           (String status) {                       this.status = status;                      }
        public void Edit_identificacao    (int identificacao){                    this.identificacao = identificacao;        }
        public void Edit_descricao        (String descricao){                     this.descricao = descricao;                }
        public void Edit_cordenador       (Usuarios cordenador){                 this.cordenador = cordenador;               }
        public void Edit_usuarios_ativos  (ArrayList<Usuarios> usuarios_ativos){  this.usuarios_ativos.add(new Usuarios());  }
        public void Edit_valor_bolsa      (double valor_bolsa){                   this.valor_bolsa = valor_bolsa;            }
        public void Edit_periodo_vigencia(int periodo_vigencia){                this.periodo_vigencia = periodo_vigencia;}
        public void Edit_data_inicio      (){                                     this.data_inicio.Edit();                   }
        public void Edit_data_termino     (){                                     this.data_termino.Edit();                  }



        //public void Delete_identificacao(){     this.identificacao = 0;                          }
        public void Delete_descricao(){         this.descricao = "";                             }
        public void Delete_cordenador(){        this.cordenador = new Usuarios();                }
        public void Delete_usuarios_ativos(){   this.usuarios_ativos = new ArrayList<Usuarios>();}
        public void Delete_atividades(){        this.atividades = new ArrayList<Atividade>();    }
        public void Delete_valor_bolsa(){       this.valor_bolsa = 0;                            }
        public void Delete_periodo_vigencia(){ this.periodo_vigencia = 0;                      }
        public void Delete_data_inicio(){       this.data_inicio = new Data();                   }
        public void Delete_data_termino(){      this.data_termino = new Data();                  }



        public void ADD_atividade   ()         {     this.atividades.add(new Atividade()) ;    }
        public void Rem_atividade   (int index){     this.atividades.remove(index) ;           }


        public int Check_atividade(int id){
            for (int i = 0; i < atividades.size(); i++){
                if(atividades.get(i).Get_identificacao() == id){
                    return i;
                }
            }
            return -1;
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
