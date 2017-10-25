package protocol;

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

    /**
     * parse string for response from server
     * @param type
     * @param list
     * @return
     */
    public String parseToStringReply(String type, String list){
        String msg = "";
        msg += lineformating(Protocol.Header.RESULT, Protocol.Result.OK);
        msg += lineformating(Protocol.Header.METHOD, Protocol.Method.REPLY);
        msg += lineformating(Protocol.Header.TYPE, type);
        msg += lineformating(Protocol.Header.WALLETID, list);
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

    public String parseToStringAvailable(Boolean isAvailable){
        String msg = "";
        if (isAvailable)
            msg += lineformating(Protocol.Header.RESULT, Protocol.Result.OK);
        else
            msg += lineformating(Protocol.Header.RESULT, Protocol.Result.BALANCE_NOTENOUGH);
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



}
