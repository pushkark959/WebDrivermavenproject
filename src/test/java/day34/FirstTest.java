package day34;

import org.testng.annotations.Test;

public class FirstTest {
  @Test(priority=1)
   void openapp() 
  {
	  System.out.println("Testing1");
  }
  
  @Test(priority=2)
  void login()
  {
	  System.out.println("Testing2");
  }
  
  @Test(priority=3)
  void close()
  {
	  System.out.println("Testing3");
  }
  
}
