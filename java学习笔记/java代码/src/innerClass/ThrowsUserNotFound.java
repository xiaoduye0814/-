package innerClass;

public class ThrowsUserNotFound {

    public void f1() throws UserNotFoundException {
        int a = 1;
        if (a == 1) {
            throw new UserNotFoundException("用户不存在");
        }
    }

    public static void main(String[] args) throws UserNotFoundException {
        ThrowsUserNotFound th = new ThrowsUserNotFound();
        th.f1();
    }
}
