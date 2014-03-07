/*
 * Computer Systems 2 Coursework.
 */

package misc;

/**
 * Makes a 16 bit byte array.
 * 
 * @author Ashley Moore (6304397)
 * @author Ian Weeks (6204848)
 */
public class KeyMaker
{
    private String keyInput;
    private byte[] keyOutput;
    
    //Default constructor.
    public KeyMaker(){}
    
    /**
     * Makes a 16 bit byte array.
     * 
     * @param key Character sequence to be used as a private key.
     * @return A 16 bit byte array to be used as a private key.
     */
    public byte[] makeKeyDriver(String key)
    {
        this.keyInput = key;
        return makeKey();
    }
    
    private byte[] makeKey()
    {
        keyOutput = new byte[16];
        /*
         * If the string given is too short then add another string onto the end
         * to make it at least 16 characters long. If the string is over 16
         * characters long then only chars 0 - 15 are used.
         */
        if(keyInput.toCharArray().length < 16)
        {
            String fixedKey = keyInput.concat("flyingturboninjakickyo");
            for (int i = 0; i < 16; i++)
            {
                keyOutput[i] = (byte) fixedKey.charAt(i);
            }
        }else
        {
            for (int i = 0; i < 16; i++)
            {
                keyOutput[i] = (byte) keyInput.charAt(i);
            }
        }
        return keyOutput; //16bit byte array.
    }
}
