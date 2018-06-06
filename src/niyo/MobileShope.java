package niyo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MobileShope {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine()); // Reading input from STDIN

		Map<Phone, Map<Double, Integer>> phonemap = new HashMap<Phone, Map<Double, Integer>>();

		for (int i = 0; i < N; i++) {
			String s[] = br.readLine().split(" ");
			Phone p = new Phone();
			p.setOperatingSystem(s[0]);
			p.setRam(Integer.parseInt(s[1]));
			p.setMemory(Integer.parseInt(s[2]));
			p.setPrice(Double.parseDouble(s[3]));
			p.setRating(Integer.parseInt(s[4]));
			if (phonemap.get(p) == null) {
				Map<Double, Integer> priceRatingMap = new HashMap<Double, Integer>();
				priceRatingMap.put(p.getPrice(), p.getRating());
				phonemap.put(p, priceRatingMap);

			} else {
				Map<Double, Integer> prMap = phonemap.get(p);
				if (prMap.get(p.getPrice()) == null) {
					prMap.put(p.getPrice(), p.getRating());
				} else {
					if (p.getRating() > prMap.get(p.getPrice())) {
						prMap.put(p.getPrice(), p.getRating());
					}
				}
			}
		}

		long t = Long.parseLong(br.readLine());

		while (t-- > 0) {
			Phone p = new Phone();
			String s[] = br.readLine().split(" ");
			p.setOperatingSystem(s[0]);
			p.setRam(Integer.parseInt(s[1]));
			p.setMemory(Integer.parseInt(s[2]));
			p.setPrice(Double.parseDouble(s[3]));

			Map<Double, Integer> prMap = phonemap.get(p);

			int maxRating = -1;
			if (prMap != null) {
				for (Entry<Double, Integer> pr : prMap.entrySet()) {
					if (p.price >= pr.getKey()) {
						maxRating = pr.getValue() > maxRating ? pr.getValue() : maxRating;
					}
				}
			}
			System.out.println(maxRating);
		}

	}

}

class Phone implements Comparable<Phone> {
	String operatingSystem;
	int ram;
	int memory;
	Double price;
	int rating;

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getRating() {
		return rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + memory;
		result = prime * result + ((operatingSystem == null) ? 0 : operatingSystem.hashCode());
		result = prime * result + ram;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		if (memory != other.memory)
			return false;
		if (operatingSystem == null) {
			if (other.operatingSystem != null)
				return false;
		} else if (!operatingSystem.equals(other.operatingSystem))
			return false;
		if (ram != other.ram)
			return false;
		return true;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public int compareTo(Phone o) {
		if (this.rating < o.rating) {
			return 1;
		} else if (this.rating == o.rating) {
			return 0;
		} else {
			return -1;
		}
	}

}
