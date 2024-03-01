
package sistema.de.gestão.de.tarefas;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
public class TaskManager {
    int introdução(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Genciador de Tarefas");
        System.out.println("Escolaha uma das opções a baixo"
                + "\n\n1.Adicionar uma nova tarefa\n"+
                  "2.Visualizar todas as tarefas\n"+
                  "3.Atualizar uma tarefa\n"+
                  "4.Excluir uma tarefa\n"+
                  "5.Sair do programa");
        System.out.print("Digite a opção: ");
        int opcao = scanner.nextInt();
        
        return opcao;
    }
    void retornarMenu(){
        
    }
    
    void adicionarTf(Task task){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Qual sua nova tarefa?: ");
        String adicionarTitulo = scanner.nextLine();
        task.setTitulo(adicionarTitulo);
        
        System.out.print("Digite uma descrição para sua tarefa: ");
        String adicionarTarefa = scanner.nextLine();
        task.setDescricao(adicionarTarefa);
        
        System.out.print("Digite o prazo maximo para sua tarefa: ");
        String prazoDeVencimento =  scanner.nextLine();
        task.setDataDeVencimento(prazoDeVencimento);
        verificaçãoDeStatus(task);
        
        
       
    }
    void visualizarTodasTarefas(Task task){
        List<String> titulo = task.getTitulo();
        List<String> descricao =  task.getDescricao();
        List<String> dataDeVencimento = task.getDataDeVencimento();

        for(int i = 0; i < titulo.size(); i++){
            System.out.println("-----------------------------");
            System.out.printf("Terefa(%d)\n", i + 1);
            System.out.println("Titulo da tarefa: " +  titulo.get(i));
            System.out.println("Descrição: " + descricao.get(i));
            System.out.println("Validade: " + dataDeVencimento.get(i));
            System.out.println("-----------------------------");
        }
        
    }
    void atualizarTarefasExistente(Task task){
        Scanner scanner = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        System.out.print("Escolha a tarefa que vc deseja alterar:");
        int indiceArray = scanner.nextInt();
        task.imprirTarefa(indiceArray - 1);
        System.out.println("\nQual das opção você gostaria de alterar?"+
                "\n1.Titulo"+
                "\n2.Descrição"+
                "\n3.Prazo de validade"+
                "\n4.Alterar tarefa inteira");
        System.out.print("Digite a opção: ");
        int opcao = scanner.nextInt();
       
        if(opcao == 1 || opcao == 4){
            System.out.print("Qual o novo titulo da sua tarefa: ");
            String novoTitulo = input.nextLine();
            task.setAlteracaoIndeceTl(indiceArray -1, novoTitulo);
        }if(opcao == 2 || opcao == 4){
            System.out.print("Digite a nova descrição da sua tarefa: ");
            String adicionarTarefa = input.nextLine();
            task.setAlteracaoIndeceDesc(indiceArray -1, adicionarTarefa);
        }if(opcao == 3 || opcao == 4){
            System.out.print("Digite o novo prazo da sua tarefa: ");
            String prazoDeVencimento =  input.nextLine();
            task.setAlteracaoIndeceDataVnc(indiceArray -1, prazoDeVencimento);
            verificaçãoDeStatus(task);
            
        }
        task.imprirTarefa(indiceArray -1);
        
        
        
        
        
        
        
    }
    void ExcluirTf(Task task){
        Scanner input = new Scanner(System.in);
        System.out.print("Qual a tarefa que você deseja excluir?: ");
        int indice = input.nextInt();
        task.excluir(indice);
    }
    int dataAtual(){
        Date data = new Date(); // Obtém a data atual
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dataFormatada = formato.format(data);
        
        int dataInteiro = Integer.parseInt(dataFormatada.substring(0, 4) + dataFormatada.substring(5, 7) + dataFormatada.substring(8, 10));

        return dataInteiro;
    }
    int formatarData(Task task){
        
        List<String> dataVnc = task.getDataDeVencimento();
        String ultimoElemento = dataVnc.get(dataVnc.size() - 1);
        String[] partes = ultimoElemento.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);
        int dataInteiro = ano * 10000 + mes * 100 + dia;
        return dataInteiro;
    }
    
    void verificaçãoDeStatus(Task task){
        
        int dataDoSistema = this.dataAtual();
        int dataUsuario = this.formatarData(task);
        if(dataDoSistema <= dataUsuario)
            task.setStatus("Tarefa ainda dentro do prazo!");
        else 
            task.setStatus("Prazo da tarefa excedida!");
       
        
    }
    


    
}
