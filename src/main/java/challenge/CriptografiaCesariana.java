package challenge;

public class CriptografiaCesariana implements Criptografia {
    final int deslocamento = 3;
    final int Letra_a = 97;
    final int Letra_z = 122;

    public String cifrar(String texto, int operacao) {
        if (!texto.isEmpty() && texto != null) {
            texto = texto.toLowerCase();
            String cifra = "";
            int codigo;
            for (int i = 0; i < texto.length(); i++) {
                codigo = (int) texto.charAt(i);
                if (codigo >= Letra_a && codigo <= Letra_z) {
                    codigo+=operacao;                    
                    if (codigo > Letra_z) {
                        codigo = Letra_a + (codigo - Letra_z);
                    } 
                    if (codigo < Letra_a) {
                        codigo = Letra_z - (Letra_a - codigo);
                    }
                }
                cifra+=(char) codigo;
            }
            return cifra;
        } else {
            throw new IllegalArgumentException("Texto vazio!");
        }
        
    }

    @Override
    public String criptografar(String texto) {
        return cifrar(texto, deslocamento);
    }

    @Override
    public String descriptografar(String texto) {
        return cifrar(texto, -1 * deslocamento);
    }    
    public static void main(String[] args) {
        CriptografiaCesariana app = new CriptografiaCesariana();
        String texto = "A ligeira raposa marrom saltou sobre o cachorro cansado";
        try {
            System.out.printf("\n%s\n", app.descriptografar(app.criptografar(texto)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
