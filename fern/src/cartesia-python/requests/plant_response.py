# This file was auto-generated by Fern from our API Definition.

import typing_extensions
import typing_extensions
import typing


class PlantResponseParams(typing_extensions.TypedDict):
    id: typing_extensions.NotRequired[int]
    name: typing_extensions.NotRequired[str]
    status: typing_extensions.NotRequired[str]
    tags: typing_extensions.NotRequired[typing.Sequence[str]]
