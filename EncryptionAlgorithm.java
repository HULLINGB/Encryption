import java.security.*;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;

public class EncryptionAlgorithm {
   public static void main(String args[]) throws Exception{
	   
	  String text = "Welcome to Tutorials Point";

      //Creating a Signature object
      //Signature sign = Signature.getInstance("SHA256withRSA");
      
      //Creating KeyPair generator object
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
      keyPairGen.initialize(2048);
      KeyPair pair = keyPairGen.generateKeyPair();      
	
      //Creating a Cipher object
	  //encrypt mode
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
	  
	  System.out.println("Your security key is:  " + pair);
	  
	  /**
		Inputed text: "Welcome to Tutorialspoint"
		**/
		
		System.out.println("Inputed text:  " + text);
	

      byte[] input = text.getBytes();	  
      cipher.update(input);
	  
      //encrypting the data
      byte[] cipherText = cipher.doFinal();

	  /**
	  Encrypted Text:
"???:]J_?]???;Xl??????*@??u???r??=T&???_?_??.??i?????(?$_f?zD??????ZGH??g???
g?E:_??bz^??f?~o???t?}??u=uzp\UI????Z??l[?G?3??Y?UAEfKT?f?O??N_?d__?????a_?15%?^?
'p?_?$,9"{??^??y??_?t???,?W?PCW??~??[?$??????e????f?Y-Zi__??_??w?_?&QT??`?`~?[?K_??_???
	  **/
	  
	  System.out.println("Your encrypted message is:  ");
	  System.out.println(" ");
      System.out.println(new String(cipherText, "UTF8"));
	  
      //Setting cipher back to decrypt mode
	  //Decrypting the text

      cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
      byte[] decipheredText = cipher.doFinal(cipherText);
	  
	  /**
		Decrypted Text:
		Welcome to Tutorialspoint
	**/
		System.out.println(" ");
		System.out.println("Decrypted text: ");
		System.out.print("  ");
		System.out.print(new String(decipheredText));
   }
}