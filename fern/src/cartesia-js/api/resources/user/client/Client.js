"use strict";
/**
 * This file was auto-generated by Fern from our API Definition.
 */
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    var desc = Object.getOwnPropertyDescriptor(m, k);
    if (!desc || ("get" in desc ? !m.__esModule : desc.writable || desc.configurable)) {
      desc = { enumerable: true, get: function() { return m[k]; } };
    }
    Object.defineProperty(o, k2, desc);
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || (function () {
    var ownKeys = function(o) {
        ownKeys = Object.getOwnPropertyNames || function (o) {
            var ar = [];
            for (var k in o) if (Object.prototype.hasOwnProperty.call(o, k)) ar[ar.length] = k;
            return ar;
        };
        return ownKeys(o);
    };
    return function (mod) {
        if (mod && mod.__esModule) return mod;
        var result = {};
        if (mod != null) for (var k = ownKeys(mod), i = 0; i < k.length; i++) if (k[i] !== "default") __createBinding(result, mod, k[i]);
        __setModuleDefault(result, mod);
        return result;
    };
})();
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.User = void 0;
const environments = __importStar(require("../../../../environments"));
const core = __importStar(require("../../../../core"));
const url_join_1 = __importDefault(require("url-join"));
const serializers = __importStar(require("../../../../serialization/index"));
const errors = __importStar(require("../../../../errors/index"));
/**
 * Operations about user
 */
