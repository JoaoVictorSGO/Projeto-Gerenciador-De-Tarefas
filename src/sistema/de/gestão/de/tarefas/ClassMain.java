
package sistema.de.gestão.de.tarefas;

public class ClassMain {
    public static void main(String[] args) {
        
        teste
        ClassMain main = new ClassMain();
        TaskManager taskManager = new TaskManager();
        Task task = new Task();
       
        boolean menu = true;

        do{
            int opcao = taskManager.introdução();
            switch (opcao) {
                case 1:
                    taskManager.adicionarTf(task);
                    task.imprirTarefa(task.quantidadeIndice());
                    break;
                case 2:
                    
                    taskManager.visualizarTodasTarefas(task);
                    break;
                case 3:
                    taskManager.atualizarTarefasExistente(task);
                    break;
                case 4:
                    taskManager.ExcluirTf(task);
                    System.out.println("\n\nTarefa excluida com sucesso!");
                    break;
                case 5:
                    menu = false;
                    break;
                default:
                    throw new AssertionError();}
            
        }while(menu);
        
      
    }  
    

        
}
        
        
        
        
        
       

