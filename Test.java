package OnTap;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Mobile mobile = new Mobile();
		
		Mobile[] list = new Mobile[5];
		// Danh sach ten Mobile
		String[] name = {"Iphone 5", "Iphone 5s", "Iphone 6", "Iphone 6s plus", "Iphone 7", "Iphone 7s plus", "Iphone 8", "Iphone X", "Iphone XS", "Iphone XR",
						"Iphone 11", "Iphone 11 pro", "Iphone 11 pro max", "Iphone 14 pro", "Samsung Glaxy S7", "Samsung Glaxy S10", "Samsung Glaxy S8"};
		String[] color = {"Violet", "Wirte", "Black", "Yellow", "Pink", "Siler", "Green", "Blue", "Red", "Grey"};
		
		double[] screen_size = {15.6, 16.0, 18.0, 14.7, 14.0};
		
		double[] weight = {1.05, 1.06, 1.21, 1.6, 1.08, 0.8, 0.9, 1.0};
		
		int index, count=0;
		for(int i=0; i<list.length; i++) {
			list[i] = new Mobile();
			
			list[i].setProduct_id("SP" + (++count));
			
			index = (int)(Math.random() * name.length);
			list[i].setProduct_name(name[index]);
			
			list[i].setProduct_price(1000 + (Math.random() * 2000));
			
			list[i].setProduct_total(10 + (int)(Math.random() * 30));
			
			index = (int)(Math.random() * color.length);
			list[i].setColor(color[index]);
			
			index = (int)(Math.random() * screen_size.length);
			list[i].setScreen_size(screen_size[index]);
			
			index = (int)(Math.random() * weight.length);
			list[i].setWeight(weight[index]);
		}
		
		for(int i=0; i<5; i++)
			mobile.listMobile.add(list[i]);
		
		Scanner sc = new Scanner(System.in);
		int luachon=1;
		do {
			System.out.println("1. Add Mobile");
			System.out.println("2. Edit Mobile");
			System.out.println("3. Delete Mobile");
			System.out.println("4. Search Mobile");
			System.out.println("5. Sort Mobile_price");
			System.out.println("0. Exit");
			System.out.print("Enter: ");
			luachon = sc.nextInt();
			if(luachon==1) {
				mobile.addMobile(mobile.input());
			}else if(luachon==2) {
				System.out.println("nhap vao thong tin can sua cua mobile:");
				System.out.println("nhap product_id: ");
				String temp_idString = sc.next();
				mobile.editMobile(temp_idString);
				
			}else if(luachon==3) {
				System.out.println("nhap vao thong tin can xoa cua mobile:");
				System.out.println("nhap product_id: ");
				String temp_idString = sc.next();
				mobile.delMobile(temp_idString);
			}else if(luachon==4) {
				System.out.println("nhap vao thong tin ten can tim kiem:");
				System.out.println("nhap product_name: ");
				String temp_nameString = sc.next();
				mobile.searchMobile(temp_nameString);
			}else if(luachon==5) {
				mobile.sortedMobile(2.0);
				mobile.display();
			}else if(luachon==0)
				break;
		}while(luachon!=0);
	}
}
