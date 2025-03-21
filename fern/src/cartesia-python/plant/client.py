# This file was auto-generated by Fern from our API Definition.

import typing
from ..core.client_wrapper import SyncClientWrapper
from ..types.plant_status import PlantStatus
from ..core.request_options import RequestOptions
from ..types.plant_response import PlantResponse
from ..core.pydantic_utilities import parse_obj_as
from ..errors.method_not_allowed_error import MethodNotAllowedError
from json.decoder import JSONDecodeError
from ..core.api_error import ApiError
from ..errors.bad_request_error import BadRequestError
from ..errors.not_found_error import NotFoundError
from .types.search_plants_by_status_request_status import (
    SearchPlantsByStatusRequestStatus,
)
from ..core.jsonable_encoder import jsonable_encoder
from ..core.client_wrapper import AsyncClientWrapper

# this is used as the default value for optional parameters
OMIT = typing.cast(typing.Any, ...)


class PlantClient:
    def __init__(self, *, client_wrapper: SyncClientWrapper):
        self._client_wrapper = client_wrapper

    def add_plant(
        self,
        *,
        name: typing.Optional[str] = OMIT,
        category: typing.Optional[str] = OMIT,
        tags: typing.Optional[typing.Sequence[str]] = OMIT,
        status: typing.Optional[PlantStatus] = OMIT,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> PlantResponse:
        """
        Parameters
        ----------
        name : typing.Optional[str]

        category : typing.Optional[str]

        tags : typing.Optional[typing.Sequence[str]]

        status : typing.Optional[PlantStatus]

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        PlantResponse
            Plant successfully added

        Examples
        --------
        from plantstore import Cartesia

        client = Cartesia()
        client.plant.add_plant(
            name="Fern",
            category="Indoor",
            tags=["green", "leafy"],
            status="available",
        )
        """
        _response = self._client_wrapper.httpx_client.request(
            "plant",
            method="POST",
            json={
                "name": name,
                "category": category,
                "tags": tags,
                "status": status,
            },
            request_options=request_options,
            omit=OMIT,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    PlantResponse,
                    parse_obj_as(
                        type_=PlantResponse,  # type: ignore
                        object_=_response.json(),
                    ),
                )
            if _response.status_code == 405:
                raise MethodNotAllowedError(
                    typing.cast(
                        typing.Optional[typing.Any],
                        parse_obj_as(
                            type_=typing.Optional[typing.Any],  # type: ignore
                            object_=_response.json(),
                        ),
                    )
                )
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    def update_plant(
        self,
        *,
        name: typing.Optional[str] = OMIT,
        category: typing.Optional[str] = OMIT,
        tags: typing.Optional[typing.Sequence[str]] = OMIT,
        status: typing.Optional[PlantStatus] = OMIT,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> PlantResponse:
        """
        Parameters
        ----------
        name : typing.Optional[str]

        category : typing.Optional[str]

        tags : typing.Optional[typing.Sequence[str]]

        status : typing.Optional[PlantStatus]

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        PlantResponse
            Plant successfully updated

        Examples
        --------
        from plantstore import Cartesia

        client = Cartesia()
        client.plant.update_plant(
            name="Fern",
            category="Indoor",
            tags=["green", "leafy"],
            status="sold",
        )
        """
        _response = self._client_wrapper.httpx_client.request(
            "plant",
            method="PUT",
            json={
                "name": name,
                "category": category,
                "tags": tags,
                "status": status,
            },
            request_options=request_options,
            omit=OMIT,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    PlantResponse,
                    parse_obj_as(
                        type_=PlantResponse,  # type: ignore
                        object_=_response.json(),
                    ),
                )
            if _response.status_code == 400:
                raise BadRequestError(
                    typing.cast(
                        typing.Optional[typing.Any],
                        parse_obj_as(
                            type_=typing.Optional[typing.Any],  # type: ignore
                            object_=_response.json(),
                        ),
                    )
                )
            if _response.status_code == 404:
                raise NotFoundError(
                    typing.cast(
                        typing.Optional[typing.Any],
                        parse_obj_as(
                            type_=typing.Optional[typing.Any],  # type: ignore
                            object_=_response.json(),
                        ),
                    )
                )
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    def search_plants_by_status(
        self,
        *,
        status: typing.Optional[SearchPlantsByStatusRequestStatus] = None,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> typing.List[PlantResponse]:
        """
        Filter plants based on their current status.

        Parameters
        ----------
        status : typing.Optional[SearchPlantsByStatusRequestStatus]
            The status of plants to search for.

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        typing.List[PlantResponse]
            List of plants matching the status filter

        Examples
        --------
        from plantstore import Cartesia

        client = Cartesia()
        client.plant.search_plants_by_status()
        """
        _response = self._client_wrapper.httpx_client.request(
            "plant/search/status",
            method="GET",
            params={
                "status": status,
            },
            request_options=request_options,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    typing.List[PlantResponse],
                    parse_obj_as(
                        type_=typing.List[PlantResponse],  # type: ignore
                        object_=_response.json(),
                    ),
                )
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    def search_plants_by_tags(
        self,
        *,
        tags: typing.Optional[typing.Union[str, typing.Sequence[str]]] = None,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> typing.List[PlantResponse]:
        """
        Filter plants based on associated tags.

        Parameters
        ----------
        tags : typing.Optional[typing.Union[str, typing.Sequence[str]]]
            Tags to filter plants (comma-separated).

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        typing.List[PlantResponse]
            List of plants matching the tags filter

        Examples
        --------
        from plantstore import Cartesia

        client = Cartesia()
        client.plant.search_plants_by_tags()
        """
        _response = self._client_wrapper.httpx_client.request(
            "plant/search/tags",
            method="GET",
            params={
                "tags": tags,
            },
            request_options=request_options,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    typing.List[PlantResponse],
                    parse_obj_as(
                        type_=typing.List[PlantResponse],  # type: ignore
                        object_=_response.json(),
                    ),
                )
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    def get_plant_by_id(
        self, plant_id: int, *, request_options: typing.Optional[RequestOptions] = None
    ) -> PlantResponse:
        """
        Retrieve a plant's details by its ID.

        Parameters
        ----------
        plant_id : int
            ID of the plant to retrieve

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        PlantResponse
            Details of the requested plant

        Examples
        --------
        from plantstore import Cartesia

        client = Cartesia()
        client.plant.get_plant_by_id(
            plant_id=1,
        )
        """
        _response = self._client_wrapper.httpx_client.request(
            f"plant/{jsonable_encoder(plant_id)}",
            method="GET",
            request_options=request_options,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    PlantResponse,
                    parse_obj_as(
                        type_=PlantResponse,  # type: ignore
                        object_=_response.json(),
                    ),
                )
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)


class AsyncPlantClient:
    def __init__(self, *, client_wrapper: AsyncClientWrapper):
        self._client_wrapper = client_wrapper

    async def add_plant(
        self,
        *,
        name: typing.Optional[str] = OMIT,
        category: typing.Optional[str] = OMIT,
        tags: typing.Optional[typing.Sequence[str]] = OMIT,
        status: typing.Optional[PlantStatus] = OMIT,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> PlantResponse:
        """
        Parameters
        ----------
        name : typing.Optional[str]

        category : typing.Optional[str]

        tags : typing.Optional[typing.Sequence[str]]

        status : typing.Optional[PlantStatus]

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        PlantResponse
            Plant successfully added

        Examples
        --------
        import asyncio

        from plantstore import AsyncCartesia

        client = AsyncCartesia()


        async def main() -> None:
            await client.plant.add_plant(
                name="Fern",
                category="Indoor",
                tags=["green", "leafy"],
                status="available",
            )


        asyncio.run(main())
        """
        _response = await self._client_wrapper.httpx_client.request(
            "plant",
            method="POST",
            json={
                "name": name,
                "category": category,
                "tags": tags,
                "status": status,
            },
            request_options=request_options,
            omit=OMIT,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    PlantResponse,
                    parse_obj_as(
                        type_=PlantResponse,  # type: ignore
                        object_=_response.json(),
                    ),
                )
            if _response.status_code == 405:
                raise MethodNotAllowedError(
                    typing.cast(
                        typing.Optional[typing.Any],
                        parse_obj_as(
                            type_=typing.Optional[typing.Any],  # type: ignore
                            object_=_response.json(),
                        ),
                    )
                )
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    async def update_plant(
        self,
        *,
        name: typing.Optional[str] = OMIT,
        category: typing.Optional[str] = OMIT,
        tags: typing.Optional[typing.Sequence[str]] = OMIT,
        status: typing.Optional[PlantStatus] = OMIT,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> PlantResponse:
        """
        Parameters
        ----------
        name : typing.Optional[str]

        category : typing.Optional[str]

        tags : typing.Optional[typing.Sequence[str]]

        status : typing.Optional[PlantStatus]

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        PlantResponse
            Plant successfully updated

        Examples
        --------
        import asyncio

        from plantstore import AsyncCartesia

        client = AsyncCartesia()


        async def main() -> None:
            await client.plant.update_plant(
                name="Fern",
                category="Indoor",
                tags=["green", "leafy"],
                status="sold",
            )


        asyncio.run(main())
        """
        _response = await self._client_wrapper.httpx_client.request(
            "plant",
            method="PUT",
            json={
                "name": name,
                "category": category,
                "tags": tags,
                "status": status,
            },
            request_options=request_options,
            omit=OMIT,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    PlantResponse,
                    parse_obj_as(
                        type_=PlantResponse,  # type: ignore
                        object_=_response.json(),
                    ),
                )
            if _response.status_code == 400:
                raise BadRequestError(
                    typing.cast(
                        typing.Optional[typing.Any],
                        parse_obj_as(
                            type_=typing.Optional[typing.Any],  # type: ignore
                            object_=_response.json(),
                        ),
                    )
                )
            if _response.status_code == 404:
                raise NotFoundError(
                    typing.cast(
                        typing.Optional[typing.Any],
                        parse_obj_as(
                            type_=typing.Optional[typing.Any],  # type: ignore
                            object_=_response.json(),
                        ),
                    )
                )
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    async def search_plants_by_status(
        self,
        *,
        status: typing.Optional[SearchPlantsByStatusRequestStatus] = None,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> typing.List[PlantResponse]:
        """
        Filter plants based on their current status.

        Parameters
        ----------
        status : typing.Optional[SearchPlantsByStatusRequestStatus]
            The status of plants to search for.

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        typing.List[PlantResponse]
            List of plants matching the status filter

        Examples
        --------
        import asyncio

        from plantstore import AsyncCartesia

        client = AsyncCartesia()


        async def main() -> None:
            await client.plant.search_plants_by_status()


        asyncio.run(main())
        """
        _response = await self._client_wrapper.httpx_client.request(
            "plant/search/status",
            method="GET",
            params={
                "status": status,
            },
            request_options=request_options,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    typing.List[PlantResponse],
                    parse_obj_as(
                        type_=typing.List[PlantResponse],  # type: ignore
                        object_=_response.json(),
                    ),
                )
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    async def search_plants_by_tags(
        self,
        *,
        tags: typing.Optional[typing.Union[str, typing.Sequence[str]]] = None,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> typing.List[PlantResponse]:
        """
        Filter plants based on associated tags.

        Parameters
        ----------
        tags : typing.Optional[typing.Union[str, typing.Sequence[str]]]
            Tags to filter plants (comma-separated).

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        typing.List[PlantResponse]
            List of plants matching the tags filter

        Examples
        --------
        import asyncio

        from plantstore import AsyncCartesia

        client = AsyncCartesia()


        async def main() -> None:
            await client.plant.search_plants_by_tags()


        asyncio.run(main())
        """
        _response = await self._client_wrapper.httpx_client.request(
            "plant/search/tags",
            method="GET",
            params={
                "tags": tags,
            },
            request_options=request_options,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    typing.List[PlantResponse],
                    parse_obj_as(
                        type_=typing.List[PlantResponse],  # type: ignore
                        object_=_response.json(),
                    ),
                )
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    async def get_plant_by_id(
        self, plant_id: int, *, request_options: typing.Optional[RequestOptions] = None
    ) -> PlantResponse:
        """
        Retrieve a plant's details by its ID.

        Parameters
        ----------
        plant_id : int
            ID of the plant to retrieve

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        PlantResponse
            Details of the requested plant

        Examples
        --------
        import asyncio

        from plantstore import AsyncCartesia

        client = AsyncCartesia()


        async def main() -> None:
            await client.plant.get_plant_by_id(
                plant_id=1,
            )


        asyncio.run(main())
        """
        _response = await self._client_wrapper.httpx_client.request(
            f"plant/{jsonable_encoder(plant_id)}",
            method="GET",
            request_options=request_options,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    PlantResponse,
                    parse_obj_as(
                        type_=PlantResponse,  # type: ignore
                        object_=_response.json(),
                    ),
                )
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)
