package thirdpartyservices.bhavishya.util;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import hisglobal.utility.Usefulmethods;

public class AESEncrytionDecryption {

    // Encrypt using AES/CBC/PKCS7
    public static String encrypt(String plainText) throws Exception {
        // Convert inputs to byte arrays
    	String key = Usefulmethods.getQuery("thirdpartyservices.bhavishya.service.cghs-bhavishya","bhavishya.aes.encryption.decryption.key");
    	String iv = Usefulmethods.getQuery("thirdpartyservices.bhavishya.service.cghs-bhavishya", "bhavishya.aes.encryption.decryption.key.iv");
    	
        byte[] keyBytes = key.getBytes();
        byte[] ivBytes = iv.getBytes();

        // Initialize Cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // PKCS5Padding works as PKCS7 in Java
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        // Encrypt
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Decrypt using AES/CBC/PKCS7
    public static String decrypt(String cipherText) throws Exception {
        // Convert inputs to byte arrays
//    	String key = Usefulmethods.getQuery("cghs-bhavishya","bhavishya.aes.encryption.decryption.key");
//    	String iv = Usefulmethods.getQuery("cghs-bhavishya", "bhavishya.aes.encryption.decryption.key.iv");
    	
    	String key = "ur32characterlongencryptionkey!!";
    	String iv = "our16bytesIVhere";
    	
        byte[] keyBytes = key.getBytes();
        byte[] ivBytes = iv.getBytes();

        // Initialize Cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // PKCS5Padding works as PKCS7 in Java
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

        // Decrypt
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(decryptedBytes);
    }

//    public static void main(String[] args) {
//        try {
//			String encryptedText = "Kq7IQj5S4bZHscxZyTKLe/xyVwN/q5m8rkkcwchCdeCzF1B7n44h3+T6lWIxM+kGANWATyDA/pW/iiOEmNcLkA==";
//        	String encryptedText = "uGJU+eys5LdFB2VOyLU2V/6+wtmKvv7ssSI2zXgNRtykl1FZy8XDH+UILaEOuhosNCefntZ9plWQfrkflNAulxe5UIZWOubZUuiaqSQFV6bmEdZUibGKXq7AAsc2G9Dl35OLuIgHfNVMu/2ETEulMVl9P11HdcZa7zZDfJcVgdhTGVT69zhNNJdsF89fZd4ibjdOi+lh2qfO/MV5bbH/UaFnXC/xKp9o2FQEgVfzThuw19MhJJxQx+6xPFN99Zk9SgHb4Xo0qeAz1XCMRVlwmSN8AcmeGYqT6eYz9jcvvz7XfLUIBEczVw86ajOAc0Mq/4sakRczaVU8h8MkBoKeTvPmpcXrKkAmFCyBrXZB9d0b8IbLuYLITmY2rTK6oK7ougfi/0EA+o9Sun0QJOH0Oqgzn0AXBHLtD2FBSKN/SEGKYuhO3QxNMzvLB3xgTcJckgBgpACr249qtUib5qdLoXeo4oxz2mmqlUqEvnAjJHn9nQ7icmkwldD8e72RqOGkYrY/2g7EzZgkUb4FBMuMe4fCVaT4mVIuMBvsI92aL88oY/L8N0ntxQrOnB9gx8itm7PZ0HfxDsVEZbUz934XLB2dypkqm2JtOmzEqzgypFEoaSOm14Z1UgxjYOPk6bykN3ncV+sMTrWP9NBP3ogxCUQeqHfuATJbWjZ2CoewnIIIdvXHv1SShEs8/OFEgTOUgC5pxFgwTQuMwkFmT9xwrjOMOd/+TejK5oLqac1KTsUN5HNhORMCuRm4IJ20qt+WZ+w8BSc18pEjWmZMQHMOIlsQ6g0mDQ4Bseqv90ZY2TrxT8yDzVQNQRvCYoMQcwbEyXODJQBjGkrsbLp077JkN6Mfm82KyxukZZ8S9VmeJ1VzxZFL8qeiqUl4Zyi8iFMLsK/uOzQ1QO/PgEV2q9NFtvt17HLymCnE++j4ZTuowjcw3ZY+tFdr4RjqIdCyeg/GrLXsEI1hjY+WR1xik0pHMV61sV/eneeelHPqR6yvJN0ihlUhiRDJ3J+KNGpU3m3kZ6Xvdlollc4Oe5ojOhDq+NevOjzIJR9QkiraN5Ju1d9b15Gjp1ysq+Ti2m0ay9+1b4BsTGbvce3VYcA8HCCoeKuD6OpQhXfBXOXK9Q3p+XtSRmcczd0tKn+2fLnIP/aIdTGBcKO+FuavXzo7slRUBPD8gsErcoFhS2EqqjtzRd372agx7OY2TKGOgmJNZDfheRBTs44UJ2QSFxEKZIIz37Esq51ih/WFhPfJCM378PRIyfduTcSga/YKGgstrjOzrMqf7XKktvnuoPHKMxQ5TGdcQxOsJS78cgvtsMSwxu0=";
//        	String encryptedText = "IrEz7pY8zJnOZLKSjxjRoebav/gX66ekuikb/D6coUeLP5F1eaEx5t/8K2z11K4SXket4pVdpef5PK+mbX65lA==";
//        	String encryptedText2 = "P8vwjjfPMFEYJUZdI4hY1RBgIrSeXs5DOxiBceZzd/ZaQCcjAVpv8s+91sAVQAeXubWbVQEJ1v55LRNRuMtWzoMcy2OnFOERsOttFFZ84eMqzDOgmTQc5LmwgAMi539KUu6/N9mMt60+ODVPzCiPFvpYdxji+M+9HOFOP36npo9g6xR49lofCVHTiYwCXzWkRAnge2IS+3aAg8chH4A/cNM0FetqFqNxocagDBsYZeW2JxitPL1+oEMmXtfKrm2y5e/KU6tdOoW4A9xNstparvAMdqF8wzwM3AXZll7xQIjsJZ5OX1oRDyY0CKTvVE1qzuuEo8S9jsckuo1Qd9PQaA==";
//            String decryptedText = decrypt(encryptedText);
//            System.out.println("Decrypted: " + decryptedText);
//            System.out.println("Decrypted 1 = "+decrypt(encryptedText2));
            
//            System.out.println("Encrypted: "+ encrypt("IMNPS1554W1740652570324"));
//            JSONObject obj = new JSONObject();
//            obj.put("pan", "IMNPS1223R1740783721847");
//            obj.put("beneficiaryId", "10020398989");
            
//            System.out.println("Encrypted: "+ encrypt(obj.toString()));
//            System.out.println(encrypt("ADCPY1949F1740783721847"));
//            System.out.println(encrypt("ABCPD1234E1741249560058"));
//            System.out.println(URLEncoder.encode("fptnu0nxgucs2cRhdRRzQ7XuS3WdQo/Ksn3/mDBfe+8=", StandardCharsets.UTF_8.toString() ));
            
//            System.out.println(decrypt("cheTUsYZ172MpRmU4DC0Cy7XfpEZZGyUa03QSXuQXLU"));
//            System.out.println(decrypt("6dMttNG2crR7qMpzm/e0awrkPsKy++Sgx7XJsduPsf0="));	
//            System.out.println("Failed Response Decrypt = "+decrypt("sq/hBUA4OHMOfp/yWaJJSg=="));
//            System.out.println("DEDPD8989D134323423423443".substring(0, 10));
//        	System.out.println("ARED3434K342423424524234".substring(9, "ARED3434K34242".length()));
            
//            System.out.println(BhavishyaIntegrationService.getBhavishyaLoginJWTToken("BBBPB9988B"));
            
//            String urlParamDecoded = URLDecoder.decode("6dMttNG2crR7qMpzm%2fe0awrkPsKy%2b%2bSgx7XJsduPsf0%3d", StandardCharsets.UTF_8.toString() );
//            System.out.println(urlParamDecoded);
//            System.out.println(decrypt("Kq7IQj5S4bZHscxZyTKLe/xyVwN/q5m8rkkcwchCdeCzF1B7n44h3+T6lWIxM+kGJWu+LclKfGkv16pgO0cRvQ=="));
//            System.out.println(encrypt("AAXPD0251L1741249560058"));
//            System.out.println(URLEncoder.encode("fptnu0nxgucs2cRhdRRzQ7XuS3WdQo/Ksn3/mDBfe+8=", StandardCharsets.UTF_8.toString() ));
            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
