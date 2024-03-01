
package sistema.de.gestão.de.tarefas;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;


public class Task{
    int id;
    
    private List<String> titulo;
    private List<String> descricao;
    private List<String> dataDeVencimento;
    private List<String>  status;
    public Task(){
        descricao = new ArrayList<>();
        titulo = new ArrayList<>();
        dataDeVencimento = new ArrayList();
        status = new ArrayList();
    }
    public List<String> getTitulo(){
        return this.titulo;
    }
    
    public List<String> getDescricao(){
        return this.descricao;
    }
    
    public List<String> getDataDeVencimento(){
        return this.dataDeVencimento;
    }
    
    public List<String> getStatus(){
        return this.status;
    }
    
    public void setTitulo(String novaTF){
        this.titulo.add(novaTF);
        
    }
    
    void setDescricao(String novoItem){
          this.descricao.add(novoItem); 
         
    }
       
    
    public void setDataDeVencimento(String dataVnc){
        this.dataDeVencimento.add(dataVnc);
    }
    
    public void setStatus(String pStatus){
        status.add(pStatus);
    }
    void imprirTarefa(int indice){
        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";
        String blue = "\u001B[34m";

        String meuTitulo = titulo.get(indice);
        String minhaDescricao = descricao.get(indice);
        String prazoVnc = dataDeVencimento.get(indice);
        String statusTarefa = status.get(indice);
        System.out.println("-----------------------");
        System.out.println("Titulo da tarefa: " + yellow + meuTitulo + reset);
        System.out.println("Descrição: " + green + minhaDescricao + reset);
        System.out.println("Prazo de vencimento: " + red + prazoVnc + reset);
        System.out.println(statusTarefa);
        System.out.println("-----------------------");
       
            
        
        
        
    }
    void setAlteracaoIndeceTl(int index, String altaracaoDeTarefa ){
        titulo.set(index, altaracaoDeTarefa);
      
        
    }
    void setAlteracaoIndeceDesc(int index, String altaracaoDeTarefa ){
        descricao.set(index, altaracaoDeTarefa);
        
        
    }
    void setAlteracaoIndeceDataVnc(int index, String altaracaoDeTarefa ){
        dataDeVencimento.set(index, altaracaoDeTarefa);
        
    }

    int quantidadeIndice(){
        return titulo.size() - 1;
    }
    void excluir(int indice){
        this.titulo.remove(indice - 1);
        this.descricao.remove(indice -1);
        this.dataDeVencimento.remove(indice -1 );
        this.status.remove(indice -1 );
    }
    
    
}
