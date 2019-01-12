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

    private static String AUTHORIZATION = "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiI4Mzk3OWE125OS1jYWRiLTQzM2YtOTM4Mi03NGYyMzE4YmY0MTFFb32dhIiwidWlkIjoidTNMYVg4bHJqaGN1emxKM3ZrY0tEQT09Iiwic3RhIjowLCJtaWQiOjAsImlhdCI6MTUzNDQyMzIyNCwiZXhwIjoxNTM1MDI4MDI0LCJiaWQiOjAsImRvbSI6Ind3dy5va2IuY29tIiwiaXNzIjoib2tjb2luIn0.lPBTCodltoP_YMQ3K8uqhefKoIAIzMez3QC-13aNvUC-XSwrZOCZBuAi_vTuAExcvo3cddApcPD-qw6AOu0PCA";

    private static String COOKIE = "locale=zh_CN; perm=4DFFA2F63059CA553A3B77CE226533E169; _ga=GA1.2.326476787.1525790846; product=btc_usdt; lp=; isLogin=1; kycNationality=CN; first_ref=https://www.okex.cn/otc/orderList; Hm_lvt_b4e1f9d04a77cfd5db302bc2bcc6fe45=1534338568,1534341340,1534423242,1534510740; ref=https://www.okb.com/otc; Hm_lpvt_b4e1f9d04a77cfd5db302bc2bcc6fe45=1534513425";

    private static String URL = "https://www.okex.me/v3/c2c/tradingOrders/book?side=all&baseCurrency=usdt&quoteCurrency=cny&userType=certified&paymentMethod=all";

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
