package TerceiroDesafioJava;

public class Admin extends Usuario {
    
    public Admin(int id, String nome, String senha){
        super(id, nome, senha, "ADMIN");
    }

    public Usuario criarUsuario(int id, String nome, String senha, String papel){
        Usuario usuario = new Usuario(id, nome, senha, papel);
        SistemaExames.usuarios.add(usuario);
        return usuario;
    }

    public void definirPapel(Usuario usuario, String papel){
        usuario.setPapel(papel);
        System.out.println("O papel do usuário " + usuario.getNome() + "foi alterado para" + papel);
    }

}
