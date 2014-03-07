/*
 * Computer Systems 2 Coursework.
 */
package misc;

//import com.sun.org.apache.xml.internal.security.utils.Base64;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.security.MessageDigest;

/**
 * Make a SHA-512 hash of a password for storage or comparison.
 * 
 * @author Ashley Moore (6304397)
 * @author Ian Weeks (6204848)
 */
public class MakeSha
{
    private String hash;
    
    public MakeSha(){}
    /**
     * 
     * @param password Password to be hashed.
     * @return A base64 encoded SHA-512 hash of the password entered.
     */
    public String makeHash(String password)
    {
        try
        {
            String salt = "ficesownad"
                        + "yshitempto"
                        + "falimprovk"
                        + "pensmalles"
                        + "vtdisdfsal"
                        + "orAtedhere"
                        + "rsonarearo"
                        + "usfgfdresd";
            MessageDigest sha256 = MessageDigest.getInstance("SHA-512");
            /*
             * Salt added in order to make rainbow table or dictionary hacks
             * less viable.
             */
            hash = Base64.encode(sha256.digest(( password + salt ).getBytes()));
        } catch (Exception e)
        {
            System.out.println("Error: SHA hash failed. " + e);
        }
        return hash;
    }
    
}
