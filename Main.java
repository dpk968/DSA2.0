
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.Random;
import java.util.stream.Collectors;

class Transaction {
	String upiId;
	int amount;
	String date;	

	Transaction(String upiId, int amount, String date) {
		this.upiId = upiId;
		this.amount = amount;
		this.date = date;
	}

	public String getUpiId() {
		return upiId;
	}

	public int getAmount() {
		return amount;
	}

	public String getDate() {
		return date;
	}
}
public class Main {
    public static void main(String[] args) {

		List<Transaction> list = Arrays.asList(
    new Transaction("dpk@sbi", 1256, "2024-01"),
    new Transaction("dpk@sbi", 2000, "2024-01"),
    new Transaction("dpk@sbi", 1900, "2024-01"),
    new Transaction("dpk@sbi", 1000, "2024-02"),
    new Transaction("dpk@sbi", 500, "2024-02"),
				new Transaction("dpk@sbi", 1000, "2024-02"),
				new Transaction("dpk@sbi", 500, "2024-02"),
				new Transaction("dpk@sbi", 1000, "2024-02"),
				new Transaction("dpk@sbi", 500, "2024-02"),
				new Transaction("dpk@sbi", 500, "2024-02"),
				new Transaction("dpk@sbi", 500, "2024-02"),
				new Transaction("dpk@sbi", 500, "2024-02"),
				new Transaction("dpk@sbi", 500, "2024-02"),

    new Transaction("aarti@axis", 4500, "2024-02"),
    new Transaction("aarti@axis", 1000, "2024-02"),
    new Transaction("aarti@axis", 700, "2024-01"),

    new Transaction("devyani@icici", 2000, "2024-05"),
    new Transaction("devyani@icici", 1800, "2024-05"),
    new Transaction("devyani@icici", 1500, "2024-05"),

    new Transaction("john@upi", 600, "2024-06"),
    new Transaction("john@upi", 300, "2024-06"),
    new Transaction("john@upi", 100, "2024-07"),

    new Transaction("ravi@paytm", 2600, "2024-03"),
    new Transaction("ravi@paytm", 2600, "2024-03"),
    
    new Transaction("nina@kotak", 3200, "2024-04"),
    new Transaction("nina@kotak", 1800, "2024-04"),
    new Transaction("nina@kotak", 1000, "2024-05"),
    
    new Transaction("sumit@ybl", 4900, "2024-01"),
    new Transaction("sumit@ybl", 200, "2024-01"),
    new Transaction("sumit@ybl", 300, "2024-01"),

    new Transaction("priya@sbi", 900, "2024-01"),
    new Transaction("priya@sbi", 800, "2024-02"),
    new Transaction("priya@sbi", 1000, "2024-02"),
    
    new Transaction("anil@hdfc", 6000, "2024-03"),
    new Transaction("anil@hdfc", 300, "2024-04"),

    new Transaction("rahul@axis", 499, "2024-02"),
    new Transaction("rahul@axis", 10, "2024-02"),

    new Transaction("megha@icici", 1000, "2024-06"),
    new Transaction("megha@icici", 4500, "2024-06"),

    new Transaction("amit@upi", 600, "2024-03"),
    new Transaction("amit@upi", 4000, "2024-03"),

    new Transaction("sana@paytm", 3000, "2024-05"),
    new Transaction("sana@paytm", 2500, "2024-05"),

    new Transaction("neha@kotak", 4000, "2024-02"),
    new Transaction("neha@kotak", 1100, "2024-02"),

    new Transaction("suresh@ybl", 1000, "2024-04"),
    new Transaction("suresh@ybl", 2000, "2024-04"),
    new Transaction("suresh@ybl", 2500, "2024-04"),

    new Transaction("deepak@sbi", 2000, "2024-01"),
    new Transaction("deepak@sbi", 2500, "2024-01"),
    new Transaction("deepak@sbi", 600, "2024-01"),

    new Transaction("rohit@hdfc", 1000, "2024-06"),
    new Transaction("rohit@hdfc", 2500, "2024-06"),
    new Transaction("rohit@hdfc", 1800, "2024-06"),

    new Transaction("muskan@axis", 400, "2024-07"),
    new Transaction("muskan@axis", 4000, "2024-07"),
    new Transaction("muskan@axis", 700, "2024-07")
);

		Map<String,List<Transaction>> map = new HashMap<>();

		for(Transaction t:list){
            if(map.containsKey(t.getUpiId()+"_"+t.getDate())){
				map.get(t.getUpiId()+"_"+t.getDate()).add(t);
			}else{
				map.put(t.getUpiId()+"_"+t.getDate(),new ArrayList<>());
				map.get(t.getUpiId()+"_"+t.getDate()).add(t);
			}
			
		}

		Set<String> ans = new HashSet<>();
		for (String k: map.keySet()){
			Map<String,Integer> temp = new HashMap<>();
			if(map.get(k).size()>5){
				for(Transaction t: map.get(k)){
					if(temp.containsKey(t.getDate())){
						int sum = temp.get(t.getDate());
						int curr = t.getAmount();
						if(sum+curr > 5000){
							ans.add(t.getUpiId());
						}else{
							temp.put(t.getDate(),sum+curr);
						}
					}else{
						temp.put(t.getDate(),t.getAmount());
					}
				}
			}

		}

		System.out.println(ans);

	}

	

	public static List<Integer> sortedArray(int []a, int []b) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i<a.length && j<b.length){
            if(a[i]<=b[j]){
				if(!ans.contains(a[i]))
                	ans.add(a[i]);
                i++;
            }else{
				if(!ans.contains(b[j])){
					ans.add(b[j]);
				}
				j++;
            }
        }

        while(i<a.length){
			if(!ans.contains(a[i]))
                	ans.add(a[i]);
                i++;
        }
        while(j<b.length){
            if(!ans.contains(b[j])){
				ans.add(b[j]);
			}
			j++;
        }

        return ans;
    }

}
