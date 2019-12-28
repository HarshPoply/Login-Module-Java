package utilities;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class Encryption {
	
	public static String MD5(String input) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1,messageDigest);
			String hashText = number.toString(16);
			while(hashText.length() < 32) {
				hashText = "0" + hashText;
			}
			return hashText;
		}
		catch(NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String SHA1(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			byte[] result = md.digest(input.getBytes());
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<result.length;i++) {
				sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
