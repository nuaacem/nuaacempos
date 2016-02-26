package nuaa.ggx.pos.collector.soap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientCall {
	 /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springcontext-config.xml");   
  
        IWSTest client = (IWSTest)context.getBean("sayHello2");   
        String response = client.sayHello("World");   
        System.out.println("Response: " + response);   
        System.exit(0);  
    }  
}
