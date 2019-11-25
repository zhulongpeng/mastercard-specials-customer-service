import com.alibaba.fastjson.JSON;
import com.mastercard.api.JSONUtil;
import com.mastercard.api.MastercardAPI;
import com.mastercard.api.OfferResp;
import com.mastercard.api.SpecialsAPI;

import java.util.List;

public class offerInterfaceProdTest {

    public void main(String[] args) throws Exception{
        String fileName = "Your Certificate file name";//Certificate file name e.g. 3ti_sandbox_key-sandbox.p12
        String keyAlias = "keyAlias";//change this to the key alias you chose when you created your production key e.g. 3ti_sandbox_key
        String password = "keyPassword";//change this to the key alias you chose when you created your production key e.g. q1w2e3r4t5
        String oauth_consumer_key = "Your oauth_consumer_key";//You should copy this from "My Keys" on your project page e.g. yhviHduc9vXNnT4AcHPYC8PpxoDebON3TxR7N33e7495c202!791ad4d4f0704a63b7d8b7db1512d7770000000000000000
        String clientId = "Your clientId";//Your clientId
        String language= "Parameters of the offer interface";//Parameters of the offer interface e.g. en-SG
        String category = "Parameters of the offer interface";//Parameters of the offer interface e.g. Culinary
        String eligibleMarkets = "Parameters of the offer interface";//Parameters of the offer interface e.g. AU,CN,HK,ID,PH,SG,KR,TW
        String destinationMarkets = "Parameters of the offer interface";//Parameters of the offer interface e.g. TH
        String mastercardProduct = "Parameters of the offer interface";//Parameters of the offer interface e.g. MCW,MRH,MLA,MRG,MPG,MDG,MRW
        String program = "Parameters of the offer interface";//Parameters of the offer interface e.g. 201812110001
        String tags = "Parameters of the offer interface";//Parameters of the offer interface e.g. Travel
        String lastModifiedDate = "Parameters of the offer interface";//Parameters of the offer interface e.g. 20191122T114825CST
        String coordinates = "Parameters of the offer interface";//Parameters of the offer interface e.g. 28.975636,41.023907
        String merchantName = "Parameters of the offer interface";//Parameters of the offer interface e.g. Test_test_dummy_data
        String cardProductId = "Parameters of the offer interface";//Parameters of the offer interface e.g. 201812040008
        String issuerId = "Parameters of the offer interface";//Parameters of the offer interface e.g. 201810190001
        String offerTitle = "Parameters of the offer interface";//Parameters of the offer interface e.g. Test_test_dummy_data
        String merchantType = "Parameters of the offer interface";//Parameters of the offer interface e.g. Single Address Merchant
        Integer limit = 100;//Parameters of the offer interface e.g. 100
        Integer offset = 0;//Parameters of the offer interface e.g. 0
        String sort = "Parameters of the offer interface";//Parameters of the offer interface e.g. alphabetical
        try {
            String offers = MastercardAPI.getOffers(fileName,keyAlias,password,
                    oauth_consumer_key,clientId, language,category,eligibleMarkets,
                     destinationMarkets,mastercardProduct,program,tags,
                     lastModifiedDate,coordinates,merchantName,
                     cardProductId,issuerId,offerTitle,
                     merchantType,limit,offset,sort);
            List<OfferResp> offerRespList = JSONUtil.jsonToObject(offers);
            offerRespList.forEach(offerResp -> {
            out("language-->"+offerResp.getLanguage());
            out("offerId-->"+offerResp.getOfferDetails().getOfferId());
            out("offerStartDate-->"+offerResp.getOfferDetails().getOfferStartDate());
            out("offerEndDate-->"+offerResp.getOfferDetails().getOfferEndDate());
            out("offerLastModifiedDate-->"+offerResp.getOfferDetails().getOfferLastModifiedDate());
            out("offerTitle-->"+offerResp.getOfferDetails().getOfferTitle());
            out("offerSubTitle-->"+offerResp.getOfferDetails().getOfferSubTitle());
            out("offerDescription-->"+offerResp.getOfferDetails().getOfferDescription());
            out("offerTermsAndConditions-->"+offerResp.getOfferDetails().getOfferTermsAndConditions());
            out("offerRedemptionCTAValue-->"+offerResp.getOfferDetails().getOfferRedemptionCTAValue());
            out("category-->"+offerResp.getOfferDetails().getCategory());
            out("merchantType()-->"+offerResp.getOfferDetails().getMerchantType());
            out("DTIPermit()-->"+offerResp.getOfferDetails().getDTIPermit());
            out("Pdfs()-->", offerResp.getOfferDetails().getPdfs());
            out("eligibleMastercardProducts()-->",offerResp.getEligibleMastercardProducts());
            out("eligibleMarkets()-->",offerResp.getEligibleMarkets());
            out("destinationMarkets()-->",offerResp.getDestinationMarkets());
            out("merchantName()-->"+offerResp.getMerchantDetails().getMerchantName());
            out("merchantLogo()-->"+offerResp.getMerchantDetails().getMerchantLogo());
            out("merchantEmailAddress()-->"+offerResp.getMerchantDetails().getMerchantEmailAddress());
            out("merchantPhoneNumber()-->"+offerResp.getMerchantDetails().getMerchantPhoneNumber());
            out("merchantCity()-->"+offerResp.getMerchantDetails().getMerchantCity());
            out("merchantCountry()-->"+offerResp.getMerchantDetails().getMerchantCountry());
            out("merchantCountryCode()-->"+offerResp.getMerchantDetails().getMerchantCountryCode());
            out("merchantWebsite()-->"+offerResp.getMerchantDetails().getMerchantWebsite());
            out("rectangleImage()-->"+offerResp.getOfferImages().getRectangleImage());
            out("squareImage()-->"+offerResp.getOfferImages().getSquareImage());
            offerResp.getMerchantDetails().getMerchantLocations().forEach(merchantLocationMO -> {
                out("latitude()-->"+merchantLocationMO.getLatitude());
                out("longitude()-->"+merchantLocationMO.getLongitude());
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
