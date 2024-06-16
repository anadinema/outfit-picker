package dev.anadinema.projects.controller;

import dev.anadinema.projects.model.dto.request.RecommendationRequest;
import dev.anadinema.projects.service.RecommendationService;
import io.smallrye.mutiny.Uni;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/outfit")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @POST
    @Path("/recommendations")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Response> getRecommendations(@Valid @NotNull final RecommendationRequest recommendationRequest) {
        return recommendationService.buildRecommendations(recommendationRequest);
    }

}
