package Projects;
import java.util.Scanner;
public class Encryption_tool {
    public static String encrypt(String message,int shift)
    {
        StringBuilder encrypted=new StringBuilder();
        for(char ch:message.toCharArray())
        {
            if(Character.isLetter(ch))
            {
                char base=Character.isLowerCase(ch)?'a':'A';
                encrypted.append((char)((ch-base+shift)%26+base));
            }
            else{
                encrypted.append(ch);
            }
        }
        return encrypted.toString();
    }
    public static String decrypt(String message,int shift)
    {
        return encrypt(message,26-shift);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //Key for the encryption
        int shift=3;
        System.out.println("Welcome to Encryption Tool");
        System.out.println("Choose an option:");
        System.out.println("1. Encrypt a message");
        System.out.println("2. Decrypt a message");
        int choice= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your message:");
        String message=sc.nextLine();
        String result="";
        switch(choice)
        {
            case 1:
                result=encrypt(message,shift);
                System.out.println("Encrypted message: "+result);
                break;
            case 2:
                result=decrypt(message,shift);
                System.out.println("Decrypted message: "+result);
                break;
            default:
                System.out.println("Invalid Choice!Restart the Encryption");
        }
        sc.close();
    }
}
