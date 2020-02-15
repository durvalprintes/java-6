package challenge;

public class CriptografiaCesariana implements Criptografia {
    final int deslocamento = 3;

    @Override
    public String criptografar(String texto) {
        if (texto != "") {
            String cifrado = "";
            int codigo;
            for (int i = 0; i < texto.length(); i++) {
                codigo = (int) texto.toLowerCase().charAt(i);
                if (codigo >= 97 && codigo <= 122) {
                    if (codigo <= (122 - deslocamento)) {
                        cifrado+= (char) (codigo + deslocamento);
                    } else { 
                        cifrado+= (char) (codigo - 23);
                    }
                } else {
                    cifrado+=(char) codigo;
                }
            }
            return cifrado;
        } else {
            throw new IllegalArgumentException("Erro ao criptografar texto vazio!");
        }
        
    }

    @Override
    public String descriptografar(String texto) {
        if (texto != "") {
            String decifrado = "";
            int codigo;
            for (int i = 0; i < texto.length(); i++) {
                codigo = (int) texto.toLowerCase().charAt(i);
                if (codigo >= 97 && codigo <= 122) {
                    if (codigo >= (97 + deslocamento)) {
                        decifrado+= (char) (codigo - deslocamento);
                    } else { 
                        decifrado+= (char) (codigo + 22);
                    }
                } else {
                    decifrado+=(char) codigo;
                }
            }
            return decifrado;
        } else {
            throw new IllegalArgumentException("Erro ao descriptografar Texto vazio!");
        }
    }
    public static void main(String[] args) {
        CriptografiaCesariana app = new CriptografiaCesariana();
        // System.out.println("\n"+app.descriptografar(app.criptografar("a ligeira raposa marrom saltou sobre o cachorro cansado")));
        System.out.println("\n"+app.descriptografar(app.criptografar(null)));
    }
}
