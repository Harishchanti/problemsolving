import java.io.IOException;
import java.math.BigDecimal;

public class Test {

	public static void main(String[] args) throws IOException {
		BigDecimal discount = new BigDecimal("29.67");
		BigDecimal tdiscount = discount.setScale(2, BigDecimal.ROUND_HALF_EVEN);

		tdiscount = discount.setScale(2, BigDecimal.ROUND_FLOOR);
		System.out.println(tdiscount);
	}

}
