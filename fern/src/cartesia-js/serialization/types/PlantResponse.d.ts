/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as Cartesia from "../../api/index";
import * as core from "../../core";
export declare const PlantResponse: core.serialization.ObjectSchema<serializers.PlantResponse.Raw, Cartesia.PlantResponse>;
export declare namespace PlantResponse {
    interface Raw {
        id?: number | null;
        name?: string | null;
        status?: string | null;
        tags?: string[] | null;
    }
}
