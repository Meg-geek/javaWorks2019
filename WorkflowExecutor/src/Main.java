import Workflow.Workflow;
//import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;



public class Main {
    static Logger log = LogManager.getLogger(Main.class);
    public static void main(String args[]){
       log.info("main() - start");
        Workflow workflow = new Workflow();
       try{
           log.info("start the workflow with the test.txt");
           workflow.run("test.txt");
       }catch(Exception ex){
           log.error("Exception, ", ex);
           ex.printStackTrace();
       }

    }
}
