/**
 * Created By SPC On
 * Date:18/09/2023
 * Time:16:08
 * Project Name:spc.com.rccgphmbackend.exception
 */

package spc.com.rccgphmbackend.exception;

public class UserAlreadyExist extends Exception{

    public UserAlreadyExist(String message) {
        super(message);
    }
}
