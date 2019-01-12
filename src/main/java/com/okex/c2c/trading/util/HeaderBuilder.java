package com.okex.c2c.trading.util;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class HeaderBuilder {

	private static String AUTHORIZATION = "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiI4Mzk3OWE125OS1jYWRiLTQzM2YtOTM4Mi03NGYyMzE4YmY0MTFFb32dhIiwidWlkIjoidTNMYVg4bHJqaGN1emxKM3ZrY0tEQT09Iiwic3RhIjowLCJtaWQiOjAsImlhdCI6MTUzNDQyMzIyNCwiZXhwIjoxNTM1MDI4MDI0LCJiaWQiOjAsImRvbSI6Ind3dy5va2IuY29tIiwiaXNzIjoib2tjb2luIn0.lPBTCodltoP_YMQ3K8uqhefKoIAIzMez3QC-13aNvUC-XSwrZOCZBuAi_vTuAExcvo3cddApcPD-qw6AOu0PCA";

    private static String COOKIE = "locale=zh_CN; perm=4DFFA2F63059CA553A3B77CE226533E169; _ga=GA1.2.326476787.1525790846; product=btc_usdt; lp=; isLogin=1; kycNationality=CN; first_ref=https://www.okex.cn/otc/orderList; Hm_lvt_b4e1f9d04a77cfd5db302bc2bcc6fe45=1534338568,1534341340,1534423242,1534510740; ref=https://www.okb.com/otc; Hm_lpvt_b4e1f9d04a77cfd5db302bc2bcc6fe45=1534513425";

    private static String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.87 Safari/537.36";

    public Header authorization(){
    	return new BasicHeader("Authorization", AUTHORIZATION);
    }
    
    public Header cookie(){
    	return new BasicHeader("Cookie", COOKIE);
    }
    
    public Header userAgent(){
    	return new BasicHeader("User-Agent", USER_AGENT);
    }
}
