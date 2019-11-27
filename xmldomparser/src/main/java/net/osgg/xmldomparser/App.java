package net.osgg.xmldomparser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DomParser dp = new DomParser("company.xml");
        try {
			dp.parse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
