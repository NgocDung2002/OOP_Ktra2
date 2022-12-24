package OnTap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Mobile extends Product implements MobileManager, Comparable<Mobile>{
	private String color;
	private double screen_size, weight;
	
	public Mobile() {
	
	}
	
	public Mobile(String product_id, String product_name, double product_price, int product_total, String color,
			double screen_size, double weight) {
		super(product_id, product_name, product_price, product_total);
		this.color = color;
		this.screen_size = screen_size;
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getScreen_size() {
		return screen_size;
	}
	public void setScreen_size(double screen_size) {
		this.screen_size = screen_size;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return super.toString() + " " + color + " " + screen_size + " " + weight;
	}

	ArrayList<Mobile> listMobile = new ArrayList<>();
	
	public void display() {
		for (Mobile mobile : listMobile) {
			System.out.println(mobile.toString());
		}
	}
	
	Scanner scanner = new Scanner(System.in);
	public Mobile input() {
		System.out.print("Enter product_id: "); String product_idString = scanner.next();
		System.out.print("Enter product_name: "); String product_name = scanner.next();
		System.out.print("Enter product_price: "); double product_price = scanner.nextDouble();
		System.out.print("Enter product_total: "); int product_total = scanner.nextInt();
		System.out.print("Enter color: "); String color = scanner.next();
		System.out.print("Enter screen_size: "); double screen_size = scanner.nextDouble();
		System.out.print("Enter weight: "); double weight = scanner.nextDouble();
		Mobile mobile = new Mobile(product_idString, product_name, product_price, product_total, color, screen_size, weight);
		return mobile;
	}
	
	@Override
	public boolean addMobile(Mobile m) {
		this.listMobile.add(m);
		return true;
	}

	@Override
	public boolean editMobile(String id) {
		int ktra = 0;
		for(int i=0; i<listMobile.size(); i++) {
			if(listMobile.get(i).getProduct_id().equals(id)) {
				listMobile.set(i, this.input());
				ktra=1;
			}
		}
		if(ktra==0) {
			System.out.println("Khong co thong tin can sua");
		}else if(ktra==1){
			System.out.println("Cap nhap thanh cong");
		}
		return true;
	}

	@Override
	public boolean delMobile(String id) {
		int ktra = 0;
		for(int i=0; i<listMobile.size(); i++) {
			if(listMobile.get(i).getProduct_id().equals(id)) {
				listMobile.remove(i);
				ktra=1;
			}
		}
		if(ktra==0) {
			System.out.println("Khong co thong tin can xoa");
		}else if(ktra==1){
			System.out.println("Xoa thanh cong");
		}
		return true;
	}

	@Override
	public ArrayList<Mobile> searchMobile(String name) {
		int ktra=0;
		for (Mobile mobile : listMobile) {
			if(mobile.getProduct_name().equals(name)) {
				System.out.println("Thong tin san pham tim kiem");
				System.out.println(mobile.toString());
				System.out.println();
				ktra=1;
			}
		}
		if (ktra==0) {
			System.out.println("Khong co thong tin tim kiem");
		}
		return listMobile;
	}
	
	@Override
	public int compareTo(Mobile o) {
		// TODO Auto-generated method stub
		return (int)this.getProduct_price() - (int)o.getProduct_price();
	}

	@Override
	public ArrayList<Mobile> sortedMobile(double price) {
		Collections.sort(listMobile);
		return listMobile;
	}

	

}
