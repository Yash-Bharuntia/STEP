package week3.assignmentProblems;

import java.util.*;
class Product{
    String id;
    String name;
    double price;
    String category;
    int stock;
    static int count=0;
    static String[] categories=new String[]{"Electronics","Books","Clothes","Home"};
    public Product(String id,String name,double price,String category,int stock){
        this.id=id;
        this.name=name;
        this.price=price;
        this.category=category;
        this.stock=stock;
        count++;
    }
    public static void listCategories(){
        for(String c:categories) System.out.println(c);
    }
    public static int totalProducts(){
        return count;
    }
}
class ShoppingCart{
    String cartId;
    String customer;
    Product[] items;
    int[] qty;
    double total;
    int size;
    public ShoppingCart(String cartId,String customer){
        this.cartId=cartId;
        this.customer=customer;
        this.items=new Product[50];
        this.qty=new int[50];
        this.total=0;
        this.size=0;
    }
    public int find(String productId){
        for(int i=0;i<size;i++) if(items[i].id.equals(productId)) return i;
        return -1;
    }
    public void addProduct(Product p,int q){
        if(p.stock>=q && q>0){
            int i=find(p.id);
            if(i==-1){
                items[size]=p;
                qty[size]=q;
                size++;
            }else{
                qty[i]+=q;
            }
            p.stock-=q;
            total+=p.price*q;
        }
    }
    public void removeProduct(String productId){
        int i=find(productId);
        if(i!=-1){
            items[i].stock+=qty[i];
            total-=items[i].price*qty[i];
            for(int j=i;j<size-1;j++){
                items[j]=items[j+1];
                qty[j]=qty[j+1];
            }
            size--;
        }
    }
    public void viewCart(){
        System.out.println("Cart "+cartId+" for "+customer);
        for(int i=0;i<size;i++){
            System.out.println(items[i].id+" "+items[i].name+" x"+qty[i]+" = "+(items[i].price*qty[i]));
        }
        System.out.println("Total: "+total);
    }
    public void checkout(){
        System.out.println("Checked out. Total paid: "+total);
        items=new Product[50];
        qty=new int[50];
        size=0;
        total=0;
    }
}
public class Assignment2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Product[] catalog=new Product[]{
            new Product("P1","Phone",15000,"Electronics",10),
            new Product("P2","Laptop",55000,"Electronics",5),
            new Product("P3","Novel",500,"Books",20),
            new Product("P4","T-Shirt",700,"Clothes",30),
            new Product("P5","Mixer",2500,"Home",8),
            new Product("P6","Headphones",1200,"Electronics",15),
            new Product("P7","Jeans",1600,"Clothes",18),
            new Product("P8","Cookbook",800,"Books",12),
            new Product("P9","Lamp",900,"Home",10),
            new Product("P10","Router",2000,"Electronics",9)
        };
        ShoppingCart cart=new ShoppingCart("C1","Customer");
        while(true){
            System.out.println("1 Browse 2 Add 3 Remove 4 View 5 Checkout 6 Categories 0 Exit");
            int ch=sc.nextInt();
            if(ch==1){
                for(Product p:catalog) System.out.println(p.id+" "+p.name+" "+p.category+" Rs."+p.price+" Stock:"+p.stock);
            }else if(ch==2){
                String id=sc.next();
                int q=sc.nextInt();
                Product sel=null;
                for(Product p:catalog) if(p.id.equals(id)) sel=p;
                if(sel!=null) cart.addProduct(sel,q);
            }else if(ch==3){
                String id=sc.next();
                cart.removeProduct(id);
            }else if(ch==4){
                cart.viewCart();
            }else if(ch==5){
                cart.viewCart();
                cart.checkout();
            }else if(ch==6){
                Product.listCategories();
                System.out.println("Total products: "+Product.totalProducts());
            }else if(ch==0){
                break;
            }
        }
        sc.close();
    }
}