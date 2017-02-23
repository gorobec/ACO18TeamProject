package utils.serhii;

import container.ProductDB;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URL;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public class PersistenceUtilsTest {


    private String json =
            "{\"products\":" +
                    "[{\"id\":1,\"name\":\"ProdName1\"}," +
                    "{\"id\":2,\"name\":\"ProdName2\"},{\"id\":1,\"name\":\"ProdName3\"}]," +
                    "\"tickets\":[" +
                    "{\"id\":1,\"creditCard\":\"credCard\"," +
                    "\"address\":{\"city\":\"kiev\",\"street\":\"sdf\",\"number\":12}}," +
                    "{\"id\":2,\"creditCard\":\"credCard\"," +
                    "\"address\":{\"city\":\"kiev\",\"street\":\"sdf\",\"number\":12}}," +
                    "{\"id\":3,\"creditCard\":\"credCard\"," +
                    "\"address\":{\"city\":\"kiev\",\"street\":\"sdf\",\"number\":12}}]}";
    private ProductDB productDb;
    private String path = "productDb.json";


/*    @Before
    public void setUp() throws Exception {
        productDb = new ProductDB();
        productDb.addProduct(new Product(1, "ProdName1"));
        productDb.addProduct(new Product(2, "ProdName2"));
        productDb.addProduct(new Product(1, "ProdName3"));

        productDb.addTicket(new Ticket(1, "credCard", new Address("kiev", "sdf", 12)));
        productDb.addTicket(new Ticket(2, "credCard", new Address("kiev", "sdf", 12)));
        productDb.addTicket(new Ticket(3, "credCard", new Address("kiev", "sdf", 12)));
    }*/

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testConvertToJson() throws Exception {
        String json = PersistenceUtils.convertToJson(productDb);
        System.out.println(json);
        Assert.assertNotNull(json);
    }

    @Test
    public void testConvertFromJson() throws Exception {
        ProductDB fromJSonProductDb = PersistenceUtils.convertFromJson(ProductDB.class, json);
        Assert.assertNotNull(fromJSonProductDb);
    }

    @Test
    public void testSaveIntoFile() throws Exception {
        File tempFile = new File("./temp.json");
        PersistenceUtils.saveIntoFile(tempFile.getPath(), json);

        Assert.assertTrue(tempFile.exists());
        tempFile.delete();
    }

    @Test
    public void testLoadFromFile() throws Exception {
        URL uri = PersistenceUtils.class.getResource("/utils/serhii/db.json");

        String loadedJson = PersistenceUtils.loadFromFile(uri.getFile());
        Assert.assertNotEquals("{}", loadedJson);
    }
}