/**
 * This file was auto-generated by Fern from our API Definition.
 */

import core.ClientOptions;
import core.Suppliers;
import java.util.function.Supplier;
import resources.plant.AsyncPlantClient;
import resources.user.AsyncUserClient;

public class AsyncPlantstoreApiClient {
  protected final ClientOptions clientOptions;

  protected final Supplier<AsyncPlantClient> plantClient;

  protected final Supplier<AsyncUserClient> userClient;

  public AsyncPlantstoreApiClient(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
    this.plantClient = Suppliers.memoize(() -> new AsyncPlantClient(clientOptions));
    this.userClient = Suppliers.memoize(() -> new AsyncUserClient(clientOptions));
  }

  public AsyncPlantClient plant() {
    return this.plantClient.get();
  }

  public AsyncUserClient user() {
    return this.userClient.get();
  }

  public static PlantstoreApiClientBuilder builder() {
    return new PlantstoreApiClientBuilder();
  }
}
