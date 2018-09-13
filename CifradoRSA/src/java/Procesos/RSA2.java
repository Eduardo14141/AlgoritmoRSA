package Procesos;
import java.math.BigInteger;
import java.security.SecureRandom;
public class RSA2 {
    private BigInteger n; // Clave compartida
    private BigInteger d; // Clave privada (no se comparte)
    private BigInteger k; // Clave publica para la otra parte
    private final int  K = 0, D = 0, N = 1;
    
    public RSA2(int bitlen){
        // Calculamos los dos numeros primos p y q:
        SecureRandom r = new SecureRandom(); //genera un número criptográfico fuerte aleatorio
        BigInteger p = new BigInteger(bitlen/2, 100, r); //bitlen es entre cuántos bits tendrá el número
        BigInteger q = new BigInteger(bitlen/2, 100, r); //entre dos porque de 1024 está cañón el procesamiento

        //n = p*q, v= (p-1)*(q-1)
        n = p.multiply(q);
        BigInteger v = ( p.subtract(BigInteger.ONE) ).multiply(q.subtract(BigInteger.ONE));

        // Calculamos k como el numero impar mas pequeño relativamente primo con v
        k = new BigInteger("3");
        while( v.gcd(k).intValue() > 1 )// gcd greatest common divisor
            k = k.add(new BigInteger("2"));
        // Calculamos d de modo que (d * k) MOD V = 1
        d = k.modInverse(v);
    }
    // Pasa el BigInteger normal a cifrado usando la clave publica.
    public BigInteger encrypt(BigInteger message){
        return message.modPow(k, n);
    }
    // Pasa el BigInteger normal a cifrado usando la clave publica recibida.
    public BigInteger encrypt(BigInteger message, BigInteger[] key) {
        return message.modPow(key[K], key[N]);
    }
    // Pasa el BigInteger de cifrado a normal usando la clave privada.
    public BigInteger decrypt(BigInteger message){
        return message.modPow(d, n);
    }
    //Pasa el BigInteger de cifrado a normal usando la clave privada recibida.
    public BigInteger decrypt(BigInteger message, BigInteger[] key){
        return message.modPow(key[D], key[N]);
    }
    public BigInteger[] getPublicKey(){
        return new BigInteger[] { k, n };
    }
    public BigInteger[] getPrivateKey() {
        return new BigInteger[] { d, n };
    }
}
