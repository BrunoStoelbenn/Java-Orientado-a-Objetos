package TerceiroDesafioJava;

public class Usuario {
    private int id;
    private String nome;
    private String senha;
    private String papel;

    public Usuario(int id, String nome, String senha, String papel){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.papel = papel;
    }

    public boolean autenticar(String senha){
        return this.senha.equals(senha);
    }

    public boolean hasRole(String papel){
        return this.papel.equals(papel);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    
}
