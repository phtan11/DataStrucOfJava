import java.io.*;
import java.util.*;

public class RatingQuery {
    private ArrayList<Rating> edges;
    private ArrayList<Product> productList;
    private ArrayList<Customer> customerList;

    public RatingQuery(String customerPath, String productPath, String ratingPath){
        edges = new ArrayList<Rating>();
        productList = new ArrayList<Product>();
        customerList = new ArrayList<Customer>();
        readCustomerFile(customerPath);
        readProductFile(productPath);
        buildGraph(ratingPath);
    }

    public void printGraph(){
		for(int i = 0; i < edges.size(); i++){
			System.out.println(edges.get(i));
		}
	}

    public boolean readCustomerFile(String filePath){
        try{
            File f = new File(filePath);
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                String content = sc.nextLine();
                String[] attributes = content.split(",");
                Customer tmpCustomer = new Customer(attributes[0], attributes[1], attributes[2]);
                customerList.add(tmpCustomer);
            }
            sc.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            return false;
        } 
        return true;
    }

    public boolean readProductFile(String filePath){
        try{
            File f = new File(filePath);
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                String content = sc.nextLine();
                String[] attributes = content.split(",");
                Product tmpProduct = new Product(Integer.parseInt(attributes[0]), attributes[1], attributes[2]);
                productList.add(tmpProduct);
            }
            sc.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            return false;
        } 
        return true;
    }

    public void addEdge(Customer u, Product v, int w){
		edges.add(new Rating(u,v,w));
	}

    public boolean buildGraph(String filePath){
        try{
            File f = new File(filePath);
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                String content = sc.nextLine();
                String[] attributes = content.split(",");
                Customer tmpCustomer = new Customer();
                Product tmpProduct = new Product();
                for(Customer c : customerList){
                    if(c.getCustomerId().equals(attributes[0]))
                        tmpCustomer = c;
                }
                for(Product p : productList){
                    if(p.getProductId() == Integer.parseInt(attributes[1]))
                        tmpProduct = p;
                }
                addEdge(tmpCustomer, tmpProduct, Integer.parseInt(attributes[2]));
            }
            sc.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            return false;
        } 
        return true;
    }

    public ArrayList<Product> query1(String customerId){
        ArrayList<Product> pro1 = new ArrayList<Product>();
        for(int i = 0; i < edges.size(); i++){
            if(edges.get(i).getRate() >= 3){
                if(customerId.equals(edges.get(i).getCustomer().getCustomerId()))
                    pro1.add(edges.get(i).getProduct());
            }
        }
        return pro1;
    }

    public Integer query2(int productId){
        Integer c = 0;
        for(int i = 0; i < edges.size(); i++){
            if(productId == edges.get(i).getProduct().getProductId()){
                if( edges.get(i).getCustomer().getGender().equals("M")){
                    if(edges.get(i).getRate() >= 3){
                        c = c+1;
                    }
                }
            }
        }
        return c;
    }

    public ArrayList<Product> query3(){
        ArrayList<Product> listProduct =new ArrayList<Product>();
        int Female ;
        int Male ;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < productList.size(); i++){
            Female=0;
            Male=0;
            boolean check = true;
            if(i==0){ list.add(productList.get(i).getProductId()); }
            int z =productList.get(i).getProductId();
            if(i > 0){
                for(int j = 0;j<list.size();j++){
                    if(list.get(j) ==z){
                        check = false;
                        break;
                    }
                }
                if(check == true){
                    list.add(z); 
                }
            }
            if(check==true){
                for(int j = 0; j < edges.size(); j++){
                    if(z == edges.get(j).getProduct().getProductId()){
                        if(edges.get(j).getCustomer().getGender().equals("F")){
                            Female++;
                        }
                        else{
                            Male++;
                        }
                    }
                }
                if(Female >= Male){
                    listProduct.add(productList.get(i));
                }
            }
            else{
                continue;
            }
        }
        return listProduct;
    }

    public <E> boolean writeFile(String filePath, ArrayList<E> list){
        try{
            File f = new File(filePath);
            FileWriter fw = new FileWriter(f);
            if(list.size() == 0){
                fw.write("No item here");
                fw.close();
                return true;
            }
            for(E data : list){
                fw.write(data + "\n");
            }
            fw.close();
        }catch(IOException e){
            System.out.println("Can't write file");
            return false;
        }

        return true;
    }

    public <E> boolean writeFile(String filePath, E data){
        try{
            File f = new File(filePath);
            FileWriter fw = new FileWriter(f);
            fw.write(data.toString());
            fw.close();
        }catch(IOException e){
            System.out.println("Can't write file");
            return false;
        }
        return true;    
    }
}
