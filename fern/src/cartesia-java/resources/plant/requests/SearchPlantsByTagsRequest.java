/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.plant.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import core.ObjectMappers;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(
    builder = SearchPlantsByTagsRequest.Builder.class
)
public final class SearchPlantsByTagsRequest {
  private final Optional<String> tags;

  private final Map<String, Object> additionalProperties;

  private SearchPlantsByTagsRequest(Optional<String> tags,
      Map<String, Object> additionalProperties) {
    this.tags = tags;
    this.additionalProperties = additionalProperties;
  }

  /**
   * @return Tags to filter plants (comma-separated).
   */
  @JsonProperty("tags")
  public Optional<String> getTags() {
    return tags;
  }

  @java.lang.Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SearchPlantsByTagsRequest && equalTo((SearchPlantsByTagsRequest) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(SearchPlantsByTagsRequest other) {
    return tags.equals(other.tags);
  }

  @java.lang.Override
  public int hashCode() {
    return Objects.hash(this.tags);
  }

  @java.lang.Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> tags = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(SearchPlantsByTagsRequest other) {
      tags(other.getTags());
      return this;
    }

    @JsonSetter(
        value = "tags",
        nulls = Nulls.SKIP
    )
    public Builder tags(Optional<String> tags) {
      this.tags = tags;
      return this;
    }

    public Builder tags(String tags) {
      this.tags = Optional.ofNullable(tags);
      return this;
    }

    public SearchPlantsByTagsRequest build() {
      return new SearchPlantsByTagsRequest(tags, additionalProperties);
    }
  }
}
