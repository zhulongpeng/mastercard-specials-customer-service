import com.alibaba.fastjson.JSON;
import com.mastercard.api.JSONUtil;
import com.mastercard.api.OfferResp;
import com.mastercard.api.SpecialsAPI;
import java.util.List;

public class offerInterfaceTest {

    public void main(String[] args) throws Exception{
        String fileName = "3ti_sandbox_key-sandbox.p12";//Certificate file name
        String userName = "3ti_sandbox_key";//userName
        String password = "q1w2e3r4t5";//password
        String oauth_consumer_key = "yhviHduc9vXNnT4AcHPYC8PpxoDebON3TxR7N33e7495c202!791ad4d4f0704a63b7d8b7db1512d7770000000000000000";//oauth_consumer_key
        String language= "en-SG";
        String category = "Culinary";
        String eligibleMarkets = "AU,CN,HK,ID,PH,SG,KR,TW";
        String destinationMarkets = "TH";
        String mastercardProduct = "MCW,MRH,MLA,MRG,MPG,MDG,MRW";
        String program = "";
        String tags = "";
        String lastModifiedDate = "";
        String coordinates = "";
        String merchantName = "Test_test_dummy_data";
        String cardProductId = "";
        String issuerId = "";
        String offerTitle = "Test_test_dummy_data";
        String merchantType = "";
        Integer limit = 100;
        Integer offset = 0;
        String sort = "";
        try {
            String offers = SpecialsAPI.getOffers(fileName,userName,password,
                    oauth_consumer_key,language,category,eligibleMarkets,
                     destinationMarkets,mastercardProduct,program,tags,
                     lastModifiedDate,coordinates,merchantName,
                     cardProductId,issuerId,offerTitle,
                     merchantType,limit,offset,sort);
            List<OfferResp> offerRespList = JSONUtil.jsonToObject(offers);
            offerRespList.forEach(offerResp -> {
            out("language-->"+offerResp.getLanguage());//-->en-SG
            out("offerId-->"+offerResp.getOfferDetails().getOfferId());//-->201907110004
            out("offerStartDate-->"+offerResp.getOfferDetails().getOfferStartDate());//-->2019-08-01T00:00:00+0800
            out("offerEndDate-->"+offerResp.getOfferDetails().getOfferEndDate());//-->2020-07-31T00:00:00+0800
            out("offerLastModifiedDate-->"+offerResp.getOfferDetails().getOfferLastModifiedDate());//
            out("offerTitle-->"+offerResp.getOfferDetails().getOfferTitle());//-->Test_test_dummy_data
            out("offerSubTitle-->"+offerResp.getOfferDetails().getOfferSubTitle());//-->Test_test_dummy_data
            out("offerDescription-->"+offerResp.getOfferDetails().getOfferDescription());//->TEST DATA ONLY - Information about the offer
            out("offerTermsAndConditions-->"+offerResp.getOfferDetails().getOfferTermsAndConditions());
            out("offerRedemptionCTAValue-->"+offerResp.getOfferDetails().getOfferRedemptionCTAValue());//-->Present Your Card
            out("category-->"+offerResp.getOfferDetails().getCategory());//-->Culinary
            out("merchantType()-->"+offerResp.getOfferDetails().getMerchantType());//->Single Address Merchant
            out("DTIPermit()-->"+offerResp.getOfferDetails().getDTIPermit());//
            out("Pdfs()-->", offerResp.getOfferDetails().getPdfs());//->["https://specials.priceless.com/mastercard/images/f38501a1-1be5-4cbe-a70c-5edcc5fda50c.pdf"]
            out("eligibleMastercardProducts()-->",offerResp.getEligibleMastercardProducts());//-->["MCW","MWE","WMR"]
            out("eligibleMarkets()-->",offerResp.getEligibleMarkets());//-->["AU","CN","HK","IN,""ID","JP","MO","MY","MM","NZ","PH","SG","KR","LK","TW","VN","KH"]
            out("destinationMarkets()-->",offerResp.getDestinationMarkets());//-->["TH"]
            out("merchantName()-->"+offerResp.getMerchantDetails().getMerchantName());//-->Test_test_dummy_data
            out("merchantLogo()-->"+offerResp.getMerchantDetails().getMerchantLogo());
            out("merchantEmailAddress()-->"+offerResp.getMerchantDetails().getMerchantEmailAddress());
            out("merchantPhoneNumber()-->"+offerResp.getMerchantDetails().getMerchantPhoneNumber());
            out("merchantCity()-->"+offerResp.getMerchantDetails().getMerchantCity());//
            out("merchantCountry()-->"+offerResp.getMerchantDetails().getMerchantCountry());//-->Singapore
            out("merchantCountryCode()-->"+offerResp.getMerchantDetails().getMerchantCountryCode());//-->SG
            out("merchantWebsite()-->"+offerResp.getMerchantDetails().getMerchantWebsite());
            out("rectangleImage()-->"+offerResp.getOfferImages().getRectangleImage());//->https://specials.priceless.com/mastercard/images/59e8da9d-f41f-4d6e-96c3-781475f55970.jpg
            out("squareImage()-->"+offerResp.getOfferImages().getSquareImage());//->https://specials.priceless.com/mastercard/images/676a8903-b826-4700-9847-0afad629965a.jpg
            offerResp.getMerchantDetails().getMerchantLocations().forEach(merchantLocationMO -> {
                out("latitude()-->"+merchantLocationMO.getLatitude());//->0.0
                out("longitude()-->"+merchantLocationMO.getLongitude());//->0.0
                out("merchantAddress()-->"+merchantLocationMO.getMerchantAddress());
            });
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void out(String value){
        System.out.println(value);
    }

    public static void out(String message, List<String> value){
        System.out.println(message+"-->"+JSON.toJSONString(value));
    }
}
