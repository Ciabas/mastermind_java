package Model;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class Score {
    
    String file = "scores.txt";
    String key = "kluczyk";
	
    public Score(){}
    public void saveToFile(String user, int score){
        FileWriter fw = null;
        try {
            String content = user + " " + String.valueOf(score) + "\n";
            fw = new FileWriter(this.file, true);
//            content = this.encrypt(content, this.key);
            fw.write(content);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String loadFromFile(){
        try {
            String content = new String(Files.readAllBytes(Paths.get(this.file)));
//            content = this.decrypt(content, this.key);
            return content;
        } catch (IOException ex) {
            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    } 

    public void clearAllInFile(){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(this.file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
    }
    
    private String encrypt(String strClearText,String strKey){
        String strData = "";
        try {
            SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
            byte[] encrypted = cipher.doFinal(strClearText.getBytes("UTF-8"));
            strData = new String(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return strData;
    }  
    
    private String decrypt(String strEncrypted,String strKey){
        String strData = "";
        try {
            SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, skeyspec);
            byte[] decrypted = cipher.doFinal(strEncrypted.getBytes("UTF-8"));
            strData = new String(decrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return strData;
    }
}
