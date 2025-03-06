/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.plant;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import core.ClientOptions;
import core.MediaTypes;
import core.ObjectMappers;
import core.PlantstoreApiApiException;
import core.PlantstoreApiException;
import core.QueryStringMapper;
import core.RequestOptions;
import errors.BadRequestError;
import errors.MethodNotAllowedError;
import errors.NotFoundError;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import resources.plant.requests.SearchPlantsByStatusRequest;
import resources.plant.requests.SearchPlantsByTagsRequest;
import types.Plant;
import types.PlantResponse;

public class AsyncPlantClient {
  protected final ClientOptions clientOptions;

  public AsyncPlantClient(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  public CompletableFuture<PlantResponse> addPlant() {
    return addPlant(Plant.builder().build());
  }

  public CompletableFuture<PlantResponse> addPlant(Plant request) {
    return addPlant(request,null);
  }

  public CompletableFuture<PlantResponse> addPlant(Plant request, RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("plant")
      .build();
    RequestBody body;
    try {
      body = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
    }
    catch(JsonProcessingException e) {
      throw new PlantstoreApiException("Failed to serialize request", e);
    }
    Request okhttpRequest = new Request.Builder()
      .url(httpUrl)
      .method("POST", body)
      .headers(Headers.of(clientOptions.headers(requestOptions)))
      .addHeader("Content-Type", "application/json")
      .addHeader("Accept", "application/json")
      .build();
    OkHttpClient client = clientOptions.httpClient();
    if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
      client = clientOptions.httpClientWithTimeout(requestOptions);
    }
    CompletableFuture<PlantResponse> future = new CompletableFuture<>();
    client.newCall(okhttpRequest).enqueue(new Callback() {
      @Override
      public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        try (ResponseBody responseBody = response.body()) {
          if (response.isSuccessful()) {
            future.complete(ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PlantResponse.class));
            return;
          }
          String responseBodyString = responseBody != null ? responseBody.string() : "{}";
          try {
            if (response.code() == 405) {
              future.completeExceptionally(new MethodNotAllowedError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
              return;
            }
          }
          catch (JsonProcessingException ignored) {
            // unable to map error response, throwing generic error
          }
          future.completeExceptionally(new PlantstoreApiApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
          return;
        }
        catch (IOException e) {
          future.completeExceptionally(new PlantstoreApiException("Network error executing HTTP request", e));
        }
      }

      @Override
      public void onFailure(@NotNull Call call, @NotNull IOException e) {
        future.completeExceptionally(new PlantstoreApiException("Network error executing HTTP request", e));
      }
    });
    return future;
  }

  public CompletableFuture<PlantResponse> updatePlant() {
    return updatePlant(Plant.builder().build());
  }

  public CompletableFuture<PlantResponse> updatePlant(Plant request) {
    return updatePlant(request,null);
  }

  public CompletableFuture<PlantResponse> updatePlant(Plant request,
      RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("plant")
      .build();
    RequestBody body;
    try {
      body = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
    }
    catch(JsonProcessingException e) {
      throw new PlantstoreApiException("Failed to serialize request", e);
    }
    Request okhttpRequest = new Request.Builder()
      .url(httpUrl)
      .method("PUT", body)
      .headers(Headers.of(clientOptions.headers(requestOptions)))
      .addHeader("Content-Type", "application/json")
      .addHeader("Accept", "application/json")
      .build();
    OkHttpClient client = clientOptions.httpClient();
    if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
      client = clientOptions.httpClientWithTimeout(requestOptions);
    }
    CompletableFuture<PlantResponse> future = new CompletableFuture<>();
    client.newCall(okhttpRequest).enqueue(new Callback() {
      @Override
      public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        try (ResponseBody responseBody = response.body()) {
          if (response.isSuccessful()) {
            future.complete(ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PlantResponse.class));
            return;
          }
          String responseBodyString = responseBody != null ? responseBody.string() : "{}";
          try {
            switch (response.code()) {
              case 400:future.completeExceptionally(new BadRequestError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
              return;
              case 404:future.completeExceptionally(new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
              return;
            }
          }
          catch (JsonProcessingException ignored) {
            // unable to map error response, throwing generic error
          }
          future.completeExceptionally(new PlantstoreApiApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
          return;
        }
        catch (IOException e) {
          future.completeExceptionally(new PlantstoreApiException("Network error executing HTTP request", e));
        }
      }

      @Override
      public void onFailure(@NotNull Call call, @NotNull IOException e) {
        future.completeExceptionally(new PlantstoreApiException("Network error executing HTTP request", e));
      }
    });
    return future;
  }

  /**
   * Filter plants based on their current status.
   */
  public CompletableFuture<List<PlantResponse>> searchPlantsByStatus() {
    return searchPlantsByStatus(SearchPlantsByStatusRequest.builder().build());
  }

  /**
   * Filter plants based on their current status.
   */
  public CompletableFuture<List<PlantResponse>> searchPlantsByStatus(
      SearchPlantsByStatusRequest request) {
    return searchPlantsByStatus(request,null);
  }

