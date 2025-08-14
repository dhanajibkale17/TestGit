package Test;


import org.testng.annotations.*;

public class TestNG1 {

	/*
	 * @Test public void a2() { System.out.println("a2 test method"); }
	 */

	
	@BeforeSuite
	public void a() {
		System.out.println("@BeforeSuite Method");
	}
	@BeforeTest
	public void b() {
		System.out.println("@BeforeTest Method");
	}
	@BeforeClass
	public void c() {
		System.out.println("@BeforeClass Method");
	}
	@BeforeMethod
	public void d() {
		System.out.println("@BeforeMethod Method");
	}
	@Test
	public void a1() {
		System.out.println("a1 test method");
	}
	
	
	@AfterMethod
	public void e() {
		System.out.println("@AfterMethod Method");
	}
	@AfterClass
	public void f() {
		System.out.println("@AfterClass Method");
	}	
	@AfterTest
	public void g() {
		System.out.println("@AfterTest Method");
	}	
	@AfterSuite
	public void h() {
		System.out.println("@AfterSuite Method");
	}
	
	public static void main(String[] args) {
		System.out.println("Hello Main Method");
	}
}
