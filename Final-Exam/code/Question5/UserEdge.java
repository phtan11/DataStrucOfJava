public class UserEdge {
    User user1;
    User user2;
    public UserEdge(User user1,User user2) {
        setUser1(user1);
        setUser2(user2);
    }
    public User getUser1() {
        return this.user1;
    }
    public void setUser1(User user1) {
        this.user1 = user1;
    }
    public User getUser2() {
        return this.user2;
    }
    public void setUser2(User user2) {
        this.user2 = user2;
    }
    @Override
    public String toString() {
        return  user1 +"," + user2; 
    }
}
