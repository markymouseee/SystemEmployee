package model;

public class Session {
    private static int userId;
    private static String role;
    private static String username;

    public static int getUserID(){
        return userId;
    }

    public static String getRole(){
        return role;
    }

    public static void setRole(String role){
        Session.role = role;
    }

    public static void setUserID(int userID) {
        Session.userId = userID;
    }

    public static String getUsername(){
        return username;
    }

    public static void setUsername(String username){
        Session.username = username;
    }

    public static void clearSession(){
        userId = 0;
        role = null;
    }
}
