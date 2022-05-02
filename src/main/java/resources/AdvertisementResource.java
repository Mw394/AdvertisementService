package resources;


import model.Category;
import model.Type;
import resources.dto.dtoAdvertisement;
import service.AdvertisementService;
import service.request.CreateAdvertisementRequest;
import service.request.GetAdvertisementRequest;
import service.request.GetAdvertisementsRequest;
import service.request.UpdateAdvertisementRequest;
import service.response.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/advertisement")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdvertisementResource {

    private final AdvertisementService service;

    @Inject
    public AdvertisementResource(AdvertisementService service) {
        this.service = service;
    }

    @Path("/create")
    @POST
    public CreateAdvertisementResponse createAdvertisement(dtoAdvertisement dtoAdvertisement) {
        CreateAdvertisementRequest cdr = new CreateAdvertisementRequest(dtoAdvertisement);
        CreateAdvertisementResponse createAdvertisementResponse = service.createAdvertisement(cdr);
        return createAdvertisementResponse;
    }

    @Path("/update")
    @POST
    public UpdateAdvertisementResponse updateAdvertisement(dtoAdvertisement dtoAdvertisement,@DefaultValue("false") @QueryParam("delete") boolean delete) {
        UpdateAdvertisementRequest request = new UpdateAdvertisementRequest(dtoAdvertisement, delete);
        UpdateAdvertisementResponse response = service.updateAdvertisement(request);
        return response;
    }

    @Path("/get")
    @GET
    public GetAdvertisementsResponse getAdvertisements(@QueryParam("category") Category category, @QueryParam("type") Type type) {
        GetAdvertisementsRequest request = new GetAdvertisementsRequest(category, type);
        GetAdvertisementsResponse response = service.getAdvertisements(request);
        return response;
    }

    @Path("/getByID")
    @GET
    public GetAdvertisementResponse getAdvertisement(@QueryParam("id") String id) {
        GetAdvertisementResponse response = service.getAdvertisement(new GetAdvertisementRequest(id));
        return response;
    }

    @Path("/categories")
    @GET
    public GetCategoriesResponse getCategories() {
        return service.getCategories();
    }


}
