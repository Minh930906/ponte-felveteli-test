package hu.ponte.hr.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignServiceTest {

    private SignService signService;

    @BeforeEach
    void setUp() {
        signService = new SignService();
    }

    @Test
    void getSignatureWithStringToSign() {
        byte[] imageDataToSign = "ImageTest".getBytes();
        String base64Signature;
        try {
            base64Signature = signService.getSignature(imageDataToSign);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertNotNull(base64Signature);
    }

    @Test
    void getSignatureWithEmptyStringToSign() {
        byte[] imageDataToSign = "".getBytes();
        String base64Signature;
        try {
            base64Signature = signService.getSignature(imageDataToSign);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertNotNull(base64Signature);
    }

    @Test
    void getSignatureWithNullStringToSign() {
        assertThrows(NullPointerException.class, () -> signService.getSignature(null));

    }
}