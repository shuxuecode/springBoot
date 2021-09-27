import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

/**
 *
 */
public class Test002 {

    @Test
    void t5(){
        //RSA rsa = new RSA();
        //
        //String publicKeyBase64 = rsa.getPublicKeyBase64();
        //String privateKeyBase64 = rsa.getPrivateKeyBase64();
        //
        //System.out.println(publicKeyBase64);
        //System.out.println(privateKeyBase64);

        //MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCIOtxamfKsNEPba+6M5elimALa8nVRtkNoRnKNNfTGw7OFWUjKAo1Sjjc4XdTngcH0fmOF8E73o+11yGfBTmxSRdTumD5zn9HBgoL3dMRjenYCHICgVgHgAXWmcF5C3QEko3qkWnqxZeK8fzcLBch7bPykYTITAGalV+WXi8gkzQIDAQAB
        //MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIg63FqZ8qw0Q9tr7ozl6WKYAtrydVG2Q2hGco019MbDs4VZSMoCjVKONzhd1OeBwfR+Y4XwTvej7XXIZ8FObFJF1O6YPnOf0cGCgvd0xGN6dgIcgKBWAeABdaZwXkLdASSjeqRaerFl4rx/NwsFyHts/KRhMhMAZqVX5ZeLyCTNAgMBAAECgYB7/RaRX4x/LxKToqh7lMXV9oSiwgoFVN4FChk4bONcBMJfm+Oj+K6ndMjNhJlCG9drr5zlStKUkZ6OlNfaGIZ8+e4MeJ7PMkz8+yY1YKv/4iIvk+WePlJ3VgpdkznYU+RAQolH92DDRxnf2sZysrKtdP8boLOnf5hqFHCkxEQcAQJBAPaLVrtzP1knCivIDGaqvH4eX9ASgBQSDMbVXQkncSJUQIM21uapfwOIO0gS6u9tKinNKUgpe/+aDlhfzmwXhKcCQQCNdGpf53ZmaJcqoXCE5H/rtyVc0eTF2RI7Kw1ldy6C7i2Sw8HpwQOEkCypyswQs+aEXhrS7M/qjPXYIQIHnhVrAkAj1BQCobjvB9Fek2/Z664A1gEuh8G9KPJaYt9mWSkDyCKn7uxEERW4ObADxVwG92JNONdq+Txf5M944FNrOe+5AkBEXf7HyXwtNOHTBeH3KOU2zPbu7LdQdIDePgmkf7zoJSu7ooeHbfVATdp4Wf7VF84TLdRzG2fGKkjsI8/yVJJvAkEAvyNIOyv2DXIS+1RClUaacEfdLqHYdx3k4/nF1ol8vv6/qh7WolroLkSTPLtECnDBreIjKdX8JtWUtQhkjgPgYw==

        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIg63FqZ8qw0Q9tr7ozl6WKYAtrydVG2Q2hGco019MbDs4VZSMoCjVKONzhd1OeBwfR+Y4XwTvej7XXIZ8FObFJF1O6YPnOf0cGCgvd0xGN6dgIcgKBWAeABdaZwXkLdASSjeqRaerFl4rx/NwsFyHts/KRhMhMAZqVX5ZeLyCTNAgMBAAECgYB7/RaRX4x/LxKToqh7lMXV9oSiwgoFVN4FChk4bONcBMJfm+Oj+K6ndMjNhJlCG9drr5zlStKUkZ6OlNfaGIZ8+e4MeJ7PMkz8+yY1YKv/4iIvk+WePlJ3VgpdkznYU+RAQolH92DDRxnf2sZysrKtdP8boLOnf5hqFHCkxEQcAQJBAPaLVrtzP1knCivIDGaqvH4eX9ASgBQSDMbVXQkncSJUQIM21uapfwOIO0gS6u9tKinNKUgpe/+aDlhfzmwXhKcCQQCNdGpf53ZmaJcqoXCE5H/rtyVc0eTF2RI7Kw1ldy6C7i2Sw8HpwQOEkCypyswQs+aEXhrS7M/qjPXYIQIHnhVrAkAj1BQCobjvB9Fek2/Z664A1gEuh8G9KPJaYt9mWSkDyCKn7uxEERW4ObADxVwG92JNONdq+Txf5M944FNrOe+5AkBEXf7HyXwtNOHTBeH3KOU2zPbu7LdQdIDePgmkf7zoJSu7ooeHbfVATdp4Wf7VF84TLdRzG2fGKkjsI8/yVJJvAkEAvyNIOyv2DXIS+1RClUaacEfdLqHYdx3k4/nF1ol8vv6/qh7WolroLkSTPLtECnDBreIjKdX8JtWUtQhkjgPgYw==";
        String password = "BoYOL2Tpvv7bQHNXJicHwPcv+TaTmhbKxPrPB7LCz6jYAvMUzfZmBA6Phka5i9vBqfoVH9nryX6MegadDw8JpKo4+FFc0TvogpDujsO8nAHm/UfJoxuk9JRDPD/v4N8EVyGopD2JI/b6gNA0qb1BR0uFyQ0UfXm8W58h8k14ai8=";
        // 构建，当只用私钥进行构造对象时，只允许使用该私钥进行加密和解密操作，本文只需要进行私钥解密，故只使用私钥构造对象
        RSA rsa = new RSA(privateKey, null);
        // 密码的密文先进行base64解码，之后再进行解密

        byte[] decrypt = rsa.decrypt(Base64.decode(password), KeyType.PrivateKey);
        String decryptStr = StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8);

