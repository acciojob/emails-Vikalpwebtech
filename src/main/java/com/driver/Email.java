package com.driver;

import javax.xml.crypto.Data;
import java.util.Date;

public class Email {

    private String emailId;
    private String password;


    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    //function to check whether the newpassword satisfies the conditions
    public boolean checkpassword(String newpassword){
        //Checking based on ascii value
        if(newpassword.length() < 8){
            return false;
        }
        int uppercase = 0;
        int lowercase = 0;
        int digit = 0;
        int specialchar = 0;

        for(int i = 0;i < newpassword.length();i++){
            int asciival = newpassword.charAt(i);
            if(asciival >= 65 && asciival <= 90) uppercase++;
            else if(asciival >= 97 && asciival <= 122) lowercase++;
            else if(asciival >= 48 && asciival <= 57) digit++;
            else if (asciival >= 32 && asciival <= 47) specialchar++;
        }

        if (uppercase >= 1 && lowercase >= 1 && digit >= 1 && specialchar >= 1) return true;
        return  false;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(password.equals(oldPassword) && checkpassword(newPassword)){
            this.password = newPassword;
            System.out.println("Password changed successfully!");
        }
    }

}
