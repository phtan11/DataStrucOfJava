import java.util.*;
import java.io.*;
public class UserManagement {
    private ArrayList<User> userList;
    private ArrayList<UserEdge> userEdges;
    public UserManagement(String USerpath,String UserEdgepath){
        userList = new ArrayList<User>();
        userEdges = new ArrayList<UserEdge>();
        readUserFile(USerpath);
        CreateGraph(UserEdgepath);
    }
    public boolean readUserFile(String filepath){
        try{
            File file = new File(filepath);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String row = sc.nextLine();
                String[] attributes = row.split(",");
                User tmpUser = new User(Integer.parseInt(attributes[0]), attributes[1], Integer.parseInt(attributes[2]), attributes[3],attributes[4]);
                userList.add(tmpUser);
            }
            sc.close();
        }catch(FileNotFoundException  e){
            System.out.println("file's not found!");
            return false;
        }
        return true;
    }
    public void addEgde(User user1, User user2){
        userEdges.add(new UserEdge(user1, user2));
    }
    public boolean CreateGraph(String filepath){
        try{
            File file= new File(filepath);
            Scanner scanner= new Scanner(file);
            while(scanner.hasNextLine()){
                User user1 = new User();
                User user2 = new User();
                String ch = scanner.nextLine();
                String[] attributes = ch.split(",");
                for(User u : userList){
                    if(u.getUserID() == Integer.parseInt(attributes[0])){
                        user1 = u;
                    }
                }
                for(User u : userList){
                    if(u.getUserID() == Integer.parseInt(attributes[1])){
                        user2 = u;
                    }
                }
                addEgde(user1, user2);
            }
            scanner.close();
        }catch(FileNotFoundException e){
            System.out.println("file's not found");
            return false;
        }
        return true;
    }
    public void printGraph(){
        for(UserEdge s : userEdges){
            System.out.println(s);
        }
    }
    //5b
    public ArrayList<User> friendListOfUser(int userID){
        ArrayList<User> list = new ArrayList<User>();
        ArrayList<Integer> userIds = new ArrayList<Integer>(); // chứa tạm cái userID để sort theo thứ tự
        
        for(UserEdge a: userEdges){
            if(a.getUser1().getUserID() == userID){
                userIds.add(a.getUser2().getUserID());
            }
            if(a.getUser2().getUserID() == userID){
                userIds.add(a.getUser1().getUserID());
            }
        }

        Collections.sort(userIds);

        for(Integer a: userIds){
            for(User d : userList){
                if(a == d.getUserID()){
                    list.add(d);
                }
            }
        }
        
        return list;
    }
    
    //5c
    public Integer countMutualFriend(int userID1, int userID2){
        int count = 0;
        
        ArrayList<Integer> userIds1 = new ArrayList<Integer>();
        for(UserEdge a: userEdges){
            if(a.getUser1().getUserID() == userID1){
                userIds1.add(a.getUser2().getUserID());
            }
            if(a.getUser2().getUserID() == userID1){
                userIds1.add(a.getUser1().getUserID());
            }
        }
        
        ArrayList<Integer> userIds2 = new ArrayList<Integer>();
        for(UserEdge a: userEdges){
            if(a.getUser1().getUserID() == userID2){
                userIds2.add(a.getUser2().getUserID());
            }
            if(a.getUser2().getUserID() == userID2){
                userIds2.add(a.getUser1().getUserID());
            }
        }
        //sort two UserID1 and 2
        Collections.sort(userIds1);
        Collections.sort(userIds2);
        //check userID1 and UserId2 which have many the mutual friend?
        for(Integer a: userIds1){
            for(Integer b: userIds2){
                if(a.intValue() == b.intValue()){
                    count = count +1;
                }
            }
        }
        return count;
    }
}