package protocol;

public class Protocol {

    public static final String SEPARETOR = ":";

    public static class Header{
        public static final String RESULT = "result";
        public static final String METHOD = "method";
        public static final String TYPE = "type";
        public static final String SENDER = "sender";
        public static final String GAMENAME = "n-game";
        public static final String GAMEID = "id-game";
        public static final String GAMEPACKAGE = "p-game";
        public static final String NET = "net";
        public static final String WALLETID = "id-wallet";
        public static final String CUSTOMERID = "id-customer";
        public static final String CUSTOMERPW = "pw-customer";
        public static final String END = "end";

    }

    public static class Result{
        public static final String OK = "200 OK";
        public static final String DATABASE_ERROR = "400 DATABASE ERROR";
        public static final String IDORPW_NOTFOUND = "600 ID OR PASSWORD NOT FOUND";
        public static final String BALANCE_NOTENOUGH = "800 BALANCE NOT ENOUGH";
    }

    public static class Method{
        public static final String LOGIN = "login";
        public static final String CREDITS = "credits";
        public static final String REPORT = "report";
        public static final String REPLY = "reply";
    }

    public static class Type{
        public static final String WALLETLIST = "wallet-list";
        public static final String REPORTLIST = "report-list";
    }




}
