import java.util.ArrayList;
import java.util.Scanner;

//import java.util.Data;
//import java.text.SimpleDateFormat;

class Gerencia {  

    private ArrayList<Projeto> Projetos;
    private ArrayList<Usuarios> Usuarios;



    public Projeto  Get_projeto(int index){ return Projetos.get(index);  }
    public Usuarios Get_Usuario(int index){ return Usuarios.get(index);  }



    public int Check_Usuario(String nome){
        for (int i = 0; i < Usuarios.size(); i++){
            if(Usuarios.get(i).Get_nome().intern() == nome.intern()){
                return i;
            }
        }
        return -1;
    }
    public int Check_Projeto(int id){
        for (int i = 0; i < Projetos.size(); i++){
            if(this.Projetos.get(i).Get_identificacao() == id){
                return i;
            }
        }
        return -1;
    }



    public void Editar_projeto(){
        System.out.println("Digite a identificação do projeto:");
        Scanner ler = new Scanner(System.in);

        int identificacao = ler.nextInt();
        int id = Check_Projeto(identificacao);

        if (id != -1){
            System.out.println("Digite a Opção:\n 1: Editar status.\n 2: Editar identificação.\n 3: Editar descrição.\n 4: Editar coordenador.\n 5: Editar atividades.\n 6: Editar valor da bolsa.\n 7: Editar periodo de vigência.\n 8: Editar data de início.\n 9: Editar data de termino.");            
            switch (ler.nextInt()) {
                case 1:
                    System.out.println("Digite a Opção: \n 1: Iniciar projeto.\n 2: Confirmar início de projeto.");
                    switch (ler.nextInt()) {
                        case 1:
                            if (this.Projetos.get(identificacao).Check()) {
                                this.Projetos.get(identificacao).Edit_status("Iniciado");
                            }
                            else {
                                System.out.println("ERRO: O projeto consta campos a serem preenchidos.");
                            }
                            break;
                        case 2:
                            if (this.Projetos.get(identificacao).Get_status() == "Iniciado") {
                                this.Projetos.get(identificacao).Edit_status("Em andamento");
                            }
                            else{
                                System.out.println("ERRO: O projeto não foi iniciado.");
                            }
                            break;
                        default:
                            System.out.println("ERRO: Opção invalida.");
                            break;
                    }
                    break;        
                case 2:
                    System.out.println("Digite a Opção: \n 1: Editar informação.");
                    switch (ler.nextInt()) {
                        case 1:
                            System.out.println("Digite a identificação do Projeto:");
                            this.Projetos.get(identificacao).Edit_identificacao(ler.nextInt());
                            break;
                        /* case 2:
                            this.Projetos.get(identificacao).Delete_identificacao();
                            break;
                        */
                        default:
                            System.out.println("ERRO: Opção invalida.");
                            break;}
                    break;
                case 3:
                    System.out.println("Digite a Opção: \n 1: Editar informação.\n 2: Deletar informação.");
                    switch (ler.nextInt()) {
                        case 1:
                            System.out.println("Digite a descrição do Projeto:");
                            this.Projetos.get(identificacao).Edit_descricao(ler.nextLine());
                            break;
                        case 2:
                            this.Projetos.get(identificacao).Delete_descricao();
                            break;
                    
                        default:
                            System.out.println("ERRO: Opção invalida.");
                            break;}
                    break;
                case 4:
                    System.out.println("Digite o nome do cordenador do projeto:");
                    String nome = ler.nextLine();
                    int _id_ = Check_Usuario(nome);
                    if (_id_ != -1){
                        Usuarios cordenador = Get_Usuario(_id_);
                        if((cordenador.Get_cargo() == "professor") || cordenador.Get_cargo() == "pesquisador"){
                            this.Projetos.get(identificacao).Edit_cordenador(cordenador);
                        }
                        else {
                            System.out.println("ERRO: Esse usuário não tem poder para ser um cordenador.");
                        }
                    }
                    else{
                        System.out.println("ERRO: Usuário não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Digite a Opção: \n 1: Edicionar atividade.\n 2: Remover atividade.");
                    switch (ler.nextInt()) {
                        case 1:
                            this.Projetos.get(identificacao).ADD_atividade();
                            break;
                        case 2:
                            System.out.println("Digite a identificação da atividade.");
                            int id_ = this.Projetos.get(identificacao).Check_atividade(ler.nextInt());
                            if (id_ != -1) {
                                this.Projetos.get(identificacao).Rem_atividade(id_);
                            }
                            else {
                                System.out.println("ERRO: Atividade não encontrada.");
                            }
                            break;
                        case 3:
                            System.out.println("Digite a identificação da atividade:");
                            int i = this.Projetos.get(identificacao).Check_atividade(ler.nextInt());
                            if (i != -1) {
                                System.out.println("Digite a Opção:\n 1: Editar identificação\n 2: Editar descrição\n 3: Editar data início\n 4: Editar data termino\n 5: Editar responsável\n 6: Editar usuários ativos\n 7: Editar tarefas");
                                switch (ler.nextInt()) {
                                    case 1:
                                        System.out.println("Digite a identificação da atividade:");
                                        this.Projetos.get(identificacao).Get_atividade(i).Edit_identificacao(ler.nextInt());
                                        break;
                                    case 2: 
                                        System.out.println("Digite a descrição do Projeto:");
                                        this.Projetos.get(identificacao).Get_atividade(i).Edit_descricao(ler.nextLine());
                                        break;
                                    case 3:
                                        System.out.println("Digite os dados da data:");
                                        this.Projetos.get(identificacao).Get_atividade(i).Get_data_inicio().Edit();
                                        break;
                                    case 4:
                                        System.out.println("Digite os dados da data:");
                                        this.Projetos.get(identificacao).Get_atividade(i).Get_data_termino().Edit();
                                        break;
                                    case 5:
                                        System.out.println("Digite nome responsavel");
                                        int id_0 = Check_Usuario(ler.nextLine());
                                        if (id_0 != -1){
                                            this.Projetos.get(identificacao).Get_atividade(i).Edit_responsavel(Get_Usuario(id_0));
                                        }
                                        else{
                                            System.out.println("ERRO: Usuário não encontrado.");
                                        }
                                        break;
                                    case 6:
                                        switch (ler.nextInt()) {
                                            case 1:
                                                System.out.println("Digite quantos usuários ativos quer adicionar");
                                                int J = ler.nextInt();
                                                for(int h = 0; h < J; h++){
                                                    System.out.println("Digite o nome usuário");
                                                    int id_1 = Check_Usuario(ler.nextLine());
                                                    if (id_1 != -1){
                                                        this.Projetos.get(identificacao).Get_atividade(i).ADD_Usuario(this.Usuarios.get(id_1));
                                                    }
                                                    else{
                                                        System.out.println("ERRO: Usuário não encontrado.");
                                                    }
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Digite quantos usuários ativos quer remover");
                                                int T = ler.nextInt();
                                                for(int h = 0; h < T; h++){
                                                    System.out.println("Digite o nome usuário");
                                                    String _nome_ = ler.nextLine();
                                                    int id_1 = Check_Usuario(_nome_);
                                                    if (id_1 != -1){
                                                        int id_2 = this.Projetos.get(identificacao).Get_atividade(i).Check_Usuario(_nome_);
                                                        if (id_2 != -1) {
                                                            this.Projetos.get(identificacao).Get_atividade(i).Rem_Usuario(id_2);
                                                        }
                                                        else{
                                                            System.out.println("ERRO: Esse usuário não está listado na atividade.");
                                                        }
                                                    }
                                                    else{
                                                        System.out.println("ERRO: Usuário não encontrado.");
                                                    }
                                                }
                                                break;
                                            default:
                                                break;
                                        }
                                        break;
                                    case 7:
                                        System.out.println("Digite a opção: \n 1: Adicionar tarefa.\n 2: Remover tarefa.");
                                        switch (ler.nextInt()) {
                                            case 1:
                                                System.out.println("Digite da nova tarefa.");
                                                this.Projetos.get(identificacao).Get_atividade(i).Get_tarefas().add(ler.nextLine());
                                                break;
                                            case 2:
                                                System.out.println("Digite a tarefa.");
                                                int id_3 =  this.Projetos.get(identificacao).Get_atividade(i).Check_tarefa(ler.nextLine());
                                                if (id_3 != -1) {
                                                    this.Projetos.get(identificacao).Get_atividade(i).Get_tarefas().remove(id_3);
                                                }
                                                else{
                                                    System.out.println("ERRO: Tarefa não encontrada.");
                                                }
                                                this.Projetos.get(identificacao).Get_atividade(i).Get_tarefas().add(ler.nextLine());
                                                break;
                                            default:
                                                System.out.println("ERRO: Opção invalida.");
                                                break;
                                        }
                                        break;
                                    default:
                                        System.out.println("ERRO: Opção invalida.");
                                        break;
                                }            
                            }
                            else{
                                System.out.println("ERRO: Atividade não encontrada.");
                            }
                            break;
                        default:
                            System.out.println("ERRO: Opção invalida.");
                            break;}
                    break;   
                case 6:
                    System.out.println("Digite a Opção: \n 1: Editar informação.\n 2: Deletar informação.");
                    switch (ler.nextInt()) {
                        case 1:
                            System.out.println("Digite o valor da bolsa.");
                            this.Projetos.get(identificacao).Edit_valor_bolsa(ler.nextDouble());
                            break;
                        case 2:
                            this.Projetos.get(identificacao).Delete_valor_bolsa();
                            break;
                    
                        default:
                            System.out.println("ERRO: Opção invalida.");
                            break;}
                    break;
                case 7:
                    System.out.println("Digite a Opção: \n 1: Editar informação.\n 2: Deletar informação.");
                    switch (ler.nextInt()) {
                        case 1:
                            System.out.println("Digite o período vigência.");
                            this.Projetos.get(identificacao).Edit_periodo_vigencia(ler.nextInt());
                            break;
                        case 2:
                            this.Projetos.get(identificacao).Delete_periodo_vigencia();
                            break;
                        default:
                            System.out.println("ERRO: Opção invalida.");
                            break;}
                    break;
                case 8:
                    System.out.println("Digite a Opção: \n 1: Editar informação.\n 2: Deletar informação.");
                    switch (ler.nextInt()) {
                        case 1:
                            System.out.println("Digite os dados da Data de ínicio.");
                            this.Projetos.get(identificacao).Edit_data_inicio();
                            break;
                        case 2:
                            this.Projetos.get(identificacao).Delete_data_inicio();
                            break;
                        default:
                            System.out.println("ERRO: Opção invalida.");
                            break;}
                    break;
                case 9:
                    System.out.println("Digite a Opção: \n 1: Editar informação.\n 2: Deletar informação.");
                    switch (ler.nextInt()) {
                        case 1:
                            System.out.println("Digite os dados da Data de termino.");
                            this.Projetos.get(identificacao).Edit_data_termino();
                            break;
                        case 2:
                            this.Projetos.get(identificacao).Delete_data_termino();
                            break;
                        default:
                            System.out.println("ERRO: Opção invalida.");
                            break;}
                    break;
                default:
                    System.out.println("ERRO: Opção invalida.");
                    break;
            }           
        }
        else{
            System.out.println("ERRO: Projeto não encontrado.");
        }
    }
    public void ADD_projeto(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o nome do cordenador do projeto:");

        String nome = ler.nextLine();
        int id = Check_Usuario(nome);
        if (id != -1){
            Usuarios cordenador = Get_Usuario(id);
            if((cordenador.Get_cargo() == "professor") || cordenador.Get_cargo() == "pesquisador"){
                this.Projetos.add(new Projeto(cordenador));
            }
            else {
                System.out.println("ERRO: Esse usuário não tem poder para ser um cordenador.");
            }
        }
        else{
            System.out.println("ERRO: Usuário não encontrado.");
        }
    }

    public void login(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o usuário:");
        int id = this.Check_Usuario(ler.nextLine());
        
        if (id != -1) {
            System.out.println("Digite a senha:");
            if (this.Usuarios.get(id).login(ler.nextLine())) {
                System.out.println("Login aceito.");   
            }
            else{
                System.out.println("ERRO: Login errado.");   
            }
        }
        else{
            System.out.println("ERRO: Usuário não encontrado.");
        }
    }

    public void relario(){
        System.out.println("Relatório.");
        System.out.println("Projetos.");

        for (int i = 0; i < this.Projetos.size(); i++){
            System.out.println("Cordenador: " + this.Projetos.get(i).Get_cordenador().Get_nome() + " Cargo do Cordenador: " + this.Projetos.get(i).Get_cordenador().Get_cargo()+ ".");
            System.out.println("Status do projeto:" + this.Projetos.get(i).Get_status() + ".");
            System.out.println("Identificação do projeto:" + this.Projetos.get(i).Get_identificacao()+".");
            System.out.println("Usuários ativos no projeto:");
            for (int j = 0; j < this.Projetos.get(i).Get_usuarios_ativos().size(); j++){
                System.out.println("Usuário:" + this.Projetos.get(i).Get_usuarios_ativos().get(j).Get_nome()+" Cargo do usuário:" + this.Projetos.get(i).Get_usuarios_ativos().get(j).Get_cargo()+".");
            }
            System.out.println("Atividades do projeto:");
            for (int j = 0; j < this.Projetos.get(i).Get_atividades().size(); j++){
                System.out.println("Identificação da atividade:" + this.Projetos.get(i).Get_atividades().get(j).Get_identificacao()+".");
                System.out.println("descrição da atividade:" + this.Projetos.get(i).Get_atividades().get(j).Get_descricao()+".");
                System.out.println("Data de início da atividade:" + this.Projetos.get(i).Get_atividades().get(j).Get_data_inicio().Get_dia() + this.Projetos.get(i).Get_atividades().get(j).Get_data_inicio().Get_mes() + this.Projetos.get(i).Get_atividades().get(j).Get_data_inicio().Get_ano() + this.Projetos.get(i).Get_atividades().get(j).Get_data_inicio().Get_horas() + this.Projetos.get(i).Get_atividades().get(j).Get_data_inicio().Get_minutos() + this.Projetos.get(i).Get_atividades().get(j).Get_data_inicio().Get_segundos() + ".");
                System.out.println("Data de termino da atividade:" + this.Projetos.get(i).Get_atividades().get(j).Get_data_termino().Get_dia() + this.Projetos.get(i).Get_atividades().get(j).Get_data_termino().Get_mes() + this.Projetos.get(i).Get_atividades().get(j).Get_data_termino().Get_ano() + this.Projetos.get(i).Get_atividades().get(j).Get_data_termino().Get_horas() + this.Projetos.get(i).Get_atividades().get(j).Get_data_termino().Get_minutos() + this.Projetos.get(i).Get_atividades().get(j).Get_data_termino().Get_segundos() + ".");
                System.out.println("Responsável pela atividade: " + this.Projetos.get(i).Get_atividades().get(j).Get_responsavel()+ ".");
                System.out.println("Responsável da atividade: " + this.Projetos.get(i).Get_atividades().get(j).Get_responsavel().Get_nome()+ " Cargo: " + this.Projetos.get(i).Get_atividades().get(j).Get_responsavel().Get_cargo()+ ".");
                System.out.println("Usuários ativos da atividade:");
                for (int k = 0; k < this.Projetos.get(i).Get_atividades().get(j).Get_usuarios_ativos().size() ; k++){
                    System.out.println("usuário : " + this.Projetos.get(i).Get_atividades().get(j).Get_usuarios_ativos().get(k).Get_nome()+" Cargo: " +this.Projetos.get(i).Get_atividades().get(j).Get_usuarios_ativos().get(k).Get_cargo()+".");
                }
                System.out.println("Tarefas da atividade:");
                for (int k = 0; k < this.Projetos.get(i).Get_atividades().get(j).Get_tarefas().size(); k++){
                    System.out.println(this.Projetos.get(i).Get_atividades().get(j).Get_tarefas().get(k)+".");
                }
            }
            System.out.println("Valor da bolsa do projeto: "+ this.Projetos.get(i).Get_valor_bolsa()+".");
            System.out.println("Período de vigência do projeto: "+ this.Projetos.get(i).Get_periodo_vigencia() + " dias.");
            System.out.println("Data de início do projeto:" + this.Projetos.get(i).Get_data_inicio() + this.Projetos.get(i).Get_data_inicio().Get_mes() + this.Projetos.get(i).Get_data_inicio().Get_ano() + this.Projetos.get(i).Get_data_inicio().Get_horas() + this.Projetos.get(i).Get_data_inicio().Get_minutos() + this.Projetos.get(i).Get_data_inicio().Get_segundos() + ".");
            System.out.println("Data de termino do projeto:" + this.Projetos.get(i).Get_data_termino().Get_dia() + this.Projetos.get(i).Get_data_termino().Get_mes() + this.Projetos.get(i).Get_data_termino().Get_ano() + this.Projetos.get(i).Get_data_termino().Get_horas() + this.Projetos.get(i).Get_data_termino().Get_minutos() + this.Projetos.get(i).Get_data_termino().Get_segundos() + ".");
        }
    }

    public Gerencia(){
        this.Projetos = new ArrayList<Projeto>();
        this.Usuarios = new ArrayList<Usuarios>();
    }
} 