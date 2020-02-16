package challenge;

public class CriptografiaCesariana implements Criptografia {
    final int deslocamento = 3;

    public String cifrar(String texto, int operacao) {
        if (!texto.isEmpty() && texto != null) {
			String cifra = "";
            int codigo;
            for (int i = 0; i < texto.length(); i++) {
                codigo = (int) texto.charAt(i);
                if (codigo >= 97 && codigo <= 122) { //[a-z]
                    codigo+=operacao;                    
                    if (codigo > 122) {
						codigo = 97 + (codigo - 122);
                    } 
                    if (codigo < 97) {
						codigo = 122 - (97 - codigo);
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
		return cifrar(texto.toLowerCase(), deslocamento);
	}

    @Override
    public String descriptografar(String texto) {
        return cifrar(texto.toLowerCase(), -1 * deslocamento);
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
