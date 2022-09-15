import java.util.ArrayList;
import java.util.Scanner;

class Atividade{

    private int identificacao;
    private String descricao;
    private Data data_inicio;
    private Data data_termino;
    private Usuarios responsavel;
    private ArrayList<Usuarios> usuarios_ativos;
    private ArrayList<String> tarefas;



    public int Get_identificacao()                   { return identificacao;    }
    public String Get_descricao()                    { return descricao;        }
    public Data Get_data_inicio()                    { return data_inicio;      } 
    public Data Get_data_termino()                   { return data_termino;     }
    public Usuarios Get_responsavel()                { return responsavel;      }
    public ArrayList<Usuarios> Get_usuarios_ativos() { return usuarios_ativos;  }
    public ArrayList<String> Get_tarefas()           { return tarefas;          }



    public void Edit_identificacao  (int identificacao)                  { this.identificacao = identificacao;    }
    public void Edit_descricao      (String descricao)                   { this.descricao = descricao;            }
    public void Edit_data_inicio    (Data data_inicio)                   { this.data_inicio = data_inicio;        } 
    public void Edit_data_termino   (Data data_termino)                  { this.data_termino = data_termino;      }
    public void Edit_responsavel    (Usuarios responsavel)               { this.responsavel = responsavel;        }
    public void Edit_usuarios_ativos(ArrayList<Usuarios> usuarios_ativos){ this.usuarios_ativos = usuarios_ativos;}
    public void Edit_tarefas        (ArrayList<String> tarefas)          { this.tarefas = tarefas;                }



    public void Delete_identificacao    (){ identificacao = 0;      }
    public void Delete_descricao        (){ descricao = null;       }
    public void Delete_data_inicio      (){ data_inicio = null;     } 
    public void Delete_data_termino     (){ data_termino = null;    }
    public void Delete_responsavel      (){ responsavel = null;     }
    public void Delete_usuarios_ativos  (){ usuarios_ativos = null; }
    public void Delete_tarefas          (){ tarefas = null;         }

    public void ADD_Usuario(Usuarios usuario){ this.usuarios_ativos.add(usuario); }
    public void Rem_Usuario(int index)      { this.usuarios_ativos.remove(index);}

    public int Check_Usuario(String nome){
        for (int i = 0; i < usuarios_ativos.size(); i++){
            if(usuarios_ativos.get(i).Get_nome().intern() == nome.intern()){
                return i;
            }
        }
        return -1;
    }

    public int Check_tarefa(String tarefa){
        for (int i = 0; i < this.tarefas.size(); i++){
            if(this.tarefas.get(i).intern() == tarefa.intern()){
                return i;
            }
        }
        return -1;
    }
    public Atividade(){
        identificacao = -1;
        descricao = "null";
        data_inicio = new Data();
        data_termino = new Data();
        responsavel = new Usuarios();
        tarefas = new ArrayList<String>();
    }
}
