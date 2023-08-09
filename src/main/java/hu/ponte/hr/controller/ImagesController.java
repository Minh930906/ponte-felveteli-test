package hu.ponte.hr.controller;


import hu.ponte.hr.services.ImageStore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@RestController()
@RequestMapping("api/images")
@Api(tags = "Image Operation Endpoints")
public class ImagesController {

    @Autowired
    private ImageStore imageStore;

    @GetMapping("meta")
    @ApiOperation(value = "List all uploaded images",notes = "Retrieve all uploaded images")
    public List<ImageMeta> listImages() {
        return imageStore.findAll();
    }

    @GetMapping("preview/{id}")
    @ApiOperation(value = "Get image by ID",notes = "Retrieve an image by its ID")
    public void getImage(@PathVariable("id") String id, HttpServletResponse response) throws IOException {
        ImageMeta imageById = imageStore.findImageById(id);
        response.setContentType(imageById.getMimeType());
        response.setContentLengthLong(imageById.getSize());

        OutputStream outputStream = response.getOutputStream();
        outputStream.write(imageById.getImageData());
        outputStream.close();
    }

}
