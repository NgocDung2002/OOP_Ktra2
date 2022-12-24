package OnTap;

import java.util.List;

public interface MobileManager {
	public boolean addMobile(Mobile m);
	public boolean editMobile(String id); 
	public boolean delMobile(String id);
	public List<Mobile> searchMobile(String name);
	public List<Mobile> sortedMobile(double price);
}
