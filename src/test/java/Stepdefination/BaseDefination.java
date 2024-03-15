package Stepdefination;

import Vtiger.Homepage;
import Vtiger.Leadpage;
import Vtiger.Loginpage;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
public class BaseDefination {

    public Properties prop;
    public WebDriver driver;
    public Loginpage Lp;
    public Homepage Hp;
    public Leadpage Ldp;
    public static String path = System.getProperty("C:\\Users\\TUSHAR\\Desktop\\Cucumber_Framework6\\src\\test\\resources\\TestData\\data.xlsx");

    public static String Workbook = System.getProperty("user.dir")+ "/src/test/resources/TestData/data.xlsx";
    public  Map<String,Map<String, String>> data;
    public  String TCName;

    public void initiation() throws Exception
    {
        if (data==null)
        {
            ReadExcelData(Workbook,  "Sheet1");
        }

       if (prop==null)
       {
           Readproperties();
       }


        if (driver==null)
        {
            Launchapp();
        }

        if (Lp==null)
        {
            PageobjectManager();
        }

    }

    public void PageobjectManager()
    {
        if (Lp==null)
            Lp = new Loginpage(driver);
        if (Hp==null)
            Hp = new Homepage(driver);
        if (Ldp==null)
            Ldp = new Leadpage(driver);
    }

    public void Launchapp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(prop.getProperty("appurl"));
        driver.manage().window().maximize();
        String timeout = prop.getProperty("implecityWait");
        int time = Integer.parseInt(timeout);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));


    }

    public void Readproperties() throws IOException
    {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\TUSHAR\\Desktop\\Cucumber_Framework6\\src\\test\\resources\\Properties\\Config.Properties");
        prop.load(fis);
        fis.close();
    }

    public void ReadExcelData(String Workbook, String sheet) throws Exception {

        Fillo fillo= new Fillo();
        Connection connection;
        connection =fillo.getConnection(Workbook);
        String strQuery ="Select * from "+sheet;
        Recordset recordset=connection.executeQuery(strQuery);
        int rowcount = recordset.getCount();
        int columcount = recordset.getFieldNames().size();

        data = new HashMap<>();

       while (recordset.next())
       {
           Map<String , String> rowmap = new HashMap<>();

           for (int j = 1; j<columcount; j++)
           {
               String columname = recordset.getFieldNames().get(j);
               String columvalue = recordset.getField(columname);
               rowmap.put(columname,columvalue);
           }

           data.put(recordset.getField("TCName"),rowmap);

       }

        recordset.close();
        connection.close();

    }

}
