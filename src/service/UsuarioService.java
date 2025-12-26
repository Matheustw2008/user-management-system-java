package service;

import model.Usuario;
import util.HashUtil;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private final List<Usuario> usuarios = new ArrayList<>();

    public void cadastrar(String nome, String email, String senha) {

        if (nome.isBlank() || email.isBlank() || senha.isBlank()) {
            System.out.println("❌ Nenhum campo pode estar vazio.");
            return;
        }

        if (emailJaExiste(email)) {
            System.out.println("❌ Email já cadastrado.");
            return;
        }

        String senhaHash = HashUtil.gerarHash(senha);
        usuarios.add(new Usuario(nome, email, senhaHash));

        System.out.println("✅ Usuário cadastrado com sucesso.");
    }

    public void login(String email, String senha) {

        Usuario usuario = buscarPorEmail(email);

        if (usuario == null) {
            System.out.println("❌ Usuário não encontrado.");
            return;
        }

        String senhaHash = HashUtil.gerarHash(senha);

        if (senhaHash.equals(usuario.getSenhaHash())) {
            System.out.println("✅ Login realizado com sucesso. Bem-vindo, " + usuario.getNome());
        } else {
            System.out.println("❌ Senha inválida.");
        }
    }

    private boolean emailJaExiste(String email) {
        return usuarios.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(email));
    }

    private Usuario buscarPorEmail(String email) {
        return usuarios.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }
}
