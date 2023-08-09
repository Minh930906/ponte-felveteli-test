package hu.ponte.hr.controller.upload;

import hu.ponte.hr.services.ImageStore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Component
@RequestMapping("api/file")
@Api(tags = "Handle Image Upload")
public class UploadController
{

    @Autowired
    private ImageStore imageStore;

    @RequestMapping(value = "post", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "Uploading and generate signature for image",notes = "Uploading and generate signature for image")
    public ResponseEntity<String> handleFormUpload(@RequestParam("file") MultipartFile file) {
        try {
            String id = UUID.randomUUID().toString();
            String name = file.getOriginalFilename();
            String mimeType = file.getContentType();
            long size = file.getSize();
            byte[] imageData = file.getBytes();

            imageStore.saveImage(id, name, mimeType, size, imageData);

            return ResponseEntity.ok("Image uploaded successfully");
        }catch (IOException er){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while processing the uploaded image.");
        }
    }
}