class User {
    constructor(_options = {}) {
        this._options = _options;
    }
    /**
     * @param {Cartesia.LoginUserRequest} request
     * @param {User.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @example
     *     await client.user.loginUser()
     */
    loginUser() {
        return __awaiter(this, arguments, void 0, function* (request = {}, requestOptions) {
            var _a, _b, _c;
            const { username, password } = request;
            const _queryParams = {};
            if (username != null) {
                _queryParams["username"] = username;
            }
            if (password != null) {
                _queryParams["password"] = password;
            }
            const _response = yield ((_a = this._options.fetcher) !== null && _a !== void 0 ? _a : core.fetcher)({
                url: (0, url_join_1.default)((_c = (_b = (yield core.Supplier.get(this._options.baseUrl))) !== null && _b !== void 0 ? _b : (yield core.Supplier.get(this._options.environment))) !== null && _c !== void 0 ? _c : environments.CartesiaEnvironment.Default, "user/auth/login"),
                method: "GET",
                headers: Object.assign({ "X-Fern-Language": "JavaScript", "X-Fern-Runtime": core.RUNTIME.type, "X-Fern-Runtime-Version": core.RUNTIME.version }, requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.headers),
                contentType: "application/json",
                queryParameters: _queryParams,
                requestType: "json",
                timeoutMs: (requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.timeoutInSeconds) != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
                maxRetries: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.maxRetries,
                abortSignal: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.abortSignal,
            });
            if (_response.ok) {
                return serializers.UserAuthResponse.parseOrThrow(_response.body, {
                    unrecognizedObjectKeys: "passthrough",
                    allowUnrecognizedUnionMembers: true,
                    allowUnrecognizedEnumValues: true,
                    skipValidation: true,
                    breadcrumbsPrefix: ["response"],
                });
            }
            if (_response.error.reason === "status-code") {
                throw new errors.CartesiaError({
                    statusCode: _response.error.statusCode,
                    body: _response.error.body,
                });
            }
            switch (_response.error.reason) {
                case "non-json":
                    throw new errors.CartesiaError({
                        statusCode: _response.error.statusCode,
                        body: _response.error.rawBody,
                    });
                case "timeout":
                    throw new errors.CartesiaTimeoutError("Timeout exceeded when calling GET /user/auth/login.");
                case "unknown":
                    throw new errors.CartesiaError({
                        message: _response.error.errorMessage,
                    });
            }
        });
    }
    /**
     * @param {User.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @example
     *     await client.user.logoutUser()
     */
    logoutUser(requestOptions) {
        return __awaiter(this, void 0, void 0, function* () {
            var _a, _b, _c;
            const _response = yield ((_a = this._options.fetcher) !== null && _a !== void 0 ? _a : core.fetcher)({
                url: (0, url_join_1.default)((_c = (_b = (yield core.Supplier.get(this._options.baseUrl))) !== null && _b !== void 0 ? _b : (yield core.Supplier.get(this._options.environment))) !== null && _c !== void 0 ? _c : environments.CartesiaEnvironment.Default, "user/auth/logout"),
                method: "GET",
                headers: Object.assign({ "X-Fern-Language": "JavaScript", "X-Fern-Runtime": core.RUNTIME.type, "X-Fern-Runtime-Version": core.RUNTIME.version }, requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.headers),
                contentType: "application/json",
                requestType: "json",
                timeoutMs: (requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.timeoutInSeconds) != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
                maxRetries: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.maxRetries,
                abortSignal: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.abortSignal,
            });
            if (_response.ok) {
                return;
            }
            if (_response.error.reason === "status-code") {
                throw new errors.CartesiaError({
                    statusCode: _response.error.statusCode,
                    body: _response.error.body,
                });
            }
            switch (_response.error.reason) {
                case "non-json":
                    throw new errors.CartesiaError({
                        statusCode: _response.error.statusCode,
                        body: _response.error.rawBody,
                    });
                case "timeout":
                    throw new errors.CartesiaTimeoutError("Timeout exceeded when calling GET /user/auth/logout.");
                case "unknown":
                    throw new errors.CartesiaError({
                        message: _response.error.errorMessage,
                    });
            }
        });
    }
    /**
     * Retrieve user details using their username.
     *
     * @param {string} username - Username of the user to retrieve
     * @param {User.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @example
     *     await client.user.getUserByName("username")
     */
    getUserByName(username, requestOptions) {
        return __awaiter(this, void 0, void 0, function* () {
            var _a, _b, _c;
            const _response = yield ((_a = this._options.fetcher) !== null && _a !== void 0 ? _a : core.fetcher)({
                url: (0, url_join_1.default)((_c = (_b = (yield core.Supplier.get(this._options.baseUrl))) !== null && _b !== void 0 ? _b : (yield core.Supplier.get(this._options.environment))) !== null && _c !== void 0 ? _c : environments.CartesiaEnvironment.Default, `user/${encodeURIComponent(username)}`),
                method: "GET",
                headers: Object.assign({ "X-Fern-Language": "JavaScript", "X-Fern-Runtime": core.RUNTIME.type, "X-Fern-Runtime-Version": core.RUNTIME.version }, requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.headers),
                contentType: "application/json",
                requestType: "json",
                timeoutMs: (requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.timeoutInSeconds) != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
                maxRetries: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.maxRetries,
                abortSignal: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.abortSignal,
            });
            if (_response.ok) {
                return serializers.User.parseOrThrow(_response.body, {
                    unrecognizedObjectKeys: "passthrough",
                    allowUnrecognizedUnionMembers: true,
                    allowUnrecognizedEnumValues: true,
                    skipValidation: true,
                    breadcrumbsPrefix: ["response"],
                });
            }
            if (_response.error.reason === "status-code") {
                throw new errors.CartesiaError({
                    statusCode: _response.error.statusCode,
                    body: _response.error.body,
                });
            }
            switch (_response.error.reason) {
                case "non-json":
                    throw new errors.CartesiaError({
                        statusCode: _response.error.statusCode,
                        body: _response.error.rawBody,
                    });
                case "timeout":
                    throw new errors.CartesiaTimeoutError("Timeout exceeded when calling GET /user/{username}.");
                case "unknown":
                    throw new errors.CartesiaError({
                        message: _response.error.errorMessage,
                    });
            }
        });
    }
}
exports.User = User;
