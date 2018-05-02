package Check;

public class AccessPoint {
    public static boolean internetAccess = true;
    public static boolean phoneAccess = true;
    // 0 - всё доступно; 1 - занят интернет, но телефон свободен; 2 - занят телефон;
    public int check() {
        if(internetAccess && phoneAccess) return 0;
        else if(!internetAccess && phoneAccess) return 1;
        else return 2;
    }
}
