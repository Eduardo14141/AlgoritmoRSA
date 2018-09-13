package Procesos;
import java.math.BigInteger;
import java.util.Arrays;
public class RSA2_1 {
        //Ejemplo de cómo usar el RSA 2
        // Estos son los datos que se van a cifrar y descifrar:
        byte[] misDatos = new byte[] { 'H', 'o', 'l', 'a', ' ', 'm', 'u', 'n', 'd', 'o', '!' };


        // Lo primero es crear dos objetos RSA, el primero hara de Cliente y el segundo de Servidor.
        // Cada uno cuenta con sus claves publicas y privadas generadas:
        RSA2 rsaCliente = new RSA2(1024);
        RSA2 rsaServidor = new RSA2(1024);


        // Cuando el Cliente cifra los datos lo hace con la clave publica del Servidor:
        BigInteger cifrado = rsaCliente.encrypt(new BigInteger(misDatos), rsaServidor.getPublicKey());


        // Cuando el Servidor descifra los datos lo hace con su propia clave privada:
        BigInteger descifrado = rsaServidor.decrypt(cifrado);


        // Y por ultimo se imprime por pantalla el BigInteger pasandolo a un array de chars:
        public byte[] array = descifrado.toByteArray();
        String mensaje= Arrays.toString(array);
}
