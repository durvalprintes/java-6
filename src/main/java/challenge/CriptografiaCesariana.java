package challenge;

public class CriptografiaCesariana implements Criptografia {
    private final int deslocamento = 3;
    private final int asciiLetraA = 97;
    private final int asciiLetraZ = 122;

    private String cifrar(String texto, int operacao) {
        if (texto.isEmpty() || texto == null) {
            throw new IllegalArgumentException("Texto vazio!");
        } else {
            texto = texto.toLowerCase();
            String cifra = "";
            int codigoAscii;
            for (int i = 0; i < texto.length(); i++) {
                codigoAscii = (int) texto.charAt(i);
                if (codigoAscii >= asciiLetraA && codigoAscii <= asciiLetraZ) {
                    codigoAscii += operacao * deslocamento;                    
                    if (codigoAscii > asciiLetraZ) {
                        codigoAscii = asciiLetraA + (codigoAscii - asciiLetraZ);
                    } 
                    if (codigoAscii < asciiLetraA) {
                        codigoAscii = asciiLetraZ - (asciiLetraA - codigoAscii);
                    }
                }
                cifra += (char) codigoAscii;
            }
            return cifra;
        }        
    }

    @Override
    public String criptografar(String texto) {
        return cifrar(texto, 1);
    }

    @Override
    public String descriptografar(String texto) {
        return cifrar(texto, -1);
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
