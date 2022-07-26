package com.company.testse;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TestEncode {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String pares = "eJyVV1mvozwS%2FSut%2Fh6jbnYIrXQkswYSk7AFyBsBwr5DIPn1Q%2B7t5U6rZzQTCcUcl09VuexjvLGSLooEMwrGLtpuYNT3fhx9SsPvnykaJejP280JGFH%2FhpQYRmEkTSzgPer6tK622Ff0K75Bfr4uBF2Q%2BNWw3fhByynalqQIiqI2yI%2FXTRl1irBlWWLNoCiKLw%2FKLN3v8Ab5Pf40vlr9EtSchtvbQ9sLhWY%2BCc477m%2FFjpBgnUQlvq6%2Fb5CXxSb0h2iLoziOkvj6E8Z8w9FvJL1B3vBN86IDZT0u3BiKbpCPwGbJvouq4LFlSXKD%2FHrbRHNTV9FiseT4q71BfsfW%2BNUW%2FfCjaWpx%2BUI3lrvdDGn5MSbiG4Z9Q4kN8oZv%2BsEfxn7rbZAfrU3g3%2B9bAAAHzhfP08HbDxZJ8t4CS65vJpsoSLfoMm%2Bv%2F7dRoIjrLh2S8hXqvwMb5BUK8lbH7cZM42px1kWf5rKo%2Bu%2Bfk2FoviHINE1fJ%2BJr3cXIqyoIyiKLQdin8T%2Bf30dFoVLd6u2G96u6SgO%2FSJ%2F%2BsFQdRkNSh59%2BOfwbpWW8WDHEEPkvC%2B2XACOrLy8EJTBq4Uf%2BTvoh3P%2FFy5sLlPwZ%2BJey7qJ%2Fut7%2F0ic%2BTr0WM%2FIH33ZjRLfoVe3ok20o3z%2F%2F82GRC2kc9cP%2F6Xih%2Bue3u48UPwnPfjFG29EN%2BUdQVGghJ5O%2FPhVrPsxaw6gd1AJBjexFcW13Rui69vefPO8jN8ivmH8k9LMyv5J7N6y0Y89zWFdr2pV5nHp79ZxIRYDYEcVPw%2FDwiygOhEJacZESspqk%2B7x40GLV1byDp4B2jzIKh4d0%2BEDaJ2YEeakhZ4TLHy1COrsJP7AoMezJ8eIid4x3gmdS3RODHVgesk9nuFeoOgYrS4wq2La%2B6PG5hgF7zI6OrF7M4%2ByJRxdfZTqfXYabp0zJPdG7G0XcWg5DnnR6okyHFiNCy9aJvyPC2KAJ%2BXSsOZSk%2FNCbG8LAaIcae%2FwhmI8oMUPb6XVuNm%2BEdU2Dafd0mJT3zKSURfOe2g%2FpaHePbn8sDk9GKk1Kqape1TLFZGWSl3Pu3nbXeK1QLapcXHo3qQ7ZVgfXXRcdZRWkBmOnA9%2B%2Ff1hFPyqyjx7vFXAplBX8wX9v8VE3pLdlVS8KBBVFMDOeB5nC8zrf8XswPo3okAtA4%2BK8TfJUZieUA3ovAYEboN5PvO4JZ12XxUnlnEy0ICfKALNFHkx73W2KoFQT32mSayZqEPRvfdw0iXopdaElOpDT3%2B3jSbOcor%2FKRee5KqqIM9Sf4gGC%2FL1%2FmnjzrM%2BSBSwu1s4cgFCQuOSacprnGpnPg6chgEia0PloiRO09FnLbFwTzv6CPd4x8RcGZXGWM%2BD95BJdowgIfbx%2BiOFQSvRfcvxbHibkwM881I95QAMuRm%2FjDwJo7Iurob5DVYpY2Mt8c0r259yKEgBHHuhr8Orn4%2F3SFsHjUA2HNds53AQl9bZUBLNH%2FuEcr3fTF2HdWE1AlcfjuqmQ5Vyo5KGAtpTH5FPECLvVV5aF6YWEp0ieUCRWVQ94tbHyfPX9Y1zs6VmZUhzlrvLpZKoaq6wq56JWIF87Nesfd7q7cku1CWEf7RNKdGSMZXn0OYesELE3N2paac%2BQAXOL8bJ6FA9Bwt3z3uhFQzvYE3Kd7Mm1xWKJ8Rl3ljStkGy6NZV4obDgXvQGtFq5K0U6BfcdM6rgLNa2oJLahb7e8%2BbOi4HZtek0BdH1np130CEBJljjWRBvByfsqyuxX4eBN7Ilx%2FZ3cz%2B4RYZes8Rt8fMNDh3bwkuRS2p9uNf7qG35xC5O9aQIQAccBKjMm61sKldC0EWOn2wASGWpBQi79fg8wpq4rVaoS9T7gK0nvdubOSTGoszP3i6oebURqXvzWMeTVYH7sWFaZJzzroEUv47SGUmlFaFF3LhSA62nnnQTQSw3A1MCesru7MzTEgnbhYYRO0I9d1mvd33n3QL3Xk9ldsLVxiQo2Rju65YQLVyoz5PB2Bla9hHG0txNyHLaOrfsWCtlhPO10%2B7NHfAN%2BeK7%2BF2CPOYY55uiZ%2F1jf6DVS8cY1snVslbrgr3dJriTKEzdmtCtS%2Fcki%2F6UxFSoargftQMnM7JhKiluy%2FYELtZ6ZM%2Ft%2BkLkh8MuUa67MloCva0YZ2TgyW%2BTRPSSoiOa8b4%2BUaRwIUV10VjkXtVr90lrQzZtkD%2BV569S1FmLFDVODKalFLGiglOd8UcfM1Ks%2BFvJoIzO%2FBOo71vas0Au%2BR%2B231LrhovK88MrpcYvpRHq6MRPb307ARi85wwYNLxJAm%2FYXgCY5jtz7ztDElR6vKiH8EEOlu2sqssCPEMOvm19ME3QlqVREbEklLVaETQRcqQrWCIFLTAvDwGfcIJYvWDKC5uOwi9sulq%2F5Y5LIK%2Bf61l8AuM9nxjyuURfXDX1nKL1HHIWLHB47wsW1V1klrBnKQP2O1ZDwcaaqzw3Pi49Qp5b1A9%2BmJ9%2BcbVIkGFP4vscCAKY9YU3thwJ9fA4hqg%2BxbGY%2FjnXQH%2FfHsIEXv17UL%2B2Ck%2Boo68UR5KWUXqmAZ1dANIhuzrsWXvMKVonTTJ1U%2FUQEBrjFo%2F0OuXsCKlVh5XeIalPVHTpU5Hpsq632lAMzxrl2OF%2BNq0yc2zB7y6K5KrYLR6KvexOlz4Wj8cmO1idw4BEATvimT5Q2sSuuG4NuOhQNH6I9DnCSYMJZQZNektASYbjZIk8ds%2F60dzcXpAFkQuXY05lbaE%2Fx2gwk8u8RGex8nmGFVl5OU9CrUWDZL1TGZ4K7Cs%2F372h1UeRPiWacWxQ2jHFZbng8jof0EfD7MOpgfnKiY%2F%2BSFsl498At0jSOoxrOk7EsccIdTlhKXDFNaJfrU55g%2Bk2ma8jsUYvxL30KPaMHBh2KTsHgJzZAneEHPpaG6EQ6w7H6Y%2F72PeP5AENB%2FqXc7NvoqNYmiB4WuD2qvHOhKIsACf%2B77bwzdaAImeBRQ53yH%2BWQ25sGq0aYEqgOx%2Bf8oE8Sb4TzQpMj155b3b3I8OTA8HT4sym1C4dr9JxyVrni3sDTBxYMZGTuGJnM2uDuDQz5mq4jwwMujv7szDbyMN90EEUO0FzreFtDBmScKxnfhBSNy853u%2Bih%2BXyO0DmZ6NsEPBMJj7SZIp9TiWKUirdHlRJTofZaM88uo8Y8Rill%2BzscE%2FtysvdWpnD05l7rmOPSUfbJKpKB22ln8EaI%2FE6rtDLaV95MGE9b1WUt1Qduf5qQmbI1vTtWuP5%2FnDK7to5b51rqAiHyyRUYlxdR6kD7tFixA6Txo7KDjiTm207F9yBZXXuWAfjrSaQFUpfFWGIchnTE2UyItL8ixwivz%2FSkF8fbr8%2F6d5uoW%2FX4NfN6eP1%2BF%2FyXQEy";
        String pares2 = "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";
        String encode = URLEncoder.encode(pares2, StandardCharsets.UTF_8.name());
        System.out.println(encode);

        String decode = URLDecoder.decode(pares, StandardCharsets.UTF_8.name());
        System.out.println(decode);

//        String decoded = new String(pares.getBytes());
//        System.out.println(decoded);
    }
}