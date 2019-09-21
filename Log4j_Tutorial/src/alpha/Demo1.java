package alpha;
import org.apache.logging.log4j.*;


public class Demo1 {

	//1- Define logManager to get access of desired class. Here logManager is API in which getLogger is function
	//to call class with getName method. all this is stored with return type as Logger in log object. 
	private static Logger log = LogManager.getLogger(Demo1.class.getName());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		log.debug("I am debugging");
		
		log.info("object is present");
		
		log.error("object is not present");
		
		log.fatal("fatal error");
	}

}
