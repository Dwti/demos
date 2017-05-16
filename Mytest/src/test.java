import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import sun.misc.BASE64Decoder;

public class test {

	public static SecretKey securekey;
	
	public static String DecryptDate(String cryptdata) {
        try {
            byte[] base64 = new BASE64Decoder().decodeBuffer(cryptdata);
            SecureRandom random = new SecureRandom();
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            return new String(cipher.doFinal(base64), "UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
	public static void main(String[] args) {
		
		String test="vK5CjXtOzZB7IC8rbzYuKqQ7KcOuCpbnPWz17L16O6E6LSLH2BzB77KWZA3HU1uS";
		try {
			test= test.replace(" ", "");  
			byte[] eckey = "ws3edaw4".getBytes();
			DESKeySpec deskey = new DESKeySpec(eckey); 
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			securekey = keyFactory.generateSecret(deskey);

			String res = DecryptDate(test);
			System.out.println(res);
		} catch (Exception e) {
            e.printStackTrace();
        }
	}
}