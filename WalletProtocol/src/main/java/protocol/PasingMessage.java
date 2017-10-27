package protocol;

import Model.Customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PasingMessage {

    private String lineformating(String header, String value){
        return header + Protocol.SEPARETOR + value + "\n";
    }

    private String endMessaging(){
        return  lineformating(Protocol.Header.END, "end");
    }

    public String parseToStringLogin(String sender, String id, String pw){
        String msg = "";
        msg += lineformating(Protocol.Header.METHOD, Protocol.Method.LOGIN);
        msg += lineformating(Protocol.Header.SENDER, sender);
        msg += lineformating(Protocol.Header.CUSTOMERID, id);
        msg += lineformating(Protocol.Header.CUSTOMERPW, pw);
        msg += endMessaging();
        return msg;
    }

    public String parseToReplyLogin(Customer customer){
        String msg = "";
        if(customer != null){
            msg += lineformating(Protocol.Header.RESULT, Protocol.Result.OK);
            msg += lineformating(Protocol.Header.CUSTOMERFNAME, customer.getFirstname());
            msg += lineformating(Protocol.Header.CUSTOMERLNAME, customer.getLastname());
        }else{
            msg += lineformating(Protocol.Header.RESULT, Protocol.Result.IDORPW_NOTFOUND);
        }
        msg += endMessaging();
        return  msg;
    }

    public String parseToStringWallet(String id, String sender){
        String msg = "";
        msg += lineformating(Protocol.Header.METHOD, Protocol.Method.WALLET);
        msg += lineformating(Protocol.Header.SENDER, sender);
        msg += lineformating(Protocol.Header.CUSTOMERID, id);
        msg += endMessaging();
        return msg;
    }


    public String parseToStringCredits(String gameName, String sender, String gameID, String gamePackage, String net, String walletID){
        String msg = "";
        msg += lineformating(Protocol.Header.METHOD, Protocol.Method.CREDITS);
        msg += lineformating(Protocol.Header.SENDER, sender);
        msg += lineformating(Protocol.Header.GAMENAME, gameName);
        msg += lineformating(Protocol.Header.GAMEID, gameID);
        msg += lineformating(Protocol.Header.GAMEPACKAGE, gamePackage);
        msg += lineformating(Protocol.Header.NET, net);
        msg += lineformating(Protocol.Header.WALLETID, walletID);
        msg += endMessaging();
        return msg;
    }

    /**
     * parse string for response from server
     * @param type
     * @param list
     * @return
     */
    public String parseToReplyList(String type, String list){
        String msg = "";
        msg += lineformating(Protocol.Header.RESULT, Protocol.Result.OK);
        msg += lineformating(Protocol.Header.METHOD, Protocol.Method.REPLY);
        msg += lineformating(Protocol.Header.TYPE, type);
        msg += lineformating(Protocol.Header.LIST, list);
        msg += endMessaging();
        return msg;
    }


    public String parseToReplyAvailable(Boolean isAvailable){
        String msg = "";
        if (isAvailable)
            msg += lineformating(Protocol.Header.RESULT, Protocol.Result.OK);
        else{
            msg += lineformating(Protocol.Header.RESULT, Protocol.Result.BALANCE_NOTENOUGH);
        }
        msg += endMessaging();
        return msg;
    }

    public String parseToStringReport(String sender, String id){
        String msg = "";
        msg += lineformating(Protocol.Header.METHOD, Protocol.Method.REPORT);
        msg += lineformating(Protocol.Header.SENDER, sender);
        msg += lineformating(Protocol.Header.CUSTOMERID, id);
        msg += endMessaging();
        return msg;
    }

//    public Customer parseToLogin(Map<String, String> map){
//
//    }

    public Map<String, String> parseRequestToMap(BufferedReader reader){
        Map<String, String> map = new HashMap<String, String>();
        String line = null;
        try {
            while((line = reader.readLine()) != null){
                System.out.println(line);
                String[] msg = line.split(Protocol.SEPARETOR);
                if(Protocol.Header.END.equals(msg[0]))
                    break;

                map.put(msg[0], msg[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;

    }



}
