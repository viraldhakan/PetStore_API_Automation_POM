package PetStore.modules;

import PetStore.payload.Category;
import PetStore.payload.PetDetails;
import PetStore.payload.Tag;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

public class PayloadManager {

    private ObjectMapper objectMapper = new ObjectMapper();

    public String createPayload() throws JsonProcessingException {

        // Create a Category
        Category category = new Category();
        category.setId(10);
        category.setName("Bull Dog");

        // Create a Tag
        Tag tag1 = new Tag();
        tag1.setId(1);
        tag1.setName("friendly");

        Tag tag2 = new Tag();
        tag2.setId(2);
        tag2.setName("intelligent");

        // Create a PetDetails

        PetDetails petDetails = new PetDetails();
        petDetails.setId(101);
        petDetails.setCategory((category));
        petDetails.setName("Bruno");
        petDetails.setPhotoUrls(Arrays.asList("http://petstore.com/photos/bruno1.jpg", "http://petstore.com/photos/bruno2.jpg"));
        petDetails.setTags(Arrays.asList(tag1, tag2));
        petDetails.setStatus("available");

        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(petDetails);
        return payload;

    }

    public String updatePayload(int id) throws JsonProcessingException {

        Category category = new Category();
        category.setId(1);
        category.setName("Golden Retriever");

        Tag tag1 = new Tag();
        tag1.setId(6);
        tag1.setName("Family");

        Tag tag2 = new Tag();
        tag2.setId(7);
        tag2.setName("loyal");


        PetDetails petDetails = new PetDetails();
        petDetails.setId(id);
        petDetails.setCategory((category));
        petDetails.setName("Golden");
        petDetails.setPhotoUrls(Arrays.asList("http://petstore.com/photos/bruno5.jpg", "http://petstore.com/photos/bruno4.jpg"));
        petDetails.setTags(Arrays.asList(tag1, tag2));
        petDetails.setStatus("available");

        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(petDetails);
        return payload;

    }
}
