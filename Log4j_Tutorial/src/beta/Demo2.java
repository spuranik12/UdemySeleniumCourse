package beta;
import org.apache.logging.log4j.*;


public class Demo2 {

	//1- Define logManager to get access of desired class. Here logManager is API in which getLogger is function
	//to call class with getName method. all this is stored with return type as Logger in log object. 
	private static Logger log = LogManager.getLogger(Demo2.class.getName());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		log.debug("Demo2, I am debugging");
		
		log.info("Demo2, object is present");
		
		log.error("Demo2, object is not present");
		
		log.fatal("Demo2, fatal error");
	}

}