  /**
   * Filter plants based on their current status.
   */
  public CompletableFuture<List<PlantResponse>> searchPlantsByStatus(
      SearchPlantsByStatusRequest request, RequestOptions requestOptions) {
    HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("plant/search/status");if (request.getStatus().isPresent()) {
        QueryStringMapper.addQueryParameter(httpUrl, "status", request.getStatus().get().toString(), false);
      }
      Request.Builder _requestBuilder = new Request.Builder()
        .url(httpUrl.build())
        .method("GET", null)
        .headers(Headers.of(clientOptions.headers(requestOptions)))
        .addHeader("Content-Type", "application/json")
        .addHeader("Accept", "application/json");
      Request okhttpRequest = _requestBuilder.build();
      OkHttpClient client = clientOptions.httpClient();
      if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
        client = clientOptions.httpClientWithTimeout(requestOptions);
      }
      CompletableFuture<List<PlantResponse>> future = new CompletableFuture<>();
      client.newCall(okhttpRequest).enqueue(new Callback() {
        @Override
        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
          try (ResponseBody responseBody = response.body()) {
            if (response.isSuccessful()) {
              future.complete(ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), new TypeReference<List<PlantResponse>>() {}));
              return;
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            future.completeExceptionally(new PlantstoreApiApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
            return;
          }
          catch (IOException e) {
            future.completeExceptionally(new PlantstoreApiException("Network error executing HTTP request", e));
          }
        }

        @Override
        public void onFailure(@NotNull Call call, @NotNull IOException e) {
          future.completeExceptionally(new PlantstoreApiException("Network error executing HTTP request", e));
        }
      });
      return future;
    }

    /**
     * Filter plants based on associated tags.
     */
    public CompletableFuture<List<PlantResponse>> searchPlantsByTags() {
      return searchPlantsByTags(SearchPlantsByTagsRequest.builder().build());
    }

    /**
     * Filter plants based on associated tags.
     */
    public CompletableFuture<List<PlantResponse>> searchPlantsByTags(
        SearchPlantsByTagsRequest request) {
      return searchPlantsByTags(request,null);
    }

    /**
     * Filter plants based on associated tags.
     */
    public CompletableFuture<List<PlantResponse>> searchPlantsByTags(
        SearchPlantsByTagsRequest request, RequestOptions requestOptions) {
      HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

        .addPathSegments("plant/search/tags");if (request.getTags().isPresent()) {
          QueryStringMapper.addQueryParameter(httpUrl, "tags", request.getTags().get(), false);
        }
        Request.Builder _requestBuilder = new Request.Builder()
          .url(httpUrl.build())
          .method("GET", null)
          .headers(Headers.of(clientOptions.headers(requestOptions)))
          .addHeader("Content-Type", "application/json")
          .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
          client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<List<PlantResponse>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
          @Override
          public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            try (ResponseBody responseBody = response.body()) {
              if (response.isSuccessful()) {
                future.complete(ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), new TypeReference<List<PlantResponse>>() {}));
                return;
              }
              String responseBodyString = responseBody != null ? responseBody.string() : "{}";
              future.completeExceptionally(new PlantstoreApiApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
              return;
            }
            catch (IOException e) {
              future.completeExceptionally(new PlantstoreApiException("Network error executing HTTP request", e));
            }
          }

          @Override
          public void onFailure(@NotNull Call call, @NotNull IOException e) {
            future.completeExceptionally(new PlantstoreApiException("Network error executing HTTP request", e));
          }
        });
        return future;
      }

      /**
       * Retrieve a plant's details by its ID.
       */
      public CompletableFuture<PlantResponse> getPlantById(int plantId) {
        return getPlantById(plantId,null);
      }

      /**
       * Retrieve a plant's details by its ID.
       */
      public CompletableFuture<PlantResponse> getPlantById(int plantId,
          RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

          .addPathSegments("plant")
          .addPathSegment(Integer.toString(plantId))
          .build();
        Request okhttpRequest = new Request.Builder()
          .url(httpUrl)
          .method("GET", null)
          .headers(Headers.of(clientOptions.headers(requestOptions)))
          .addHeader("Content-Type", "application/json")
          .addHeader("Accept", "application/json")
          .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
          client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<PlantResponse> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
          @Override
          public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            try (ResponseBody responseBody = response.body()) {
              if (response.isSuccessful()) {
                future.complete(ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PlantResponse.class));
                return;
              }
              String responseBodyString = responseBody != null ? responseBody.string() : "{}";
              future.completeExceptionally(new PlantstoreApiApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class)));
              return;
            }
            catch (IOException e) {
              future.completeExceptionally(new PlantstoreApiException("Network error executing HTTP request", e));
            }
          }

          @Override
          public void onFailure(@NotNull Call call, @NotNull IOException e) {
            future.completeExceptionally(new PlantstoreApiException("Network error executing HTTP request", e));
          }
        });
        return future;
      }
    }
