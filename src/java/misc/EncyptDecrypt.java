/*
 * Computer Systems 2 Coursework.
 */
package misc;


//import com.sun.org.apache.xml.internal.security.utils.Base64;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * Encryption and decryption class.
 * 
 * @author Ashley Moore (6304397)
 * @author Ian Weeks (6204848)
 */
public class EncyptDecrypt
{
    private Cipher cipher;
    
    public EncyptDecrypt()
    {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        try
        {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e)
        {
            System.out.println("Error in ecrypt object creation. " + e);
        }
    }
    
    /**
     * Encrypts a string of text.
     * 
     * @param input String to be encrypted.
     * @param sks 16bit key.
     * @return String of encrypted, base64 coded text.
     */
    public String encrypt(String input, SecretKeySpec sks)
    {
        byte[] byteInput = input.getBytes();
                
        String output = "";
        try
        {
            cipher.init(Cipher.ENCRYPT_MODE, sks);
            output = Base64.encode(cipher.doFinal(byteInput));
        } catch (IllegalBlockSizeException | BadPaddingException 
                | InvalidKeyException ex)
        {
            System.out.println("Encryption error. " + ex);
        }
        return output; //Base64 encoded, AES-128 encrypted text.
    }
    
    /**
     * Decrypts a string of text.
     * 
     * @param input String to be decrypted.
     * @param sks 16bit key.
     * @return String of decrypted text.
     */
    public String decrypt(String input, SecretKeySpec sks)
    {
        String output;
                  
        try
        {
            byte[] b = Base64.decode(input);
            cipher.init(Cipher.DECRYPT_MODE, sks);
            output = new String(cipher.doFinal(b));
        } catch (InvalidKeyException | IllegalBlockSizeException 
                | BadPaddingException iibe)
        {
            output = "Error: Incorrect key used. " + iibe;
        } catch (Exception e)
        {
            output = "Error: Decryption error. " + e;
        }
        return output;
    }
}
