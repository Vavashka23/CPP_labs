package Check;

public class AccessPoint {
    private boolean internetAccess;
    private boolean phoneAccess;
    public AccessPoint() {
        this.internetAccess = true;
        this.phoneAccess = true;
    }
    // 0 - всё доступно; 1 - занят интернет, но телефон свободен; 2 - занят телефон; 3 - чёто другое;
    public int check() {
        if(internetAccess && phoneAccess) return 0;
        else if(!internetAccess && phoneAccess) return 1;
        else if(!phoneAccess) return 2;
        else return 3;
    }
}
