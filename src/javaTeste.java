
import sistema.de.gestão.de.tarefas.Task;

public class javaTeste {
    public static void main(String[] args) {
        boolean menu = true;
        while(menu){
            
            Task task = new Task();
            String teste = task.getDataDeVencimento();
            System.out.println(teste);
        }
       
    }
    
}
