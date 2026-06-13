package controlador;

import java.util.ArrayList;
import java.io.*;

import modelo.Usuario;
import modelo.Participante;
import modelo.Resultado;

public class Sistema {

    public static ArrayList<Usuario> usuarios =
            new ArrayList<>();

    public static ArrayList<Participante> participantes =
            new ArrayList<>();

    public static ArrayList<Resultado> listaResultados =
            new ArrayList<>();

    public static Usuario usuarioLogado;

    public static Participante participanteAtual;

    // LOGIN
    public static boolean autenticar(
            String email,
            String senha
    ) {

        for (Usuario u : usuarios) {

            if (u.getEmail().equals(email)
                    && u.getSenha().equals(senha)) {

                usuarioLogado = u;

                return true;
            }
        }

        return false;
    }

    // CADASTRO
    public static boolean cadastrarUsuario(
            Usuario novo
    ) {

        for (Usuario u : usuarios) {

            if (u.getEmail().equals(novo.getEmail())) {

                return false;
            }
        }

        usuarios.add(novo);

        salvarDados();

        return true;
    }

    //  SALVAR
    public static void salvarDados() {

        try {

            FileOutputStream fos =
                    new FileOutputStream(
                            "dados.dat"
                    );

            ObjectOutputStream oos =
                    new ObjectOutputStream(fos);

            oos.writeObject(usuarios);

            oos.writeObject(participantes);

            oos.writeObject(listaResultados);

            oos.flush();

            oos.close();

            fos.close();

            System.out.println(
                    "DADOS SALVOS!"
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    //  CARREGAR
    public static void carregarDados() {

        try {

            FileInputStream fis =
                    new FileInputStream(
                            "dados.dat"
                    );

            ObjectInputStream ois =
                    new ObjectInputStream(fis);

            usuarios =
                    (ArrayList<Usuario>)
                            ois.readObject();

            participantes =
                    (ArrayList<Participante>)
                            ois.readObject();

            listaResultados =
                    (ArrayList<Resultado>)
                            ois.readObject();

            ois.close();

            fis.close();

            System.out.println(
                    "DADOS CARREGADOS!"
            );

        } catch (Exception e) {

            System.out.println(
                    "Nenhum dado salvo ainda."
            );
        }
    }
}