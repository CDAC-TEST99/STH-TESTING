###Procedure 9.1. Create a Private/Public Key Pair with Keytool###
"c:\Program Files\Java\jdk1.8.0_191\bin\keytool.exe" -genkey -alias root@123 -storepass secret -keypass secret -keystore private.key -keyalg RSA -validity 365 -storetype PKCS12

###How to import a .cer certificate into a java keystore###
"c:\Program Files\Java\jdk1.8.0_191\bin\keytool.exe" -importcert -file MuditBhargava.cer -alias root -storepass secret -keypass secret -keystore private.key

###Extracting the Private Key With OpenSSL and Keytool###
###1. Convert JKS to the PKCS12 format:###
"c:\Program Files\Java\jdk1.8.0_191\bin\keytool.exe" -importkeystore -srckeystore PAN-Private.key -srcstorepass secret -srckeypass secret -srcalias root -destalias root -destkeystore PAN-CACert.pfx -deststoretype PKCS12 -deststorepass secret -destkeypass secret 

