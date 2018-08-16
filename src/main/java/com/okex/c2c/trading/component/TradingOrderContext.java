package com.okex.c2c.trading.component;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicHeader;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.okex.c2c.trading.web.model.TradingOrderModel;
import com.okex.c2c.web.Result;

@Component
public class TradingOrderContext {

    private static String AUTHORIZATION = "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyY2M4OWFhNS1jODIzLTRlYzAtODZhNS0wZmUwMjhiMjEzM2Z1d2x1IiwidWlkIjoiN3pRNFV4MHVOcDlKekloLzlVUTlPdz09Iiwic3RhIjowLCJtaWQiOjAsImlhdCI6MTUzNDM0MTcxMiwiZXhwIjoxNTM0OTQ2NTEyLCJiaWQiOjAsImRvbSI6Ind3dy5va2IuY29tIiwiaXNzIjoib2tjb2luIn0.Nl8Gna--tEBxi_HkH1pmPOSpEEn08vc2JCWFGL_YYdOwvFtMm-uahh-RJk5JT3_5zFQLqm8AQaDDNL6sOHJApA";

    private static String COOKIE = "locale=zh_CN; perm=4DFFA2F63059CA553A3B77CE2265E169; _ga=GA1.2.326476787.1525790846; product=btc_usdt; lp=; isLogin=1; kycNationality=CN; first_ref=https://www.okb.com/otc/orderList; Hm_lvt_b4e1f9d04a77cfd5db302bc2bcc6fe45=1534030215,1534083377,1534338568,1534341340; ref=https://www.okb.com/spot/trade; Hm_lpvt_b4e1f9d04a77cfd5db302bc2bcc6fe45=1534341752";

    private static String URL = "https://www.okb.com/v2/c2c-open/tradingOrders/group?digitalCurrencySymbol=%s&legalCurrencySymbol=cny&best=1&exchangeRateLevel=0&paySupport=0";

    private static String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.87 Safari/537.36";

    public TradingOrderModel currentTrading(String digitalCurrencySymbol) {
        try {
            Header authorizationHeader = new BasicHeader("Authorization", AUTHORIZATION);
            Header cookieHeader = new BasicHeader("Cookie", COOKIE);
            Header userAgentHeader = new BasicHeader("User-Agent", USER_AGENT);
            Content content = Request.Get(String.format(URL, digitalCurrencySymbol)).addHeader(authorizationHeader).addHeader(cookieHeader).addHeader(userAgentHeader).execute().returnContent();
            String s = content.asString(Charset.defaultCharset());

            ObjectMapper om = new ObjectMapper();
            Result<TradingOrderModel> tradingOrderModel = om.readValue(s.getBytes(), new TypeReference<Result<TradingOrderModel>>() {
            });
            return tradingOrderModel.getData();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
