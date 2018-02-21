import org.testng.annotations.Test;
import org.testng.*;

public class WeirdStringTests {
	@Test
	public void testNoel() {
		String noel = "noël";
		String noel2 = "noe\u0308l";
		Assert.assertEquals(noel, noel2);
		Assert.assertEquals(noel.length(), 5);
		String reverse = new StringBuilder(noel).reverse().toString();
		Assert.assertEquals(reverse.length(), 5);
		// Fails:
		// Assert.assertEquals(reverse,"lëon");
	}

	@Test
	public void testNoelAnders() {
		String s = "Noël";
		Assert.assertEquals(4, s.length());
		String s2 = new StringBuilder(s).reverse().toString();
		Assert.assertEquals("lëoN", s2);
		Assert.assertEquals(s2.length(), 4);
	}

	@Test
	public void testCats() {
		String s = "😸😾";
		Assert.assertEquals(s.length(), 4);
		String s2 = new StringBuilder(s).reverse().toString();
		Assert.assertEquals("😾😸", s2);
		Assert.assertEquals(s2.length(), 4);
	}

	@Test
	public void testBaffle() {
		String baffle = "baﬄe";
		Assert.assertEquals(baffle.length(), 4);
		Assert.assertEquals(baffle.substring(3), "e");
		Assert.assertEquals(baffle.substring(0, 3), "baﬄ");
		String upper = baffle.toUpperCase();
		Assert.assertEquals("BAFFLE", upper);
		Assert.assertEquals(upper.length(), 6);
		// Fails:
		// Assert.assertEquals(upper.toLowerCase(), baffle);
	}

	@Test
	public void testCompare() {
		String s1 = "noël";
		String s2 = "noël";
		Assert.assertEquals(s1.length(), 5);
		Assert.assertEquals(s2.length(), 4);
		// Both Fail:
		// Assert.assertTrue(s1.equalsIgnoreCase(s2));
		// Assert.assertEquals(s1, s2);
	}
}
