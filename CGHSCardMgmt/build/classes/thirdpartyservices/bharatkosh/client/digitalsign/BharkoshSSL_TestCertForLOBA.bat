#####=========================================================================#####
#####=========================================================================#####

###Procedure 9.1. Create a Private/Public Key Pair with Keytool###
"c:\Program Files\Java\jdk1.8.0_191\bin\keytool.exe" -genkey -alias root@123 -storepass loba#ntrp@123 -keypass loba#ntrp@123 -keystore PAN-Private.key -keyalg RSA -validity 365 -storetype PKCS12 -dname "CN=CertForPAN"

###How to import a .cer certificate into a java keystore###
"c:\Program Files\Java\jdk1.8.0_191\bin\keytool.exe" -importcert -file MuditBhargava.cer -alias root -storepass loba#ntrp@123 -keypass loba#ntrp@123 -keystore PAN-Private.key

###Extracting the Private Key With OpenSSL and Keytool###
###1. Convert JKS to the PKCS12 format:###
"c:\Program Files\Java\jdk1.8.0_191\bin\keytool.exe" -importkeystore -srckeystore PAN-Private.key -srcstorepass loba#ntrp@123 -srckeypass loba#ntrp@123 -srcalias root -destalias root -destkeystore PAN-CACert.pfx -deststoretype PKCS12 -deststorepass loba#ntrp@123 -destkeypass secret 


#####=========================================================================#####
#####=========================================================================#####
##Exporting the Private Key:C:\Users\sumit.jagia\AppData\Local\Programs\Git\usr\bin\openssl###
openssl pkcs12 -in bharatkosh-test.p12 -legacy -nodes -nocerts -out bharatkosh-test-private.key

##Exporting the Public Key:C:\Users\sumit.jagia\AppData\Local\Programs\Git\usr\bin\openssl###
openssl pkcs12 -in bharatkosh-test.pfx -legacy -nokeys -out bharatkosh-testkey_cert.pem


##How to view the contents of a .pem certificate###
openssl x509 -in bharatkosh-testkey_cert.pem -text

###How to check certificate name and alias in keystore files###
"c:\Program Files\Java\jdk1.8.0_191\bin\keytool.exe" -v -list -keystore TestCertForLOBA_Exp_2026.pfx

###Export cer file to pfx
openssl x509 -inform der -in certificate.cer -out certificate.pem
openssl pkcs12 -export -out certificate.pfx -inkey private.pem -in certificate.pem

#####=========================================================================#####
#####=========================================================================#####
