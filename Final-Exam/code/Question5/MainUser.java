import java.util.*;
public class MainUser {
    public static void main(String[] args) {
        UserManagement userMana = new UserManagement("User.txt","UserEdge.txt");
        userMana.printGraph();
        System.out.println("the neighbors of user:");
        ArrayList<User> list = userMana.friendListOfUser(24016); // id of user1
        for(User u : list) {
            System.out.println(u);
        }

        System.out.println();

        int count = userMana.countMutualFriend(24012,24013); //id of user 12 and user 17
        System.out.println("Amount the mutual friend of two user: "+count);
    }
}
