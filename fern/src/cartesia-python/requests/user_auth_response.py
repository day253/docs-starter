# This file was auto-generated by Fern from our API Definition.

import typing_extensions
import typing_extensions
from ..core.serialization import FieldMetadata


class UserAuthResponseParams(typing_extensions.TypedDict):
    token: typing_extensions.NotRequired[str]
    """
    Authentication token
    """

    expires_in: typing_extensions.NotRequired[
        typing_extensions.Annotated[int, FieldMetadata(alias="expiresIn")]
    ]
    """
    Token expiration time in seconds
    """
