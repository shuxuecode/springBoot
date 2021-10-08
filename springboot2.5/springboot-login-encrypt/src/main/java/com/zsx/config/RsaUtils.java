package com.zsx.config;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

/**
 *
 */
public class RsaUtils {

    public static String[] generateKey() {
        RSA rsa = new RSA();
        String publicKey = rsa.getPublicKeyBase64();
        String privateKey = rsa.getPrivateKeyBase64();

        String[] arr = new String[2];
        arr[0] = publicKey;
        arr[1] = privateKey;

        return arr;
    }




    public static String encrypt(String context, String publicKeyStr) {
        RSA rsa = new RSA(null, publicKeyStr);

        byte[] encrypt = rsa.encrypt(context, KeyType.PublicKey);

        String str = Base64.encode(encrypt);

        return str;
    }

    public static String decrypt(String context, String privateKeyStr) {
        RSA rsa = new RSA(privateKeyStr, null);

        byte[] decrypt = rsa.decrypt(Base64.decode(context), KeyType.PrivateKey);

        String str = StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8);

        return str;
    }

}
