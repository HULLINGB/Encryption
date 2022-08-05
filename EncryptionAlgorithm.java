import java.security.*;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;

public class EncryptionAlgorithm {
   public static void main(String args[]) throws Exception{
      //Creating a Signature object
      //Signature sign = Signature.getInstance("SHA256withRSA");
      
      //Creating KeyPair generator object
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
      
      //Initializing the key pair generator
      keyPairGen.initialize(2048);
      
      //Generating the pair of keys
      KeyPair pair = keyPairGen.generateKeyPair();      
	
      //Creating a Cipher object
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        
      //Initializing a Cipher object for encryption
      cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
	  
      //Adding data to the cipher
	  //"Welcome to Tutorialspoint"
      byte[] input = "Welcome to Tutorialspoint".getBytes();	  
      cipher.update(input);
	  
      //encrypting the data
      byte[] cipherText = cipher.doFinal();
	  //Output the encrypted cipher as a String	  
      System.out.println(new String(cipherText, "UTF8"));
	  
	  /**
	  Encrypted Text:
"???:]J_?]???;Xl??????*@??u???r??=T&???_?_??.??i?????(?$_f?zD??????ZGH??g???
g?E:_??bz^??f?~o???t?}??u=uzp\UI????Z??l[?G?3??Y?UAEfKT?f?O??N_?d__?????a_?15%?^?
'p?_?$,9"{??^??y??_?t???,?W?PCW??~??[?$??????e????f?Y-Zi__??_??w?_?&QT??`?`~?[?K_??_???
	  **/

      //Initializing the same cipher for decryption
      cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
      
      //Decrypting the text
      byte[] decipheredText = cipher.doFinal(cipherText);
	  //Output the decrypted text
      System.out.println(new String(decipheredText));
	  
	  /**

	Decrypted Text:
	Welcome to Tutorialspoint

	**/
   }
}