        System.out.println(decryptStr);

    }

    @Test
    void t4() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        String separator = System.getProperty("line.separator");

        String privateKey = "-----BEGIN RSA PRIVATE KEY-----"
                + "MIICXQIBAAKBgQDlOJu6TyygqxfWT7eLtGDwajtNFOb9I5XRb6khyfD1Yt3YiCgQ"
                + "WMNW649887VGJiGr/L5i2osbl8C9+WJTeucF+S76xFxdU6jE0NQ+Z+zEdhUTooNR"
                + "aY5nZiu5PgDB0ED/ZKBUSLKL7eibMxZtMlUDHjm4gwQco1KRMDSmXSMkDwIDAQAB"
                + "AoGAfY9LpnuWK5Bs50UVep5c93SJdUi82u7yMx4iHFMc/Z2hfenfYEzu+57fI4fv"
                + "xTQ//5DbzRR/XKb8ulNv6+CHyPF31xk7YOBfkGI8qjLoq06V+FyBfDSwL8KbLyeH"
                + "m7KUZnLNQbk8yGLzB3iYKkRHlmUanQGaNMIJziWOkN+N9dECQQD0ONYRNZeuM8zd"
                + "8XJTSdcIX4a3gy3GGCJxOzv16XHxD03GW6UNLmfPwenKu+cdrQeaqEixrCejXdAF"
                + "z/7+BSMpAkEA8EaSOeP5Xr3ZrbiKzi6TGMwHMvC7HdJxaBJbVRfApFrE0/mPwmP5"
                + "rN7QwjrMY+0+AbXcm8mRQyQ1+IGEembsdwJBAN6az8Rv7QnD/YBvi52POIlRSSIM"
                + "V7SwWvSK4WSMnGb1ZBbhgdg57DXaspcwHsFV7hByQ5BvMtIduHcT14ECfcECQATe"
                + "aTgjFnqE/lQ22Rk0eGaYO80cc643BXVGafNfd9fcvwBMnk0iGX0XRsOozVt5Azil"
                + "psLBYuApa66NcVHJpCECQQDTjI2AQhFc1yRnCU/YgDnSpJVm1nASoRUnU8Jfm3Oz"
                + "uku7JUXcVpt08DFSceCEX9unCuMcT72rAQlLpdZir876"
                + "-----END RSA PRIVATE KEY-----";

        privateKey = "-----BEGIN RSA PRIVATE KEY-----" + separator
                + "MIICXQIBAAKBgQDlOJu6TyygqxfWT7eLtGDwajtNFOb9I5XRb6khyfD1Yt3YiCgQ" + separator
                + "WMNW649887VGJiGr/L5i2osbl8C9+WJTeucF+S76xFxdU6jE0NQ+Z+zEdhUTooNR" + separator
                + "aY5nZiu5PgDB0ED/ZKBUSLKL7eibMxZtMlUDHjm4gwQco1KRMDSmXSMkDwIDAQAB" + separator
                + "AoGAfY9LpnuWK5Bs50UVep5c93SJdUi82u7yMx4iHFMc/Z2hfenfYEzu+57fI4fv" + separator
                + "xTQ//5DbzRR/XKb8ulNv6+CHyPF31xk7YOBfkGI8qjLoq06V+FyBfDSwL8KbLyeH" + separator
                + "m7KUZnLNQbk8yGLzB3iYKkRHlmUanQGaNMIJziWOkN+N9dECQQD0ONYRNZeuM8zd" + separator
                + "8XJTSdcIX4a3gy3GGCJxOzv16XHxD03GW6UNLmfPwenKu+cdrQeaqEixrCejXdAF" + separator
                + "z/7+BSMpAkEA8EaSOeP5Xr3ZrbiKzi6TGMwHMvC7HdJxaBJbVRfApFrE0/mPwmP5" + separator
                + "rN7QwjrMY+0+AbXcm8mRQyQ1+IGEembsdwJBAN6az8Rv7QnD/YBvi52POIlRSSIM" + separator
                + "V7SwWvSK4WSMnGb1ZBbhgdg57DXaspcwHsFV7hByQ5BvMtIduHcT14ECfcECQATe" + separator
                + "aTgjFnqE/lQ22Rk0eGaYO80cc643BXVGafNfd9fcvwBMnk0iGX0XRsOozVt5Azil" + separator
                + "psLBYuApa66NcVHJpCECQQDTjI2AQhFc1yRnCU/YgDnSpJVm1nASoRUnU8Jfm3Oz" + separator
                + "uku7JUXcVpt08DFSceCEX9unCuMcT72rAQlLpdZir876" + separator
                + "-----END RSA PRIVATE KEY-----";


        System.out.println(privateKey);



    }

    @Test
    void t3() {
        Assert.assertTrue("assert true is error", 1 == 2);
    }

    @Test
    void t2() {
        // todo
        int num = 13 & 17;
        System.out.println(num); // 1

    }

    @Test
    void t1() {
        long time = System.currentTimeMillis();

        String timeStr = String.valueOf(time);

        System.out.println(timeStr);

        DateTime parse = DateTime.parse("9999-12-31");
        System.out.println(parse);
//        time = parse.getMillis();

        String binaryString = Long.toBinaryString(time);
        System.out.println(binaryString);
        System.out.println(binaryString.length());


        long l = Long.parseLong("01111111111111111111111111111111111111111", 2);

        System.out.println(l);

        Date date = new Date(l);
        System.out.println(date);


    }
}
