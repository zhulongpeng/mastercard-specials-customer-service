import com.mastercard.api.MastercardAPI;
import org.junit.Test;

public class test {

    @Test
    public void testLan() throws Exception {
        String cli = "vcDLug1R7K1kKoYanyi6eYi0BrO_MNOzq_i-77Bue9fec2d5";
        String fileName = "3ti_prd_key-production.p12";
        String userName = "3ti_prd_key";
        String password = "q1w2e3r4t5";
        String oauth_consumer_key = "OH4q7S64RsAQAacQvT6rMgCFjhW9lfq3blaxdq95aac57d39!78ca1d91925b4c7c9088f13c1a4b51460000000000000000";
        String languages = MastercardAPI.getLanguages(fileName, userName, password, oauth_consumer_key, cli);
        System.out.println("*************************");
        System.out.println(languages);
        System.out.println("***************************");
    }

    @Test
    public void testOffer(){
        String cli = "vcDLug1R7K1kKoYanyi6eYi0BrO_MNOzq_i-77Bue9fec2d5";
        String fileName = "3ti_prd_key-production.p12";
        String userName = "3ti_prd_key";
        String password = "q1w2e3r4t5";
        String oauth_consumer_key = "OH4q7S64RsAQAacQvT6rMgCFjhW9lfq3blaxdq95aac57d39!78ca1d91925b4c7c9088f13c1a4b51460000000000000000";
        String offers = MastercardAPI.getOffers(fileName, userName, password, oauth_consumer_key, cli, "en-HK", "Travel", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        System.out.println("*************************");
        System.out.println(offers);
        System.out.println("***************************");
    }

    @Test
    public void testBenefits(){
        String cli = "vcDLug1R7K1kKoYanyi6eYi0BrO_MNOzq_i-77Bue9fec2d5";
        String fileName = "3ti_prd_key-production.p12";
        String userName = "3ti_prd_key";
        String password = "q1w2e3r4t5";
        String oauth_consumer_key = "OH4q7S64RsAQAacQvT6rMgCFjhW9lfq3blaxdq95aac57d39!78ca1d91925b4c7c9088f13c1a4b51460000000000000000";
        String offers = MastercardAPI.getBenefits(fileName, userName, password, oauth_consumer_key, cli, "en-HK", null, null, "AF,AX,DZ,AS", null, null, null, null, "E-Commerce", null, null, null);
        System.out.println("*************************");
        System.out.println(offers);
        System.out.println("***************************");
    }

    @Test
    public void getFilePath(){
        String fileName = this.getClass().getClassLoader().getResource("3ti_prd_key-production.p12").getPath();
        System.out.println("**********fileName***************");
        System.out.println(fileName);
        System.out.println("***************************");
        String fileUtl = test.class.getResource("3ti_prd_key-production.p12").getFile();
        System.out.println("************fileUtl*************");
        System.out.println(fileUtl);
        System.out.println("***************************");
    }
}
