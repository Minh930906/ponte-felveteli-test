package hu.ponte.hr.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.*;
import java.util.Base64;

@Service
@Slf4j
public class SignService {

    public String getSignature(String name) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {

        log.info("Generating digital signature...");

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        PrivateKey privateKey = keyPair.getPrivate();

        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);

        byte[] data = name.getBytes();
        signature.update(data);

        byte[] digitalSignature = signature.sign();

        String base64Signature = Base64.getEncoder().encodeToString(digitalSignature);

        log.info("Digital signature generated successfully.");

        return base64Signature;
    }
}
